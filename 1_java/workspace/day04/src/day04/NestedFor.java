package day04;

//1 이중for문
public class NestedFor {
	public static void main(String[] args) {
		
		int[][] arData = {
				{10,20,30},
				{40,50,60}
		};
		
//		System.out.println(arData[0][0]);
//		System.out.println(arData[0][1]);
//		System.out.println(arData[0][2]);
//		
//		System.out.println(arData[1][0]);
//		System.out.println(arData[1][1]);
//		System.out.println(arData[1][2]);
		
		
//		for(int i = 0; i < 6; i++) {
//			System.out.println(arData[i/3][i%3]); // 방안에 연산은 되도록 쓰지 않도록
//		}
		
//		for(int j = 0; j < arData[0].length; j++) {
//			System.out.println(arData[0][j]);
//		}
//		for(int j = 0; j < arData[0].length; j++) {
//			System.out.println(arData[1][j]);
//		}
		
		// 중첩 반복문 이용해서 2차원 배열 출력
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(arData[i][j]);
			}	
		}
		
		// 구구단 2단 출력
//		System.out.println("---- 2단 출력 ----");
//		for(int i = 1; i <= 9; i++) {
//			System.out.printf("%d x %d = %d\n", 2, i, 2*i);
//		}
		
		// 구구단 출력
		for(int i = 2; i <=9; i++) {			
			System.out.println("---- " + i +"단 출력 ----");
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j);
			}
		}
		

		int[][] arData2 = new int[3][];
		arData2[0] = new int[5];
		arData2[1] = new int[3];
		arData2[2] = new int[2];
		

//		for(int j = 0; j < arData2[0].length; j++) {
//			System.out.println(arData2[0][j]);
//		}
//		for(int j = 0; j < arData2[1].length; j++) {
//			System.out.println(arData2[1][j]);
//		}
//		for(int j = 0; j < arData2[2].length; j++) {
//			System.out.println(arData2[2][j]);
//		}

//		for(int i = 0; i < arData2.length; i++) {
//			for(int j = 0; j < arData2[i].length; j++) {
//				System.out.println(arData2[i][j]);
//			}			
//		}
		
		
	
		
	}

}
