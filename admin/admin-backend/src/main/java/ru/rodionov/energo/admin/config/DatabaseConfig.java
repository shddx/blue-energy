package ru.rodionov.energo.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("ru.rodionov.energo.repository")
public class DatabaseConfig {
}
