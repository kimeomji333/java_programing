package zoo;

public class Dog extends Animal{

	public Dog() {
	}
	
	public Dog(String name) {
		super(name);
	}
	
	void crying() {
		System.out.println(this.name + "의 울음소리는 멍");
	}
	
	@Override
	void makeSound() {
		System.out.println("멍");
	}
	
}
