package fms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//데이터를 컨트롤(백)
public class Controller {

	public final static String DATABASE = "db.txt"; // 상수 선언(저장할 경로)

	// 처리를 위한 메소드 필요
	void insert(Model model) {
		try {
			FileWriter fw = new FileWriter(DATABASE, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(model.data + "\r\n");
			bw.close();
		} catch (IOException e) {
		}
	}

	void update(String data, Model updatemodel) {
		List<Model> models = new ArrayList<>();
		models.add(updatemodel);
		try {
			// 데이터 읽기(일치여부) -> 삭제 -> 수정
			FileReader fr = new FileReader(DATABASE);
			BufferedReader br = new BufferedReader(fr);

			br.readLine();

			String result = "";
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				if (line.equals(data)) {

				} else {
					result += line + "\r\n";
				}
			}

//			while(true) {
//				String line = br.readLine();
//				if(line != null) {
//					//파일에서 읽어온 데이터로부터 Model 객체 생성
//					model = new Model(line);
//					models.add(model);
//				}
//			}
			// 쓰기
			FileWriter fw = new FileWriter(DATABASE);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(result);
			bw.close();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	void delete(String data) {
		// 삭제할 내용 빼고 나머지 데이터들을 모아서 덮어씌우기
		try {
			FileReader fr = new FileReader(DATABASE);
			BufferedReader br = new BufferedReader(fr);

			String result = "";
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				if (line.equals(data)) {

				} else {
					result += line + "\r\n";
				}
			}

			FileWriter fw = new FileWriter(DATABASE);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(result);
			bw.close();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	List<Model> read() {
		List<Model> models = new ArrayList<>();
		try {
			FileReader fr = new FileReader(DATABASE);
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String line = br.readLine();
				if (line != null) {
					Model model = new Model(line);
					models.add(model);
				}
				System.out.println(line);
				br.close();
			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return models;
	}

}
