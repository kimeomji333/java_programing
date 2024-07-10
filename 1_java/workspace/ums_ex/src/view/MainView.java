package view;

import java.util.Scanner;

import controller.ProductController;
import model2.Session;

//"1. 상품 추가\n2. 상품 수정\n3. 상품 삭제\n"+ "4. 내 상품 보기\n5. 상품 검색\n6. 내 정보 수정\n7. 로그아웃
public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----- welcome to Main page -----");
		
		while(true) {
			System.out.println("1. addProduct\n2. modifyProduct\n3. deleteProduct\n"
					+ "4. readMyProduct\n5. searchProdect\n6. modifyMyInfo\n7. log_out");
			
			int choice = sc.nextInt();
			if(choice == 7) {
				System.out.println(Session.getData("loginUser")+ ", you choose log_out! See you again!");
				Session.setData("loginUser", null);
				break;
			}
			
			switch(choice) {
			case 1:
				new AddProductView();
				break;
			case 2:
				new ModifyProductView();
				break;
			case 3:
				new DeleteProductView();
				break;
			case 4:
				new ReadMyProductView();
				break;
			case 5:
				new SearchProductView();
				break;
			case 6:
				new ModifyMyInfoView();
				break;
			}
		}
	}
}
