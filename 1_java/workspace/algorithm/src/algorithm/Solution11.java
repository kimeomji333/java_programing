package algorithm;

public class Solution11 {
	public static void main(String[] args) {
		int start_num = 3;
		int end_num = 10;
		int[] answer = {};
		
		//ArrayList를 사용해야하는건가...?
		for(int i = start_num; i <= end_num; i++) {
			answer[i] = i;
		}
		System.out.println(answer);
	}
}
