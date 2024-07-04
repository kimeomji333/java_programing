package day05;


//3

public class ClassTest {
	
	public static void main(String[] args) {
//		Car mycar = new Car(); // 객체화
//		System.out.println(mycar); // day05.Car@6f2b958e
//		mycar.model = "Ferrari";  
//		mycar.color = "Red";
//		mycar.price = 70000;
//		System.out.println(mycar.model);
//		
//		Car mycar2 = new Car();
//		System.out.println(mycar2); // day05.Car@5e91993f
//		mycar2.model = "Audi";  
//		mycar2.color = "Gray";
//		mycar2.price = 20000;
//		System.out.println(mycar2.model);
		
		Car mycar = new Car("Ferrari", "Red", 70000);
		System.out.println(mycar.model);
		Car momcar = new Car("K7", "White", 4000);
		Car dadcar = new Car("G80", "Black", 7000);
		
		mycar.engineStart();
		momcar.engineStart();
		dadcar.engineStart();
	}
}

// 클래스 선언
class Car {
	// (필드) 속성, 성징들을 변수로 선언
	String carNum;
	String model;
	String color;
	int price;
	
	
	
	// 기본 생성자(매개변수 없음)
	public Car() {
	}
	
	// 생성자: 객체를 초기화하는 특별한 메서드
	public Car(String model, String color, int price) {
		this.model = model;
		this.color = color;
		this.price = price;
	}
	
	
	
	// 메소드: 기능 행위, 클래스의 동작을 정의
	void engineStart() {
		// 지역변수 model이 선언된 것이 없으므로 this. 은 생략이 가능하다.
		System.out.println(model + " 시동 켜기");
	}
	
	void engineStop() {
		System.out.println(model + " 시동 끄기");
	}
	
	
}
