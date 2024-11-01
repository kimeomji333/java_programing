//package todostudy;
//
//import java.util.Scanner;
//
//public class NestedForExStudents {
//	public static void main(String[] args) {
//		// 다시 작성해볼 수 있어야 함. 연습연습 !
//
//		/*
//		 * 학생수 입력 -> 과목수, 과목명 입력 받기 -> 첫 번째 학생 ~ n 번째 학생까지의 점수 입력받기 한 사람당 총점, 평균/ 전체 평균
//		 * 각 과목별 평균
//		 */
//		// 소배열이 각 학생수 마다, 과목수 마다 생김 -> 2차원 배열
//
//		// 학생수 stuCnt 과목수 subjCnt -> 2차배열 arrScore
//		// 1차 배열 과목명 arrSubject
//
//		// 입력
//		Scanner sc = new Scanner(System.in);
//		System.out.print("학생수를 입력하세요: ");
//		int stuCnt = sc.nextInt();
//
//		System.out.print("과목수를 입력하세요: ");
//		int subjCnt = sc.nextInt();
//
//		// 처리
//		int[][] arrScore = new int[stuCnt][subjCnt]; // 학생수, 과목수
//		String[] arrSubject = new String[subjCnt]; // 과목명
//
//		for (int i = 0; i < subjCnt; i++) {
//			System.out.print(i + 1 + "번째 과목명: ");
//			arrSubject[i] = sc.next();
//		}
//
//		int[] arSum1 = new int[stuCnt]; // 학생별 총점
//		int[] arSum2 = new int[subjCnt]; // 과목별 총점
//
//		for (int i = 0; i < stuCnt; i++) {
//			for (int j = 0; j < subjCnt; j++) {
//				System.out.print(i + 1 + "번째 학생의 " + arrSubject[j] + "점수: ");
//				arrScore[i][j] = sc.nextInt();
//				arSum1[i] += arrScore[i][j];
//				arSum2[j] += arrScore[i][j];
//			}
//		}
//
//		// 총점과 평균을 출력하기 위해 '학생수'만큼 반복한다.
//		for (int i = 0; i < stuCnt; i++) {
//			System.out.println(i + 1 + "번째 학생의 총점: " + arSum1[i]);
//			System.out.println(i + 1 + "번째 학생의 평균: " + arSum1[i] / (double) subjCnt);
//		}
//
//		for (int i = 0; i < subjCnt; i++) {
//			System.out.println(arrSubject[i] + " 과목의 평균: " + arSum2[i] / (double) stuCnt);
//		}
//
//	}
//}
//
//public class MethodTask {
//	// 문자열을 전부 대문자로 바꿔주는 메소드(hEllo~123 -> HELLO~123)
//	String changeToUpperCase(String msg) { // hEllo~123
//		// 9
//		int len = msg.length();
//		String result = "";
//
//		for (int i = 0; i < len; i++) { // 0 ~ 8
//			char ch = msg.charAt(i); // msg.charAt(0) ~ msg.charAt(8) --> 'h' 'E' 'l' ...
//
//			// result = "HELL"
//			if (ch >= 'a' && ch <= 'z') {
//				// 'a' : 97 / 'A' : 65
//				result += (char) (ch - 32);
//			} else {
//				result += ch;
//			}
//		}
//
//		return result;
//	}
//
//	// 문자열을 거꾸로 바꿔주는 메소드(Hello -> olleH)
//	String reverse(String msg) {
//		String result = "";
////				for (int i = 0; i < msg.length(); i++) {
////					result = msg.charAt(i) + result;
////				}
//		for (int i = msg.length() - 1; i >= 0; i--) {
//			result += msg.charAt(i);
//		}
//		return result;
//	}
//
//	// 문자열이 숫자로 이루어져 있는지 검사하는 메소드(숫자가 아닌것이 포함되어 있다면 false)
//	// is~~~(has~~~) : ~~이면(~~를 가지고 있다면) 참 / 아니라면 거짓을 리턴하는 메소드(return 타입이 boolean)
//	boolean isDigit(String msg) { // 01a23
//		for (int i = 0; i < msg.length(); i++) {
//			char ch = msg.charAt(i);
//			if (ch < '0' || ch > '9') {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	// 문자열의 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드(hEllo~123 -> HeLLO~123)
//	String changeCase(String msg) {
//		int len = msg.length();
//		String result = "";
//		for (int i = 0; i < len; i++) { // 0 ~ 8
//			char ch = msg.charAt(i); // msg.charAt(0) ~ msg.charAt(8) --> 'h' 'E' 'l' ...
//			if (ch >= 'a' && ch <= 'z') {
//				result += (char) (ch - 32);
//			} else if (ch >= 'A' && ch <= 'Z') {
//				result += (char) (ch + 32);
//			} else {
//				result += ch;
//			}
//		}
//		return result;
//	}
//
//	// 정수를 한글로 바꿔주는 메소드(1024 -> 일공이사)
//	String changeToHangle(int num) {
//		// num : 1024
//		String hangle = "공일이삼사오육칠팔구";
//		// hangle.charAt(0) : '공' / hangle.charAt(7) : '칠'
//		String result = "";
//		String data = num + ""; // "1024"
//
//		for (int i = 0; i < data.length(); i++) {
////					result += hangle.charAt(data.charAt(i)-48);
//
//			char ch = data.charAt(i); // '1' '0' '2' '4'
////					hangle.charAt('1'); --> hangle.charAt(49)
////					(int)'1' -> 49
//			int idx = ch - 48; // 1 0 2 4
//			result += hangle.charAt(idx); // '일' '공' '이' '사'
//		}
//		return result;
//	}
//}
