package org.example.config;

import org.example.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/*
1.配置controller层扫描包，全局异常处理扫描包，拦截器扫描包
2.添加handlerMapping handleAdapter json处理器 使用@EnableWebMvc
3.注册拦截器
4.开启静态资源处理
5.配置视图解析器
 */
@Configuration
@ComponentScan({"org.example.controller","org.example.exceptionhandle","org.example.interceptor"})
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB_INF/views/",".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
//                .addPathPatterns("/user/**")
//                .excludePathPatterns("/user/login");
    }
}
