package bmsEx;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---- BMS 은행입니다 ----");
		
		while(true) {
			System.out.println("1. 계좌 개설\n2. 로그인\n3. 나가기");
			
			int choice = sc.nextInt();
			if(choice == 3) {
				System.out.println("프로그램 종료합니다. 안녕히 가세요.");
				break;
			}
			
			switch(choice) {
			case 1: 
				new JoinView();
				break;
			case 2:
				new LoginView();
				break;
			}
		}
		
	}
}
