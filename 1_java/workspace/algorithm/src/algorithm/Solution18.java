package algorithm;

import java.util.ArrayList;

public class Solution18 {
	public static void main(String[] args) {
		String my_string = "banana";
		String is_prifix = "ban";
		String str = "";
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < my_string.length(); i++) {
			str = my_string.substring(0, i+1);
			list.add(str);
		}
		
		System.out.println(list);
		for(int j = 0; j < list.size(); j++) {
			if(list.contains(is_prifix)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
