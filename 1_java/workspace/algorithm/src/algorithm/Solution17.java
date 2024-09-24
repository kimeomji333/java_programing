package algorithm;

import java.util.ArrayList;

public class Solution17 {
	public static void main(String[] args) {
		// 접미사인지 확인하기 
		// 문자열을 하나씩 잘라서 배열에 넣고, 
		ArrayList<String> list = new ArrayList<>();
		String my_string = "banana";
		String is_suffix = "ana";
		String is_prefix = "";
		String str = "";
		
		for(int i = 0; i < my_string.length(); i++) {
			str = my_string.substring(i);
			list.add(str);
		}
		System.out.println(list);
		
		// list를 순회하면서 is_suffix와 문자열이 같은지 확인하기
		// 접미사라면 1, 아니면 0을 리턴
		for(int j = 0; j < list.size(); j++) {
			if(list.contains(is_suffix)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
