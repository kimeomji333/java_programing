package obj;

public class MathTest {
	public static void main(String[] args) {
		//Math.ceil(실수): 소수점 첫째 자리에서 올림
		System.out.println(Math.ceil(19.11));	//20.0
		System.out.println(Math.ceil(-19.11));	//-19.0
		
		//Math.floor(실수): 소수점 첫째 자리에서 내림
		System.out.println(Math.floor(19.11));	//19.0
		System.out.println(Math.floor(-19.11));	//-20.0
		
		//Math.round(실수): 소수점 첫째 자리에서 반올림
		System.out.println(Math.round(19.4999999));	//19
		System.out.println(Math.round(19.5));		//20
		
		//특정한 자리에서 하고 싶은 경우(1. 10의 제곱수를 곱하고 2. 반올림 3. 곱해줬던 수만큼 나눈다)
		//11.484 -> 11.5 //(11.484*10)/10.0
		System.out.println((Math.ceil(11.484*10))/10.0);	//11.5
		// ↓ 쉬운 방법
		//제곱
		System.out.println(Math.pow(10, 2));	//100.0
		//제곱근
		System.out.println(Math.sqrt(9));		//3.0
	
	}

}
