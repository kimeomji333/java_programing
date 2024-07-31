package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//파일에 Food 객체를 저장하는 기능 구현. fileSave 메서드 작성
//[조치내용] : fileSave() 메소드를 작성하시오. : public void fileSave(String fileName){}
//- 전달받은 fileName 으로 파일 객체를 생성한다.
//- 파일 객체와 연결하는 파일 출력스트림을 생성한다.
//- 파일에 Food 객체를 기록할 수 있는 객체 출력스트림을 추가한다.
//- 파일에 Food 객체 정보를 기록하고 스트림들을 닫는다.
//- Food 객체 샘플 : "사과", 20

public class MyFood {

	//FileOutputStream: Food 객체를 직렬화하여 파일에 저장
	//ObjectOutputStream 사용해서 Food 객체를 파일에 기록
	
	//파일에 Food 객체를 저장하는 메서드
	public void fileSave(String fileName) {
		Food food = new Food("사과", 20);
		File file = new File(fileName); 
		
		try (FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos)){ 
						
			oos.writeObject(food);
			System.out.println("Food 객체가 파일에 저장 완료!");
			
		} catch (FileNotFoundException e) {
		} catch (IOException e1) {
			System.out.println("파일 저장 중 오류가 발생했습니다. ");
		}
	}
	
	public static void main(String[] args) {
		MyFood mfood = new MyFood();
		mfood.fileSave("food.ser");
	}
}
