package bms;

import java.util.Scanner;

public class JoinView {
	public JoinView() {
		// 화면 구현
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 국민은행\n2. 신한은행\n3. 우리은행");
		int bankChoice = sc.nextInt();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("비밀번호: ");
		String pw = sc.next();
		
		//처리 로직
		BankManager manager = new BankManager();
		String account = manager.join(bankChoice, name, pw);
		if(account != null) {
			System.out.println(name + "님 계좌 개설을 환영합니다.");
			System.out.println("계좌번호: " + account);
		} else {
			System.out.println("알 수 없는 오류 발생 / 계좌 개설 실패");
		}
	}
	
	void f() {
		
	}
	
	
}
