package com.example.boutiquecommercial.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Logging {

//    public class PerformanceAspect {
//
//        @Around("execution(* tn.esprit.spring.services.*.*(..))")
//        public void profile(ProceedingJoinPoint pjp) throws Throwable {
//            long start = System.currentTimeMillis();
//            pjp.proceed();
//            long elapsedTime = System.currentTimeMillis() - start;
//            log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        }
//    }
    @AfterReturning("execution(void com.example.boutiquecommercial.Serv.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
    String name = joinPoint.getSignature().getName();
    log.info("With success " + name );
}
}
