package road;


public class SuperCar extends Car {
	String mode;
	
	public SuperCar() {
		super();
	}
	
	
	//부모 생성자를 받아와서 사용할 수 있음
	//Alt + Shift + S > C: 부모 생성자를 받아와서 똑같은 형태의 생성자 만들기
	public SuperCar(int price) {
		super(price);
	}
	
	public SuperCar(String model, String color, int price) {
		super(model, color, price); //super: 상속받고 있는 부모 클래스의 이름 //ex) super(); -> Car();
	}


	//Alt + Shift + S > O: 필드 이용해서 생성자 만들기
	public SuperCar(String model, String color, int price, String mode) {
		super(model, color, price);
		this.mode = mode;
	}
	
	//자식 메소드(부모의 메소드와 이름이 동일)
	void engineStart() {
		System.out.println(this.model + " 휘파람으로 시동 켜기");
	}
	
	@Override
	void engineStop() {
		System.out.println(this.model + " 휘파람으로 시동 끄기");
	}
	
	void roofOpen() {
		System.out.println(this.model + " 뚜껑 열기");
	}
	

	void roofClose() {
		System.out.println(this.model + " 뚜껑 닫기");
	}
}

//		super(model, color, price); //부모생성자 //super() 작성하지 않아도 부모 기본 생성자가 호출됨
//		//생성자 호출되기 전에, 부모 기본 생성자 접근이 우선순위(먼저 메모리에 만들어진다)