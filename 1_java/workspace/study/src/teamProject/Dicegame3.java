package teamProject;

import java.util.InputMismatchException;
//주사위 게임 완성!
import java.util.Random;
import java.util.Scanner;

//주사위 게임 완료
public class Dicegame3 {
	public Dicegame3() {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		// 바깥쪽 반복문 - 난수 생성, 게임 재시작 여부
		while (true) {
			// 게임 시작! 난수 생성
			int randomNum = r.nextInt(11) + 2;

			// 안쪽 반복문 - 게임 시작, 정답 일치 여부
			int userNum = 0;
			while (true) {
				
				// 입력
				try {
					System.out.print("주사위 두 개의 합을 맞춰보세요(2 ~ 12 입력): ");
					userNum = sc.nextInt();
				} catch (InputMismatchException ime) {
					System.out.println("정수를 입력해주세요");
					sc.next();
					continue;
				}

				if (userNum >= 2 && userNum <= 12) {
					// 로직
					if (randomNum == userNum) {
						System.out.println("정답입니다!");
						break;
					} else {
						System.out.println("오답입니다!");
					}
				} else {
					System.out.println("2에서 12 사이의 숫자만 입력해주세요.");
				}

				// 계속하기 여부
				while (true) {
					System.out.print("게임을 계속하시겠습니까?(y/n): ");
					String restart = sc.next();

					if (restart.equals("N") || restart.equals("n")) {
						System.out.println("게임이 종료됩니다.");
						return;
					} else if (restart.equals("Y") || restart.equals("y")) {
						System.out.println("새로운 게임을 시작합니다.");
						break;
					} else {
						System.out.println("잘못된 입력입니다.");
					}
				}

			}
		}
	}
}
