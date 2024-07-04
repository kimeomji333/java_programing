package bms;

import java.util.Scanner;

public class LoginView {
	
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		BankManager manager = new BankManager();
		
		System.out.print("계좌번호: ");
		String account = sc.next();
		System.out.print("비밀번호: ");
		String pw = sc.next();
		
		if(manager.login(account, pw)) {
			System.out.println(BankManager.session.name + "님 다시 보니 반갑습니다.");
			//(로그인 후)메인화면
			new MainView();
			
		} else {
			System.out.println("알 수 없는 오류 / 로그인 실패");
		}
		
	}
}
