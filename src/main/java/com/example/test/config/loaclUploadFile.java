package com.example.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 资源映射路径
 */
@Configuration
public class loaclUploadFile implements WebMvcConfigurer {
    @Value("${resourcesPath}")
    private String resourcePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler：指的是对外暴露的访问路径
        //addResourceLocations：指的是内部文件放置的目录
        //通过设置spring.resources.static-locations自定义Spring boot加载前端静态资源路径
//        如果指定了拦截器，该属性有可能失效
//        需要在拦截器ResourceHandlerRegistry中通过addLocations()指定对应路径
        File uploadFilePath = new File(resourcePath);
        registry.addResourceHandler("/uploadFile/**")
                .addResourceLocations("file:"+uploadFilePath.getAbsolutePath()+File.separator);
    }
}
