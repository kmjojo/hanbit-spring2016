package com.hanbit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//이 어노테이션을 사용하면 xml config에 bean을 등록하지 않아도 됨
@Component
public class FirstBean {

	private SecondBean secondBean; 
	
	private int value;
	

	// FirstBean과 SecondBean의 관계를 알려줌
	@Autowired
	public void setSecondBean(SecondBean secondBean) {
		this.secondBean = secondBean;
	}
	
	public void callSecondBean() {
		System.out.println(value++);
		secondBean.printName();
	}  

}
