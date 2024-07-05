package collection;

import java.util.HashSet;

public class HSetTest1 {
	public static void main(String[] args) {
		HashSet<Integer> hSet = new HashSet<>();
		
		//HashSet에 요소 추가하기
		hSet.add(10);
		hSet.add(20);
		hSet.add(30);
		hSet.add(40);
		hSet.add(50);
		hSet.add(10);
		hSet.add(10);
		hSet.add(10);

		//구조 파악
		System.out.println(hSet); //[50, 20, 40, 10, 30]
		
		for (int i = 0; i < hSet.size(); i++) {
//			System.out.println(hSet.get(i)); //.get(i)을 사용할 수 없음. 순서가 없기 때문에
		}
		
		//요소 포함 여부 확인하기
		System.out.println(hSet.contains(80));	//false
		System.out.println(hSet.contains(10));	//true
		
		//요소 삭제
		hSet.remove(20); //박싱 안하고 넘겨도 된다. 매개변수 자리에 Object면 아무거나 넘겨도 된다는 뜻
		System.out.println(hSet);
		
		
	}

}
