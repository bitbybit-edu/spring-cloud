package com.bitbybit.demoaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = Logger.getLogger("com.bitbybit.demoaop.aspect.LogAspect");

    @Pointcut("execution(* com.bitbybit.demoaop.test.*.*(..))")
    private void allMethod() {

    }

    @Before("allMethod()")
    private void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        logger.log(Level.INFO, className + "." + methodName + "()开始执行。。。。");
    }

    @Before("allMethod()")
    private void after(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        logger.log(Level.INFO, className + "." + methodName + "()方法结束。。。。");
    }
}
