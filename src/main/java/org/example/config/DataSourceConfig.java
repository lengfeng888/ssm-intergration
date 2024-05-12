package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(@Value("${jdbc.url}") String url,
                                 @Value("${jdbc.driver}") String driver,
                                 @Value("${jdbc.username}") String username,
                                 @Value("${jdbc.password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        return dataSource;
    }

}
