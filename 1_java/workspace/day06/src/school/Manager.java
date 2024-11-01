package school;

//5 처리 로직
public class Manager {
	
	//static을 붙여서 student 객체 하나의 공간에서 사용함
	static Student[] list = new Student[100];
	static int studCnt = 0;
	
	//등록: 정보 받아오기(매개변수를 이용해서)
	void insert(String name, int ban, int bun) {
		//추가하는 코드: 매개변수 받아온 데이터를 저.장. -> 클래스를 기능 용도로 배열 만들어 보관(Student class 만듦)
		list[studCnt] = new Student(name, ban, bun);
		studCnt++;
	}
	
	//전체 조회
	String selectAll() {
		//각 학생들을 순회하며 
		//김사과(1반 1번) - 총점 : 0점 
		// ...
		//형태의 문자열들을 다 연결해서 문자열 데이터로 생성
		//학생 추가로 인해 값이 달라져 매개변수는 필요없다?
		String result = "";
		for (int i = 0; i < studCnt; i++) {
			Student temp = list[i];
			result += String.format("%s(%d반 %d번) - 총점: %d점\n", temp.name, temp.ban, temp.bun, temp.tot); 
		}
		return result;
	}
	
	//선택 조회 메소드? 학생 객체 위치를 찾는 메소드
	int selectIdx(int ban, int bun) {
		for (int i = 0; i < studCnt; i++) {
			Student temp = list[i];
			
			if (temp.ban == ban) {
				if (temp.bun == bun) {
					return i;
				}
			}
		}
		return -1;
	}
	
	// 학생 객체 주소를 찾는 메소드 
	Student select(int ban, int bun) {
		for (int i = 0; i < studCnt; i++) {
			Student temp = list[i];
			
			if (temp.ban == ban) {
				if (temp.bun == bun) {
					return temp;
				}
			}
		}
		return null;
	}

	//삭제
	public void delete(int idx) {
		for (int i = 0; i < studCnt - 1; i++) {
			list[i] = list[i + 1];
		}
		list[studCnt - 1] = null;
		studCnt--;
	}
			
	
	

	
	
	
}
