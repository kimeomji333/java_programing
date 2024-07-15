package stream.inputstream;

import java.io.IOException;

public class SystemInTest2 {
	public static void main(String[] args) {
		System.out.print("알파벳 여러 개를 쓰고 ENTER를 누르세요.");
		
		int i;
		try {
			while((i = System.in.read()) != '\n') {
				System.out.println((char)i);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
