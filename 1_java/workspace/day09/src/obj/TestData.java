package obj;

public class TestData {
	int intData;
	double doubleData;
	
	public TestData(int intData, double doubleData) {
		super(); //object을 상속받으니 뜸
		this.intData = intData;
		this.doubleData = doubleData;
	}

	//Alt + Shift + S > S : toString() 만둘기
	@Override
	public String toString() {
		return "TestData [intData=" + intData + ", doubleData=" + doubleData + "]";
	}
	
//	@Override
//	public String toString() {
////		return super.toString();
//		return String.format("TestData(intData=%d, doubleData=%f)", intData, doubleData); //재정의 가능. 개발자들이 객체에 대해서 확실히 구별할 수 있다.
//	}
	
	
	@Override
	public int hashCode() {
//		return super.hashCode();
		return (int)doubleData*3 + intData; //해싱 알고리즘
	}
	
	
	//obj1.equals(obj2)	//this: obj1 //obj: obj2
	
	//equals 재정의 하기 위한 과정은 암기 <- 필요성: 동위객체를 동일객체를 보기 위함
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) { return false;}
		
		//1. 타입 비교
		if(obj instanceof TestData) {
			//2. 다운캐스팅
			TestData target = (TestData)obj;
			
			//3. 조건 비교
			if(this.intData == target.intData) { //TestData을 Object에 넣었으니 업캐스팅이 된 상태. 그래서 다운캐스팅을 해서 intData 를 찾아야함
				if(this.doubleData == target.doubleData) {
					return true;
				}
			}
		} 
		return false;
	}
}
//obj 매개변수는 Object 타입으로 밖에서 사용할 때 넘겨준 객체들은 업캐스팅해서 받는다.
//따라서 내부 필드를 서로 비교하려면 업캐스팅되며 접근이 제한되었던 필드들을 다시 사용 가능하도록 다운캐스팅을 해준 후 그 객체로 서로 비교해야 한다. 
//다운캐스팅은 TestData 타입의 객체가 업캐스팅 되었을 때만 가능하다. 따라서 instanceof 로 타입 비교부터 먼저 해준다. 
