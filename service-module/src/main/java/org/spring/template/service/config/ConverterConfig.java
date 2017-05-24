package org.spring.template.service.config;

import org.spring.template.service.dto.converter.PersonConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * Created by osman on 9.5.2017.
 */
@Configuration
public class ConverterConfig {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new PersonConverter());
        return service;
    }

}
