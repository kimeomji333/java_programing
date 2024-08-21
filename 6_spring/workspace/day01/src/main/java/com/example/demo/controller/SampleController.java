package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.SampleDTO;

//어노테이션 controller 에서 요청을 받는다.
@Controller
public class SampleController {
	
	// 요청이 왔을 때 호출이 되려면
	// @RequestMapping("/a")
	@GetMapping("/a")
	// 문자열로 리턴을 하면, View Resolver 설정에 맞게 해당 이름의 View를 찾는다.
	// prefix: /views/
	// suffix: .jsp
	// /views/a.jsp
	public String a() {
		System.out.println("a 요청 호출!!");
		return "a";
	}
	
	// void 메소드는 요청명과 같은 이름의 View를 찾는다.
	// /views/basic/jsp
	@GetMapping("basic")
	public void adfdfdsdf() {
		System.out.println("basic 요청 호출!!");
	}
	
	@GetMapping("basic1")
	// localhost:8080/basic1?age=10 쿼리스트링 방식으로 데이터를 넘겨주면, 서버에서 매개변수로 받을 수 있다. 
	public void basicGet(int age) {
		System.out.println("basic1 요청 호출!! : " +age);
	}
	
	@PostMapping("basic2")
	public void basicPost(int age) {
		System.out.println("basic2 요청 호출!! : " +age);
	}
	
	// dto 객체로 데이터 수집
	@GetMapping("test01")
	public void test01(SampleDTO dto) {
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
	}
	
	// 파라미터명과 담을 매개변수명이 다른 경우 수집방법(특정 이름의 파라미터로 날아오는 데이터 수집 방법)
	@GetMapping("test02")
	public void test02(@RequestParam("data2") String name, @RequestParam("data1")int age) {
		System.out.println(name);
		System.out.println(age);
	}
	
	// 파라미터가 같은 이름으로 여러개 날아오는 경우 수집 방법 ex. checkbox
	@GetMapping("test03")
	public void test03(@RequestParam("data") String[] datas){
		System.out.println(datas.length);
	}
	
	@GetMapping("test04")
	public void test04(@RequestParam("data") ArrayList<String> datas) {
		System.out.println(datas);
	}
	
	// 오류처리하는 것. 나중에 타임리프 배울 때 하자.
//	@GetMapping("test05")
//	public void test05() {
//		String msg = null;
//		msg.charAt(1000);
//	}
	
	
}
