package bms;

public class Bank {
	String account;
	String name;
	String pw;
	int balance;
	
	public Bank() {
	}
	
	public Bank(String account, String name, String pw) {
		this.account = account;
		this.name = name;
		this.pw = pw;
		this.balance = 0;
	}
	
	void deposit(int money) {
		balance += money;
	}
	
	boolean withdraw(int money) {
		if(balance >= money) {
			balance -= money;
			return true;
		}
		return false;
	}
	
	//김사과님 계좌(11111)
	//잔액: 1000원
	void show() {
		System.out.printf("%s님 계좌(%s)\n잔액: %d원\n", name, account, balance);
	}
	
}
