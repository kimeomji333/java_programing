package stream.decorator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	public static void main(String[] args) {
		long millisecond = 0;

		try(FileInputStream fis = new FileInputStream("a.zip")) {
			FileOutputStream fos = new FileOutputStream("copy.zip");
			
			//파일 복사를 하기 전 시간
			millisecond = System.currentTimeMillis(); 
			
			int i;
			while((i = fis.read()) != -1) {
				fos.write(i);
			}
			
			//파일 복사 하는데 걸리는 시간
			millisecond = System.currentTimeMillis() - millisecond; 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일 복사하는 데 " + millisecond + " milliseconds 소요되었습니다. ");
	}
}
