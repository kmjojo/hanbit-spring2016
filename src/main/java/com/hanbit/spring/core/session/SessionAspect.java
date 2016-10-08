package com.hanbit.spring.core.session;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 세션 관련 컴포넌트
 * @author 1027
 * 오후 4:42:09
 */
@Component
@Aspect
public class SessionAspect {

	@Around("@annotation(com.hanbit.spring.core.session.SigninRequired)")
	public Object checkSignIn(ProceedingJoinPoint pjp) throws Throwable {
		
		
		Object returnValue = pjp.proceed();
		
		return returnValue;
	}
}
