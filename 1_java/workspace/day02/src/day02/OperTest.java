package day02;

import java.util.Scanner;

public class OperTest {
	
	public static void main(String[] args) {
		//삼항 연산자
//		String msg = 10>3 ?"true": "false";
//		System.out.println(msg);
//		
		// 사용자에게 정수 하나 입력 받아서 양수, 음수, 0을 판단하고 결과 출력
		// 10 -> 양수입니다. 
		// -10 -> 음수입니다. 
		// 0 -> 0입니다.
		
		//입력
		//정수 하나 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요: ");
		int num = sc.nextInt();	
		
		//처리
		//위에서 입력받은 정수가 양수, 음수, 0 중에 이떤 것에 해당하는 지 판단 !
//		boolean pas = num > 0;
//		boolean nav = num < 0;
//		
//		//출력
//		System.out.println(pas ? "양수입니다." : nav? "음수입니다." : "0입니다.");
		
		String result = num > 0 ? "양수입니다." : num < 0 ? "음수입니다." : "0입니다.";
		System.out.println(result);
	}
}
