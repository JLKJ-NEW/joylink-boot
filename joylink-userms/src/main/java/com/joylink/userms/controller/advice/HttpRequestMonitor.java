package com.joylink.userms.controller.advice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class HttpRequestMonitor {
	
	private static final String REQUEST_CLASS_NAME = "org.apache.catalina.connector.RequestFacade";
	
	private static final String RESPONSE_CLASS_NAME = "org.apache.catalina.connector.ResponseFacade";

	@Autowired
	private UnifiedExceptionHandler unifiedExceptionHandler;

	@Pointcut("execution(public * com.joylink.userms.controller.*.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		RequestInfo reqInfo = new RequestInfo();
		reqInfo.setUrl(request.getRequestURL().toString());
		reqInfo.setMethodType(request.getMethod());
		reqInfo.setIp(request.getRemoteAddr());
		reqInfo.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "::" + joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		if(null != args && args.length > 0) {
			Map<String, Object> argMap = new HashMap<>();
			for(int i=0; i<args.length; ++i) {
				Object object = args[i];
				if(null != object) {
					String name = args[i].getClass().getName();
					if(REQUEST_CLASS_NAME.equals(name)) {
						argMap.put("arg"+i, "httpRequest");
					} else if(RESPONSE_CLASS_NAME.equals(name)) {
						argMap.put("arg"+i, "httpResponse");
					} else {
						argMap.put("arg"+i, object);
					}
				} else {
					argMap.put("arg"+i, object);
				}
			}
			reqInfo.setArgs(new JSONObject(argMap).toString());
		}
		log.info("request={}", new JSONObject(reqInfo).toString());
	}

	@Around("log()")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		try {
			return jp.proceed(jp.getArgs());
		} catch (Exception e) {
			return unifiedExceptionHandler.exceptionGet(e);
		}
	}

	@AfterReturning(pointcut = "log()", returning = "object") // 打印输出结果
	public void doAfterReturing(Object object) {
		JSONObject jo = new JSONObject(object);
		log.info("response={}", jo.toString());
	}

}
