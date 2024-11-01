package obj;

public class ObjectTest1 {
	public static void main(String[] args) {
		TestData obj1 = new TestData(10, 0.0);
		TestData obj2 = new TestData(20, 1.0);
		TestData obj3 = new TestData(10, 0.0);
		System.out.println(obj1); //obj.TestData@6f2b958e 주소값
		System.out.println(obj1.toString()); //object을 상속받으니, 부모메소드 사용가능 (업캐스팅) //obj.TestData@6f2b958e 주소값 -> 재정의 가능
		
		System.out.println(obj2); //obj.TestData@5e91993f 주소값 -> 재정의 가능
		
		System.out.println(obj1.hashCode());	//1993134103 -> 재정의 가능
		System.out.println(obj2.hashCode());	//405662939 -> 재정의 가능
	}

}
