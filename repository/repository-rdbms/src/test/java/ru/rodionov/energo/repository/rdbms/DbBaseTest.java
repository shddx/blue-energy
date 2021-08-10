package ru.rodionov.energo.repository.rdbms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ComponentScan("ru.rodionov.energo.repository")
@PropertySource("classpath:application-db.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DbBaseTest {
    private static final String IMAGE_VERSION = "postgres:13-alpine";
    static PostgreSQLContainer container = new PostgreSQLContainer(IMAGE_VERSION)
            .withDatabaseName("spring-blue-energy-test-db")
            .withUsername("test_user")
            .withPassword("pass");

    static {
        container.start();
        System.setProperty("SPRING_DATASOURCE_URL", container.getJdbcUrl());
        System.setProperty("SPRING_DATASOURCE_USERNAME", container.getUsername());
        System.setProperty("SPRING_DATASOURCE_PASSWORD", container.getPassword());
    }

    @Test
    public void containerIsRunning() {
        assertTrue(container.isRunning());
    }
}
