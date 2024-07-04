package pattern.adapter;

public class Top implements Champion{

	@Override
	public void hit() {
		System.out.println("마구 때린다.");
	}

	@Override
	public void useSkill() {
		System.out.println("나는 싸움꾼이다.");
	}

	@Override
	public void seeMap() {
		System.out.println("보긴 보지만 상관없다. 이긴다는 마인드.");
	}

	@Override
	public void eatMinion() {
		System.out.println("돈은 중요하지않고 경험치가 중요하다.");
	}

	
}
