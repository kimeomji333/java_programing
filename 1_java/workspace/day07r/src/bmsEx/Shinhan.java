package bmsEx;

//500원 출금하면 1000월 출금
public class Shinhan extends Bank{

	public Shinhan(String account, String name, String pw) {
		super(account, name, pw);
	}

	@Override
	boolean withdraw(int money) {
		money *= 2;
		return super.withdraw(money);
	}
}
