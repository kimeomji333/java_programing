package pattern.adapter;

public class Mid implements Champion {

	@Override
	public void hit() {
		System.out.println("미니언을 조심하며 때린다.");
	}

	@Override
	public void useSkill() {
		System.out.println("나의 턴을 유지하기 위해 조심스럽게 상대를 맞춘다.");
	}

	@Override
	public void seeMap() {
		System.out.println("주변을 살펴본다.");
	}

	@Override
	public void eatMinion() {
		System.out.println("한 개가 소중하므로 잘 챙긴다.");
	}
}
