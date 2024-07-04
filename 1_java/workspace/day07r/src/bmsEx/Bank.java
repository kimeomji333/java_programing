package bmsEx;

public class Bank {

	String account;
	String name;
	String pw;
	int balance;
	
	public Bank() {
	}

	public Bank(String account, String name, String pw) {
		super();
		this.account = account;
		this.name = name;
		this.pw = pw;
		this.balance = 0;
	}
	
	void deposit(int money) {
		balance += money;
	}
	
	boolean withdraw(int money) {
		if(money >= balance) {
			balance -= money;
			return true;
		}
		return false;
	}
	
	void show() {
		System.out.printf("%s님 계좌(%s)\n잔액: %d\n", name, account, balance);
	}
}
