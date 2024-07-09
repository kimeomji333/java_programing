package zoo;

import java.util.ArrayList;

public class Ground2 {
	public static void main(String[] args) {
		ArrayList<Animal2> cage = new ArrayList<>();
		cage.add(new Cat("나비", "암컷", 5));
		cage.add(new Dog("초롱이", "수컷", 8));
		
		Thread[] threads = {
				new Thread((Runnable)cage.get(0)),
				new Thread((Runnable)cage.get(1))
		};
		
//		for(Animal2 a : cage) {
//			if(a instanceof Mammal) {
//			}
//		}
		
		System.out.println("--- 시작 ---"); //main 쓰레드
		for (int i = 0; i < threads.length; i++) {
			if(cage.get(i) instanceof Mammal) {
				threads[i].start();
			}
		}
		
		//join() 메소드는 다른 쓰레드들이 본인이 완료될 때까지 잠시 멈추는 역할을 한다. 그래서 try-catch문이 필요
		for (int i = 0; i < threads.length; i++) {
			if(cage.get(i) instanceof Mammal) {
				
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("--- 끝 ---");
	}

}
