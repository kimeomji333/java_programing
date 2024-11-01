package day05;

import java.util.Iterator;
import java.util.Scanner;

//5 주석 없이 연습
public class School_NoComment {
	public static void main(String[] args) {
		// 1. 학생 추가
		// 2. 학생 목록
		// 3. 학생 삭제
		// 4. 학생 수정
		// 5. 성적 입력
		// 6. 석차 보기
		// 7. 나가기

		Scanner sc = new Scanner(System.in);
		String name = "";
		int ban = 0;
		int bun = 0;
		boolean flag;

		Student[] list = new Student[100];
		int stuCnt = 0;

		while (true) {
			System.out.print("1. 학생 추가\n2. 학생 목록\n3. 학생 삭제\n4. 학생 수정\n5. 성적 입력\n6. 석차보기\n7. 나가기");
			int choice = sc.nextInt();

			if (choice == 7) {
				System.out.println("종료되었습니다.");
				break;
			}

			switch (choice) {
			case 1:
				// 학생 추가
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("반: ");
				ban = sc.nextInt();
				System.out.print("번호: ");
				bun = sc.nextInt();

				list[stuCnt] = new Student(name, ban, bun);
				stuCnt++;

				System.out.println(name + "학생 등록 완료");
				break;

			case 2:
				// 학생 목록
				System.out.println("========학생 목록=========");
				for (int i = 0; i < stuCnt; i++) {
					Student temp = list[i];
					String data = String.format("%s(%d반 %d번) - 총점: %d점", temp.name, temp.ban, temp.bun, temp.tot); 
					System.out.println(data);
				}
				System.out.println("========================");
				break;

			case 3:
				// 학생 삭제
				System.out.print("반: ");
				ban = sc.nextInt();
				System.out.print("번호: ");
				bun = sc.nextInt();

				flag = false;
				for (int i = 0; i < stuCnt; i++) {
					Student temp = list[i];

					if (temp.ban == ban) {
						if (temp.bun == bun) {
							flag = true;
							// 삭제 로직
							for (int j = i; j < stuCnt - 1; j++) {
								list[j] = list[j + 1];
							}
							list[stuCnt - 1] = null;
							stuCnt--;
							break;
						}
					}
				}
				if (flag) {
					System.out.println("성공적으로 삭제되었습니다.");
				} else {
					System.out.println("일치하는 학생을 찾을 수 없습니다.");
				}
				break;

			case 4:
				// 학생 수정
				System.out.println("반: ");
				ban = sc.nextInt();
				System.out.println("번호: ");
				bun = sc.nextInt();

				flag = false;
				for (int i = 0; i < stuCnt; i++) {
					Student temp = list[i];

					if (temp.ban == ban) {
						if (temp.bun == bun) {
							flag = true;
							// 수정 로직
							System.out.print("새로운 이름: ");
							temp.name = sc.next();
							break;
						}
					}
				}
				if (flag) {
					System.out.println("성공적으로 수정되었습니다.");
				} else {
					System.out.println("일치하는 학생을 찾을 수 없습니다.");
				}
				break;

			case 5:
				// 성적 입력
				System.out.println("반: ");
				ban = sc.nextInt();
				System.out.println("번호: ");
				bun = sc.nextInt();

				flag = false;
				for (int i = 0; i < stuCnt; i++) {
					Student temp = list[i];

					if (temp.ban == ban) {
						if (temp.bun == bun) {
							flag = true;
							// 입력 로직
							System.out.print("국어 점수: ");
							temp.kor = sc.nextInt();
							System.out.print("영어 점수: ");
							temp.eng = sc.nextInt();
							System.out.print("수학 점수: ");
							temp.math = sc.nextInt();

							temp.tot = temp.kor + temp.eng + temp.math;
							break;
						}
					}
				}
				if (flag) {
					System.out.println("성공적으로 성적이 입력 되었습니다.");
				} else {
					System.out.println("일치하는 학생을 찾을 수 없습니다.");
				}
				break;

			}

		}
	}
}
