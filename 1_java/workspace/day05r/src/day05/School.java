package day05;

//4
import java.util.Scanner;

public class School {
	public static void main(String[] args) {
		// CRUD
		// 1. 학생 추가
		// 2. 학생 목록
		// 3. 학생 삭제
		// 4. 학생 수정
		// 5. 성적 입력
		// 6. 석차 보기
		// 7. 나가기

		// 메뉴, 나가기 기능 -> while문
		// 출력, 입력받기(미리 스케너 준비) <= int형 변수 선언
		// switch문으로 case 번호 받기
		// break(7번): while문 탈출할 때, 속해있는 switch문을 탈출하게 됨 <- 그래서 직전에 if문을 따로 만듦
		// 즉, while문 안에 if문, 나가서 switch문(변수 선언 안에서 하지말기. 변수 선언은 선언부에다가!!! 맨위)
		// 배열을 이용해서 데이터 저장하기 (선언은 선언부에다가) -> 매번 배열 생성할 수 없어 대안점 -> 클래스를 만듦 -> 클래스 배열

		Scanner sc = new Scanner(System.in);
		String name = "";
		int ban = 0;
		int bun = 0;
		boolean flag;

		// 등록된 학생들의 정보를 객체화해서 저장할 배열, 정보(데이터)를 객체 단위로 저장 (클래스 사용하는 방법) 메소드 관리, 정보 관리
		// 배열의 각 방 하나하나가 Student 타입의 객체
		Student[] list = new Student[1000];
		// 현재까지 등록된 학생의 수 == 새로 등록될 학생 객체가 들어갈 방(인덱스) 번호
		int studCnt = 0;

		while (true) {
			System.out.println(
					"1. 학생 추가\n" + "2. 학생 목록\n" + "3. 학생 삭제\n" + "4. 학생 수정\n" + "5. 성적 입력\n" + "6. 석차 보기\n" + "7. 나가기");
			int choice = sc.nextInt();

			if (choice == 7) {
				System.out.println("안녕히 가세요.");
				break;
			}

			// 7종료를 선택하지 않았다면 그대로 switch문까지 흐름이 내려온다.
			switch (choice) {
			case 1:
				// 학생 추가
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("반: ");
				ban = sc.nextInt();
				System.out.print("번호: ");
				bun = sc.nextInt();

				// 여기까지 왔으면 학생을 등록하기 위한 모든 정보를 입력 받았으므로
				// 각 이름, 반, 번호를 저장해준다.
				// 이름, 반, 번호를 따로 저장하게 되면 각각 정보들 마다 배열이 필요하므로
				// 하나의 객체로 포장해서 저장해준다.
				// 학생 객체를 새로 생성해서 (new Student(name, ban, bun) )
				// 모든 학생 객체들을 저장해주는 list 배열에 담아준다. (list[] = )
				// 새로 등록되는 학생이 들어갈 방 번호는 현재 학생수인 studCnt와 일치하고
				// 새롭게 학생이 등록되었기 때문에 저장 후에는 studCnt를 하나 증가시켜 준다.
				list[studCnt] = new Student(name, ban, bun);
				studCnt++;

				System.out.println(name + " 학생 등록 완료!");
				break;

			case 2:
				// 학생 목록
				System.out.println("===== KH 고등학교 학생목록 =====");

				// for문은 현재 등록된 학생 수 만큼 반복하면서
				// list[i] : list 배열 전체 순회(각 배열에서 학생 객체들을 하나씩 꺼내온다)
				for (int i = 0; i < studCnt; i++) {
					// 꺼내오는 객체 내부의 필드를 이용하려면 list[i].ban 과 같은 형태로 사용해야 하므로 코드가 너무 길어진다.
					// 따라서 temp라는 임시 변수를 만들어서 그 주소값을 그대로 담아준다.
					Student temp = list[i];
					// (temp에 담겨있는 꺼내온 객체(순회중인 객체)의 필드를 이용해서) 출력하기 위한 문자열(data)생성
					// 김사과(1반 1번) - 총점 : 0점 -> 이런 서식으로 "문자열" 생성 메서드: String.format("서식문자열", 값1, 값2,
					// ...) 사용
					String data = String.format("%s(%d반 %d번) - 총점 : %d점", temp.name, temp.ban, temp.bun, temp.tot);
					System.out.println(data);
				}
				System.out.println("===========================");
				break;

			case 3:
				// 학생 삭제
				System.out.print("반: ");
				ban = sc.nextInt();
				System.out.print("번호: ");
				bun = sc.nextInt();

				// 순회를 하면서 학생 리스트 중에서 해당 학생이 있는지 확인해야 함
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					// 꺼내온 객체의 ban과 입력한 ban이 같은지 비교
					if (temp.ban == ban) {
						if (temp.bun == bun) {
							// 삭제할 객체를 찾은 상황(현재 순회중인 객체가 삭제할 객체라는 뜻)
							// 현재 순회중인 객체가 존재하는 방(i)부터 가장 마지막에서 두번째방(studCnt -2)까지 순회
							for (int j = i; j < studCnt - 1; j++) {
								// 순회하는 방 뒤에 있는 주소값으로 덮어씌우기
								list[j] = list[j + 1];
							}
							// for문이 끝나고 나옸을 때 가장 마지막 학생 객체(studCnt -1번 방에 있던 객체)의 주소값은
							// 두 곳에 저장되어 있는 상태이다. (studCnt -2번 방, studCnt -1번 방)
							// 중복을 피하기 위해 가장 마지막에 있는 studCnt -1번 방에는 null로 직접 초기화해준다.
							list[studCnt - 1] = null;
							// 학생이 삭제되었으므로 전체 학생수는 1 감소
							studCnt--;
							break;
						}
					}
				}
				System.out.println("성공적으로 삭제되었습니다.");
				break;

			case 4:
				// 학생 수정
				// 순회하면서 학생을 찾아옴 -> 반복되니깐 메소드를 이용하기
				System.out.print("반: ");
				ban = sc.nextInt();
				System.out.print("번호: ");
				bun = sc.nextInt();

				// 순회를 하면서 학생 리스트 중에서 해당 학생이 있는지 확인해야 함
				// flag 기법: 특정 영역에 들어갔는지 아닌지 체크해 볼 수 있음
				flag = false;
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					if (temp.ban == ban) {
						if (temp.bun == bun) {
							flag = true;
							System.out.print("새로운 이름: ");
							temp.name = sc.next();
							break;
						}
					}
				}
				if (flag) {
					System.out.println("학생 수정 성공! ^0^//");
				} else {
					System.out.println("일치하는 학생을 찾을 수 없습니다!");
				}

				break;

			case 5:
				// 성적 입력
				System.out.print("반: ");
				ban = sc.nextInt();
				System.out.print("번호: ");
				bun = sc.nextInt();

				flag = false;
				for (int i = 0; i < studCnt; i++) {
					Student temp = list[i];
					if (temp.ban == ban) {
						if (temp.bun == bun) {
							flag = true;
							System.out.print("국어 점수: ");
							temp.kor = sc.nextInt();
							System.out.print("영어 점수: ");
							temp.eng = sc.nextInt();
							System.out.print("수학 점수: ");
							temp.math = sc.nextInt();

							// 찾은 학생의 tot 에다가 총점 구해서 넣기
							temp.tot = temp.kor + temp.eng + temp.math;
							break;
						}
					}
				}
				if (flag) {
					System.out.println("성적 입력 성공! ^0^//");
				} else {
					System.out.println("일치하는 학생을 찾을 수 없습니다!");
				}

				break;

			case 6:
				// 석차 보기

				break;
			}
		}

	}
}

// Student 타입의 객체 한 개로 한번에 관리
class Student {

	String name;
	int ban;
	int bun;

	int kor;
	int eng;
	int math;
	int tot;

	// 생성자
	public Student(String name, int ban, int bun) {
		this.name = name;
		this.ban = ban;
		this.bun = bun;
	}
}
