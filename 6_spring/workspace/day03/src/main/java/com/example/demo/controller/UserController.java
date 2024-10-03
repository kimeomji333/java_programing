package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.UserDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
//엔티티를 붙이고 메소드들을 적는다. 한번에 적어줄 수 있는게 RequestMapping
@RequestMapping("/user/*")
public class UserController {
	
	// 여러 요청 주소를 하나의 메소드에 매핑하는 방법(배열 안에다가 매핑되는 것들을 적어줄 수 있음)
	@GetMapping(value = {"joinview", "loginview", "main"})
	public void replace() {}
	
	@PostMapping("joinOk")
	public String joinOk(UserDTO dto, HttpServletResponse resp) throws Exception { //DTO로 파라미터 처리완
		System.out.println(dto);
		//DB 처리
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/gb";
		String user = "root";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		// sql문 작성
		String sql = "insert into test_user values(?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getUserid());
		ps.setString(2, dto.getUserpw());
		ps.setString(3, dto.getUsername());
		
		int result = ps.executeUpdate();

		// 결과가 하나 삽입이 되어있으면,
		if(result == 1) {
			// 성공시 로그인뷰
			// 로그인 아이디에 입력받은 데이터를 추가해주기 위해서 쿠키 사용
			Cookie cookie = new Cookie("joinid", dto.getUserid());
			cookie.setMaxAge(60*5);
			resp.addCookie(cookie);
			return "/user/loginview";
		} else {
			return "/user/joinview";
		}
	}
	
	@PostMapping("loginOk")
	public String loginOk(UserDTO dto, HttpServletRequest req) throws Exception {
		//DB 처리
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/gb";
		String user = "root";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		// sql문 작성
		String sql = "select * from test_user where userid=? and userpw=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,  dto.getUserid());
		ps.setString(2, dto.getUserpw());
		
		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			// 세션에다가 !하면 로그인 성공
			req.getSession().setAttribute("loginUser", dto.getUserid());
			return "/user/main";
		} else {
			return "/user/loginview";
		}
			
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		// 특정 키에 해당하는 데이터만 지우기
		// req.getSession().removeAttribute("loginUser");
		// 초기화
		req.getSession().invalidate();
		return "/user/loginview";
	}
}