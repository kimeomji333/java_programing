package zoo;

public class Cat extends Animal2 implements Runnable, Mammal{

	public Cat(String name, String gender, int age) {
		super(name, gender, age);
	}

	@Override
	void makeSomeNoise() {
		System.out.println("야옹");
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
