package day02;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = sc.next();
		System.out.println(name + "님 어서오세요~");
		
		System.out.print("주소: ");
		sc.nextLine(); //위의 입력에서 입력 종료로 사용한 \n을 입력받아버리기 때문에 의미 없는 sc.nextLine() 를 미리 써주어야 한다. 
		String addr = sc.nextLine();
		System.out.println("사는 곳은 \"" + addr + "\" 이네요~");
		
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.println("당신은 5년 뒤에 " + (age+5) + "살입니다.");
	}		
}
