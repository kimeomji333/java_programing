package zoo;

public class Ground {
	public static void main(String[] args) {
		Gangsa gangsa = new Gangsa("홍길동", "남", 20);
		Mosquito mosquito = new Mosquito("모기", "여자", 1);
		Otter otter = new Otter("수달", "남", 2);
		
		gangsa.makeSomeNoise();
		mosquito.makeSomeNoise();
		otter.makeSomeNoise();
	}

}
