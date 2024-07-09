package model.dao;

import java.util.ArrayList;

import model.dto.UserDTO;
import model2.DBConnection;

public class UserDAO {
	DBConnection connection;
	
	public UserDAO() {
		connection = new DBConnection("UserTable.txt");
	}
	
	public UserDTO getUserByUserid(String userid) {
		//검색 -> 결과가 있다면 객체로 만들어서 리턴, 없다면 null 리턴
		ArrayList<String[]> result = connection.select(0, userid);
		
		if(result.size() > 0) {
			String[] line = result.get(0);
			UserDTO user = new UserDTO(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4], line[5]);
			return user;
		}
		return null;
	}

	public boolean insertUser(UserDTO user) {
		//넘겨진 정보로 삽입할 형태의 문자열 생성 -> //API 이용해서 삽입!
		String data = String.format("%s\t%s\t%s\t%d\t%s\t%s", user.getUserid(), user.getUserpw(), user.getUsername(), user.getUserage(), user.getUserphone(), user.getUseraddr());
		return connection.insert(data);
	}

}
