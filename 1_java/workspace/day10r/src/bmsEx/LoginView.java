package bmsEx;

import java.util.Scanner;

//2. 로그인
public class LoginView {
	public LoginView() {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String account = sc.next();
		
		System.out.println("비밀번호: ");
		String pw = sc.next();
		
		//출력
		BankManager manager = new BankManager();
		if(manager.login(account, pw)) {
			System.out.println("성공적으로 로그인되었습니다.\n" + BankManager.session.name + "님 다시 보니 반갑습니다. ");
			new MainView();
		} else {
			System.out.println("알 수 없는 오류 발생 / 로그인에 실패했습니다.");
		}
	}
}
