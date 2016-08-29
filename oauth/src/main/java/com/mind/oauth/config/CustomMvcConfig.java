package com.mind.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lrh on 2016/8/16.
 */
@Configuration
public class CustomMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/403").setViewName("403");
    }

//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Bean
//    public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
//        ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
//        contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
//
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//
//        MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
//        defaultView.setExtractValueFromSingleKeyModel(true);
//
//        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
//        contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
//        contentViewResolver.setViewResolvers(Arrays.<ViewResolver> asList(viewResolver));
//        contentViewResolver.setDefaultViews(Arrays.<View> asList(defaultView));
//        return contentViewResolver;
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }



}
