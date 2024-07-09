package controller;

import model.Session;
import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserController {
	public boolean checkId(String userid) {
		//어떤 기능을 개발하는 코드는 여러 데이터로직(데이터들을 관리하는 로직)과 비즈니스로직(실제 알고리즘)들이 합쳐진 형태
		//데이터 접근용 객체(DAO)를 이용해서 userid값을 넘겨주며 UserDTO 객체 찾기(데이터 로직)
		//찾은 객체가 있는지 없는지를 비교(== null / 비즈니스 로직)한 후 결과를 리턴
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		//데이터 로직을 활용해서 비즈니스 로직을 구현한 상태
		//검색된 user가 없을 때 참이므로 null일때 true를 리턴
		return user == null;
	}

	public boolean join(UserDTO user) {
		//목적 : 전달받은 DTO 객체에 담긴 정보들을 데이터베이스에 삽입
		UserDAO udao = new UserDAO();
		//데이터 접근용 객체를 활용해서 데이터베이스에 데이터들 삽입
		return udao.insertUser(user);
	}

	public boolean login(String userid, String userpw) {
		//목표 : 넘겨받은 아이디로 유저를 찾고, 찾은 유저의 비밀번호가 넘겨받은 비밀번호와 같다면 로그인 성공
		UserDAO udao = new UserDAO();
		//아이디로 유저 찾기(데이터 로직)
		UserDTO user = udao.getUserByUserid(userid);
		//유저가 찾아졌다면
		if(user != null) {
			//찾은 유저의 비밀번호도 비교
			if(user.getUserpw().equals(userpw)) {
				//로그인 성공시 세션에 세팅
				Session.setData("loginUser", user.getUserid());
				return true;
			}
		}
		return false;
	}
	
}








