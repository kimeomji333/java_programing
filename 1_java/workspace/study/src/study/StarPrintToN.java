package study;

import java.util.InputMismatchException;
import java.util.Scanner;

//별과 숫자 출력
public class StarPrintToN {
	public static void main(String[] args) {

		try {
			starAgain();
		} catch (InputMismatchException ime) {
			System.out.println("숫자만 입력해주세요");
			starAgain();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void starAgain() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("정수 : ");
			int n = sc.nextInt();

			if (n > 0) {
				for (int i = 0; i < n; i++) {
					for (int j = i - 1; j < 2 * i - 1; j++) {
						System.out.print("*");
					}
					System.out.println(i + 1);
				}
				break;
			} else {
				System.out.println("양수가 아닙니다.");
				while (true) {
					System.out.print("다시 입력 하시겠습니까(Y/N)");
					String restart = sc.next();
					if (restart.equals("N") || restart.equals("n")) {
						System.out.println("게임이 종료됩니다.");
						return;
					} else if (restart.equals("Y") || restart.equals("y")) {
						System.out.println("새로운 정수를 입력해주세요");
						break;
					} else {
						System.out.println("잘못된 입력입니다.");
					}
				}
			}
		}

	}
}
