package jdbc_day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest3 {
	public static void main(String[] args) {
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "select * from test";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//시스템을 변화시키는 쿼리문(insert, update, delete) : executeUpdate()
			//select : executeQuery -> 타입: ResultSet
			ResultSet rs = ps.executeQuery();
			
//			rs.next(); //다음 줄(첫 번째 행)으로 이동
//			rs.getString("strdata"); //strdata에 있는 첫 번째 행 데이터
//			rs.getDouble("doubledata"); 
//			
//			rs.next(); //두 번째 행으로 이동 -> 반복문이용 하자. rs.next()는 boolean 타입
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String strdata = rs.getString("strdata");
				double doubledata = rs.getDouble("doubledata"); 
				String timedata = rs.getString("timedata");
				
				System.out.println(num + "/" + strdata + "/" + doubledata + "/" + timedata);
			}
			
		} catch (SQLException e) {
		}
		
	}
}
