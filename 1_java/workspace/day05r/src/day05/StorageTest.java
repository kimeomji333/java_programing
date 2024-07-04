package day05;


//2 변수의 종류
public class StorageTest {
	int num; //전역 변수(파란색) - 필드에 선언되는 변수
	int gnum;
	static int snum; // 정적 변수(살짝 기울어짐, 이탤릭체)
	
	
	public static void main(String[] args) {

		// 정적 메소드(static이 붙은 메소드) 내 에서는 일반 전역변수를 사용할 수 없다. 
//		System.out.println(gnum);
		System.out.println(snum);
	}
	
	void f1() {
		int num = 0; //지역 변수(갈색)
		// 지역 변수는 직접 초기화하지 않으면 사용할 수 없다.
		System.out.println(num);
		
		// 지역 변수는 해당 지역에서만 접근 가능
//		System.out.println(data);
		
		// 같은 이름의 변수가 지역, 전역 으로 선언되어 있다면 사용시 지역변수가 우선시된다.
		num = 10;
		
		System.out.println(gnum);
		System.out.println(snum);
	}
	
	// 매개 변수도 지역변수의 일종이다.
	void f2(int data) {
		
		// 매개변수는 호출시에 초기화가 되기 때문에(호출시 값을 넘겨주기 때문에) 사용이 가능하다.
		System.out.println(data);
		
		// 지역변수 num이 없기 때문에 그 다음으로 가까이에 있는 전역변수 num을 찾아 사용한다.
		num = 10;
		
		System.out.println(gnum);
		System.out.println(snum);
	}
}
