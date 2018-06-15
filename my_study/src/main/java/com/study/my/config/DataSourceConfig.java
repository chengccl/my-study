package com.study.my.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author sk-cailicheng on 2018/6/14.
 */
@Configuration
@PropertySource("classpath:config.properties")
public class DataSourceConfig {

    public DataSourceConfig() {
    }

    @Bean(name = {"testDS"})
    @Qualifier("testDS")
    @ConfigurationProperties(prefix = "spring.ism.datasource")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
}
