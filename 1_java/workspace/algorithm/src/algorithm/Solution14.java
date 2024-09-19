package algorithm;

import java.util.ArrayList;

public class Solution14 {
	public static void main(String[] args) {
		String[] intStrs = {"0123456789","9876543210","9999999999999"};
		int k = 50000;
		int s = 5;
		int l = 5;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		//반복문을 돌면서 
		//배열에서 원하는 길이만큼 substring, 문자열을 정수로 형변환
		//조건식으로 변환값이 k보다 크면 배열에 add
		
		for(int i = 0; i < intStrs.length; i++) {
			int str = Integer.parseInt(intStrs[i].substring(s, s+l));
			if(str > k) {
				list.add(str);
			}
		}
		System.out.println(list);
		
	}
}
