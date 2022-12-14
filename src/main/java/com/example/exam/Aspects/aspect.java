package com.example.exam.Aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class aspect {


    	@After("execution(* com.example.exam.Controller.ExamRestController.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().getName();

		log.info("Out of method :" + name );
	}

}
