package bmsEx;

import java.util.Scanner;

//처리 메인 화면
public class MainView {
	public MainView() {
		//입력
		Scanner sc = new Scanner(System.in);
		int money = 0;
		Bank session = BankManager.session;
		
		while(true) {
			System.out.println("1. 입금하기\n2. 출금하기\n3. 잔액보기\n4. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice == 4) {
				System.out.println("정상적으로 로그아웃이 되었습니다. 다음에 만나요!");
				BankManager.session = null;
				break;
			}
			
			//출력
			switch(choice) {
			case 1:
				System.out.print("입금하실 금액: ");
				money = sc.nextInt();
				session.deposit(money);
				break;
			case 2:
				System.out.print("출금하실 금액: ");
				money = sc.nextInt();

				if(!session.withdraw(money)) {
					System.out.println("출금할 수 없는 잔액입니다.");
				}
				break;
			case 3:
				session.show();
				break;
				
			}
		}

	}
}
