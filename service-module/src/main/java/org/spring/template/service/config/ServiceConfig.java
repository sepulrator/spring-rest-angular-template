package org.spring.template.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by osman on 9.5.2017.
 */
@Configuration
@ComponentScan(basePackages = "org.spring.template.service")
@Import({ConverterConfig.class})
public class ServiceConfig {
}
