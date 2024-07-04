package day04;

//4 String 문자열 메소드
// split  indexOf  charAt  replace  substring  trim  length 메소드
public class StrTest {
	public static void main(String[] args) {
		String msg = "Hello World!";
		
		// 문자열1.split("문자열2"): 문자열1을 문자열2 기준으로 나누기
		// 나뉘어진 값들이 담겨있는 String[] 반환
		String[] arr1 = msg.split(" "); // 띄어쓰기를 기준으로 나누다. {"Hello", "World!"}
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		
		// split()은 나누지 못했다면 전체 문자열 한 개가 담겨있는 한 칸짜리 String[] 반환
		String[] arr2 = msg.split("u");
		System.out.println(arr2[0]); // {"Hello World!"}
		
		
		
		
		// "문자열1".indextOf("문자열2") : 문자열1 에서 문자열2 가 시작하는 인덱스 반환
		int idx = msg.indexOf("W"); 
		System.out.println("W의 인덱스: " + idx);  //6
		
		idx = msg.indexOf("World!");
		System.out.println("World!의 인덱스: " + idx); // 6
		
		idx = msg.indexOf("*");
		System.out.println("*의 인덱스: " + idx); // -1
		

		
		
		// 문자열.charAt(n) : 문자열에서 n 번째 인덱스 위치의 문자를 반환
		char ch = msg.charAt(6);
		System.out.println("6번째 글자: " + ch);  // W
		
		// 범위를 벗어나는 경우 오류 발생
//		char ch = msg.charAt(100000);
//		System.out.println("100000번째 글자: " + ch);
		
		
		
		
		
		
		// 문자열1.replace("문자열2", "문자열3") : 문자열1 에서 문자열2를 찾아 문자열3으로 변환
		String newMsg = msg.replace("Hello", "Bye");
		System.out.println("원본: " + msg);
		System.out.println("적용된 값: " + newMsg);
		
		
		
		
		
		
		// 문자열.substring(n) : 문자열을 n 부터 끝까지 잘라서 돌려주기
		String subMsg1 = msg.substring(6);
		System.out.println("6번째부터 끝까지: " + subMsg1);
		
		// 문자열.substring(n,m) : 문자열을 n부터 m 이전까지 잘라서 돌려주기
		String subMsg2 = msg.substring(6, 8);
		System.out.println("6번째부터 8 이전까지: " + subMsg2);
		
		
		
		
		
		// 문자열.trim() : 문자열 양 옆에 있는 공백들을 제거해서 돌려주기
		System.out.println("           j a v a          ".trim());
		
		
		
		
		
		// 문자열.length() : 문자열의 길이를 반환
		int len = msg.length();
		System.out.println("msg의 길이: " + len);  // 12
		
		
		
		
		
		
		// 실제 원본을 바꾸는 방법
		msg = msg.substring(6);
		System.out.println(msg);
		
		
		
		// 연습 ~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~~~~~~~~~~~~
		String str1 = new String("신민철");
		String str2 = "신민철";
		String str3 = "신민철";
		
		System.out.println(str1 == str2); //false
		System.out.println(str2 == str3); //true
		
		System.out.println(str1.equals(str2)); //true
		System.out.println(str2.equals(str3)); //true
		
		
		
	}
}
