package ru.rodionov.energo.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Profile("RDBMS")
@Configuration
@Import(ru.rodionov.energo.repository.rdbms.config.DBConfig.class)
public class RDBMSConfig {
}
