package com.vouficarbem.configuration;

import com.vouficarbem.controllers.HomeController;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = HomeController.class)
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposedContextBeanNames("acalme-se");
        return resolver;
    }
//  estrutura para auxílio de futuro form
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("/WEB-INF/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(1);
//
//        return messageSource;
//    }
//
//    @Bean
//    public FormattingConversionService mvcConversionService() {
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
//        registrar.registerFormatters(conversionService);
//
//        return conversionService;
//    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}