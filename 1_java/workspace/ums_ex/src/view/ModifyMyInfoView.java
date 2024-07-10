package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.dto.UserDTO;
import model2.Session;

public class ModifyMyInfoView {
	public ModifyMyInfoView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");
		
		HashMap<String, Object> datas = controller.getDetail(loginUser);
		
		UserDTO user = (UserDTO)datas.get("user");
		int prodCnt = (Integer)datas.get("prodCnt");
		
		System.out.printf("----- %8s 님의 회원 정보 -----\n", loginUser);
		System.out.println("id: " +user.getUserid());
		System.out.println("password: " + user.getUserpw());
		System.out.println("phone number: " + user.getUserphone());
		System.out.println("address: " + user.getUseraddr());
		System.out.println("count of product: " + prodCnt);
		System.out.println("-------------------------");
		
		System.out.println("1. modify to pw\n2. modify to phone number\n3. modify to address\n4. cancel to modify\n5. delete membership");
		int choice = sc.nextInt();
		if(choice == 4) {
			System.out.println("back to the main page");
		} else if(choice == 5) {
			System.out.print("input the re_password for cancel: ");
			String userpw = sc.next();
			if(user.getUserpw().equals(userpw)) {
				if(controller.leaveId(loginUser)) {
					System.out.println(loginUser + ", i'm happy to you! see you again later!");
				}
			}
		} else {
			System.out.print("input the new info: ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			if(controller.modifyUser(loginUser, choice, newData)) {
				System.out.println("success to modify your information!");
			} else {
				System.out.println("fail to modify / try again!");
			}
		}
	}
}
