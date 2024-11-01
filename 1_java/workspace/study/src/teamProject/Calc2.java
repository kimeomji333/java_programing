package teamProject;

import java.util.InputMismatchException;
import java.util.Scanner;

//계산기 완료
public class Calc2 {
	public Calc2() {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int num1 = 0;
		int num2 = 0;

		while(true) {
			try {
				System.out.print("첫 번재 정수 : ");
				num1 = sc.nextInt();
				
				System.out.print("두 번재 정수 : ");
				num2 = sc.nextInt();
				
				break; //정상적으로 입력되면 반복문 탈출
				
			} catch (InputMismatchException e) {
				System.out.println("정수형으로 입력해주세요");
				sc.next(); // 잘못된 입력 버퍼 비우기
			}
		}

		System.out.print("연산자(+,-,x,/): ");
		String op = sc.next();

		char oper = op.charAt(0);

		if (oper == '+') {
			result = num1 + num2;
		} else if (oper == '-') {
			result = num1 - num2;
		} else if (oper == 'x' || oper == 'X') {
			result = num1 * num2;
		} else if (oper == '/') {
			// 두 정수의 나누기 몫이나 나누는 수(두번째수)가 0이면 "0으로 나눌 수 없습니다." 출력
			// 결과값은 0으로 처리
			if (num2 == 0 || num1 / num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				result = 0;
			} else {
				result = num1 / num2;
			}
		} else {
			System.out.println("잘못된 연산자입니다.");
		}
		System.out.printf("%d %s %d = %d", num1, op, num2, result);
	}

}
