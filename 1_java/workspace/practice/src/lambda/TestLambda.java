package lambda;

public class TestLambda {
	interface PrintString {
		void showString(String str);
	}

	public static void main(String[] args) {
		PrintString pstr = s -> System.out.println(s);
		pstr.showString("hello lamda");
		showMyString(pstr);
	}

	public static void showMyString(PrintString p) {
		p.showString("hello lamda2");
	}

}
