package study;

import java.util.Scanner;

public class StudentImpo {
	public static void hakJeom() {
		Scanner sc = new Scanner(System.in);

		// 사용자로부터 입력 받기
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();

		System.out.print("학년을 입력하세요: ");
		int grade = sc.nextInt();

		System.out.print("반을 입력하세요: ");
		int classroom = sc.nextInt();

		System.out.print("번호를 입력하세요: ");
		int number = sc.nextInt();

		sc.nextLine(); // 버퍼 비우기

		System.out.print("성별을 입력하세요 (F/M): ");
		String gender = sc.nextLine();

		System.out.print("성적을 입력하세요: ");
		double score = sc.nextDouble();

		// 학점 계산
		char gradeLetter;
		if (score >= 90) {
			gradeLetter = 'A';
		} else if (score >= 80) {
			gradeLetter = 'B';
		} else if (score >= 70) {
			gradeLetter = 'C';
		} else if (score >= 60) {
			gradeLetter = 'D';
		} else {
			gradeLetter = 'F';
		}

		// 남녀 구분
		String genderString;
		if (gender.equals("F") || gender.equals("f")) {
			genderString = "여학생";
		} else if (gender.equals("M") || gender.equals("m")) {
			genderString = "남학생";
		} else {
			genderString = "성별 불명";
		}

		// 최종 문장 출력
		System.out.printf("%d학년 %d반 %d번 %s %s의 점수는 %.1f이고 %c학점입니다.\n", grade, classroom, number, genderString, name, score, gradeLetter);

		sc.close();
	}

	// 메인 메소드에서 호출
	public static void main(String[] args) {
		hakJeom();
	}
}
