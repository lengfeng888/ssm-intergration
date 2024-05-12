package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/*
1.添加service层扫描包,增强扫描包
2.开启aop注解支持 @EnableAspectJAutoProxy
3.配置事务管理器实现 DataSourceTransactionManager 接口TransactionManager
4.开启事务注解支持 @EnableTransactionManagement
 */
@Configuration
@ComponentScan({"org.example.service","org.example.advice"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ServiceConfig {

    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        //todo 需要配置连接池对象
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
