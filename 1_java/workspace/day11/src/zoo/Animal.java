package zoo;

public class Animal extends Thread {
	String sound;
	boolean isMammal;

	public Animal(String sound) {
		this.sound = sound;
		this.isMammal = false; //기본값 포유류가 아님
	}
	
	public Animal(String sound, boolean isMammal) {
		this.sound = sound;
		this.isMammal = isMammal; 
	}

	@Override
	public void run() {
		if(isMammal) {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(sound);
				
				try {
					sleep(1000); // 1초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
