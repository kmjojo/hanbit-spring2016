package com.hanbit.spring.core.session;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 세션 컴포넌트에서 어떤 페이지에서 로그인 되어있는지 확인하기 위해...관련 어노테이션
 * @author 1027
 * 오후 4:44:20
 */

@Target(ElementType.METHOD)	// 메소드에만 붙일 수 있는 어노테이션
public @interface SigninRequired {

}
