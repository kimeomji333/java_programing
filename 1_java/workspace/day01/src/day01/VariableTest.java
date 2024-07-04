package day01;

public class VariableTest {
	public static void main(String[] args) {
		//========홍길동 님의 개인정보========
		//이름 : 홍길동
		//나이 : 10살
		//키 : 180.22cm
		//몸무게 : 79.15kg
		//성적 : C
		// \O/
//		Alt + Shift + R : 선언부와 사용부 함께 이름 변경하기
		String name = "홍길동";
		int age = 10;
		float height = 180.22f;
		double weight = 79.15;
		char score = 'C';
		
		System.out.println("========" + name + " 님의 개인정보========");
		System.out.println("이름 : " + name);
		System.out.printf("나이 : %d살\n", age);
		
//		%.2f : 소수점 둘째자리까지 출력
		System.out.printf("키 : %.2fcm\n", height);
		System.out.println("몸무게 : " + weight + "kg");
		System.out.println("성적 : " + score);
		System.out.println("\\O/");
	}
}









