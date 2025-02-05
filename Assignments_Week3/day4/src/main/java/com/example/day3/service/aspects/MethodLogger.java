package com.example.day3.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodLogger {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MethodLogger.class);

    @AfterReturning("execution(* com.example.day3.service.BookServiceImp.*(..))")
    public Object afterReturning(JoinPoint joinPoint) throws Throwable {
        System.out.println("afterReturning");
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method {} executed", methodName);
        return joinPoint;
    }
}
