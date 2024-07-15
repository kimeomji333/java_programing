package lambda;

//람다식으로 인터페이스 구현하기
public class TestStringConcat2 {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World!";
		StringConcat cc = (s, v) -> System.out.println(s + ", " + v);
		cc.makeString(s1, s2);
	}

}
