package com.example.demo.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//생성자로 주입
//@AllArgsConstructor // 생성자로 주입하는 방법으로 모든 매개변수 받아오는 생성자를 선언하겠다. (인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자 작성)
@RequiredArgsConstructor // 요구되는 필드들만 채워준다. (특정 변수를 위한 생성자를 만들 때 작성). final이나 @NonNull이 붙은 인스턴스 변수에 대한 생성자를 작성 
//@NoArgsConstructor
@Getter
@Component // 이 객체 또한 스프링에게 맡긴다. 
public class Hotel {
	
	@NonNull
	private Chef chef;
	
	int data;
}
