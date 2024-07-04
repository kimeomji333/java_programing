package obj;

public class ObjectTest2 {
	public static void main(String[] args) {
		String msg1 = "Hello";
		String msg2 = "Hello";
		String msg3 = new String("Hello");
		
		System.out.println(msg1 == msg2); //true 
		System.out.println(msg1.equals(msg2)); //true
		System.out.println(msg1 == msg3); //false
		System.out.println(msg1.equals(msg3)); //true
		
		TestData obj1 = new TestData(10, 0.0);
		TestData obj2 = new TestData(10, 0.0);
		
		System.out.println(obj1 == obj2);  //false
		
		//false 내부에서 상위클래스를 상속받아 쓰고 있으니 주소비교를 하고 있으니깐, 
		//동위(위상) 객체가 동일 객체로 여겨져야 할 때, 재정의가 필요하다. //true
		//우리가 만든 클래스(특히 데이터를 포장하는 클래스)에서는 재정의를 해야한다.
		System.out.println(obj1.equals(obj2));  
		
	}

}
