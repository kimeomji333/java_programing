package pattern.single;

public class HanRiver {
	public static void main(String[] args) {
		Bridge bridge1 = new Bridge(); //주소값이 서로 다름. 객체 하나만으로 사용하고 싶을 때, 싱글톤패톤
		Bridge bridge2 = new Bridge();
		
		System.out.println(bridge1);	//pattern.single.Bridge@6f2b958e 다름
		System.out.println(bridge2);	//pattern.single.Bridge@5e91993f
		
		//싱글톤패턴
		Bridge bridge3 = Company.getBridge();
		Bridge bridge4 = Company.getBridge();
		
		System.out.println(bridge3);	//pattern.single.Bridge@379619aa 같음
		System.out.println(bridge4);	//pattern.single.Bridge@379619aa
	}
}
