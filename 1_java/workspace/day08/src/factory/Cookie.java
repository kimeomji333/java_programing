package factory;

//모든 과자들이 가질만한 값(속성ex.똑같은 값: 질소유무)들을 상수로 선언
public interface Cookie {
//	public static final boolean 질소 = true; //상수(모든 곳에서 접근 가능, 수정 불가)
//	public abstract void 포장(); ////추상 메소드 선언
	
	//인터페이스는 상수, 추상 메소드만 존재하기 때문에, 그냥 선언해도 상수, 추상 메소드가 된다.
	boolean 질소 = true;
	void 포장();
	
}
