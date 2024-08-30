package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@MybatisTest
// 실제환경으로 DB 테스트 설정. 대체 세팅 NONE: DataSource 를 대체하지 않음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
public class MapperTests {
	
	@Autowired
	private TimeMapper mapper;
	
	@Test
	public void getTimeTest() {
		System.out.println(mapper.getTime());
	}

}
