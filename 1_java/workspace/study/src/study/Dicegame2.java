package study;

import java.util.Random;
import java.util.Scanner;

public class Dicegame2 {
	public static void main(String[] args) {
		//주사위 숫자 맞히기 게임
		//두 개의 주사위가 만들어낼 수 있는 모든 경우의 수를 랜덤으로 정하고, 
		//합이 입련된 수와 같으면, "맞췄습니다." 출력 / 다르면, "틀렸습니다." 출력
		//맞출 때까지 반복
		//값을 맞추면 "계속 하시겠습니까?(y/n): " 가 출력되고 입력시 새로운 랜덤 수가 정해지고 처음부터 다시 시작
		
		//입력
		Scanner sc = new Scanner(System.in);
		//주사위 2개의 합 최소2부터 최대12까지 난수 생성
		Random r = new Random();
		int randomNum = r.nextInt(11)+2;

		System.out.println("주사위 숫자 맞히기 게임 스타트!");		
		
		//반복문으로 게임 실행
		while(true) {
			
			System.out.print("주사위 두 개의 합을 맞춰보세요(2~12입력): "); //난수 2 ~ 12까지 나옴
			int userNum = sc.nextInt();
			
			//로직
			if(randomNum != userNum) {
				System.out.println("ㅠㅠ 틀렸습니다.");
			} else {
				System.out.print("맞췄습니다.\n계속 하시겠습니까?(y/n)");
				String conti = sc.next();
				
				//계속하기 여부
				if(conti.equals("N") || conti.equals("n")) {
					System.out.println("게임이 종료됩니다.");
					break;
				} else if(conti.equals("Y") || conti.equals("y")) {
					randomNum = r.nextInt(11)+2;
					continue;
				} else {
					System.out.println("잘못된 입력입니다.");
				}
			}
		} 

	}
}
