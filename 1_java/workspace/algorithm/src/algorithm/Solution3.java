package algorithm;

public class Solution3 {
	public static void main(String[] args) {
		int n = 10; //2,4,6,8,10
		int answer = 0;
		
		//조건문으로 짝수/홀수
		//짝수는 제곱의 합/ 홀수는 정수누적합
		//2로 나눈 나머지가 0이 아니라면 홀수
//		if(n%2 == 0) {
//			for(int i = 1; i <= n;	i++) {
//				if(i%2==0) {
//					answer += i*i;					
//				}
//			}
//		} else {
//			for(int i = 1; i <= n; i++) {
//				if(i%2!=0) {
//					answer += i;
//				}
//			}
//		}
		
		//다른사람 문제풀이
		if(n%2==0) {
			for(int i = 2; i <= n; i +=2) {
				answer += i*i;
			}
		} else {
			for(int i = 1; i <= n; i +=2) {
				answer += i;
			}
		}
		
        System.out.println(answer);
	}
}
