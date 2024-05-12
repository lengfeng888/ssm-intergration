package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.logging.SLF4JImpl;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.Properties;

/*

2.配置sqlSessionFactory
3.配置mapper代理对象
 */
@Configuration
public class MapperConfig {

    /*@Bean//保留mybatis-config.xml配置文件
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //1.指定数据库连接池
        sqlSessionFactoryBean.setDataSource(dataSource);
        //2.指定mybatis配置文件
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }*/

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //1.指定数据库连接池
        sqlSessionFactoryBean.setDataSource(dataSource);
        //将配置文件中的配置项，使用代码方式进行配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //开启驼峰映射
        configuration.setMapUnderscoreToCamelCase(true);
        //设置自动映射，包含嵌套映射的字段
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        //设置日志输出
        configuration.setLogImpl(Slf4jImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        //给指定包中的类设置别名，默认类名首字母小写
        sqlSessionFactoryBean.setTypeAliasesPackage("org.example.pojo");
        //设置pageHelper分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        //mapper代理对象的FactoryBean->指定一个mapper接口包->将所有mapper代理对象加入ioc
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.example.mapper");//mapper和xml文件的共同包
        return mapperScannerConfigurer;
    }


}
