package view;

import java.util.Scanner;

import controller.UserController;
import model2.Session;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		System.out.println("----- welcome to login -----");
		System.out.print("id: ");
		String userid = sc.nextLine();
		System.out.print("password: ");
		String userpw = sc.nextLine();
		
		//id, pw check
		if(controller.login(userid, userpw)) {
			System.out.println("Login is SUCCESS!");
			System.out.println(Session.getData("loginUser") + ", welcome!");
			new MainView();
		} else {
			System.out.println("check your Id or password!");
		}
	}


}
