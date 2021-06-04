package com.example.user.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfiguration implements WebMvcConfigurer {

	//定制资源映射
   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/server_resource/**").addResourceLocations("file:/Users/zhuiming/Documents/yanhai/server_resource/");
    }
}
