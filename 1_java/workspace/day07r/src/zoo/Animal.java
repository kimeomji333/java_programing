package zoo;

public abstract class Animal {

	String name;
	String gender;
	int age;
	
	public Animal(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	//상속 관계에서 재정의가 안되는 메소드에는 final을 붙인다.
	final void init() {
		System.out.println(name + "은 동물입니다.");
	}
	
	void eat() {
		System.out.println(name + "가 먹는 중");
	}
	
	void sleep() {
		System.out.println(name + "가 자는 중");
	}
	
	abstract void makeSomeNoise(); //메소드에 바디가 존재하면, 구체화가 되기 때문에 추상메소드는 바디 없이 ; 메소드와 클래스 앞에 abstract 붙임
	
}
