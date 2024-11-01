package obj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date data = new Date();
		System.out.println(data);	//Thu Jul 04 12:10:31 KST 2024
		
//		System.out.println(data.getMonth());	//6 (월은 0이 1월부터 시작)
		//지역을 상징하는 고유한 정보를 가지고 있는 객체
		ZoneId zone = ZoneId.systemDefault();

		//			=	시간 정보를 가진 객체.지역에서.지역연월일정보
		LocalDate ld = data.toInstant().atZone(zone).toLocalDate();
		System.out.println(ld);					//2024-07-04
		System.out.println(ld.getYear());		//2024
		System.out.println(ld.getMonthValue());	//7
		System.out.println(ld.getDayOfMonth());	//4
		
		LocalDateTime ldt = data.toInstant().atZone(zone).toLocalDateTime();
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
		
		//---------------------------------java--------------------------------------------
		//↓현재 시간정보 객체를 만들 때 쉽게 사용할 수 있음(자바에서만). //위의 경우는 다른 언어와 협업시에 알아야함
		LocalDateTime now = LocalDateTime.now(); 
		
		//지정된 순간
		LocalDateTime ind_day = LocalDateTime.of(1945, 8, 15, 12, 20, 11);
		System.out.println(ind_day);	//1945-08-15T12:20:11
		
		//시간 정보를 서식화
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String time = ind_day.format(formatter);
		System.out.println(time);
		
		
	}

}
