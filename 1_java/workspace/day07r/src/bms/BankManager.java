package bms;

import java.util.Random;

public class BankManager {
	
	static Bank[][] arUser = new Bank[3][1000];
	static int[] arCnt = {0, 0, 0};
	static Bank session = null; //세션: 웹 상에 존재하는 저장공간(로그인 정보 유지)
	
	
	String join(int bankChoice, String name, String pw) {
		//bankChoice: 1(국민은행)- 5글자, 신한- 6글자, 우리- 7글자
		//계좌 개설 로직
		String account = makeAccount(bankChoice); //자주 사용되니 메소드로 뽑음
		
		//중복회원 확인
		for (int i = 0; i < arCnt[bankChoice - 1]; i++) { //bankChoice - 1: 인덱스 번호
			if(arUser[bankChoice - 1][i].account.equals(account)) {
				//중복회원일 경우 계좌 개설 다시
				account = makeAccount(bankChoice);
				i = -1; //for문을 처음으로 도는 것과 같이 된다.증감식을 통해 0으로 바뀜. [bankChoice - 1][0]부터
			}
		}
		
		//회원 저장(가입)
		//switch문 리팩토링
		Bank[] makers = {
				 new Kookmin(account, name, pw),
				 new Kookmin(account, name, pw),
				 new Kookmin(account, name, pw)
		};
		arUser[bankChoice-1][arCnt[bankChoice-1]] = makers[bankChoice-1];
		arCnt[bankChoice-1]++;
		
//		switch(bankChoice) {
//		case 1: 
//			arUser[0][arCnt[0]] = new Kookmin(account, name, pw); //arCnt[0]: 국민은행의 회원수 //업캐스팅: 뱅크타입 2차원 배열에 각 은행의 객체들을 담음
//			arCnt[0]++;
//			break;
//		case 2: 
//			arUser[1][arCnt[1]] = new Kookmin(account, name, pw); //arCnt[1]: 신한은행의 회원수
//			arCnt[1]++;
//			break;
//		case 3: 
//			arUser[2][arCnt[2]] = new Kookmin(account, name, pw); //arCnt[2]: 우리은행의 회원수
//			arCnt[2]++;
//			break;
//		}
		return account; //가입 성공 계좌번호를 리턴으로 알려줌(여기서만 account를 알 수 있으니)
		
	} //join 닫
	
	String makeAccount(int bankChoice) {
		Random r = new Random();
		String account = null;
		
		//5글자: 10000 ~ 99999
		//r.nextInt(90000): 0 ~ 89999		
		//r.nextInt(90000)+10000: 10000 ~ 99999
		if(bankChoice == 1) {
			account = r.nextInt(90000)+10000 + "";
		} else if(bankChoice == 2) {
			account = r.nextInt(900000) + 100000 + "";
		} else if(bankChoice == 3) {
			account = r.nextInt(9000000) + 1000000 + "";
		} 
		return account;
	}

	boolean login(String account, String pw) {
		//반복문- 일치하는 객체를 찾음
		//account 길이가 객체마다 다름
		//5- 국민(0), 6- 신한(1), ...
		int idx = account.length() - 5;
		
		for (int i = 0; i < arCnt[idx]; i++) {
			Bank temp = arUser[idx][i];
			if(temp.account.equals(account)) {
				if(temp.pw.equals(pw)) {
					session = temp; //로그인을 성공한 객체를 세션에 담아서 다른 클래스에서 사용 가능
					return true;
				}
			}
		}
		return false;
	}

}
//3400 ~ 3700	(301)+3400
