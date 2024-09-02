package com.example.demo.service;

import com.example.demo.domain.UserDTO;

// 데이터타입은 개발자나름. 인터페이스 > 클래스 상속받아서 사용
// 서비스부터는 클라이언트용어에 익숙하도록 변수명 사용
public interface UserService {
	boolean join(UserDTO user);
	boolean login(String userid, String userpw);
	boolean ckeckId(String userid);
	boolean leaveId(String userid);
}
