package fileio;

import java.io.BufferedReader;
import java.io.FileReader;

//Reader 읽기, 출력: 입력만 해서는 안보이지, 출력까지 해줘야함
public class ReaderTest {
	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("test.txt");
		System.out.println("파일 준비 완료!");
		BufferedReader br = new BufferedReader(fr);
		System.out.println("버퍼 비슷 준비 완료!");
		
		//text 한 줄씩 읽어옴
		br.readLine();
		
//		String data1 = br.readLine();
//		System.out.println(data1);
//
//		String data2 = br.readLine();
//		System.out.println(data2);
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			System.out.println(line);
		}
		br.close();
	}
}
