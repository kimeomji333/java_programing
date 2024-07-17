package jdbc_day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest2 {
	public static void main(String[] args) {
		
		Connection conn = DBConnection.getConnection();
		String data1 = "Hello JDBC";
		
//		String sql = "insert into test (strdata, timedata) values('"+data1+"', now())";
//		String sql = String.format("insert into test (strdata, timedata) values('%s', now())", data1);
		String sql = "insert into test (strdata, timedata) values(?, now())";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, data1);
			
			int result = ps.executeUpdate(); //시스템을 변화시키는 쿼리문에서 사용
			
			if(result == 1) {
				System.out.println("성공(데이터 들어왔는지 확인해보자)");
			} else {
				System.out.println("실패");
			}
			
		} catch (SQLException sqle) {
			System.out.println("오타입니다.2" + sqle);
		}
		
		
	}
}
