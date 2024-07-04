package day03;

import java.util.Scanner;

//3배열
// Alt + Shift + R : 변수명 전체 수정
public class ArTest1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
//		int data0 = 10;
//		int data1 = 5;
//		int data2 = -7;
//		int data3 = -17;
//		int data4 = 22;
		
		//선언 방법1
		int[] arrData1 = {10, 5, -7, -17, 22, 20000};
		System.out.println(arrData1);  // [I@7f63425a
		System.out.println(arrData1[2]);  // -7
		
		//for문의 반복 횟수를 해당하는 배열의 길이로 해놓으면 유지보수에 편리하다. 
		//적절한 상황에 사용해야 함.
		for(int i = 0; i < arrData1.length; i++) {
			System.out.println(arrData1[i]);			
		}

		
		//선언 방법2
		int[] arrData2 = new int[3];
		
		//배열의 각 방은 변수나 마찬가지(공간으로 사용)
		for(int i = 0; i < arrData2.length; i++) {
			System.out.print((i+1) + "번째 정수: ");
			arrData2[i] = sc.nextInt();
		}
		
		for(int i = 0; i < arrData2.length; i++) {
			System.out.println(arrData2[i]);			
		}
		
		
		
	}
}
