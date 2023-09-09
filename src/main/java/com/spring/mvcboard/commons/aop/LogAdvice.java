package com.spring.mvcboard.commons.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.mvcboard.article.controller.ArticleController;

@Component
@Aspect
public class LogAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
	
	@Around("execution(* com.spring.mvcboard..*Controller.*(..))"
            + " or execution(* com.spring.mvcboard..service..*Impl.*(..))"
            + " or execution(* com.spring.mvcboard..persistence..*Impl.*(..))")
	 public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String name = "";

        if (type.contains("Controller")) {
            name = "Controller : ";
        } else if (type.contains("Service")) {
            name = "Service : ";
        } else if (type.contains("DAO")) {
            name = "Persistence : ";
        }

        long end = System.currentTimeMillis();

        log.info(name + type + "."+proceedingJoinPoint.getSignature().getName() + "()");
        log.info("Argument/Parameter : " + Arrays.toString(proceedingJoinPoint.getArgs()));
        if (result != null) {
        	log.info("Return Value : " + result.toString());
        } else {
        	log.info("Return Type : void");
        }
        log.info("Running Time : " + (end-start));
        log.info("----------------------------------------------------------------");

        return result;
    }

}
