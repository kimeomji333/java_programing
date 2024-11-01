package teamProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gugudan2 {
	public Gugudan2() {
		// 정수 입력 -> 양수인 경우만 그 수의 구구단 출력(단, 곱하기 수(i)가 입력 받은 단(2)의 배수일 경우 출력 제외(i=2,4,6,8
		// 제외) - 조건문)
		Scanner sc = new Scanner(System.in);
		int num = 0;

		while (true) {
			while (true) {
				try {
					System.out.print("정수를 입력하세요: ");
					num = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("정수형으로 입력해주세요");
					sc.next(); // 잘못된 입력 버퍼 비우기
				}
			}

			if (num > 1) {
				System.out.println(num + "단");
				for (int i = 1; i <= 9; i++) {
					if (i % num != 0) {
						System.out.printf("%d X %d = %d\n", num, i, num * i);
					}
				}
				break;
			} else {
				System.out.println("정수 2부터 입력해주세요.");
			}
		}
	}
}
