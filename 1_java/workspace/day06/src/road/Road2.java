package road;

//3 전역변수
public class Road2 {
	public static void main(String[] args) {
		Car mycar = new Car("Ferrari", "Red", 70000);
		Car momcar = new Car("Sportage", "Gray", 4000);
		
		momcar.engineStart();
		momcar.wheel--;
		momcar.price -= 1000;
		
		System.out.println(momcar.wheel);	//3
		System.out.println(momcar.price);	//3000
		
		System.out.println(mycar.wheel);	//3
		System.out.println(mycar.price);	//70000
		
		System.out.println(Car.wheel);		//3

		
	}
}
