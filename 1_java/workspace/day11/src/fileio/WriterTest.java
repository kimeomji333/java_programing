package fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Writer 쓰기, 입력
public class WriterTest {
	public static void main(String[] args) throws Exception {
		//절대 경로(거의 안씀)
//		FileWriter fw = new FileWriter("D:\\ttt.txt"); //문자열 형태로 경로를 적어줌(공간 확보) -> 디드라이브에 생김
		
		//상대 경로(기준점이 있어야 함) 프로젝트 최상위 경로가 현재 위치를 뜻함 (현재 프로젝트 최상위 경로)
//		FileWriter fw = new FileWriter("test.txt");
		
		//없는 폴더(a)는 만들어 내지는 못한다. 파일명 앞에 실제로 존재하는 폴더명을 썼을 경우에는 "현재 프로젝트 경로/폴더" 안데 해당 파일을 생성한다.
//		FileWriter fw = new FileWriter("a/test/txt"); //슬래쉬 앞에 폴더명을 적음
		
		//1. 덮어쓰기 모드
//		FileWriter fw = new FileWriter("test.txt");
		
		//2. 추가하기 모드
		FileWriter fw = new FileWriter("test.txt", true);
		System.out.println("파일 준비 완료!");
		
//		fw.write(97);	//파일에 실제데이터를 쓰기 위해서 모아놓음 
//		fw.flush(); 	//-> 실제 파일로 데이터 보냄(플러쉬)
//		fw.close(); 	//닫기만 해도 flush까지 됨
		
		//단점: 데이터로 적어줌 -> FileWriter를 쓰기 보다는 BufferedWriter 사용 : 반복해도 덮어씌우기, 줄바꿈이 안돼
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println("버퍼 비슷 준비 완료");
		bw.write("Hello World ! ! !\r\n"); //줄바꿈은 두 개의 조함 ex. 타자기를 생각해
		bw.write("Hi~~~ Good Morning~~~\r\n");
		bw.close();
		
	}

}
