package bmsEx;

import java.util.Random;

//로직
public class BankManager {
	static Bank[][] arUser = new Bank[3][1000]; //은행-사용자
	static int[] arCnt = {0,0,0}; //은행
	static Bank session = null; //로그인 정보 유지(세션: 웹상 저장공간)
	

	//계좌 개설
	public String join(int bankChoice, String name, String pw) {
		String account = makeAccount(bankChoice);
		
		//중복 회원 확인
		for (int i = 0; i < arCnt[bankChoice - 1]; i++) {
			if(arUser[bankChoice - 1][i].account.equals(account)) {
				account = makeAccount(bankChoice);
				i -= 1;
			}
		}
		
		//회원 가입(저장)
		Bank[] makers = { 
				new Kookmin(name, pw, account),
				new Shinhan(name, pw, account),
				new Woori(name, pw, account)	
		};
		
		arUser[bankChoice - 1][arCnt[bankChoice - 1]] = makers[bankChoice - 1];
		arCnt[bankChoice - 1]++;
		return account;
	} 
	

	//로그인
	public boolean login(String account, String pw) {
		//일치하는 객체 찾음
		int idx = account.length() -5;
		for (int i = 0; i < arCnt[idx]; i++) {
			Bank temp = arUser[idx][i];;
			if(temp.account.equals(account)) {
				if(temp.pw.equals(pw)) {
					session = temp;
					return true;
				}
			}
		}
		return false;
	}
	
	//계좌 개설 메소드
	String makeAccount(int bankChoice) {
		Random r = new Random();
		String account = null;
		
		if(bankChoice == 1) {
			account = r.nextInt(90_000) + 10_000 + "";
		} else if(bankChoice == 2) {
			account = r.nextInt(900_000) + 100_000 + "";
		} else if(bankChoice == 3) {
			account = r.nextInt(9_000_000) + 1_000_000 + "";
		}
		return account;
	}

}

