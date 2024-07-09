package thread;

//Thread(작업을 수행)를 상속시켜 주면 스레드의 성질을 가지게 됨
public class MyThread extends Thread{
	String data;
	
	public MyThread(String data) {
		this.data = data;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			
			try {
				sleep(1000); //1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
