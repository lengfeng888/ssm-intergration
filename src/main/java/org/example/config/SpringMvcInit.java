package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
    添加root容器的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServiceConfig.class,MapperConfig.class,DataSourceConfig.class};
    }
    /*
    添加web容器的配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    /*
    配置dispatcherServlet 的处理路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
