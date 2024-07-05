package bmsEx;

//500원 출금하면 1000월 출금
public class Shinhan extends Bank {

	public Shinhan(String name, String pw, String account) {
		super(name, pw, account);
	}

	@Override
	boolean withdraw(int money) {
		money *= 2;
		return super.withdraw(money);
	}
}
