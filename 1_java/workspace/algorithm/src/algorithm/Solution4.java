package algorithm;

public class Solution4 {
	public static void main(String[] args) {
		String ineq = "<";
		String eq = "=";
		int n = 41;
		int m = 78;
		int answer = 0;
		
		//연산자 기호는 합쳐야 하는가? -> 경우의 수를 생각하기? 4개 -> 조건문?
		//연산자와 정수형은 어떻게 계산 할 것인가 -> 조건문?
		//n과 m을 비교해보았을 때, 누가 더 큰지 알아야 하나?
		
		if(n <= m || n < m) {
			answer = 1;
		} else if(n >= m || n > m) {
			answer = 0;
		}
		
		System.out.println(answer);
	}
}
