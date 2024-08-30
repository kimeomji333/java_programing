package com.example.demo.sample;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HotelTests {
	
	@Autowired
	private Hotel hotel;
	@Autowired
	private Restaurant restaurant;
	
	@Test // Test 어노테이션을 붙이면 하나의 단위가 된다.
	@DisplayName("생성자로 주입")
	public void testExist() {
//		System.out.println(hotel.getChef());
		
		//assert~~ : ~~이면 통과
		assertNotNull(hotel.getChef());
	}
	
	@Test
	@DisplayName("세터로 주입")
	public void testExist2() {
		assertNotNull(restaurant.getChef());
	}
}
