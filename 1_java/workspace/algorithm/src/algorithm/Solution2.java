package algorithm;

public class Solution2 {
	public static void main(String[] args) {
		
		String str1 = "aaaaa";
		String str2 = "bbbbb";
		String answer = "";
		
		for(int i = 0; i < str1.length(); i++) {
//            answer += str1.charAt(i) + str2.charAt(i); 문자열 연산시에 아스키값으로 더해져서 숫자로 출력된다.
			
			//문자열 -> 문자 뽑아내기
			//문자 -> 문자열 붙이기
//			answer += Character.toString(str1.charAt(i)) + Character.toString(str2.charAt(i));
			
			//""이용헤서 문자열로 만드는 방법
			answer += "" + str1.charAt(i) + str2.charAt(i);
        }
		System.out.println(answer);
	}
}
