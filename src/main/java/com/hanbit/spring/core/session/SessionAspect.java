package com.hanbit.spring.core.session;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
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
		
		
		// 지금 실행되고 있는 메소드에 대한 정보
		//pjp.getSignature();
		
		// MethodSignature 로 형변환함으로써 더 많은 정보를 알아낼 수 있음?
		//MethodSignature signature = (MethodSignature) pjp.getSignature();
		
		
		
		Object returnValue = pjp.proceed();
		
		return returnValue;
	}
}
