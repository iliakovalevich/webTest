package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.controller")
public class WebConfig implements WebMvcConfigurer {
  @Bean
  public ViewResolver getViewResolver() {
    FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
    freeMarkerViewResolver.setOrder(1);
    freeMarkerViewResolver.setSuffix(".ftl");
    freeMarkerViewResolver.setPrefix("");
    return freeMarkerViewResolver;
  }

  @Bean
  public FreeMarkerConfigurer getFreeMarkerConfigurer() {
    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
    freeMarkerConfigurer.setTemplateLoaderPaths("/", "/webapp/WEB-INF/views/");
    return freeMarkerConfigurer;
  }
}
