package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.UserDTO;
import model2.DBConnection;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	//조회
	public UserDTO getUserByUserid(String userid) {
		String sql = "select * from user where userid= ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs= ps.executeQuery();
			
			if(rs.next()) {
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
		
		return null;
	}

	//삽입
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
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		
		return false;
	}

	//삭제
	public void deleteUser(String loginUser) {
		String sql = "delete from user where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginUser);
		} catch (SQLException e) {
		}
		
	}

	//수정
	public boolean updateUser(String loginUser, String col, String newData) {
		String sql = "update user set " + col + " = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, loginUser);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		
		return false;
	}

}
