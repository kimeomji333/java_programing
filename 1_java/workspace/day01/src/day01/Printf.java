package day01;

// 개인 공부
public class Printf {

	public static void main(String[] args) {
		int age = 20;
		String addr = "서울시 강남구";
		
		// %n 지시자 사용 X
		System.out.printf("줄");
		System.out.printf("바꿈");
		
		// %n 지시자 사용 O
		System.out.printf("줄%n");
		System.out.printf("바꿈%n");

		
		System.out.printf("나이는 %d살 입니다.%n", age);
		System.out.printf("나이는 %d살이고, %s에 살고 있습니다.%n", age, addr);
	
	}
}
