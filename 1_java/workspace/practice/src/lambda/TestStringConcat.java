package lambda;

public class TestStringConcat {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World!";
		StringConCatImpl cc = new StringConCatImpl();
		cc.makeString(s1, s2);
	}

}
