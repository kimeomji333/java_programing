package algorithm;

import java.io.Serializable;

//자바에서 객체를 저장하려면 직렬화를 사용할 수 있다. 

//[클라이언트용 프로그래밍 실행 순서]
//[원인] : kh.model.vo.Food 클래스를 캡슐화(EnCapsulation) 원칙에 맞춰서 구현하시오.
//- 직렬화 선언한다.
//- String타입의 name과 int타입의 kcal 필드를 선언한다
//- 기본생성자와 매개변수 있는 생성자를 작성한다.
//- 필드에 대한 getter 와 setter 작성한다.
//- toString() 메소드를 오버라이딩하여 인스턴스변수의 값에 대한 문장을 작성하여 리턴한다.

public class Food implements Serializable {
	
	private static final long serialVersionUID = 1L; //직렬화 ID
	
	private String name;
	private int kcal;
	
	public Food() {
	}

	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	//toString() 메서드 오버라이딩
	@Override
	public String toString() {
		return "Food name = " + name + ", kcal = " + kcal;
	}
}
