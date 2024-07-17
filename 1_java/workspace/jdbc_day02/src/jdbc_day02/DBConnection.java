package jdbc_day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	//다리는 여러개 지을 필요없이 다른 클래스로 빼서 <싱글톤 패턴>으로 만듦
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/gb";
				String user = "root";
				String password = "1234";
				
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패");
			} catch (SQLException e) {
				System.out.println("DB 연결 실패");
			}
		}
		return conn;
	}
}
