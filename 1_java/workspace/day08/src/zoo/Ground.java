package zoo;

public class Ground {
	public static void main(String[] args) {
//		Gangsa gangsa = new Gangsa("홍길동", "남", 20);
//		Mosquito mosquito = new Mosquito("모기", "여자", 1);
//		Otter otter = new Otter("수달", "남", 2);
		
		//배열에 담기
		Animal[] cage = {
				new Gangsa("홍길동", "남", 20),
				new Mosquito("모기", "여자", 1),
				new Otter("수달", "남", 2)
		};
		
		//0,2번방에 있는 객체는 Mammal이라는 타입을 마킹해 놓은듯한 효과를 낼 수 있다.
		//마크 인터페이스(내부가 비워져 있는 경우도 있음- 목표가 하나의 타입을 더 부여하기 위함이라서)
		for (int i = 0; i < cage.length; i++) {
			//cage[i].makeSomeNoise();
			if(cage[i] instanceof Mammal) {
				((Mammal)cage[i]).breed();
			}
		}
//		gangsa.makeSomeNoise();
//		mosquito.makeSomeNoise();
//		otter.makeSomeNoise();
	}

}
