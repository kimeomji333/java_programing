package day03;

import java.util.Scanner;

//5 배열문제
public class ArTask {
	public static void main(String[] args) {
		
		//5칸 빈 배열 생성 후 1부터 5까지 넣어준 후 각 방에 있는 값들 순서대로 출력
		System.out.println("1번-----------------------------");
		int[] arr1 = new int[5];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = i+1;
			System.out.println(arr1[i]);
		}
		
		
		
		//1, 100, 7, 35, 22, 78, 17, 89, 3, 9 반복문 사용해서 출력
		System.out.println("2번-----------------------------");
		int[] arr2 = {1, 100, 7, 35, 22, 78, 17, 89, 3, 9};
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		
		
		//5칸 빈 배열 생성 후 10, 7, 4, 1, -2 넣어준 후 순서대로 출력		
		System.out.println("3번-----------------------------");
		int[] arr3 = new int[5];
		arr3[0] = 10;
		arr3[1] = 7;
		arr3[2] = 4;
		arr3[3] = 1;
		arr3[4] = -2;
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
			//for문 안에서 arr3[i] = -3*i + 10;
		}
		
		
		
		//사용자에게 정수 3개 입력 받아서 순서대로 출력 후 합도 출력
		System.out.println("4번-----------------------------");
		Scanner sc = new Scanner(System.in);
		
		int[] arr4 = new int[3];
		int sum = 0;
		
		for(int i = 0; i < arr4.length; i++) {
			System.out.print((i+1) + "번째 정수를 입력해주세요: ");
			arr4[i] = sc.nextInt();
			sum += arr4[i];
		}
		
		for(int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]);			
		}
		
		System.out.println("배열의 총 합: " + sum);
		

		
		//20칸 빈 배열 생성 후 홀수번째 방은 -2, -4, -6, -8, ... 넣고
		//짝수번째 방은 1, 3, 5, 7, .. 넣기
		// 0 1 2 3 4 5 6 7 8 ..
		// 짝수인 경우
		//  0  2  4  6
		//  1, 3, 5, 7
		// 
		// 홀수인 경우
		// 1  3  5  7
		//-2, -4, -6, -8,
		System.out.println("5번-----------------------------");
		int[] arr5 = new int[20];
		
		for(int i = 0; i < arr5.length; i++) {
			if(i % 2 == 0) {
				arr5[i] =  i + 1;  //  0  2  4  6
			} else {
				arr5[i] = -1 * i - 1; // 1  3  5  7
			}
		}
		
		for(int i = 0; i < arr5.length; i++) {
			System.out.println(arr5[i]);
		}
		
		// 0 1(짝) 2 3 4 
		
		//20칸 빈 배열 생성 후 홀수번째 방은 -1, -4, -7, -10, ... 넣고
		//짝수번째 방은 2, 7, 12, 17 ... 넣기

		// 홀수번째방(짝수) 0 2 4 6  (2씩증가)
		//   -1, -4, -7, -10    (3씩감소)
		
		// 짝수번째방(홀수) 1 3 5 7  (2씩증가)
		//    2, 7, 12, 17      (5씩증가)
		
		System.out.println("6번-----------------------------");
		int[] arr6 = new int[20];
		
		for(int i = 0; i < arr6.length; i++) {
			if(i % 2 == 0) {
				arr6[i] = -3*(i / 2) - 1;
			} else {
				arr6[i] = 5*(i / 2) + 2;
			}
		}
		
		for(int i = 0; i < arr6.length; i++) {
			System.out.println(arr6[i]);
		}
		
		
		
		//사용자에게 국어점수, 수학점수, 영어점수 입력받은 후 전체 점수 출력하고
		//총점과 평균 출력하기
		//입력
		//국어 점수 :
		//수학 점수 :
		//..
		//출력
		//국어 점수 : 100점
		//수학 점수 : 80점
		//영어 점수 : 90점
		//총점 : 270점
		//평균 : 90.00점
		System.out.println("7번-----------------------------");
		
		String[] arrSubject = {"국어", "수학", "영어"};
		int[] arr7 = new int[arrSubject.length];
		int sumScore = 0;
		
		//입력
		for(int i = 0; i < arr7.length; i++) {
			System.out.print(arrSubject[i] + "점수: ");
			arr7[i] = sc.nextInt();
		}
		
		//처리
		for(int i = 0; i < arr7.length; i++) {
			sumScore += arr7[i];
		}
		double avg = (double)sumScore / arr7.length;
		
		//출력
		for(int i = 0; i < arr7.length; i++) {
			System.out.println(arrSubject[i] + "점수: " + arr7[i] + "점");
		}
		System.out.println("총점: " + sumScore + "점");
		System.out.printf("평균: %.2f점\n",avg);
		
		// 위의 문제에서 사용자에게 '과목수'와 '과목명' 입력받아서 위의 과정 해보기
	}

}
