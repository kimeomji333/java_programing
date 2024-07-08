package bmsEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//리팩토링 연습하기 !!!!!!!!!!!!
//로직
public class BankManager2 {
	static ArrayList<ArrayList<Bank>> arUser = null;
	static HashMap<String, Object> session = null;
	
	//
	public BankManager2() {
		if(arUser == null) {
			arUser = new ArrayList<>();
			arUser.add(new ArrayList<>());
			arUser.add(new ArrayList<>());
			arUser.add(new ArrayList<>());			
		} if(session == null) {
			session = new HashMap<>();
		}
	}
	
	String join(int bankChoice, String name, String pw) {
		String account = makeAccount(bankChoice);
		
		ArrayList<Bank> temp = arUser.get(bankChoice - 1);
		
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i).account.equals(account)) {
				account = makeAcount(bankChoice);
				i = -1;
			}
		}
		
		Bank[] makers = {
				new Kookmin(name, pw, account),
				new Shinhan(name, pw, account),
				new Woori(name, pw, account)
		};
		
		temp.add(makers[bankChoice - 1]);
		
		return account;
	}
	
	boolean login(String account, String pw) {
		int idx = account.length() - 5;
		ArrayList<Bank> temp = arUser.get(idx);
		
		for(Bank user : temp) {
			if(user.account.equals(account)) {
				if(user.pw.equals(pw)) {
					session.put("loginUser", user);
					return true;
				}
			}
		}
		return false;
	}
	
	
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

