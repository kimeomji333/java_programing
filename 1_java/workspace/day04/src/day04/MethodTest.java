package day04;

import java.util.Date;

//5 메소드
public class MethodTest {
	public static void main(String[] args) {
		
		MethodTest m = new MethodTest();
		System.out.println( "f(3) 호출 결과: " + m.f(3) );
	}
	
	
	
	//f(x) = 2x + 1
	int f(int x) {
		System.out.println("메소드 출력");
		return 2*x + 1;
	}
	
	
	
	// Hello라고 인사해주는 메소드
	void sayHello() {
		System.out.println("Hello");
	}
	
	
	// 매개변수X 리턴X
	// 홍길동을 10번 출력하는 메소드
	void printName() {
		for(int i = 0; i < 10; i++) {
			System.out.println("홍길동");
		}
	}
	
	
	// 매개변수O 리턴O
	// 착한 일을 하면 선물을 돌려주는 메소드 <- 선물을 받기 위해서 메소드 호출
	// 메소드 이름이 get~~ : ~~를 받아오기 위해 호출하는 메소드(보통 return 값이 있다는 뜻)
	String getGift(String action) {
		String result = "";
		if(action.equals("good")) {
			result = "gift";
		} else {
			result = "ddong";
		}
		return result;
	}
	
	
	// 매개변수X 리턴O
	// 현재 시간정보를 알려주는 메서드
	Date getTime() {
		return new Date();
	}
	
	
	// 매개변수O 리턴X
	// 구구단의 한 단을 출력해주는 메서드
	void printDan(int dan) {
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, dan*i);
		}
	}
	

}
