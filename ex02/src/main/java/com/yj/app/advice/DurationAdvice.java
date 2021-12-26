package com.yj.app.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
//@Aspect	//특정 aop를 안보고싶으면 이 어노테이션을 지우면 됨
public class DurationAdvice {

	@Around("LogAdvice.allpointcut()")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		Object obj = null;
		try {
			// 서비스 메서드 호출
			obj = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Time ==========" + (end - start));
		return obj;
	}
}
