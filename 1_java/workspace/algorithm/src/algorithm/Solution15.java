package algorithm;

import java.util.ArrayList;

public class Solution15 {
	public static void main(String[] args) {
		String[] my_strings = { "progressive", "hamburger", "hammer", "ahocorasick" };
		int[][] parts = { {0, 4}, {1, 2}, {3, 5}, {7, 7} };
		String answer = "";
		
		//배열 두개
		//일차원 배열을 순회하면서
		//이차원 배열의 숫자만큼 substring해서
		//이어붙인다.
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < my_strings.length; i++) {
			String str = my_strings[i];
			answer += my_strings[i].substring(parts[i][0], parts[i][1]+1);
		}
		
		System.out.println(answer);
	}
}
