package com.cglia.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cglia.demo.entity.Department;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class AspectInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(AspectInterceptor.class);

	@Pointcut("execution(* com.cglia.demo.controller.*.*(..))")
	public void loggingpointcut() {
	}

	@Before("loggingpointcut()")
	public void before(JoinPoint joinpoint) {
		log.info("Before method invoked:" + joinpoint.getSignature());
	}
	
	@After("loggingpointcut()")
	public void after(JoinPoint joinpoint) {
		log.info("After method invoked:" + joinpoint.getSignature());
	}

	@AfterReturning(value = "execution(* com.cglia.demo.controller.*.*(..))", returning = "department")
	public void after(JoinPoint joinpoint, Department department) {
		log.info("After method invoked:" + department);
	}

	@AfterThrowing(value = "execution(* com.cglia.demo.controller.*.*(..))", throwing = "e")
	public void after(JoinPoint joinpoint, Exception e) {
		log.info("After method invoked:" + e.getMessage());

	}
}
