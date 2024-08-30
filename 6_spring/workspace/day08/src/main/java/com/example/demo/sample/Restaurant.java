package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data // Setter, Getter, ToString, ... 를 하나로 합친 어노테이션
//@Setter
public class Restaurant {
//	@Setter(onMethod_ = @Autowired) 예전에는 이런식으로 썼었다.
	@Autowired
	private Chef chef;

}
