package zoo;

public class Dog extends Animal2 implements Runnable, Mammal{

	public Dog(String name, String gender, int age) {
		super(name, gender, age);
	}

	@Override
	void makeSomeNoise() {
		System.out.println("멍");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeSomeNoise();
			
			try {
				Thread.sleep(1000); // 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
