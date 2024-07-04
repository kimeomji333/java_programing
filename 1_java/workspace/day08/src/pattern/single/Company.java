package pattern.single;

public class Company {
	private static Bridge bridge; //bridge를 사용하려면 getter 이용
	
	public static Bridge getBridge() {
		//객체 bridge가 만들어지지 않았으니, null값 확인 필요 / 초기값. 객체를 넣어줌
		if(bridge == null) {
			bridge = new Bridge();
		}
		return bridge;
	}
	
}
