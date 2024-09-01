package com.example.demo.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class SampleController {
	
	@GetMapping("a")
	public void a() {	}
	
	@GetMapping("b")
	public String b(int num1, int num2, Model model) {
		int result = num1+num2;
		model.addAttribute("result", result);
		return "c";
	}
	
	@GetMapping("getCookie")
	public void getCookie(HttpServletRequest req) {
		String check = req.getHeader("Cookie");

		if(check != null) {
			Cookie[] cookies = req.getCookies();
			for(int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				System.out.println(cookie.getName() + " : " + cookie.getValue());
			}
		} else {
			System.out.println("쿠키가 존재하지 않습니다.");
		}
	}
	
	@GetMapping("setCookie")
	public void setCookie(HttpServletResponse resp) {
		Cookie cookie1 = new Cookie("weather", "so_hot");
		Cookie cookie2 = new Cookie("winter", "is_comming");
		
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
	}
	
	@GetMapping("updateCookie")
	public void updateCookie(HttpServletRequest req, HttpServletResponse resp) {
		String check = req.getHeader("Cookie");
		
		if(check != null) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("weather")) {
					cookie.setValue("is_so_good");
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
				if(cookie.getName().equals("weather")) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					break;
				}
			}
		} else {
			System.out.println("쿠키 존재하지 않습니다.");
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
