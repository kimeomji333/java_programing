package school;

import java.util.Scanner;

//4 school 리팩토링
public class School {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		View view = new View();

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
				view.addStudent();
				break;

			case 2:
				// 학생 목록
				view.showList();
				break;

			case 3:
				// 학생 삭제
				view.recordScore();
				break;

			case 4:
				// 학생 수정
				view.modifyStudent();
				break;

			case 5:
				// 성적 입력
				view.recordScore();
				break;

			case 6:
				//석차 보기
//				manager = new Manager();
//				System.out.println(manager.getRanking());
				break;
			}

		}
	}
}
