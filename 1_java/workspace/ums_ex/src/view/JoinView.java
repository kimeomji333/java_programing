package view;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;
import controller.UserController;
import model.dto.UserDTO;

public class JoinView {
	public JoinView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		System.out.println("----- welcome to Join page -----");
		System.out.print("id: ");
		String userid = sc.nextLine();
		if(controller.checkId(userid)) {
			System.out.print("password: ");
			String userpw = sc.nextLine();
			System.out.print("password again: ");
			String userpw_re = sc.nextLine();
			if(userpw.equals(userpw_re)) {
				System.out.print("name: ");
				String username = sc.nextLine();
				System.out.print("age: ");
				String userage = sc.nextLine();
				System.out.print("phone number: ");
				String userphone = sc.nextLine();
				System.out.print("address: ");
				String useraddr = sc.nextLine();
				
				//처리
				UserDTO user = new UserDTO(userid, userpw, username, Integer.parseInt(userage), userphone, useraddr);
				if(controller.join(user)) {
					System.out.println("Join is SUCCESS!!");
				}
				else {
					System.out.println("Join is FAIL!!");
				}
			} 
			else {
				System.out.println("password is wrong! try again!");
			}
		}
		else {
			System.out.println("There is a duplicated Id. try again!");
		}
	}
}
