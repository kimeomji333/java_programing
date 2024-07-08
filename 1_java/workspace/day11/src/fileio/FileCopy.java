package fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//복사: 읽는 파일을 읽어서 다른 경로에 써준다
public class FileCopy {
	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream("copy.jpg");
		System.out.println("InputStream 오픈");
		
		OutputStream os = new FileOutputStream("src/copy2.jpg");
		System.out.println("OutputStream 오픈");
		
		int data;
		while((data = is.read()) != -1) {
			os.write(data);
		}
		
		is.close();
		os.close();
	}

}
