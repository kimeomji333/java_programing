package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Session;
import model.dao.ProductDAO;
import model.dao.UserDAO;
import model.dto.ProductDTO;
import model.dto.UserDTO;

public class UserController {
	public boolean checkId(String userid) {
		//어떤 기능을 개발하는 코드는 여러 데이터로직(데이터들을 관리하는 로직)과 비즈니스로직(실제 알고리즘)들이 합쳐진 형태
		//데이터 접근용 객체(DAO)를 이용해서 userid값을 넘겨주며 UserDTO 객체 찾기(데이터 로직)
		//찾은 객체가 있는지 없는지를 비교(== null / 비즈니스 로직)한 후 결과를 리턴
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		//데이터 로직을 활용해서 비즈니스 로직을 구현한 상태
		//검색된 user가 없을 때 참이므로 null일때 true를 리턴
		return user == null;
	}

	public boolean join(UserDTO user) {
		//목적 : 전달받은 DTO 객체에 담긴 정보들을 데이터베이스에 삽입
		UserDAO udao = new UserDAO();
		//데이터 접근용 객체를 활용해서 데이터베이스에 데이터들 삽입
		return udao.insertUser(user);
	}

	public boolean login(String userid, String userpw) {
		//목표 : 넘겨받은 아이디로 유저를 찾고, 찾은 유저의 비밀번호가 넘겨받은 비밀번호와 같다면 로그인 성공
		UserDAO udao = new UserDAO();
		//아이디로 유저 찾기(데이터 로직)
		UserDTO user = udao.getUserByUserid(userid);
		//유저가 찾아졌다면
		if(user != null) {
			//찾은 유저의 비밀번호도 비교
			if(user.getUserpw().equals(userpw)) {
				//로그인 성공시 세션에 세팅
				Session.setData("loginUser", user.getUserid());
				return true;
			}
		}
		return false;
	}

	public HashMap<String, Object> getDetail(String loginUser) {
		//두 개 이상의 데이터베이스에 접근해야 하므로 DAO가 두 개 이상 필요할 수도 있음.
		UserDAO udao = new UserDAO();
		ProductDAO pdao = new ProductDAO();
		
		//유저 정보 긁어오기
		UserDTO user = udao.getUserByUserid(loginUser);
		//상품 정보들 긁어오기
		ArrayList<ProductDTO> list = pdao.getList(loginUser, 1, 1);
		//상품 리스트가 null이라면 0, 아니라면 그 개수
		int prodCnt = list == null ? 0 : list.size();
		
		//위에서 조회된 모든 정보들을 HashMap에 담아서 리턴
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user", user);
		datas.put("prodCnt", prodCnt);
		return datas;
	}

	public boolean modifyUser(String loginUser, int choice, String newData) {
		//choice : 1(비밀번호 수정) / 2(핸드폰 번호 수정) / 3(주소 수정)
		String[] cols = {"","userpw","userphone","useraddr"};
		UserDAO udao = new UserDAO();
		String col = cols[choice];
		
		return udao.updateUser(loginUser,col,newData);
	}

	public boolean leaveId(String loginUser) {
		//탈퇴 시 그 사람이 올렸던 모든 상품들도 삭제해주어야 함
		//leaveId 라는 기능은, Product와 User 두 가지 정보에 모두 접근해야 하므로 DAO를 두 개 사용
		UserDAO udao = new UserDAO();
		ProductDAO pdao = new ProductDAO();
		
		//현재 탈퇴하려는 사람의 모든 상품 목록을 불러와서
		ArrayList<ProductDTO> list = pdao.getList(loginUser, 1, 1);
		//상품들을 하나씩 꺼내며 반복
		for (ProductDTO product : list) {
			//꺼낸 상품들의 번호를 넘겨주며 삭제 요청
			pdao.deleteProductByProdnum(product.getProdnum());
		}
		//회원 데이터베이스 에서 이 사람의 정보를 삭제"해줘" 요청
		udao.deleteUser(loginUser);
		//탈퇴되었으므로 로그인 된 정보를 유지하는 세션도 초기화를 진행해야 한다.
		Session.setData("loginUser", null);
		return true;
	}
}












