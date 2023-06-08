package com.example.producer.configuration;

import com.example.producer.datasource.MyDatasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class DatasourceConfiguration {

    @Value("${spring.dbType}")
    public String dbType;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public MyDatasource myDatasource() {
        MyDatasource datasource = new MyDatasource();
        datasource.setDbType(dbType);
        return datasource;
    }
}
