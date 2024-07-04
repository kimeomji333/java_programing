package zoo;

//메서드 오버라이딩, 상속관계 연습
public class Ground {
	public static void main(String[] args) {
		//서로 다른 종류의 동물 세마리 울게하기 //사자, 고양이, 강아지
		
		Animal animal = new Animal();
		Cat mycat = new Cat();
		Lion mylion = new Lion("사자");
		Dog mydog = new Dog("강아지");
		
		mycat.makeSound();
		mylion.crying();
		mydog.crying();
		
		//객체들 규칙성 없어 -> 규칙성 부여하기 위해서 배열에 담기
		//부모타입의 배열에 담김
		Animal[] cage = {
				new Cat(),
				new Lion(),
				new Dog()
		};
		
		for (int i = 0; i < cage.length; i++) {
			cage[i].makeSound();
		}
		
	}
}
