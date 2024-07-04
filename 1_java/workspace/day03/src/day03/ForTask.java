package day03;


// 1예제 문제
import java.util.Scanner;

public class ForTask {
	// 반복 횟수 = (끝값 - 초기값) / 증감값

	public static void main(String[] args) {
		//초기식은 int i = 0; 증감식은 i++
		
		System.out.println("1-------------------");
		//1부터 10까지 출력하기
		for(int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		
		
		
		
		System.out.println("2-------------------");
		//10부터 1까지 출력하기
		//0	10
		//1	9
		for(int i = 0; i < 10; i++) {
			System.out.println(10-1*i);
		}
		
		
		
		
		System.out.println("3-------------------");
		//12부터 3씩 증가하며 13번 출력하기
		//12 15 18
		int num1 = 12;
		for(int i = 0; i < 13; i++) {
			System.out.println(num1);
			num1 += 3;
		}
		
		
		
		
		System.out.println("4-------------------");
		//100 94 88 ... 28 출력하기
		//0 100
		//1 94
		//2 88
		//방법1
		int num2 = 100;
		while (num2 >= 28) {
			System.out.println(num2);
			num2 -= 6;
		}
		
		//방법2
		for(int i = 0; i < 13; i++) {
			System.out.println(i*-6 + 100);			
		}
		
		
		
		System.out.println("5-------------------");
		//1부터 10까지의 총 합 구하기
		//0 1 
		//1 2 
		//2 3 
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += i + 1;
		}
		System.out.println(sum);
		
		
		
		
		System.out.println("6-------------------");
		//n 하나 입력받아서 1부터 n까지의 총 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int n = sc.nextInt();
		
		int sum1 = 0;
		for(int i = 0; i < n; i++) {
			sum1 += i + 1;
		}
		System.out.println(sum1);
		
		
		
		
		System.out.println("7-------------------");
		//n, m 입력받아서 n부터 m까지 출력하기
		System.out.print("첫 번째 숫자를 입력하세요: ");
		int n1 = sc.nextInt();
		System.out.print("두 번째 숫자를 입력하세요: ");
		int n2 = sc.nextInt();
		
		for(int i = n1; i <= n2; i++) {
			System.out.println(i);
		}
		
		
		
		
		System.out.println("8-------------------");
		//1부터 100까지 중 짝수만 출력하기
		//방법1
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		
//		//방법2 이런 방법으로도 가능하겠군 ^^
//		for(int i = 2; i <=100; i += 2) {
//			System.out.println(i);
//		}
//		
		
		
		
		System.out.println("9-------------------");
		//1부터 100까지 중 3과 5의 공배수만 출력하기
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				System.out.println(i);
			}
		}
		
		
		
		
		System.out.println("10-------------------");
		//A부터 F 출력하기
		for(int i = 65; i <= 70; i++) {
			System.out.println((char)i);
		}
		
		
		
		// ?????????????????????????????????????????????????
		// 잘모르겠당. 3의 배수와 5의 배수가 출력이 됬는데, 여기서 왜 더 수정이 필요한지 모르겠당.
		System.out.println("11-------------------");
		//1부터 100까지 중 3의 배수와 5의 배수를 출력하되 공배수는 제외하고 출력하기
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				if(!(i % 3 == 0 && i % 5 == 0)) { // (i % 3 != 0 || i % 5 != 0)
					System.out.println(i);				
				}
			}
		}
		
		
		
		System.out.println("12-------------------");
		//AbCdEf ... Yz 출력하기
		//홀수일 때는 대문자, 짤수일 때는 소문자
		String result = ""; //빈 문자열
		for(int i = 0; i < 26; i++) {
			result += (char)( (i % 2 == 0 ? 65 : 97) + i); //누적 연결
		}
		System.out.println(result); //출력값
		
		
		
		
		//------------------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("13-------------------");
		//중첩반복문 사용하지 않고 구구단 전부 출력하기
		for(int i = 2, j = 1; i <= 9; j++) {
			System.out.printf("%d * %d = %d\n", i, j, i*j);
			if(j == 9) {
				i++;
				j = 0;
				System.out.println();
			}
		}
		
		
		System.out.println();
		//방법2
		for(int i = 0; i < 81; i++) {
			int row = i / 9 + 1;  //행
			int col = i % 9 + 1;  //열
			
			int result2 = row * col;
			System.out.printf("%d * %d = %d\n", row, col, result2);
		}
		
		
		System.out.println("14-------------------");
		//10진수 숫자 입력 받아서 2진수로 출력하기
		//Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요: ");
		int decimal = sc.nextInt();
		
		String binary = Integer.toBinaryString(decimal);
		System.out.println(binary);
		
		
		
		// ?????????????????????????????????????????????????
		// 잘모르겠당. 
		System.out.println("15-------------------");
		//ABCD efgh IJKL mnop QRST uvwx YZ 출력하기
		int count = 0;
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);	//대문자 출력
			count++;
			
			ch += 32;				//소문자 변환
			System.out.print(ch); 	//소문자 출력
			ch -= 32;				//대문자 변환
		}
		// AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz
		
		
		
		
		
		System.out.println();
		System.out.println("16-------------------");
		//AbCDDefGHIjklMNOPqrstUVWXYz 출력하기

		
		
		
	}

}
