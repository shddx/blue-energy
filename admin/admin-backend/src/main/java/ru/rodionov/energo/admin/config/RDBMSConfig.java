package ru.rodionov.energo.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ru.rodionov.energo.repository.rdbms.config.DBConfig.class)
public class RDBMSConfig {
}
