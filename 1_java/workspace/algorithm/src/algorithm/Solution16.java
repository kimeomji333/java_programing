package algorithm;

import java.util.Arrays;

public class Solution16 {
	public static void main(String[] args) {
		String my_string = "banana";
		String[] answer = new String[my_string.length()];
		String str = "";
		
		for(int i = 0; i < my_string.length(); i++) {
			answer[i] = my_string.substring(i);
		}
		Arrays.sort(answer);
		
	}
}
