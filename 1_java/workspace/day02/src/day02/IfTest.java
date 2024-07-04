package day02;

import java.util.Scanner;

public class IfTest {

	// Ctrl + M : 보고있는 창 최대화
	// Ctrl + Shift + F : 들여쓰기 정리
	
		public static void main(String[] args) {
			
			//입력
			Scanner sc = new Scanner(System.in);
			System.out.print("숫자를 입력해주세요: ");
			int num = sc.nextInt();
			
			//처리 - 조건문 이용
			String result = "";
			
			if(num > 0) {
				result = "양수입니다.";
			} else if (num < 0) {
				result = "음수입니다.";
			} else {
				result = "0입니다.";
			}
				
			//출력 - 일괄 처리 방식 (반대말로 분기 처리 방식)
			System.out.println(result);
			
		}
}
