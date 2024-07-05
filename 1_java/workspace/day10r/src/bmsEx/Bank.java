package bmsEx;

public class Bank {
	String name;
	String pw;
	String account;
	int balance;
	
	public Bank() {
	}

	public Bank(String name, String pw, String account) {
		this.name = name;
		this.pw = pw;
		this.account = account;
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
	
	void show() {
		System.out.printf("%s님 계좌(%s)에 잔액이 %d원 남았습니다.\n", name, account, balance);
	}
	
	
}
