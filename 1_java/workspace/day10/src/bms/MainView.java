package bms;

import java.util.Scanner;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		//BankManager 클래스에 있는 session 객체를 편하게 쓰기 위해 따로 변수에 담기
		Bank loginUser = (Bank)BankManager.session.get("loginUser");
		
		while(true) {
			System.out.println("1. 입금하기\n2. 출금하기\n3. 잔액보기\n4. 로그아웃");
			int choice = sc.nextInt();
			if(choice == 4) {
				System.out.println("다음에 다시 만나요~");
				//로그아웃시 session이라는 공간 자체를 지우는 것이 아니라
				//session에 "loginUser"로 저장되어 있는 Value를 지워야 한다.
				//따라서 remove()를 사용하거나 혹은
				//해당 Key로 null을 추가해서 지워진듯한 효과를 내야한다.
				
				BankManager.session.remove("loginUser");
//				BankManager.session.put("loginUser",null);
				break;
			}
			//session 객체는 업캐스팅 하며 저장했던 객체를 그대로 꺼내서 담아준 것이므로 업캐스팅 되어있는 상태이다.
			//따라서 오버라이딩 한 메소드는 새로운 내용으로 수행하게 된다.(자식에서 추가된 내용이 없으므로 굳이 다운캐스팅 안 해도 됨)
			//어떤 은행 객체가 업캐스팅 되어있는지에 따라 특정 메소드는 새로운 내용으로 수행
			switch(choice) {
			case 1:
				System.out.print("입금하실 금액 : ");
				money = sc.nextInt();
				loginUser.deposit(money);
				break;
			case 2:
				System.out.print("출금하실 금액 : ");
				money = sc.nextInt();
				if(!loginUser.withdraw(money)) {
					System.out.println("저런~ 안타까운 잔액이네요~");
				}
				break;
			case 3:
				loginUser.show();
				break;
			}
		}
	}
}





