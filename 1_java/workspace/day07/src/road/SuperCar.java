package road;

public class SuperCar extends Car {
	String mode;
	
	public SuperCar() {
		//super : 상속받고 있는 부모 클래스의 이름
		//ex) super(); ---> Car();
		super();
	}
	
	//Alt + Shift + S > C : 부모 생성자를 받아와서 똑같은 형태의 생성자 만들기
	public SuperCar(int price) {
		super(price);
	}

	public SuperCar(String model, String color, int price) {
		super(model, color, price);
	}
	
	//Alt + Shift + S > O
	public SuperCar(String model, String color, int price, String mode) {
		super(model, color, price);
		this.mode = mode;
	}
	
	void engineStart() {
		System.out.println(this.model + " 휘파람으로 시동 켜기");
	}
	
	//@ : 어노테이션
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




