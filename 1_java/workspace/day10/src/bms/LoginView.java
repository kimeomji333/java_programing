package bms;

import java.util.Scanner;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		BankManager manager = new BankManager();
		
		System.out.print("계좌번호 : ");
		String account = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		//로그인 처리 메소드 호출
		if(manager.login(account,pw)) {
			//session 이라는 HashMap에 "loginUser"라는 Key로 로그인 성공한 객체가 담겨있는 상태
			//get으로 해당 객체를 꺼내서 사용 (Object로 업캐스팅 되어있는 상태)
			Bank loginUser = (Bank)BankManager.session.get("loginUser");
			//사용할 때는 다운캐스팅 해서 사용
			System.out.println(loginUser.name+"님 다시 보니 반가워요~");
			//메인화면
			new MainView();
		}
		else {
			System.out.println("알 수 없는 오류 / 로그인 실패");
		}
	}
}





