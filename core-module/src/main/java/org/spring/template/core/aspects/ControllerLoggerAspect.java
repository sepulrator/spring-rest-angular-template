package org.spring.template.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.spring.template.core.event.domain.LogEvent;
import org.spring.template.core.event.producer.LogEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by osman on 14.5.2017.
 */
@Aspect
@Component
public class ControllerLoggerAspect {

    @Autowired
    LogEventPublisher logEventPublisher;



    @Pointcut("execution(* org.spring.template.webapp.controller..*(..))")
    public void controller() {}

    @Around("controller()")
    public Object doAccessCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("This is LogAdvice BEFORE excuting Method");
        Object returnObj = joinPoint.proceed();

        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Arg: " + signatureArg);
        }
        System.out.println("This is LogAdvice AFTER excuting Method");
        LogEvent logEvent = new LogEvent();
        logEvent.setId(System.currentTimeMillis());
        logEvent.setClassName(joinPoint.getTarget().getClass().getName());
        logEvent.setMethodName(joinPoint.getSignature().getName());
        logEvent.setRequest(signatureArgs);
        logEvent.setResponse(returnObj);
        logEventPublisher.publishServiceLog(logEvent);
        return returnObj;
    }




    @AfterThrowing(
            pointcut = "execution(* org.spring.template.webapp.controller..*(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }

}
