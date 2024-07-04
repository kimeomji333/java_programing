package cafe;

public class Manager {
	
	//Cafe는 인터페이스인데, 메소드를 어떻게 사용할 수 있는가? 매개변수로 Cafe 객체가 담아져있어 구현이 되어 있을 것이라 생각함. 그래서 사용할 수 있는거임.
	void openCafe(Cafe cafe) {
		System.out.println("오픈");
		System.out.println("원두 그라인딩");
		cafe.drip();
		cafe.sell();
		cafe.clean();
		System.out.println("--- 마감 ---");
	}

}
