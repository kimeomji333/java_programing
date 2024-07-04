package access1;

public class AccessTest {
	int data1 = 10;
	public int data2 = 20;
	private int data3 = 30;
	protected int data4 = 40;

	//private으로 생성된 생성자는 다른 곳에서 객체를 만들 수 없어 -> 다른 방법으로 활용하는 방법이 있음(나중에 사용하는 방법 찾아봐)
//	private AccessTest() {
//	}
	
	void f() {
		System.out.println(data3); // private 내부에서만 사용가능
	}


	//Alt + Shift + S > R : getter, setter 생성하기 (private 필드를 만들면 메소드를 이용해서 사용하기 때문에 getter, setter 매우 중요)
	public int getData3() {
		return data3;
	}
	
	public void setData3(int data3) { //밖에서 세팅할 값 받아와야 함
		this.data3 = data3;
	}
}
