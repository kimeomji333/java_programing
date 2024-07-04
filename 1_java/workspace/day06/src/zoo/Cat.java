package zoo;

public class Cat extends Animal{
	
	public Cat() {
	}
	
	public Cat(String name) {
		super(name);
	}
	
	void crying() {
		System.out.println(this.name + "의 울음소리는 냥");
	}
	
	@Override
	void makeSound() {
		System.out.println("야옹");
	}
	
}
