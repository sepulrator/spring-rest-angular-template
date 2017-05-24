package org.spring.template.core.event.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.spring.template.core.event.domain.LogEvent;
import org.spring.template.datastore.entity.mongodb.ServiceLog;
import org.spring.template.datastore.repository.mongodb.ServiceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.fn.Consumer;

import static reactor.bus.selector.Selectors.$;

/**
 * Created by osman on 22.5.2017.
 */
@Service
public class LogEventReceiver implements Consumer<Event<LogEvent>> {

    @Autowired
    ServiceLogRepository serviceLogRepository;

    @Autowired
    public LogEventReceiver(EventBus eventBus ){
        eventBus.on($("serviceLog"),this);
    }

    @Override
    public void accept(Event<LogEvent> serviceLogEvent) {
        ServiceLog serviceLog = new ServiceLog();
        serviceLog.setId(serviceLogEvent.getData().getId());
        serviceLog.setClassName(serviceLogEvent.getData().getClassName());
        serviceLog.setMethodName(serviceLogEvent.getData().getMethodName());

        ObjectMapper mapper = new ObjectMapper();
        String requestJson = "";
        String responseJson = "";
        try {
            requestJson = mapper.writeValueAsString(serviceLogEvent.getData().getRequest());
            responseJson = mapper.writeValueAsString(serviceLogEvent.getData().getResponse());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        serviceLog.setRequest(requestJson);
        serviceLog.setResponse(responseJson);
        serviceLogRepository.save(serviceLog);
    }
}
