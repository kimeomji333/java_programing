package thread;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("○"); 
		MyThread t2 = new MyThread("●"); 
		
		MyRunnable r1 = new MyRunnable("♡");
		MyRunnable r2 = new MyRunnable("♥");
		Thread t3 = new Thread(r1); //t3은 r1 작업을 수행해야 할 쓰레드가 됨
		Thread t4 = new Thread(r2);
		
		//단일 쓰레드가 되어 버림
//		t1.run();
//		t2.run();
		
		//멀티 쓰레드(컴퓨터에서 언제 할지 스케쥴링을 해야함)
		t1.start(); //start(): 스케줄링 
		t2.start();
		t3.start();
		t4.start();
		
		
	}

}
