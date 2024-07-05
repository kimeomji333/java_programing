package bmsEx;

//잔액 볼 때마다 잔액 절반
public class Woori extends Bank {

	public Woori(String name, String pw, String account) {
		super(name, pw, account);
	}

	@Override
	void show() {
		balance /= 2;
		super.show();
	}
}
