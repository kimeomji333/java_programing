package day01;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		//입력의 준비과정, Scanner 타입의 변수 만들기
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		//이곳 밑으로는 사용자가 이미 입력을 해서
		//name이라는 변수에 특정 값이 담겨있다고 가정하고 개발한다.
		
		System.out.println(name + "님 어서오세요~");
	}
}
