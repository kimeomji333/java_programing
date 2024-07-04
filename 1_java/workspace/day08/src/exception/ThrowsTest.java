package exception;

public class ThrowsTest {
	public static void main(String[] args) throws InterruptedException{
		f();
	}
	static void f() throws InterruptedException{
		try {
			//1000 밀리초(1초) 동안 프로그램 진행 멈추기
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		
		//Thread.sleep() 쓸 때마다 try-catch로 묶어야 함. -> throw 이용(예외 떠넘기기) 내부에서 발생하는 예외들을 throws를 이용해서 sleep을 호출했던 곳으로 예외를 떠넘겨준다. 
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
	}

}
