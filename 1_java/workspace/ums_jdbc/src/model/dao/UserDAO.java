package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.UserDTO;

//DB 접근하기 위한 객체인 DAO
//Connection, PreparedStatement, ResultSet 준비 (다리, 택배차, 답장)
//udao.getUserByUserid를 사용했다는건 생성자를 호출했다는거. 생성자에서 udao 만들어질 때마다 connection을 잡아주면 된다.
public class UserDAO {
	//전역변수로
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	//순서: sql문, 택배차, ?준비, 택배차출발, 답장
	public UserDTO getUserByUserid(String userid) {
		//데이터 로직은 순수하게 데이터에 관련된 로직만 구성되어 있다.
		//뭔진 몰라도 넘겨진 userid로 User객체 찾아서 돌려주기만 하면 끝
		//목표 : API 이용해서 데이터베이스 접근 후 객체로 리턴
		
		String sql = "select * from user where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			//userid는 pk니깐 1개 아니면 0개 -> 반복문이 아니라 조건문 이용
			if(rs.next()) {
				//결과가 있다면 한 줄 꺼내서 userDTO 객체를 만들어야 함.
				UserDTO user = new UserDTO(
						rs.getString("userid"),
						rs.getString("userpw"),
						rs.getString("username"),
						rs.getInt("userage"),
						rs.getString("userphone"),
						rs.getString("useraddr")
				);

				return user;
			}
			
		} catch (SQLException e) {
		}
		//결과가 없다면 null 리턴
		return null;
	}

	public boolean insertUser(UserDTO user) {
		String sql = "insert into user values(?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setInt(4, user.getUserage());
			ps.setString(5, user.getUserphone());
			ps.setString(6, user.getUseraddr());
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
		}
		
		return false;
	}

	//동적 쿼리 연결을 위해 문자열 연결로 함.
	public boolean updateUser(String loginUser, String col, String newData) {
		String sql = "update user set " +col+ " = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newData);
			ps.setString(2, loginUser);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
		}
		
		return false;
	}

	public void deleteUser(String loginUser) {
		String sql = "delete from user where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginUser);
			
		} catch (SQLException e) {
		}
	}
}
