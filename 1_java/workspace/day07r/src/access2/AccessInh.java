package access2;

import access1.AccessTest;

public class AccessInh extends AccessTest{
	void f2() {
//		System.out.println(data1);
		System.out.println(data2); //public이라 가능
//		System.out.println(data3);
		System.out.println(data4); //protected 상속 받아 가능
	}
}
