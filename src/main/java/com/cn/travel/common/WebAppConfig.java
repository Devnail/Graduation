package com.cn.travel.common;

import com.cn.travel.web.base.ManagerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new ManagerInterceptor()).addPathPatterns("/manager/**");
    }

    /**
     * 配置静态资源
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);


    }
    /**
     * 文件上传配置
     */
    //在spring boot中，文件上传的配置，可以在application.properties中配置，也可以在代码中配置
   /* @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        //设置上传文件大小 5M
        commonsMultipartResolver.setMaxUploadSize(5242880);
        return commonsMultipartResolver;
    }*/
}
