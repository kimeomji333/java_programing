package day04;

import java.util.Scanner;

//2 이중for문 예제 - 별 찍기
public class NestedForEx {
	public static void main(String[] args) {
		
		/*
		 	*****	
		 	*****	
		 	*****	
		 	*****	
		 	*****	
		 */
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("*****");
		}
		
		
		
		
		
		
		
		/*
		 		*
		 		**
		 		***
		 		****
		 		*****
		 */
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
		
		
		

		
		/*
		 		*****
		 		****
		 		***
		 		**
		 		*
		 */
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
				
		
		
		/*
		 			*
		 		   ***
		 		  *****
		 		 *******
		 		*********
		 */
		// 공백: 4 3 2 1 0
		// 별: 1 3 5 7 9 // 홀수 개수 만큼(O) or 2개씩 증가(X)
		for(int i = 1; i <= 5; i++) {	
			for(int k = 1; k <= 5 - i; k++) {
				System.out.print(" ");
			}
				
			for(int j = 1; j <= i*2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		/*
		 		*********
		 		 *******
		 	      *****
		 	       ***
		 		    *
		 */
		//공백: 0 1 2 3 4
		//*: 9 7 5 3 1
		for(int i = 5; i >= 1; i--) {	
			for(int k = 1; k <= 5 - i; k++) {
				System.out.print(" ");
			}
				
			for(int j = 1; j <= i*2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		/*
		 	학생수 입력 -> 과목수, 과목명 입력 받기 -> 첫 번째 학생 ~ n 번째 학생까지의 점수 입력받기
		 	한 사람당 총점, 평균/ 전체 평균
		 	각 과목별 평균
		 */
		// 소배열이 각 학생수 마다, 과목수 마다 생김 -> 2차원 배열
		
		
		// 학생수 stuCnt 과목수 subjCnt -> 2차배열 arrScore
		// 1차 배열 과목명 arrSubject
		
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("학생수를 입력하세요: ");
		int stuCnt = sc.nextInt();
		
		System.out.print("과목수를 입력하세요: ");
		int subjCnt = sc.nextInt();
		
		// 처리
		int[][] arrScore = new int[stuCnt][subjCnt]; //학생수, 과목수 
		String[] arrSubject = new String[subjCnt]; //과목명 
		
		for(int i = 0; i < subjCnt; i++) {
			System.out.print(i+1 + "번째 과목명: ");
			arrSubject[i] = sc.next();
		}
		
		int[] arSum1 = new int[stuCnt];  //학생별 총점
		int[] arSum2 = new int[subjCnt];  //과목별 총점
		
		for(int i = 0; i < stuCnt; i++) {
			for(int j = 0; j < subjCnt; j++) {
				System.out.print(i+1 + "번째 학생의 " + arrSubject[j] + "점수: ");
				arrScore[i][j] = sc.nextInt();
				arSum1[i] += arrScore[i][j];
				arSum2[j] += arrScore[i][j];
			}
		}
		
		//총점과 평균을 출력하기 위해 '학생수'만큼 반복한다.
		for(int i = 0; i < stuCnt; i++) {
			System.out.println(i+1 + "번째 학생의 총점: " + arSum1[i]);
			System.out.println(i+1 + "번째 학생의 평균: " + arSum1[i]/(double)subjCnt);
		}
		
		for(int i = 0; i < subjCnt; i++) {
			System.out.println(arrSubject[i] + " 과목의 평균: " + arSum2[i]/(double)stuCnt);
		}
		
		
		// 다시 작성해볼 수 있어야 함. 연습연습 !
		

		
		
		
		
		
		
		
		
	}
}
