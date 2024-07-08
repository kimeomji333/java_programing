package fms;

//데이터들을 담당하는 클래스. 묶어서 보낼 것임
public class Model {
	String data; //나중에 private로, 지금은 그냥 함

	public Model() {
	}

	public Model(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
	
	
}
