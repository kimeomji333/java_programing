package teamProject;

import java.util.Scanner;

public class StudentImpo2 {
	public StudentImpo2() {
		//입력받은 값들을 변수에 기록, 출력
		//점수가 90이상: A학점, 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 정보");
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("학년: ");
		int grade = sc.nextInt();
		
		System.out.print("반: ");
		int ban = sc.nextInt();
		
		System.out.print("번: ");
		int bun = sc.nextInt();
		
		System.out.print("성별(M/F): ");
		String gender = sc.next();
		
		System.out.print("성적: ");
		double score = sc.nextDouble();
		
		//성별
		String genderStr;
		if(gender.equals("F") || gender.equals("f")) {
			genderStr = "여학생";
		} else if(gender.equals("M") || gender.equals("m")){
			genderStr = "남학생";
		} else {
			genderStr = "잘못된 입력입니다.";
		}
		
		//학점
		String gradeLetter;
		if(score >= 90) {
			gradeLetter = "A학점";
		} else if(score >= 80) {
			gradeLetter = "B학점";
		} else if(score >= 70) {
			gradeLetter = "C학점";
		} else if(score >= 60) {
			gradeLetter = "D학점";
		} else {
			gradeLetter = "F학점";
		}
		
		//출력
		System.out.printf("%d학년 %d반 %d번 %s %s의 점수는 %.1f이고, %s입니다.", grade, ban, bun, genderStr, name, score, gradeLetter);
	}
}
