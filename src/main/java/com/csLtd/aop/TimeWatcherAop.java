package com.csLtd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Shelupets Denys on 21.06.2021.
 */
@Component
@Aspect
public class TimeWatcherAop {
    private static final Logger LOG = LoggerFactory.getLogger(TimeWatcherAop.class);

    @Around("execution (* com.csLtd.service.employee.EmployeeService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnValue = null;
        Throwable throwable = null;
        try {
            returnValue = joinPoint.proceed();
        } catch (Throwable t) {
            throwable = t;
        }
        long finish = System.currentTimeMillis();
        LOG.info("Duration of {} mS", (finish - start));
        if (throwable != null) {
            throw throwable;
        }
        return returnValue;
    }
}
