package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumTest {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("정수: ");
			int num1 = sc.nextInt();
			System.out.print("정수: ");
			int num2 = sc.nextInt();
			
			int result = num1/num2;
			
			System.out.println("결과: " + result);
		} catch(ArithmeticException ae) {
			System.out.println("0으로는 나눌 수 없습니다.");
//			ae.getCause()		이런 기능도 있다. 아직 배우기 전.
//			ae.getMessage()
//			ae.getStackTrace()
		} catch(InputMismatchException ime) {
			System.out.println("정수만 입력하세요.");
		} catch (Exception e) { //임시로 잡는 구간
//			System.out.println("알 수 없는 오류 발생 / 개발자에게 알려주세요.");
			System.out.println(e); //예외 객체를 syso로 찍어보면 이유를 알 수 있음
		}
		
		//어떤 예외가 발생할 시 몰라. 어떤 예외든 잡도록 만들어 놓음
		//줄선택 > Alt + Shift + Z >  ↓ > Enter : try ~ catch 블럭 만들기
	}
}
