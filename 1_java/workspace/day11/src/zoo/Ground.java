package zoo;

public class Ground {
	public static void main(String[] args) {
		//동물 네 마리 만들어서 포유류들만 동시에 울게 하기 //개 고양이 까마귀 악어
		
		Animal dog = new Animal("멍", true);
		Animal cat = new Animal("야옹", true);
		Animal crow = new Animal("까악까악");
		Animal crocodile = new Animal("악윽");
		
		dog.start();
		cat.start();
		crow.start();
		crocodile.start();
		
	}
}
