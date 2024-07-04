package road;

public class Road {
	public static void main(String[] args) {
		Car[] garage = {
			new Car("K7", "White", 4000),
			new SuperCar("Ferrari", "Red", 70000),
			new SuperCar("Porsche", "Yellow", 20000)
		};
		
		Car temp = new SuperCar();
//		temp.engineStart();
		
		for (int i = 0; i < garage.length; i++) {
			garage[i].engineStart();
		}
		
//		SuperCar s = (SuperCar)garage[1];
//		s.roofOpen();
//		s.roofOpen();
//		s.roofOpen();
		for (int i = 0; i < garage.length; i++) {
			//0번방에는 Car타입의 일반적인 객체가 담겨있어서 다운캐스팅 불가능(오류발생)
			//1번방, 2번방에는 업 캐스팅 된 객체가 있기 때문에 다운캐스팅 가능
			//0번방일때는 instanceof 조건식이 false
			//1, 2번방일때는 조건식의 결과가 true
			if(garage[i] instanceof SuperCar) {
				SuperCar s = (SuperCar)garage[i];
				s.roofOpen();
			}
		}
	}
}








