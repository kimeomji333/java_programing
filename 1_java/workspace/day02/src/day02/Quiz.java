package day02;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("다음 중 프로그래밍 언어가 아닌 것은?\n1. C언어\n2. Java\n3. 사과\n4. 파이썬");
		String choice = sc.next();
		
		//if문
		//"문자열1".equals("문자열2") : 문자열끼리 일치한다면 true
//		if(choice.equals("3")) {
//			System.out.println("정답입니다!");
//		} else if(choice.equals("1") || choice.equals("2") || choice.equals("4")) {
//			System.out.println("오답입니다.");
//		} else {
//			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
//		}
		
		
		//swich문
		switch(choice) {
		case "3": 
			System.out.println("정답입니다!");			
			break;
		case "1": 
		case "2": 
		case "4": 
			System.out.println("오답입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
		
		//상황에 맞추어 작성
	}
}

