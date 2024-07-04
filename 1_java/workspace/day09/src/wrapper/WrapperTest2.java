package wrapper;

public class WrapperTest2 {
	public static void main(String[] args) {
		Integer obj = 10;
		f1(obj);
		
		int data = 10;
		f2(data);
		
		g(obj);				//Integer 타입으로 호출한 메소드: 10
		g(data);			//int 타입으로 호출한 메소드: 10

		g(obj.intValue());	//int 타입으로 호출한 메소드: 10
		g((Integer)data);	//Integer 타입으로 호출한 메소드: 10
	}
	
	//static으로 만들었으니, 객체화 없이 호출 가능
	//오토언박싱
	static void f1(int data) {
		System.out.println("int 타입으로 호출한 메소드: " + data);
	}

	//오토박싱
	static void f2(Integer obj) {
		System.out.println("Integer 타입으로 호출한 메소드: " + obj);
	}
	
	
	static void g(int data)	{
		System.out.println("int 타입으로 호출한 메소드: " + data);
	}
	
	static void g(Integer obj) {
		System.out.println("Integer 타입으로 호출한 메소드: " + obj);
	}
	
	//Object 타입의 매개변수가 선언되어 있다. 
	//1. 아무 타입이나 넘겨
	//2. 객체 하나 넘겨
	//업캐스팅이 
	static void g(Object obj) {
		System.out.println("Object 타입으로 호출한 메소드: " + obj);
	}
}
