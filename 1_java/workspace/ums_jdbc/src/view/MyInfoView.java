package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.Session;
import model.dto.UserDTO;

public class MyInfoView {
	public MyInfoView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");
		//CRUD 과정 중 Read의 경우 여러 데이터들을 조회해서 가지고 와야 할 수 있다.
		//지금의 경우엔 User정보에 해당하는 UserDTO 객체와 상품 개수라는 int 타입의 데이터가 필요하다.
		//UserDTO 객체는 User 엔티티(개체)에 관한 데이터이고, 상품 개수는 Product 엔티티에 관한 데이터이다.
		//원칙적으로는 서로 다른 엔티티의 데이터이기 때문에 UserController와 ProductController에
		//요청을 두 번 보내서 데이터를 받아와야 한다. 하지만 요청을 두 번 보내게 되면 비효율적이기 때문에
		//Read의 경우에는 한 번의 요청으로 두 개 이상의 엔티티의 데이터들을 받아오는 경우가 있다.
		//두 개 이상의 서로 다른 타입의 데이터로 return 될 가능성이 있으므로 HashMap으로 데이터를 돌려주게 설계한다.
		HashMap<String, Object> datas = controller.getDetail(loginUser);
		//돌려받은 HashMap 안에 있는 데이터 꺼내기
		UserDTO user = (UserDTO)datas.get("user");
		int prodCnt = (Integer)datas.get("prodCnt");
		
		System.out.printf("======%8s님의 회원정보======\n",loginUser);
		System.out.println("아이디 : "+user.getUserid());
		System.out.println("비밀번호 : "+user.getUserpw());
		System.out.println("핸드폰 번호 : "+user.getUserphone());
		System.out.println("주소 : "+user.getUseraddr());
		System.out.println("올린 상품의 개수 : "+prodCnt);
		System.out.println("==============================");
		System.out.println("1. 비밀번호 수정\n2. 핸드폰 번호 수정\n3. 주소 수정\n4. 수정 취소\n5. 회원 탈퇴");
		int choice = sc.nextInt();
		if(choice == 4) {
			System.out.println("메인으로 돌아갑니다");
		}
		else if(choice == 5) {
			//회원 탈퇴
			System.out.print("비밀번호 재 입력 : ");
			String userpw = sc.next();
			if(user.getUserpw().equals(userpw)) {
				if(controller.leaveId(loginUser)) {
					System.out.println(loginUser+"님 그 동안 함께해서 행복했습니ㄷr...ㅠ_ㅠ\n다시... 돌아오실..거..죠..?");
				}
			}
		}
		else {
			System.out.print("새로운 정보 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			//Read를 제외한 Create, Update, Delete의 경우에는 그 엔티티의 컨트롤러로 요청을 한다.
			if(controller.modifyUser(loginUser,choice,newData)) {
				System.out.println("정보 수정 완료!");
			}
			else {
				System.out.println("정보 수정 실패 / 다음에 다시 시도해주세요~");
			}
		}
	}
}















