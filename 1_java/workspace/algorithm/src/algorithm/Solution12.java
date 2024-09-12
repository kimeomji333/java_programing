package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Solution12 {
	public static void main(String[] args) {
		int l = 5;
		int r = 555;
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i = l; i <= r; i++) {
			String number = Integer.toString(i);
			boolean valid = true;
			
			for(char c : number.toCharArray()) {
				if(c != '0' && c != '5') {
					valid = false;
					break;
				}
			}
			
			if(valid) {
				answer.add(i);
				Collections.sort(answer);
			}
		}
		
		if(answer.isEmpty()) {
			answer.add(-1);
		}
		System.out.println(answer);
	}
}

// 접근 방법
// 1. int형을 문자열로 바꾼다음
// 2. 문자열에서 문자만 꺼내 0과 5가 있는지 확인한다. -> 문자열을 char형 배열로 바꿔서 반환
// 3. 있다면 오름차순으로 정렬 / 없다면 -1을 리턴한다.
