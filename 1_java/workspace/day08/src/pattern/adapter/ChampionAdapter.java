package pattern.adapter;

//인터페이스를 상속 받았기 때문에 사용하지 않은 메소드들도 재정의 된다. -> 해결하기 위해 어뎁터 클래스를 만들어 빈 채로 재정의
//내용이 없더라도 틀을 만들기 위함
//어뎁터를 extends 하면, 필요한 메소드만 호출 가능해짐
public class ChampionAdapter implements Champion {

	@Override
	public void hit() {}

	@Override
	public void useSkill() {}

	@Override
	public void seeMap() {}

	@Override
	public void eatMinion() {}

}
