package bms;

import java.util.Scanner;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		Bank session = BankManager.session;
		
		while(true) {
			System.out.println("1. 입금하기\n2. 출금하기\n3. 잔액보기\n4. 로그아웃");
			int choice = sc.nextInt();
			if(choice == 4) {
				System.out.println("다음에 다시 만나요~");
				BankManager.session = null;
				break;
			}
			switch(choice) {
			case 1:
				System.out.print("입금하실 금액 : ");
				money = sc.nextInt();
				session.deposit(money);
				break;
			case 2:
				System.out.print("출금하실 금액 : ");
				money = sc.nextInt();
				if(!session.withdraw(money)) {
					System.out.println("저런~ 안타까운 잔액이네요~");
				}
				break;
			case 3:
				session.show();
				break;
			}
		}
	}
}





