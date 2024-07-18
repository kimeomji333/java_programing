package algorithm;

public class Solution5 {
	public static void main(String[] args) {
		int a = 4;
		int b = 4;
		int c = 4;

		int answer = 0;

		if (a != b) {
			answer = (b != c) ? a + b + c : (a + b + c) * (a * a + b * b + c * c);
		} else if (a == b) {
			answer = (b != c) ? (a + b + c) * (a * a + b * b + c * c)
					: (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
		}
		
		System.out.println(answer);
	}
}
