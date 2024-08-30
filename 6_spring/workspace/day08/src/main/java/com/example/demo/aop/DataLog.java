package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component //스프링에 맡길거니깐
public class DataLog {
// 지금부터 컨트롤러에 날라오는 데이터를 찍어볼께 !
	//com.example.demo.controller 패키지의 하위 클래스들의 경우 cut() 당함을 설정
	@Pointcut("execution(* com.example.demo.controller..*.*(..))") //execution이 실행되면 자르겠다. com.example.demo.controller 실행이 될 때, 잘라서 훔쳐온다.
	private void cut() {	}
	
	//cut() 메소드가 호출되기 전에 호출
	@Before("cut()")
	public void before(JoinPoint joinPoint) { //JoinPoint : 잘린 지점을 객체로 받음. 이런 정보들을 받을 수 있음.
		// 흐름이 짤린 메소드의 상징(ID라고 생각하면 됨)을 받아오기
		MethodSignature signature = (MethodSignature)joinPoint.getSignature(); 
		// 받은 상징을 통해 메소드들을 객체화함
		Method method = signature.getMethod(); 
		// 그 메소드의 이름 추출
		System.out.println(method.getName() + " 호출!!");
		
		// 실행되는 메소드의 매개변수를 배열에 담아 가져오기
		Object[] args = joinPoint.getArgs(); // getArgs를 이용해서 매개값들을 가져옴. Object타입에 담아둘 수 있다
		// 각 매개값들을 하나씩 반복하여 꺼내면서
		for(Object obj : args) {
			// 결과 타입 출력
			System.out.println(obj + "(type : " + obj.getClass().getSimpleName()+")");
		}
	}
	
	@AfterReturning(value = "cut()", returning = "obj")
	public void afterReturning(Object obj) {
		System.out.println("return : " + obj);
	}
	
}
