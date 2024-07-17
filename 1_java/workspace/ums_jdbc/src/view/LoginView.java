package view;

import java.util.Scanner;

import controller.UserController;
import model.Session;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		
		System.out.print("아이디 : ");
		String userid = sc.next();
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
		
		//컨트롤러에 아이디와 비밀번호 넘겨주며 로그인 요청
		if(controller.login(userid,userpw)) {
//			System.out.println(userid+"님 어서오세요~");
			//세션에 loginUser라는 Key로 로그인 성공한 사람의 아이디가 세팅되어 있는 상태
			System.out.println(Session.getData("loginUser")+"님 어서오세요~");
			//메인으로 이동
			new MainView();
		}
		else {
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호를 다시 확인해주세요~");
		}
	}
}




