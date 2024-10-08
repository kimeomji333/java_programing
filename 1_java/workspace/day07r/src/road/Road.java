package road;

//1업 캐스팅/다운 캐스팅
public class Road {
	public static void main(String[] args) {
		//자식 객체도 부모타입의 배열에 담을 수 있다.
		Car[] garage = { 
				new Car("K7", "White", 4000),
				new SuperCar("Ferrari", "Red", 70000), 
				new SuperCar("Porsche", "Black", 50000)
		};
		
		//자식 객체를 부모타입의 변수에 담을 수 있다. 오버로딩은 살아있다. 
		//자식의 내용을 가지고는 있지만, 접근할 수는 없다. ex)엄마폰 예시
		Car temp = new SuperCar();
		
		//temp.engineStart(); //바뀐 내용으로 가능
		
		for (int i = 0; i < garage.length; i++) {
			garage[i].engineStart();
		}
		
		System.out.println("=====================");
		
		//보통 타입을 바꿔 변수에 담아서 메소드 접근에 사용된다. 
//		SuperCar s = (SuperCar)garage[1];
//		s.roofOpen();

		//garage[1]은 현재 Car 타입(부모)
		//roofOpen() 메소드를 사용하려면, SuperCar 타입(자식)으로 변환시켜야함: 다운캐스팅
		((SuperCar)garage[1]).roofOpen(); //연산자 우선순위
		
		for (int i = 0; i < garage.length; i++) {
			if(garage[i] instanceof SuperCar) {//업캐스팅객체 instanceof 자식클래스
			SuperCar s = (SuperCar)garage[i];
			s.roofOpen(); //업캐스팅된 객체가 없으니, 출력 불가 (ClassCastException) - (업캐스팅된 객체인지 판단하는)조건문 이용 > instanceof 이용
			}
		}
	}
}
//0번방에는 Car타입의 일반적인 객체가 담겨 있어서 다운캐스팅 불가능 -> instanceof 조건식이 false
//1,2번방에는 업캐스팅된 객체가 있어서 다운캐스팅 가능 -> true
