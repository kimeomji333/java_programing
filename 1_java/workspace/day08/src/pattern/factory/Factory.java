package pattern.factory;

public class Factory {

	//주문을 받는 메소드
	public static Product getInstance(String name) {
		switch(name) {
		case "Computer":
			return new Computer("Computer");
		case "Camera":
			return new Camera("Camera");
		case "Dryer":
			return new Dryer("Dryer");			
		}
		return null;
	}
}
//Product 타입으로 리턴 받기 때문에 업캐스팅 되어 있음 -> 사용할 때 다운캐스팅