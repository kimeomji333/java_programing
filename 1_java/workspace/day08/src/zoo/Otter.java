package zoo;

public class Otter extends Animal implements Mammal{

	public Otter(String name, String gender, int age) {
		super(name, gender, age);
	}

	@Override
	void makeSomeNoise() {
		System.out.println("끼끼");
	}
	
	@Override
	public void breed() {
		System.out.println("문가에 안전한 자리를 찾아 낳는다.");
		
	}
}
