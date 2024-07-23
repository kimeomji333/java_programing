package algorithm;

public class Solution6 {
	public static void main(String[] args) {
		int[] num_list = {5,7,8,3};
		int answer = 0;
		int multi = 1;
		int sum = 0;
		
		for(int i : num_list) {
            multi *= i;
            sum += i;
        }
		int t = sum*sum;
		
        if(multi < t) {
            answer = 1;
        } else if(multi > t) {
            answer = 0;
        }
        
        System.out.println(num_list[0]);
        System.out.println(num_list[1]);
        System.out.println(num_list[2]);
        System.out.println(num_list[3]);
        System.out.println(multi);
        System.out.println(sum);
        System.out.println(t);
        System.out.println(answer);
	}
}
