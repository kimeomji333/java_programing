package com.example.demo.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.UserDTO;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@GetMapping(value = {"joinview"})
	public void replace() {}
	
	@PostMapping("joinOk")
	public String joinOk(UserDTO dto, HttpServletResponse resp) {
		System.out.println(dto);
		
		return "/user/joinview";
	}
}
