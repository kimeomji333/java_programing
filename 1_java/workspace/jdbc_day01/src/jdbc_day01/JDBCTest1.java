package jdbc_day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JDBCTest1 {
	public static void main(String[] args) {
		
		//Java -> DBMS(MySQL)과 연결 
		//어떤 위치에 설치 되어 있는지: PORT 번호 -> localhost:3306/gb
		
		//Driver.class(설계도) 에 설계되어 있으니, 가져다가 쓰면 된다. 설계도 준비.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //클래스를 준비시킬 때 사용하는 메소드
			
			//연결을 위한 정보들(목적지, user, pw)
			String url = "jdbc:mysql://localhost:3306/gb";
			String user = "root";
			String password = "1234";
			
			//Connection 다리 민듦
			Connection conn = DriverManager.getConnection(url, user, password);
			
			//삽입할 데이터
			String strdata = "JDBC Test data6";
			double doubledata = 1.00;
//			String timedata = "2024-07-16 15:50:50";
//			Timestamp timedata = new Timestamp(System.currentTimeMillis());
			String timedata = "now()";
			
			//데이터 삽입을 위한 명령문. 쿼리문
			String sql = "insert into test(strdata, doubledata, timedata) values('"+strdata+"', "+doubledata+", "+timedata+")"; //문자열 연결
			
			//택배차 준비(Statement 객체 생성)
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//택배차 출발
			int result = ps.executeUpdate();
			
			//결과확인
			if(result == 1) {
				System.out.println("워크밴치로 가서 데이터 들어왔는지 확인해보자.");
			} else {
				System.out.println("오타입니다.3");
			}
			
			
		} catch (ClassNotFoundException e) { //Class.forName 준비 잘못시키면 발생하는 exception
			System.out.println("오타입니다.1" + e);
		} catch (SQLException sqle) {
			System.out.println("오타입니다.2" + sqle);
		}
		
	}

}

//try-catch문 자동완성: alt + shift + z
//설계도(Class.forName), 정보 준비(목적자, root, pw), 다리 준비(DriverManager를 이용한 Connection 객체), 데이터 준비(data), 
//쿼리문(sql), 택배차 준비(PreparedStatement), 출발(executeUpdate), 결과확인(조건문)