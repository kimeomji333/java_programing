package bmsEx;

import java.util.Scanner;

//1. 계좌 개설
public class JoinView {
	public JoinView() {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 국민은행\n2. 신한은행\n3. 우리은행");
		int bankChoice = sc.nextInt();
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("비밀번호: ");
		String pw = sc.next();
		
		//출력
		BankManager manager = new BankManager();
		String account = manager.join(bankChoice, name, pw);
		if(account != null) {
			System.out.println(name + "님 계좌 개설을 환영합니다.\n계좌 번호: " + account);
		} else {
			System.out.println("알 수 없는 오류 발생 / 계좌 개설에 실패했습니다.");
		}
		
	}
}
