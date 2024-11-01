package cafe;

public class Building {
	public static void main(String[] args) {
		//int data = 10;
		//f(data);
		//== f(10); 위와 같은 말임. 
		
		Manager manager = new Manager();

		//방법1
		Cafe cafe1 = new Cafe() { //Cafe는 인터페이스기 때문에 재정의 후, 카페 객체를 만들어 넘겨준다. 
			
			@Override
			public void sell() {
				System.out.println("손님에게 커피 팔기");
			}
			
			@Override
			public void drip() {
				System.out.println("커피 내리기");
			}
			
			@Override
			public void clean() {
				System.out.println("청소하기");
			}
		};

		manager.openCafe(cafe1);
		
		
		//방법2
		manager.openCafe(  new Cafe() {
			
			@Override
			public void sell() {
				System.out.println("손님에게 커피 팔기");
			}
			
			@Override
			public void drip() {
				System.out.println("커피 내리기");
			}
			
			@Override
			public void clean() {
				System.out.println("청소하기");
			}
		}  );
	}
}
