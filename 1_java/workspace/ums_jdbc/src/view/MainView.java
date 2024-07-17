package view;

import java.util.Scanner;

import model.Session;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======메인화면======");
		while(true) {
			System.out.println("1. 상품 추가\n2. 상품 수정\n3. 상품 삭제\n"
					+ "4. 내 상품 보기\n5. 상품 검색\n6. 내 정보 수정\n7. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice == 7) {
				System.out.println(Session.getData("loginUser")+"님 다음에 또 오세요~");
				Session.setData("loginUser", null);
				break;
			}
			switch(choice) {
			case 1:
				//상품 추가
				new AddProductView();
				break;
			case 2:
				//상품 수정
				new ModifyProductView();
				break;
			case 3:
				//상품 삭제
				new RemoveProductView();
				break;
			case 4:
				//내 상품 보기
				new MyListView();
				break;
			case 5:
				//상품 검색
				new SearchView();
				break;
			case 6:
				//내 정보 수정
				new MyInfoView();
				break;
			}
		}
	}
}









