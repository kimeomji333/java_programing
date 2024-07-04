package wrapper;

public class WrapperTest1 {
	public static void main(String[] args) {
//		Integer obj = new Integer(10);	//자바에서는 auto를 지워하기 때문에 밑줄이 그어짐
		
		//박싱
		Integer obj = 10;
		System.out.println(obj);
		
		//언박싱
		int data = obj.intValue(); //int타입의 값을 꺼낸다.
		
		//오토박싱, 오토언박싱
		obj = 10;
		data = obj;
	}

}
