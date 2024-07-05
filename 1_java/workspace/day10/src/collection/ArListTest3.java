package collection;

import java.util.ArrayList;

public class ArListTest3 {
	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<>();
		userList.add(  new User("apple", "1234", "김사과")  );
		userList.add(  new User("banana", "1234", "반하나")  );
		userList.add(  new User("cherry", "1234", "이체리")  );
		
//		컬렉션 객체는 출력시 내부에 있는 객체들의 toString()으로 리턴되는 문자열들을 보여준다.
//		우리가 만든 클래스 타입의 객체를 저장할 때에는 그 클래스에 toString()을 재정의해서
//		우리가 보기에 편한 문자열로 볼 수 있도록 해야한다.
		System.out.println(userList);
		
//		remove 메소드는 값으로 삭제시 내부에서 넘긴 객체의 equals()로 같은 객체를 찾아 삭제한다.
//		우리가 만든 클래스에서 equals()를 주소 비교가 아닌 값 비교를 할 수 있도록 재정의 해서
//		올바르게 지울 대상을 찾도록 해야한다.
		userList.remove(  new User("banana", "1234", "반하나")  );
		System.out.println(userList);
		
	}
}









