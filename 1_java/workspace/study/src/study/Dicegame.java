package study;

import java.util.Random;
import java.util.Scanner;

public class Dicegame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			Random r = new Random();
			int num1 = r.nextInt(11) + 2;
			System.out.println(num1);

			System.out.print("주사위 두개의 합을 맞춰보세요(2 ~ 12 입력): ");
			int num = sc.nextInt();
			if (num == num1) {
				System.out.println("정답입니다~!");

				while (true) {
					System.out.println("계속 하시겠습니까?(y / n)");
					String ans = sc.next();

					if (ans.equals("n")) {
						System.out.println("종료합니다.");
						return;
					} else if (ans.equals("y")) {
						break;
					} else {
						System.out.println("잘못된 입력입니다. y또는 n을 입력하세요.");
					}
				}

			} else if (num != num1) {
				System.out.println("틀렸습니다.");
			}
		}
	}
}
