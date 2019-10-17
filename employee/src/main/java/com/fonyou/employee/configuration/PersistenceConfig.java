package com.fonyou.employee.configuration;

import com.fonyou.employee.commons.constants.core.DeployType;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * The type Persistence config.
 *
 * @author Nestor Villar Lautero
 * @version 0.0.1 16/10/2019
 * @since 0.0.1 16/10/2019
 *
 */
@Slf4j
@Configuration
@EnableConfigurationProperties
public class PersistenceConfig {

    /**
     * Datasource properties datasource configuration.
     *
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     *
     * @return the datasource configuration
     */
    @Bean
    @ConfigurationProperties(value = "spring.datasource.primary")
    public DatasourceConfiguration datasourceProperties() {
        return new DatasourceConfiguration();
    }

    /**
     * Datasource configuration data source.
     *
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     *
     * @return the data source
     */
    @Bean
    @Profile({DeployType.DEVELOP, DeployType.TEST, DeployType.QA, DeployType.PRODUCTION})
    public DataSource datasourceConfiguration() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if (log.isDebugEnabled())
            log.info("Datasource Connection Properties: {}", datasourceProperties().toString());

        dataSource.setUrl(datasourceProperties().url);
        dataSource.setUsername(datasourceProperties().username);
        dataSource.setPassword(datasourceProperties().password);
        dataSource.setSchema(datasourceProperties().schema);
        return dataSource;
    }

    /***
     *
     * Inner type {@link DatasourceConfiguration } configurations from properties.
     *
     * @author Nestor Villar Lautero
     * @version 0.0.1 16/10/2019
     * @since 0.0.1 16/10/2019
     */
    @Data
    @Getter
    @ToString
    private static class DatasourceConfiguration {
        private String url;
        private String username;
        private String password;
        private String driver;
        private String driverClassName;
        private String maxActive;
        private String maxIdle;
        private String minIdle;
        private String initialSize;
        private String removeAbandoned;
        private String schema;

    }
}
