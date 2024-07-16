package algorithm;

public class Solution1 {
	public static void main(String[] args) {
		
//		String my_string = "Program29b8UYP";
//		String overwrite_string = "merS123";
//		int s = 7;
		
		String my_string = "He11oWor1d";
		String overwrite_string = "lloWorl";
		int s = 2;
		
		String answer = "";
		String temp = "";
		int leng = s + overwrite_string.length();
		System.out.println(leng);
		
		//my_string라는 문자열의 인덱스 s 부터 overwrite_string 길이만큼
		//overwrite_string로 바꾼다. <- 바꾼다.(기존의 것, 새로운 것)
		temp = my_string.substring(s, leng);
		System.out.println(temp);
		answer = my_string.replace(temp, overwrite_string);
		System.out.println(answer);
		
	}
}