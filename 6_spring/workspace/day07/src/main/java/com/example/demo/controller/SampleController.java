package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.TimeMapper;
import com.example.demo.mapper.UserMapper;

@Controller
public class SampleController {
//	TimeMapper는 인터페이스라서 new 생성하면, 직접 사용 불가. spring에게 맡겨야함 -> 인터페이스에 @Mapper 이용
//	스프링에서 주입을 해줘야 함. Autowired 사용
	//객체를 만들어 달라고 스프링에 요청
	@Autowired
	TimeMapper mapper;
	@Autowired
	UserMapper mapper2;
	
	@GetMapping("time1")
	public void time1() {
		System.out.println("Test : " + mapper.getTime1());
	}
	
	@GetMapping("time2")
	public void time2() {
		System.out.println("Test : " + mapper.getTime2());		
	}
	
	@GetMapping("user1")
	public void user1() {
		System.out.println("Test : " + mapper2.getUsernameByUserid("apple"));
	}
	
	@GetMapping("user2")
	public void user2() {
		UserDTO user = mapper2.getUserByUserid("apple");
		System.out.println("Test : " + user);
	}
}
