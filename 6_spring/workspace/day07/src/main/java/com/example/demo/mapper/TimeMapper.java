package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

//@Component 상위요소 하에 Mapper, .. 존재
@Mapper
public interface TimeMapper {
	String getTime1();
	
	// Mapper를 작성하는 작업은 xml을 이용할 수도 있지만, 
	// 최소한의 코드로 작성하기 위해서는 Mapper 인터페이스에 바로 작성한다.
	@Select("select now() from daul")
	String getTime2();
}
