package zoo;

//상속시켜 다른 클래스들을 쉽게 만들기 위함
public class Animal {
	String name;
	String gender;
	int age;

	public Animal() {
	}
	
	public Animal(String name) {
		this.name = name;
	}

	void eat() {
		System.out.println(name + "이(가) 밥 먹는 중");
	}
	
	void sleep() {
		System.out.println(name + "이(가) 잠자는 중");
	}
	
	void move() {
		System.out.println(name + "이(가) 움직이는 중");
	}
	
	//오버라이딩으로 메소드 내용이 비어있어도 된다. 
	void makeSound() {
	}

	void crying() {
		System.out.println(this.name + "의 울음소리는");
	}
	
}
