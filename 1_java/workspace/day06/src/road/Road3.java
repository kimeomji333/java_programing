package road;

public class Road3 {
	public static void main(String[] args) {
		
		SuperCar mycar = new SuperCar("Ferrari", "Red", 700000, "우주모드"); //상속받은 걸로 객체 만들었음
		Car momcar = new Car("K7", "White", 4000);
		
		mycar.engineStart();
		mycar.roofOpen();
		momcar.engineStart();
	}
}

