package exception;

public class IDFormatTest {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) throws IDFormatException {
		if (userId == null) {
			throw new IDFormatException("아이디는 null일 수 없습니다."); // 강제로 예외 발생 시킴
		} else if (userId.length() < 8 || userId.length() < 20) {
			throw new IDFormatException("아이디는 8자 이상 10자 이하로 쓰세요.");
		}
		this.userId = userId;
	}

	public static void main(String[] args) {
		IDFormatTest test = new IDFormatTest();

		// id값이 null 인경우
		String userId = null;
		try {
			test.setUserId(userId);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}

		// id값이 8자 이하인 경우
		userId = "12345";
		try {
			test.setUserId(userId);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
