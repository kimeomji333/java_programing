package teamProject;

import java.util.InputMismatchException;
import java.util.Scanner;

//작은 수에서 큰 수까지 합계 완료
public class MinMaxSum {
	public MinMaxSum() {
		//작은 수에서 큰 수까지 합계
		//정수 두 개를 입력받아
		//작은 값(시작 값), 큰 값(종료값)으로 합계를 구함
		
		//입력
		Scanner sc = new Scanner(System.in);
		int min = 0;
		int max = 0;
		int sum = 0;
		int num1 = 0;
		int num2 = 0;
		
		
		while(true) {
			try {
				System.out.print("첫 번째 정수를 입력하세요: ");
				num1 = sc.nextInt();
				
				System.out.print("두 번째 정수를 입력하세요: ");
				num2 = sc.nextInt();
				
				break; //정상적으로 입력되면 반복문 탈출
				
			} catch (InputMismatchException e) {
				System.out.println("정수형으로 입력해주세요");
				sc.next(); // 잘못된 입력 버퍼 비우기
			}
		}
		
		//처리
		if(num1 > num2) {
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}
		
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		
		//출력
		System.out.println("첫 번째 정수: " + num1);
		System.out.println("두 번째 정수: " + num2);
		System.out.println(min + " 부터 " + max + " 까지 정수들의 합: " + sum);
	}
}
