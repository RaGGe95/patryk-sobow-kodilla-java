package com.kodilla.patterns2.facade.api;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
// ta kalsa musi się nazywać inaczej ponieważ nie można utworzyć w kontekście springa dwóch beanów o tych samych nazwach
public class WatcherOne {
    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("Time consumed: " + (end - start) + "[ms]");
        } catch (Throwable throwable){
            log.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @AfterThrowing(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) throws Throwable {
        log.error("\n\n  Aspect: There was error: " +  exception.getMessage());
    }

}
