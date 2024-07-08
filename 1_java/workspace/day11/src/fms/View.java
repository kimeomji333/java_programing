package fms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1 초기화면(프론트엔드)
public class View {
	public static void main(String[] args) {
		index();
	}
	
	static void index() {
		//입출력을 위한 스캐너
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 데이터 추가\n2. 데이터 수정\n3. 데이터 삭제\n4. 데이터 전체 조회\n5. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				break;
			}
			switch(choice) {
			case 1:
				addView();
				break;
			case 2:
				updateView();
				break;
			case 3:
				deleteView();
				break;
			case 4:
				readView();
				break;
				
			}
		}
	}


	//화면 추가하기 위한 메소드
	static void addView() {
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 데이터: ");
		String data = sc.nextLine();
		
		//데이터 포장(데이터가 많은 경우엔? 포장 !)
		Model model = new Model();
		model.data = data;
		
		
		//추가(처리로직) - 데이터를 조작하고 관리할 컨트롤러에 gogo
		Controller controller = new Controller();
		controller.insert(model);
		
		System.out.println(data + " 데이터가 추가되었습니다.");
	}

	static void updateView() {
		//찾기(조회) 일치여부 필요 -> 삭제 -> 내용 추가
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 데이터: ");
		String data = sc.nextLine();
		
		System.out.print("어떤 내용으로 수정할 것인지?: ");
		String updatedata = sc.nextLine();
		
		Model updatemodel = new Model();
		updatemodel.data = data;
		
		Controller controller = new Controller();
		controller.update(data, updatemodel);
		
		System.out.println(data + " 데이터가" + updatedata + "로 수정되었습니다.");
	}

	static void deleteView() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 데이터: ");
		String data = sc.nextLine();
		
		Controller controller = new Controller();
		controller.delete(data);
		
		System.out.println(data + " 데이터가 삭제되었습니다.");
	}
	
	static void readView() {
		Controller controller = new Controller();
		List<Model> models = controller.read();
		
		for(Model m : models) {
			System.out.println(m.getData());
		}
		
		System.out.println("데이터가 조회되었습니다.");
	}
}
