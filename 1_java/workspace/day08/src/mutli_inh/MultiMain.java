package mutli_inh;

//다중 상속
public class MultiMain {
	public static void main(String[] args) {
		D obj = new D();
		obj.f(); //클래스인 c의 메소드가 우선순위가 됨
		obj.doSomething();
	}
}
