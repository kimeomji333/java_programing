package bmsEx;

//1000원 입금 시 절반만 입금(절반 수수료)
public class Kookmin extends Bank{

	public Kookmin(String account, String name, String pw) {
		super(account, name, pw);
	}
	
	@Override
	void deposit(int money) {
		money /= 2;
		super.deposit(money);
	}
}
