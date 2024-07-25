package algorithm;
//조건 문자열
public class Solution4 {
	public static void main(String[] args) {
		String ineq = "<";
		String eq = "=";
		int n = 41;
		int m = 78;
		int answer = 0;
		
		if(ineq.equals(">") && eq.equals("=")){
			answer = (n >= m) ? 1 : 0;
		} else if (ineq.equals("<") && eq.equals("=")){
			answer = (n <= m) ? 1 : 0;
		} else if (ineq.equals(">") && eq.equals("!")){
			answer = (n > m) ? 1 : 0;
		} else if (ineq.equals("<") && eq.equals("!")){
			answer = (n < m) ? 1 : 0;
		} 
		System.out.println(answer);
	}
}
