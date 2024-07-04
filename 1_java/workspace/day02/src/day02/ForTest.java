package day02;

public class ForTest {

	public static void main(String[] args) {
		//0. 홍길동
		//1. 홍길동
		//2. 홍길동
		//...
		//9. 홍길동

		//while문
//		int cnt = 0;
//		while(cnt < 10) {
//			System.out.println(cnt + ". 홍길동");
//			cnt++;
//		}
//		
//		//for문
//		for(int i = 0; i < 10; i++) {
//			System.out.println(i + ". 홍길동");
//		}
//	
//		//공식 :       반복 횟수 = (끝값 - 초기값) / 증감값
//	
//		
//		//10번 반복하는 반복문
//		for(int i = 4; i >-36 ; i -=4) {
//			
//		}
//		
//		//100부터 -3씩 하면서 13번 반복
//		for(int i = 100; i > 61; i -= 3) {
//			
//		}
//		
//		//for문도 조건식이 참일 동안 반복이다.
//		//초기식, 조건식, 증감식은 다 생략이 가능하고 
//		//조건식을 생략할 시 무한 반복
//		for(;true;) {
//			
//		}
		
//		//2 4 6 8 10 12 14 16 18 20
//		for(int i = 2; i <= 20; i += 2) {
//			System.out.println(i);
//		}
//		
//		//2 4 6 8 10 12 14 16 18 20
//		for(int i = 0; i < 10; i ++) {
//			System.out.println(i*2 +2);
//		}
		
		//i 	표현해야 할 값
		//0		2
		//1		4
		// ...
		//9		20
	
		//26 23 20 ... -10
		for(int i = 0; i <13 ; i++) {
			System.out.println(i*-3+26);
		}
		
		//2 3 / 4 6 / 6 9 / 8 12 / 10 15
		//i		표현할 값
		//0		2		3
		//1		4		6
		//2		6		9
		//3		8		12
		//4		10		15
		//		i*2+2	i*3+3
		for(int i = 0; i <5 ; i++) {
			System.out.println(i * 2 + 2);
			System.out.println(i * 3 + 3);
		}
	} 
}
