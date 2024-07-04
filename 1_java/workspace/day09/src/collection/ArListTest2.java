package collection;

import java.util.ArrayList;

// 리스트 안의 리스트: 2차원 리스트 (ex. 마트료시카)
public class ArListTest2 {
	public static void main(String[] args) {
		//list 객체: 타입(ArrayList), 담고 있는 것의 타입(ArrayList)
		ArrayList<	ArrayList<Integer>	> list = new ArrayList<>();
		
		//각 데이터들이 담길 내부 리스트들 (행의 역할, 소배열 역할)을 생성 후 추가
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		
		//실제 값 담기 : 내부 리스트들을 가져와서 그 리스트에 데이터 추가
		//0행에는 값 3개 추가
		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);

		list.get(1).add(300);
		list.get(1).add(300);
		list.get(1).add(300);
		list.get(1).add(300);
		list.get(1).add(300); //비정방배열처럼 열의 값이 다를 수 있다. 

		//list의 요소 개수(소배열의 개수, 행의 개수)
		for (int i = 0; i < list.size(); i++) {
			//내부 리스트(list.get(i))의 요소 개수(각 행의 요소 개수, 열의 개수)
			for (int j = 0; j < list.get(i).size(); j++) {
				//list.get(i): 내부의 작은 리스트 꺼내오기
				//.get(j): 그 리스트에서 j 번째 요소(Integer) 꺼내오기
				System.out.println(list.get(i).get(j));
			}
		}
		
		
		
	}
}
