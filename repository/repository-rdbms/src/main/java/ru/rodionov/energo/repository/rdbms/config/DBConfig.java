package ru.rodionov.energo.repository.rdbms.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ru.rodionov.energo.repository.rdbms.repo"})
@EntityScan(basePackages = {"ru.rodionov.energo.repository.rdbms.domain"})
@ComponentScan(basePackages = {"ru.rodionov.energo.repository.rdbms"})
@PropertySource("classpath:application-db.properties")
public class DBConfig {
}
