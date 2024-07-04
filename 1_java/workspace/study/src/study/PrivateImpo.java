package study;

import java.util.Scanner;

public class PrivateImpo {
	public static void sinsang() {
		Scanner sc = new Scanner(System.in);

		// 사용자로부터 입력 받기
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();

		System.out.print("나이를 입력하세요: ");
		int age = sc.nextInt();

		sc.nextLine(); // 버퍼 비우기

		System.out.print("성별을 입력하세요 (남자/여자): ");
		String gender = sc.nextLine();

		System.out.print("성격을 입력하세요: ");
		String person = sc.nextLine();

		// 입력된 값 출력
		System.out.println("신상 정보:");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("성별: " + gender);
		System.out.println("성격: " + person);
		sc.close();
	}

	// 메인 메소드에서 호출
	public static void main(String[] args) {
		sinsang();
	}
}

// ??? 잘 모르겠당 ???
// next보다 (버퍼 비우기를 써야하는데) nextLine을 쓰는 이유는? 
// 메소드를 따로 빼는 이유?