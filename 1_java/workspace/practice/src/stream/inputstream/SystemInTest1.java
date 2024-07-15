package stream.inputstream;

import java.io.IOException;

public class SystemInTest1 {
	public static void main(String[] args) {
		System.out.print("알파벳 하나를 쓰고 ENTER를 누르세요.");
		
		int i;
		try {
			i = System.in.read(); //read메서드로 한 바이트 읽음
			System.out.println("숫자: " + i);
			System.out.println("문자: " + (char)i);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
