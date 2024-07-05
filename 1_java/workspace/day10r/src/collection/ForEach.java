package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

//향상된 for문
public class ForEach {
	public static void main(String[] args) {
		//배열
		int[] arData = {10,20,30,40,50};
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (i+1)*100;
//			System.out.println(i + "번방: " + arData[i]);
//		}
		
		//단순히 조회나 순회할 때 향상된 for문 사용한다.
		for(int data : arData) {
			System.out.println(data);
			//data라는 변수는 arData에 있는 값들을 차례대로 받아오는 별개의 변수이다.
			//따라서 data에 담긴 값을 아무리 수정해도 실제 arData 배열의 각 공간에 있는 값들은 변화가 없다.
			data += 5; //편리하긴 하지만, 이렇게 직접적인 공간( arData[i] )을 사용하는 것은 불가능하다. 
		}
		
		//ArrayList
		ArrayList<Integer> arList = new ArrayList<>();
		arList.add(10);
		arList.add(20);
		arList.add(30);
		arList.add(40);
		arList.add(50);
		
		//오토 언박싱하면서 꺼내 옴
		for(int data : arList) {
			System.out.println(data);
		}
		
		//HashSet
		HashSet<Integer> hSet = new HashSet<>();
		hSet.add(10);
		hSet.add(20);
		hSet.add(30);
		hSet.add(40);
		hSet.add(50);
		
		for(int data : hSet) {
			System.out.println(data);
		}
		
		//HashMap -> entrySet을 이용해야 한다.
		HashMap<String, Integer> map = new HashMap<>();
		map.put("하나", 1);
		map.put("둘", 2);
		map.put("셋", 3);
		map.put("넷", 4);
		map.put("다섯", 5);
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
