package collection;

import java.util.ArrayList;

public class ArListTest1 {
	public static void main(String[] args) {
		
		ArrayList<String> arData1 = new ArrayList<>();
		
		//ArrayList에 요소 추가하기
		arData1.add("Hello");
		arData1.add("Collection");
		arData1.add("So");
		arData1.add("EZ");
		
		//ArrayList의 구조 간단하게 파악하기
		System.out.println(arData1);	//[Hello, Collection, So, EZ]
		
						//ArrayList의 요소 개수
		for (int i = 0; i < arData1.size(); i++) {
											//ArrayList의 요소 가져오기
			System.out.println(i + "번방 : " + arData1.get(i));
			
//			0번방 : Hello
//			1번방 : Collection
//			2번방 : So
//			3번방 : EZ
		}
		
		//ArrayList의 요소 수정하기
		arData1.set(3, " HARD");
		System.out.println(arData1);	//[Hello, Collection, So,  HARD]
		
		
		//ArrayList의 요소 삭제하기
		arData1.remove(3);
		System.out.println(arData1);	//[Hello, Collection, So]
		//오버로딩 되어 있어서 값이나, 인덱스로도 삭제 가능
		arData1.remove("So");
		System.out.println(arData1);	//[Hello, Collection]
		
		
		ArrayList<Integer> arData2 = new ArrayList<>();
		arData2.add(10);
		arData2.add(20);
		arData2.add(30);
		arData2.add(40);
		arData2.add(50);
		
		System.out.println(arData2);	//[10, 20, 30, 40, 50]
		
		//remove(int index) 매개변수로 index로 들어오기 때문에 30번째 수를 찾게 된다. 박싱하는 과정이 필요함.
		int data = 30;
		arData2.remove((Integer)data); //박싱
		System.out.println(arData2);	//[10, 20, 40, 50]
		
		
	}

}
