package fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

//다운로드
public class FileDownload {
	public static void main(String[] args) throws Exception {
		
		String path = "https://i.namu.wiki/i/BH0SvRxVhYLx4lFJXW8Z91vdL9BuZHGng38RvoXfDCC86uSFUc77hK3qhQm2BDFi4F0G0HWjTt9ekhUNeAaTXVpcNPIkMGwRjzZzlMwiatE9Qdym2deAnJL_QDUp4wFiSDCxDGl-KWQARoYkZyu8zw.webp";
		
		URL url = new URL(path);
		
		System.out.println("URL 오픈!");
		InputStream is = url.openStream();
		System.out.println("InputStream 오픈");
		
		OutputStream os = new FileOutputStream("copy.jpg");
		System.out.println("OutputStream 오픈");
		
		//반복문으로 데이터 끝까지 읽어와서 써준다. -> 다운로드와 마찬가지
		while(true) {
			int data = is.read();
			if(data == -1) {
				break;
			} 
			os.write(data);
		}
		
		is.close();
		os.close();
	}
}
