package algorithm;

public class Solution7 {
	public static void main(String[] args) {
		int[] num_list = {2, 1, 6};
		int newNum = 0;
		
		//새배열 만들어서 반복문으로 값 넣어주기
		int[] answer = new int[num_list.length + 1];

		for(int i = 0; i < num_list.length; i++) {
			answer[i] = num_list[i];
			
			int lastNum = num_list[num_list.length-1];
			int sNum = num_list[num_list.length-2];
			
			if(lastNum > sNum) {
				newNum = lastNum - sNum;
			} else {
				newNum = lastNum*2;
			}
			
			answer[i+1] = newNum;
		}

		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
		System.out.println(answer[3]);

	}

}
