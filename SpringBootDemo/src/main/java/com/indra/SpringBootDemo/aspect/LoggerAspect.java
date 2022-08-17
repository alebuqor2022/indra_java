package com.indra.SpringBootDemo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
private static Logger logger=Logger.getLogger(LoggerAspect.class);

@Pointcut("execution(* com.indra.SpringBootDemo.*.*.*(..))")
private void generalPointcut() {}

@Before("generalPointcut()")
public void infoLog(JoinPoint joinPoint) {
	logger.info(joinPoint.getTarget().getClass().getSimpleName()+" : "+
    joinPoint.getSignature().getName()
			);
}

@AfterThrowing(pointcut="generalPointcut() throws Exception", throwing="ex")
public void exceltionLog(JoinPoint joinPoint, Exception ex) throws Exception {
	logger.info(joinPoint.getTarget().getClass().getSimpleName()+" : "+
		    joinPoint.getSignature().getName()
					);
}
}
