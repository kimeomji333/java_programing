package teamProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrivateImpo2 {
	public PrivateImpo2() {
		// 신상 정보 확인- 자료형에 맞춰 변수에 기록, 출력까지
		Scanner sc = new Scanner(System.in);

		System.out.println("신상 정보");
		System.out.print("이름: ");
		String name = sc.next();

		int age = 0;

		while (true) {
			try {
				System.out.print("나이: ");
				age = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("정수형으로 입력해주세요");
				sc.next(); // 잘못된 입력 버퍼 비우기
			}
		}

		System.out.print("성별: ");
		String s = sc.next();

		System.out.print("성격: ");
		String ch = sc.next();

		// 출력
		System.out.println(name);
		System.out.println(age);
		System.out.println(s);
		System.out.println(ch);

	}
}
