package access1;

public class AccessMain1 {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		System.out.println(obj.data1);
		System.out.println(obj.data2);
		
//		System.out.println(obj.data3); //접근제어자가 private라서 사용 불가 -> 우회해서 사용 가능(메소드를 만들어서 !)
		System.out.println(obj.getData3()); //getter	//30
		
//		obj.data3 = 300;
		obj.setData3(300); //setter
		System.out.println(obj.getData3());		//300
		
		System.out.println(obj.data4);
		
	}

}
