package inner;

public class InnerTest {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		b.f();
		
		//In 클래스는 객체 만들기 쉽지 않음 -> 필드는 설계는 해놨지만, 실제화는 객체를 만들었을 때 생긴다. 즉, in 클래스 또한 마찬가지. 그래서 out 객체 안에 있는 in 객체화 해야한다. 
		//내부 클래스를 객체화하는 경우는 많이 없음. 
		Out out = new Out();
//		Out.In in= out.new In(); //밖에서 new In() 를 못만들게 되어 있는 경우가 있다. 
//		in.f();
		
		//내부 클래스는 보통 직접 객체화를 진행하기 보다 내부 클래스 타입의 객체를 리턴해주는 메소드를 호출하여 내부에서 생성된 객체를 받아서 사용한다.
		Out.In in = out.doSomething();
		in.f();
	}
}

class A {
	int data = 10;
}

class B extends A {
	void f() {
		System.out.println(data); //다른 클래스의 필드를 사용하려면 상속받기
	}
}

//이너클래스: 감추고 싶을 때? 내부있을 때 필드를 사용할 수 있다. 
class Out{
	int data = 20;
	
	//in과 같이 올라와있는 In 타입의 메소드를 만들어
	In doSomething() {
		System.out.println("In 타입의 객체를 만들어준다.");
		return new In();
	}
	
	class In{
		void f() {
			System.out.println(data);
		}
	}
}