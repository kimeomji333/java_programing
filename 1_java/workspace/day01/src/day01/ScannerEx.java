package day01;

import java.util.Scanner;

// 개인 공부
public class ScannerEx {
	
	public static void main(String[] args) {
		// nextInt() 예시
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int num = sc.nextInt();
		System.out.println(num);
		
		
		// nextLine() 예시
		Scanner sc2 = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String str = sc2.nextLine();
		System.out.println(str);
		
	}
}
