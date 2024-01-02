package com.pet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // todo: 图片
        registry.addResourceHandler("/myimg/**").addResourceLocations("file:D:/JavaProject/pet-adoption-project/files/images/");
        super.addResourceHandlers(registry);
    }

}
