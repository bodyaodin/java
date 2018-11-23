package com.rest.user.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Using for connection pool
 */
@Configuration
public class DatabaseConfig {

    private final ConnectionSettings connectionSettings;

    @Autowired
    public DatabaseConfig(ConnectionSettings connectionSettings) {
        this.connectionSettings = connectionSettings;
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(connectionSettings.getDriver());
        hikariConfig.setJdbcUrl(connectionSettings.getUrl());
        hikariConfig.setUsername(connectionSettings.getUsername());
        hikariConfig.setPassword(connectionSettings.getPassword());
        hikariConfig.setMaximumPoolSize(connectionSettings.getMaxPoolSize());
        hikariConfig.setPoolName("main");
        return new HikariDataSource(hikariConfig);
    }
}
