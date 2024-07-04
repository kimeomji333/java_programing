package access2;

import access1.AccessTest; //다른 패키지에 있는 클래스를 사용할 때는 소속을 밝혀주어야 한다: import 패키지명.클래스이름

public class AccessMain2 {
	public static void main(String[] args) {
		
//		access1.AccessTest obj = access1.AccessTest();
		AccessTest obj = new AccessTest();
//		System.out.println(obj.data1);
		System.out.println(obj.data2); //public 접근제어자 : 모든 곳에서 접근 가능
//		System.out.println(obj.data3);
		System.out.println(obj.getData3());
		
//		System.out.println(obj.data4);
		
	}
}
