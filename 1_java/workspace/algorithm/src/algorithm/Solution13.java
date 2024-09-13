package algorithm;

import java.util.Arrays;

public class Solution13 {
	public static void main(String[] args) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		int[] dice = {4,1,4,4};
		
		Arrays.sort(dice);
		
		if(dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[3]){
            answer = 1111 * dice[0];
        } else if (dice[0] == dice[1] && dice[1] == dice[2] && dice[2] != dice[3]){
            answer = (10 * dice[0] + dice[3]) * (10 * dice[0] + dice[3]);
        } else if (dice[0] == dice[1] && dice[1] != dice[2] && dice[2] == dice[3]){
            answer = (dice[0] + dice[3]) * Math.abs(dice[0] - dice[3]);
        } else if (dice[0] == dice[1] && dice[1] != dice[2] && dice[2] != dice[3]){
            answer = dice[2] * dice[3];
        } else{
            for(int i : dice){
                min = Math.min(min, i);
            }
            answer = min;
        }
		
		System.out.println(answer);
	}
}
