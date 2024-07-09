package zoo;

//항상 사용 추상클래스로 정의
public abstract class Animal2 {
	String name;
	String gender;
	int age;
	
	public Animal2(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	abstract void makeSomeNoise();
}
