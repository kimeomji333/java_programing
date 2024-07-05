package collection;

//2
import java.util.ArrayList;

public class ArListTest3 {
	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<>();
		userList.add(new User("apple", "1234", "김사과"));	//user 객체를 추가
		userList.add(new User("banana", "1234", "반하나"));	
		userList.add(new User("cherry", "1234", "이채리"));	
	
		//-> 객체에 오버라이딩 해줌
		
		//컬렉션 객체는 출력시 내부에 있는 객체들의 toString()으로 리턴되는 문자열들을 보여준다.
		//user들의 toString 재정의를 안했기 때문에 Object의 toString이 나옴 
		//[collection.User@1eb44e46, collection.User@6504e3b2, collection.User@515f550a]
		//[apple(김사과), banana(반하나), cherry(이채리)] <- User 클래스에서 재정의해줌
		System.out.println(userList);	
		
		//remove 메소드는 값으로 삭제시 내부에서 넘긴 객체의 equals()로 같은 객체를 찾아 삭제한다.
		//우리가 만든 클래스에서 equals()를 "주소 비교"가 아닌 "값 비교"를 할 수 있도록 재정의 해서 올바르게 지울 대상을 찾도록 해야한다.
		userList.remove(new User("banana", "1234", "반하나"));
		System.out.println(userList);	
		//즉, 값 비교할 수 있게 재정의를 해서 내부에서 넘겨준 객체와 equals로 비교해서 객체의 값을 넘겨서 삭제
		
		
		
	}
}
