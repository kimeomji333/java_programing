package collection;

import java.util.HashMap;

public class HMapTest1 {
	public static void main(String[] args) {
		HashMap<String, String> dict = new HashMap<>();
		
//		HashMap에 요소 추가하기
		dict.put("fly", "날다");
		dict.put("walk", "걷다");
		dict.put("run", "뛰다");
		
//		HashMap의 구조 간단하게 파악하기
		System.out.println(dict);
		
//		HashMap의 요소 수정하기
//		기존에 존재하던 Key에 새로운 Value를 put() 해주면 수정이 일어난다.
		dict.put("run", "달리다");
		System.out.println(dict);
		
//		HashMap의 요소 삭제하기
//		remove(key) : 넘겨준 Key에 해당하는 Value를 리턴하며 삭제
//		System.out.println("마지막 유산 : "+dict.remove("run"));
//		System.out.println(dict);
		
//		remove(key,value) : 넘겨준 Key와 Value 쌍이 완벽히 일치하는게 있다면 삭제 후 true, 아니라면 삭제하지 않고 false 리턴
		System.out.println(dict.remove("fly","달리다"));
		System.out.println(dict);
		
//		HashMap에서 요소 가져오기
		System.out.println(dict.get("run"));
	}
}











