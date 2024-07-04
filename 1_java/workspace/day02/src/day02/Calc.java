package day02;

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수: ");
		String num1 = sc.nextLine();
		
		System.out.print("두 번째 정수: ");
		String num2 = sc.nextLine();
		
		//처리
		//두 개의 입력받은 문자열 -> 정수를 더하기
		//1. 입력받은 문자열(num1, num2)을 정수로 바꾸기
		int realNum1 = Integer.parseInt(num1);
		int realNum2 = Integer.parseInt(num2);
		
		//Integer.parseInt("정수로 이루어진 문자열") : 문자열을 정수로 형변환
		//Double.parseDouble("실수로 이루어진 문자열") : 문자열을 실수로 형변환
		
		//2. 바뀐 정수들로 더하기 연산(+)
		int result = realNum1 + realNum2;
		
		//출력
		System.out.println("결과는 " + result +  "입니다.");
		
	
	}
}
