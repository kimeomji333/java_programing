package generic;

public class GMethodTest {
	<NMIXX> void f(NMIXX data) {
		if(data instanceof Integer) {
			System.out.println("정수로 호출");
		}
		else if(data instanceof String) {
			System.out.println("문자열로 호출");
		}
	}

}
