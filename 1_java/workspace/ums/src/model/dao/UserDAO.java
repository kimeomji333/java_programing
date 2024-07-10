package model.dao;

import java.util.ArrayList;

import model.DBConnection;
import model.dto.UserDTO;

public class UserDAO {
	DBConnection dbConnection;
	
	public UserDAO() {
		dbConnection = new DBConnection("UserTable.txt");
	}
	
	public UserDTO getUserByUserid(String userid) {
		//데이터 로직은 순수하게 데이터에 관련된 로직만 구성되어 있다.
		//뭔진 몰라도 넘겨진 userid로 User객체 찾아서 돌려주기만 하면 끝
		//목표 : API 이용해서 데이터베이스 접근 후 객체로 리턴
		
		//검색
		ArrayList<String[]> result = dbConnection.select(0, userid);
		
		//결과가 있다면
		if(result.size() > 0) {
			//한 줄 꺼내서
			//{"apple","abcd1234","김사과","10",...}
			String[] line = result.get(0);
			//객체로 만들고
			UserDTO user = new UserDTO(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4], line[5]);
			//리턴
			return user;
		}
		//결과가 없다면 null 리턴
		return null;
	}

	public boolean insertUser(UserDTO user) {
		//넘겨진 정보로 삽입할 형태의 문자열 생성
		String data = String.format("%s\t%s\t%s\t%d\t%s\t%s",
				user.getUserid(),user.getUserpw(),user.getUsername(),
				user.getUserage(),user.getUserphone(),user.getUseraddr());
		//API 이용해서 삽입!
		return dbConnection.insert(data);
	}

	public boolean updateUser(String loginUser, String col, String newData) {
		return dbConnection.update(loginUser, col, newData);
	}

	public void deleteUser(String loginUser) {
		dbConnection.delete(loginUser);
	}
}













