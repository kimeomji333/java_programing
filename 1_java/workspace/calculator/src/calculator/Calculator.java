package calculator;

import java.util.Scanner;

//계산기를 만들어보자 !
public class Calculator {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println(" < 계산기 > ");
		System.out.println("1. 계산기 작동\n2. 나가기");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			while(true) {
				System.out.print("첫번째 정수를 입력해주세요: ");
				int num1 = sc.nextInt();
				
				System.out.print("두번째 정수를 입력해주세요: ");
				int num2 = sc.nextInt();
				
				System.out.print("연산자를 입력해주세요(+,-,/,*): ");
				sc.nextLine();
				String oper = sc.nextLine();
				
				//처리
				int result = 0;
				//oper의 경우에 따라서 연산이 되어지도록
				if(oper.equals("+")) {
					result = num1 + num2;
				} else if(oper.equals("-")) {
					result = num1 - num2;
				} else if(oper.equals("/")) {
					result = num1 / num2;
				} else if(oper.equals("*")){
					result = num1 * num2;
				} else {
					System.out.println("연산자를 잘못 입력하셨습니다. 정확히 입력해주세요.");
				}
				
				// 출력
				System.out.println(result);
				
				//재시작 여부
				
				System.out.print("재시작하겠습니까? (재시작은 1번, 나가기 버튼은 0번): ");
			}
			
		case 2:
			break;
		}
	}
}
	
//게임시작하기
//정수, 연산자 입력
//결과값 출력. 반복문 끝. 재시작 여부 

