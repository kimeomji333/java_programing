package collection;

import java.util.HashMap;

public class HMapTest1 {
	public static void main(String[] args) {
		HashMap<String, String> dict = new HashMap<>();
		
		//요소 추가
		dict.put("fly", "날다");
		dict.put("walk", "걷다");
		
		//구조 파악
		System.out.println(dict);	//{fly=날다, walk=걷다}
		
		//요소 수정
		//기존에 존재하던 key에 새로운 value를 put()해주면 수정이 일어난다.
		dict.put("walk", "천천히 걷다");
		System.out.println(dict);
		
		//요소 삭제
		//remove(key): 넘겨준 key에 해당하는 value를 리턴하며 삭제
		System.out.println(dict.remove("fly"));
		System.out.println(dict);

		//remove(key, value): 넘겨준 key와 value 씽이 완벽히 일치하는게 있다면 삭제 후 true, 아니라면 삭제하지 않고 false 리턴
		System.out.println(dict.remove("fly", "달리다"));
		System.out.println(dict);
		
		//요소 가져오기
		System.out.println(dict.get("walk"));
		
		
	}
}
