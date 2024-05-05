/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.platform.suite.engine.testcases;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggedTestTestCase {
	@Test
	@Tag("excluded")
	public void test() {
	}

}