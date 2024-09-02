package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("join")
	public void replace() {}
	
	@GetMapping("login")
	public String login() {
		return "redirect:/";
	}
	
	@GetMapping("checkId")
	@ResponseBody
	public String checkId(String userid) {
		if(service.ckeckId(userid)) {
			return "O";
		}
		else {
			return "X";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}
	
}
