FROM maven:3.8-jdk-11 as backend-build

COPY pom.xml .
COPY admin/pom.xml admin/
COPY admin/admin-backend/pom.xml admin/admin-backend/
COPY repository/pom.xml repository/
COPY repository/repository-api/pom.xml repository/repository-api/pom.xml
COPY repository/repository-rdbms/pom.xml repository/repository-rdbms/pom.xml

RUN mvn dependency:go-offline -B

COPY admin/admin-backend/src admin/admin-backend/src
COPY repository/repository-api/src repository/repository-api/src
COPY repository/repository-rdbms/src repository/repository-rdbms/src
RUN mvn clean install -DskipTests


RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../../admin/admin-backend/target/*.jar)

FROM openjdk:11
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY --from=backend-build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=backend-build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=backend-build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","ru.rodionov.energo.admin.AdminBackendApplication"]
