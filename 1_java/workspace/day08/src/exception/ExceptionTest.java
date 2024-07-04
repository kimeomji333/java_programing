package exception;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println(10/3);
			System.out.println(10/0);	//ArithmeticException (첫 글자 대문자임. 즉, 클래스. 개발자가 만들어 낸 것임) 이 예외 타입으로 객체를 만들어 냈다는 것. 
			System.out.println(10/2);	//출력이 안됨. 꼭 출력해야 한다면, finally에다가 
		} catch(ArithmeticException ae) {
			System.out.println("0으로는 나눌 수 없습니다!");
		} finally {
//			System.out.println("프로그램 끝 !");	//try-catch 끝나고 사용할 수 있으니, finally 에 넣지 않아도 됨. 하지만 끝날 때 프로그램이 끝난다면 finally에 넣음.
		}
		System.out.println("프로그램 끝 !");
	}

}
