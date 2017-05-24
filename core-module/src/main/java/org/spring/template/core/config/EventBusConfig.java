package org.spring.template.core.config;

import org.spring.template.core.event.consumer.LogEventReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

import javax.annotation.PostConstruct;

import static reactor.bus.selector.Selectors.$;

/**
 * Created by osman on 22.5.2017.
 */
@Configuration
public class EventBusConfig {

    @Bean
    Environment env() {
        return Environment.initializeIfEmpty().assignErrorJournal();
    }

    @Bean
    EventBus createEventBus(Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }

    @Autowired
    EventBus eventBus;

    @Autowired
    LogEventReceiver logEventReceiver;

    @PostConstruct
    public void onStartUp() {
        eventBus.on($("serviceLog"), logEventReceiver);
    }


}
