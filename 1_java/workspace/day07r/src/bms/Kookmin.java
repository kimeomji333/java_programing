package bms;

//1000원 입금 시 500원만 입금(500원 수수료)
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
