package day02;

public class CastingTest {

	public static void main(String[] args) {
		//정수와 정수의 연산 결과는 정수
		System.out.println(10/3);
		
		//정수와 실수의 연산 결과는 실수
		System.out.println(10/3.0);

		System.out.println("============");
		System.out.println(10/(3+0.0));
		System.out.println(10/(3*1.0));
		System.out.println("============");
		
		//아스키 코드: 문자마다 대응되는 정수값 
		//'A' : 65,  'a' : 97,  '0' : 48
		System.out.println('0' + 1);
		
		//빈문자열 이용 -> 문자열로 자동 형변환
		System.out.println(10 + "");	//49
		
		//강제형변환
		System.out.println((double)10);
		
		//우선연산자 먼저 
		System.out.println((char)'A' + 5);  //70
		
		//괄호를 이용
		System.out.println((char)('A' + 5)); //F
		
	}

}
