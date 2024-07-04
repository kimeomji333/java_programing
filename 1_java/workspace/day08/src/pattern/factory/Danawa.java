package pattern.factory;

public class Danawa {
	public static void main(String[] args) {
//		Computer computer = new Computer();
//		Camera camera = new Camera();
//		Dryer dryer = new Dryer(); //대신에 Factory에 객체를 요구
		
		//이제 객체를 직접 만드는 것이 아니라, 설계된 Factory 클래스에 객체를 요구할 것임 
		Computer computer = (Computer)Factory.getInstance("Computer");

		//이렇게 사용하면 기본 생성자가 없으면 문제가 생김. 즉 강한 의존성을 약화시키고자 팩토리 패턴을 이용
//		Computer[] arComputer1 = {
//				new Computer(),
//				new Computer(),
//				new Computer(),
//				new Computer()
//		};

		Computer[] arCompouter2 = {
				(Computer)Factory.getInstance("Computer"),
				(Computer)Factory.getInstance("Computer"),
				(Computer)Factory.getInstance("Computer"),
				(Computer)Factory.getInstance("Computer")
		};
		
	}
}
