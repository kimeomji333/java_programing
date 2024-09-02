package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.example.demo.domain.UserDTO;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {
	
	@Autowired
	private UserMapper mapper;
	
//	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	@Test
	public void insertUserTest() {
		// POJO 방식으로
		UserDTO user = new UserDTO();
		user.setUserid("testid");
		user.setUserpw("testpw");
		user.setUsername("testname");
		user.setUsergender("OK");
		user.setZipcode("testzipcode");
		user.setAddrdetail("testdata");
		boolean result = mapper.insertUser(user) == 1;
		System.out.println("RESULT: " + result);
	}
	
//	TEST는 DB에 값이 없으니 테스트할 수 없음
//	@Test
	public void getUserByUseridTest() {
		UserDTO user = mapper.getUserByUserid("testid");
		assertNotNull(user);
	}
}
