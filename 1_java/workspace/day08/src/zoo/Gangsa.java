package zoo;

public class Gangsa extends Animal implements Mammal{

	public Gangsa(String name, String gender, int age) {
		super(name, gender, age);
	}
	

	//메소드에 final이 붙어서 사용 불가
//	@Override
//	void init() {
//		
//	}

	// 추상클래스에서 extends 해오면 오버라이딩 필수로 해야함.
	@Override
	void makeSomeNoise() {
		System.out.println("여기까지 이해 되셨죠?");
	}

	@Override
	public void breed() {
		System.out.println("산부인과에 가서 낳는다.");
	}
}
