/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.params.converter;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.apiguardian.api.API.Status.INTERNAL;
import static org.junit.platform.commons.util.ReflectionUtils.getWrapperType;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.platform.commons.util.ClassLoaderUtils;
import org.junit.platform.commons.util.ReflectionUtils;

/**
 * {@code DefaultArgumentConverter} is the default implementation of the
 * {@link ArgumentConverter} API.
 *
 * <p>The {@code DefaultArgumentConverter} is able to convert from strings to a
 * number of primitive types and their corresponding wrapper types (Byte, Short,
 * Integer, Long, Float, and Double), date and time types from the
 * {@code java.time} package, and some additional common Java types such as
 * {@link File}, {@link BigDecimal}, {@link BigInteger}, {@link Currency},
 * {@link Locale}, {@link URI}, {@link URL}, {@link UUID}, etc.
 *
 * <p>If the source and target types are identical the source object will not
 * be modified.
 *
 * @since 5.0
 * @see org.junit.jupiter.params.converter.ArgumentConverter
 */
@API(status = INTERNAL, since = "5.0")
public class DefaultArgumentConverter implements ArgumentConverter {

	public static final DefaultArgumentConverter INSTANCE = new DefaultArgumentConverter();

	private static final List<StringToObjectConverter> stringToObjectConverters = unmodifiableList(asList( //
		new StringToBooleanConverter(), //
		new StringToCharacterConverter(), //
		new StringToNumberConverter(), //
		new StringToClassConverter(), //
		new StringToEnumConverter(), //
		new StringToJavaTimeConverter(), //
		new StringToCommonJavaTypesConverter(), //
		new FallbackStringToObjectConverter() //
	));

	private DefaultArgumentConverter() {
		// nothing to initialize
	}

	@Override
	public final Object convert(Object source, ParameterContext context) {
		Class<?> targetType = context.getParameter().getType();
		return convert(source, targetType, context);
	}

	public final Object convert(Object source, Class<?> targetType, ParameterContext context) {
		if (source == null) {
			if (targetType.isPrimitive()) {
				throw new ArgumentConversionException(
					"Cannot convert null to primitive value of type " + targetType.getTypeName());
			}
			return null;
		}

		if (ReflectionUtils.isAssignableTo(source, targetType)) {
			return source;
		}

		if (source instanceof String) {
			Class<?> targetTypeToUse = toWrapperType(targetType);
			Optional<StringToObjectConverter> converter = stringToObjectConverters.stream().filter(
				candidate -> candidate.canConvert(targetTypeToUse)).findFirst();
			if (converter.isPresent()) {
				Class<?> declaringClass = context.getDeclaringExecutable().getDeclaringClass();
				ClassLoader classLoader = ClassLoaderUtils.getClassLoader(declaringClass);
				try {
					return converter.get().convert((String) source, targetTypeToUse, classLoader);
				}
				catch (Exception ex) {
					if (ex instanceof ArgumentConversionException) {
						// simply rethrow it
						throw (ArgumentConversionException) ex;
					}
					// else
					throw new ArgumentConversionException(
						"Failed to convert String \"" + source + "\" to type " + targetType.getTypeName(), ex);
				}
			}
		}
		throw new ArgumentConversionException(
			String.format("No built-in converter for source type %s and target type %s",
				source.getClass().getTypeName(), targetType.getTypeName()));
	}

	private static Class<?> toWrapperType(Class<?> targetType) {
		Class<?> wrapperType = getWrapperType(targetType);
		return wrapperType != null ? wrapperType : targetType;
	}

}
