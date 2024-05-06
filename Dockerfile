FROM openjdk:17
COPY ./out/production/LibrarySystem/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "Bibliotheksverwaltung"]