package day02;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
//		String choice = "";
//
//		// 1. while문
//		while (!choice.equals("3")) {
//
//			System.out.println("다음 중 프로그래밍 언어가 아닌 것은?\n1. C언어\n2. Java\n3. 사과\n4. 파이썬");
//			choice = sc.next();
//
//			if (choice.equals("3")) {
//				System.out.println("정답입니다 !");
//			} else if (choice.equals("1") || choice.equals("2") || choice.equals("4")) {
//				System.out.println("오답입니다.");
//			} else {
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요!");
//			}
//		}
		
		//2. do ~ while 문
//		String choice = "";
//
//		do {
//			System.out.println("다음 중 프로그래밍 언어가 아닌 것은?\n1. C언어\n2. Java\n3. 사과\n4. 파이썬\n0. 나가기");
//			choice = sc.next();
//
//			if (choice.equals("3")) {
//				System.out.println("정답입니다 !");
//			} else if (choice.equals("1") || choice.equals("2") || choice.equals("4")) {
//				System.out.println("오답입니다.");
//			} else if(choice.equals("0")) {
//				System.out.println("안녕히 가세요...");
//			} else {
//				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요!");
//			}
//		} while (!choice.equals("0"));
		
		
		//3. 무한 반복
		String choice = "0";

		 while (true) {
			System.out.println("다음 중 프로그래밍 언어가 아닌 것은?\n1. C언어\n2. Java\n3. 사과\n4. 파이썬\n0. 나가기");
			choice = sc.next();

			if (choice.equals("3")) {
				System.out.println("정답입니다 !");
				break;
			} else if (choice.equals("1") || choice.equals("2") || choice.equals("4")) {
				System.out.println("오답입니다.");
			} else if(choice.equals("0")) {
				System.out.println("안녕히 가세요...");
				break; //탈출 조건에서 break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요!");
			}
		}
		
		 
		 
		 
	}
}
