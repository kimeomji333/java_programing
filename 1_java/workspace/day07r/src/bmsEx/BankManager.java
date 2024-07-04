package bmsEx;

import java.util.Random;

public class BankManager {
	
	static Bank[][] arUser = new Bank[3][1000]; // static으로 User 정보를 담은 2차원 배열 선언, 생성 [은행인덱스][회원정보]
	static int[] arCnt = {0, 0, 0}; // 은행 수
	static Bank session = null;
	

	String join(int bankChoice, String name, String pw) {
		//계좌 개설 로직
		//bankChoice1(국민5글자), 2(신한6글자), 3(우리7글자)
		String account = makeAccount(bankChoice);
		
		//중복회원 확인
		for (int i = 0; i < arCnt[bankChoice - 1]; i++) {
		
		}
		
		//회원가입 저장
		
		return account;
	}

	//계좌 개설 메서드
	String makeAccount(int bankChoice) {
		//랜덤을 이용해서 계좌 번호 작성
		Random r = new Random();
		String account = null;
		
		if(bankChoice == 1) {
			account = r.nextInt(90000)+10000 + "";
		} else if(bankChoice == 2) {
			account = r.nextInt(900000)+100000 + "";
		} else if(bankChoice == 3) {
			account = r.nextInt(9000000)+1000000 + "";
		}
		return account;
	}

}
