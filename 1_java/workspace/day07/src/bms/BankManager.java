package bms;

import java.util.Random;

public class BankManager {
	static Bank[][] arUser = new Bank[3][1000];
	static int[] arCnt = {0, 0, 0};
	static Bank session = null;
	
	String join(int bankChoice, String name, String pw) {
		//bankChoice : 1(국민은행) - 5글자, 2(신한은행) - 6글자, 3(우리은행) - 7글자
		//계좌 개설에 관한 로직을 작성
		String account = makeAccount(bankChoice);
		
		for (int i = 0; i < arCnt[bankChoice-1]; i++) {
			if(arUser[bankChoice-1][i].account.equals(account)) {
				account = makeAccount(bankChoice);
				i = -1;
			}
		}
		
		switch(bankChoice) {
		case 1:
			arUser[0][ arCnt[0] ] = new Kookmin(account, pw, name);
			arCnt[0]++;
			break;
		case 2:
			arUser[1][ arCnt[1] ] = new Shinhan(account, pw, name);
			arCnt[1]++;
			break;
		case 3:
			arUser[2][ arCnt[2] ] = new Woori(account, pw, name);
			arCnt[2]++;
			break;
		}
		return account;
		
	}
	String makeAccount(int bankChoice) {
		Random r = new Random();
		String account = null;
		// 3400~3700	r.nextInt(301)+3400
		if(bankChoice == 1) {
			// 			0 ~ 89999	10000 ~ 99999
			account = r.nextInt(90000)+10000+"";
		}
		else if(bankChoice == 2) {
			account = r.nextInt(900000)+100000+"";
		}
		else if(bankChoice == 3) {
			account = r.nextInt(9000000)+1000000+"";
		}
		return account;
	}
	boolean login(String account, String pw) {
		//5 - 국민은행(0) , 6 - 신한은행(1), ...
		int idx = account.length()-5;
		
		for (int i = 0; i < arCnt[idx]; i++) {
			Bank temp = arUser[idx][i];
			if(temp.account.equals(account)) {
				if(temp.pw.equals(pw)) {
					session = temp;
					return true;
				}
			}
		}
		return false;
	}
}

















