package bms;

import java.util.Scanner;

//index : 처음으로 시작하는 곳
public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("☆★☆★☆★BMS 프로그램 입니다★☆★☆★☆");
		while(true) {
			System.out.println("1. 계좌개설\n2. 로그인\n3. 나가기");
			int choice = sc.nextInt();
			if(choice == 3) {
				System.out.println("안녕ㅎl ㄱr세yo...☆");
				break;
			}
			switch(choice) {
			case 1:
//				new JoinView().f();
				new JoinView();
				break;
			case 2:
				new LoginView();
				break;
			}
		}
	}
}





