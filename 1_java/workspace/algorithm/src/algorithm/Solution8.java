package algorithm;

public class Solution8 {
	public static void main(String[] args) {
		String control = "wsdawsdassw";
		int n = 0;
		
		//먼저 문자열을 돌면서 알파벳 파악. 조건문을 이용해서 식계산
        for(int i = 0; i < control.length(); i++) {
            char ch = control.charAt(i);
            if(ch == 'w') {
                n += 1;
            } else if(ch == 's') {
                n -= 1;
            } else if(ch == 'd') {
                n += 10;
            } else if(ch == 'a') {
                n -= 10;
            }
        }
        System.out.println(n);
	}
}
