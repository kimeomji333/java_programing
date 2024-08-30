package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//setter로 주입
@Data // Setter, Getter, ToString, ... 를 하나로 합친 어노테이션
//@Setter
@Component
public class Restaurant {
//	@Setter(onMethod_ = @Autowired) 예전에는 이런식으로 썼었다.
	@Autowired
	private Chef chef;

}
