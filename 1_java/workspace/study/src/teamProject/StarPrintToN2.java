package teamProject;

import java.util.InputMismatchException;
import java.util.Scanner;

//별과 숫자 출력 완료
public class StarPrintToN2 {
	public StarPrintToN2() {
		//별과 숫자 출력
		//정수 하나 입력 받아 양수인 경우 줄 수로 적용하여 출력
		
		//입력
		Scanner sc = new Scanner(System.in);
		int num;
		
		while(true) {
			try {
				System.out.print("정수를 입력해주세요: ");
				num = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("정수형으로 입력해주세요");
				sc.next();
			}
		}
		
		if(num > 0) {
			for (int i = 0; i < num; i++) {
				for (int j = i-1; j < 2*i-1; j++) {
					System.out.print("*");
				}
				System.out.println(i+1);
			}
		} else {
			System.out.println("양수가 아닙니다.");
			
			//계속하기 여부
			while (true) {
				System.out.print("다시 입력 하시겠습니까(Y/N)");
				String restart = sc.next();

				if (restart.equals("N") || restart.equals("n")) {
					System.out.println("게임이 종료됩니다.");
					return;
				} else if (restart.equals("Y") || restart.equals("y")) {
					System.out.println("새로운 정수를 입력해주세요");
					break;
				} else {
					System.out.println("잘못된 입력입니다.");

				}
			}
		}
	}
}
