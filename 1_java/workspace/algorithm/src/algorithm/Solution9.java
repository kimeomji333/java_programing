package algorithm;
//코드 처리하기
public class Solution9 {
	public static void main(String[] args) {
	//문자열 code를 읽어서 1이면 mode를 바꾼다. 
	//mode == 0 일 때,
	//code[idx] != 1 -> idx가 짝수일 때, ret 맨뒤에 code[idx]를 추가
	//code[idx] == 1 -> mode를 1로 바꿈.
		
	//mode == 1 일 때, 
	//code[idx] != 1 -> idx가 홀수일 때, ret 맨뒤에 code[idx]를 추가
	//code[idx] == 1 -> mode를 0로 바꿈.
		
	//ret가 만약 빈 문자열이라면 대신 "EMPTY"를 return
	
	String code = "abc1abc1abc";
	String answer = "";
	int mode = 0;
	
	//문자열을 문자로 쪼개서 1이 들어가 있는지 확인한다. 
	//1이 들어가 있으면 mode를 바꿔준다.
	//1이 있는지 확인하기 전까지 홀짝 구분해서 ret 에 문자를 포함시킨다.
	for(int i = 0; i < code.length(); i++) {
		char ch = code.charAt(i);
//		if()
	}
	}
}
