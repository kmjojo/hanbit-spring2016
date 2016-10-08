package com.hanbit.spring.core.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExampleAOP {

	private static final Logger logger = LoggerFactory.getLogger(ExampleAOP.class);
	
	@Pointcut("execution(public * com.hanbit..*.*(..))")	// 접근지시자 반환값 함수이름(파라미터 ..은 있어도 되고 없어도 된다는 의미)
	public void publicExecute() {		// com.hanbit..* : 이 패키지 밑에 있는 함수들
		// 포인트 컷만으로는 할 수 없음...
	}
	
	@Pointcut("execution(* get*(..))")	// 메소드 이름에 get이 들어가는 것
	public void getMethod() {}
	
	@Before("publicExecute() && getMethod()")
	public void runBeforePublicExe() {
		logger.debug("runBefore");
	}
	
	@After("execution(public * com.hanbit..*.*(..))")
	public void runAfterPublicExe() {
		logger.debug("runAfter");
	}
	
	
	/*
	@Around	("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
	public Object aroundEmp(ProceedingJoinPoint pjp) throws Throwable {		//@Around 어노테이션 많이 씀
										// ProceedingJoinPoint : 메소드에 대한 정보를 가지고 있음
		// Throwable -> Exception 보다 더 상위 클래스
		
		// 이 안에서 Before After 등을 다 사용할 수 있다.
		
		// Before
		
		Object returnValue = null;
		
		// 로그인이 되어있는지 확인하는 코드를 넣을 수 있다.
		
		try {
			
			returnValue = pjp.proceed();
			
		} catch (Throwable e) {
			
			//AfterThrowing
			
			//if (e instanceof RuntimeException) {
				Map errorResult = new HashMap();
				
				errorResult.put("errorMsg", e.getMessage());
				return errorResult;
			//}
			
			//e.printStackTrace();
		}
		
		// AfterReturning
		if (returnValue instanceof Map) {
			Map result = (Map) returnValue;
			result.put("additional", "aop");
		}
		
		
		// After
		
		return null;
		
	}
	*/
	
}
