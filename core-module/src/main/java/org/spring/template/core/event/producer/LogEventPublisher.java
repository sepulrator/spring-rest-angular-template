package org.spring.template.core.event.producer;

import org.spring.template.core.event.domain.LogEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**
 * Created by osman on 22.5.2017.
 */
@Service
public class LogEventPublisher {

    @Autowired
    @Lazy
    EventBus eventBus;

    public void publishServiceLog(LogEvent logEvent) throws InterruptedException {
        long start = System.currentTimeMillis();

        eventBus.notify("serviceLog", Event.wrap(logEvent));
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Elapsed time: " + elapsed + "ms");
    }


}
