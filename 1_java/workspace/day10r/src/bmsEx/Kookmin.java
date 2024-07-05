package bmsEx;

//1000원 입금 시 500원만 입금(500원 수수료)
public class Kookmin extends Bank{

	public Kookmin(String name, String pw, String account) {
		super(name, pw, account);
	}
	
	@Override
	void deposit(int money) {
		money /= 2;
		super.deposit(money);
	}
	

}
