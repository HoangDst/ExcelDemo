package vn.tnteco.exceldemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConnection {
    @Value("${spring.datasource.postgres.jdbc-url}")
    private String URL;
    @Value("${spring.datasource.postgres.username}")
    private String USER;
    @Value("${spring.datasource.postgres.password}")
    private String PASSWORD;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        return new DriverManagerDataSource(URL, USER, PASSWORD);
    }
}

