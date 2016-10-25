package com.sprint.aop;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
@Aspect
@Component
public class WebLogAspect {
	
	/*日志*/
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	/* 同步计算每次请求时间*/
	ThreadLocal<Long> startTime = new ThreadLocal<>();

	@Pointcut("execution(public * com.sprint.ctrls..*(..))")
	public void webLog() {}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
			.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//记录下请求内容
		logger.info("URL: " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD: " + request.getMethod());
		logger.info("IP: " + request.getRemoteAddr());
		logger.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(returning="ret", pointcut="webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		//处理完请求,返回内容
		logger.info("RESPONSE: " + ret);
		logger.info("SPEND TIME: " + (System.currentTimeMillis() -  startTime.get()));
	}
}
