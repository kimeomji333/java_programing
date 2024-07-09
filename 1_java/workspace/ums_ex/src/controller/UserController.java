package controller;

import model.dao.UserDAO;
import model.dto.UserDTO;
import model2.Session;

public class UserController {

	public boolean checkId(String userid) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		return user == null;
	}

	public boolean join(UserDTO user) {
		UserDAO udao = new UserDAO();
		return udao.insertUser(user);
	}

	public boolean login(String userid, String userpw) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		if(user != null) {
			if(user.getUserpw().equals(userpw)) {
				//로그인 성공시 세션에 세팅
				Session.setData("loginUser", user.getUserid());
				return true;
			}
		}
		return false;
	}

}

