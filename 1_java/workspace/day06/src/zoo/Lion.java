package zoo;

public class Lion extends Animal{

	public Lion() {
	}
	
	public Lion(String name) {
		super(name);
	}
	
	void crying() {
		System.out.println(this.name + "의 울음소리는 어흥");
	}
	
	@Override
	void makeSound() {
		System.out.println("어흥");
	}
	
}
