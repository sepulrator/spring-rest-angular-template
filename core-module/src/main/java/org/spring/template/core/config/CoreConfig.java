package org.spring.template.core.config;

import org.spring.template.core.aspects.ControllerLoggerAspect;
import org.springframework.context.annotation.*;

/**
 * Created by osman on 13.5.2017.
 */
@Configuration
@ComponentScan(basePackages = "org.spring.template.core")
@EnableAspectJAutoProxy
@Import(EventBusConfig.class)
public class CoreConfig {

    @Bean
    public ControllerLoggerAspect controllerLoggerAspect(){
        return new ControllerLoggerAspect();
    }
}
