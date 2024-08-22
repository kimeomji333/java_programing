package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class SampleController {
	// 입력 -> 요청 -> 데이터 수집(컨) -> 처리 -> 응답 생성 과 응답(컨) -> 출력
	@GetMapping("/a")
	public void a() {	}
	
	@GetMapping("/b") // Model : 사용자에게 응답할 데이터를 포함시킬 방법들이 정의되어 있음. 즉, 사용자에게 응답 데이터를 보내준다. 
	public String b(int num1, int num2, Model model) {
		int result = num1+num2;
		model.addAttribute("result", result);
		return "c";
	}
	
	@GetMapping("getCookie")
	// 클라이언트의 요청 자체를 의미하는 객체, "요청"에 관한 모든 정보들을 가지고 있는 객체
	public void getCookie(HttpServletRequest req) {
		// 사용자에게 요청객체를 받아야함(요청 헤더안에 쿠키가 있기 떄문)
//		요청 객체 안에 가지고 있는 것들...
//		req.getRequestURL();
//		req.getServerPort();
		
		String check = req.getHeader("Cookie");
		
		if(check != null) {
			Cookie[] cookies = req.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				System.out.println(cookie.getName() + " : " + cookie.getValue());
			}
		} else {
			System.out.println("쿠키가 존재하지 않습니다.");
		}
	}
	
	// 쿠키만들어서 사용자 컴퓨터에 세팅하는 방법 -> 응답객체가 필요
	@GetMapping("setCookie")
	// 클라이언트에게 하는 응답 자체를 의미하는 객체, "응답"에 관한 모든 정보들을 가지고 있는 객체
	public void setCookie(HttpServletResponse resp) {
		Cookie cookie1 = new Cookie("Homrunball", "creammy");
		Cookie cookie2 = new Cookie("sunchip", "spicy");
		
//		cookie1.set해서 담을 수 있음
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
	}
	
		@GetMapping("updateCookie")
		public void updateCookie(HttpServletRequest req, HttpServletResponse resp) {
		// 기존의 쿠키를 받아서 꺼내서 수정해야함
		String check = req.getHeader("Cookie");
		
		if(check != null) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("sunchip")) {
					cookie.setValue("is_so_good");
					// 응답에 추가해줘야 함
					resp.addCookie(cookie);
					break;
				}
			}
		} else {
			System.out.println("쿠키가 존재하지 않습니다.");
		}
	}
	
	@GetMapping("deleteCookie")
	public void deleteCookie(HttpServletRequest req, HttpServletResponse resp) {
		String check = req.getHeader("Cookie");
		
		if(check != null) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("sunchip")) {
					// 쿠키의 유효기간을 설정해주는 방식으로 삭제할 수 있다.
					// 초 단위로 저장하고, 음수로 입력하면 브라우저 종료시 쿠키 삭제(default)
					// 유효기간 한 달 : cookie.setMaxAge(60*60*24*30);
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					break;
				}
			}
		} else {
			System.out.println("쿠키가 존재하지 않습니다.");
		}
	}
	
	@GetMapping("setSession")
	public void setSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("loginUser", "apple");
	}
	
	@GetMapping("getSession")
	public void getSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("loginUser"));
	}
	
}
