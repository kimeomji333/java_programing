package teamProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamProject {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
	
		//게임시작
		while(true) {
			System.out.println("\n==== 미니 게임을 시작합니다 ====");
			System.out.println("1. 간단계산기\n"
					+ "2. 작은 수에서 큰 수까지 합계\n"
					+ "3. 신상 정보 확인\n"
					+ "4. 학생 정보 확인\n"
					+ "5. 별과 숫자 출력\n"
					+ "6. 난수까지의 합계\n"
					+ "7. 구구단\n"
					+ "8. 주사위 숫자 맞히기 게임\n"
					+ "9. 프로그램 종료");
			
			//예외처리
			while(true) {
				try {
					//입력
					System.out.print("메뉴 번호: ");
					choice = sc.nextInt();

					if(choice == 9) {
						System.out.println("프로그램을 종료합니다.");
						break;
					} else if(choice < 1 || choice > 9){
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					} else {
						break; //정상적이면 반복문 탈출
					}
					
				} catch (InputMismatchException e) {
					System.out.println("정수형으로 입력해주세요");
					sc.next(); // 잘못된 입력 버퍼 비우기
				}
			}

			
			//처리: 선택된 메뉴 실행
			switch(choice) {
			case 1:
				new Calc2();
				break;
			case 2:
				new MinMaxSum();
				break;
			case 3:
				new PrivateImpo2();
				break;
			case 4:
				new StudentImpo2();
				break;
			case 5:
				new StarPrintToN2();
				break;
			case 6:
				new RandomNum2();
				break;
			case 7:
				new Gugudan2();
				break;
			case 8:
				new Dicegame3();
				break;
			} //switch닫
		}

	}
}
