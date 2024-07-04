package day05;

//연습
public class MethodTask2 {
	public static void main(String[] args) {

		MethodTask2 mt = new MethodTask2();

		String str = "abcd";
		int n = 3;
		int m = 5;

		System.out.println(mt.sum1To10());
		System.out.println(mt.sum1ToN(n));
		System.out.println(mt.divide(n, m));
		System.out.println(mt.sumFromNtoM(n, m));

		System.out.println(mt.changeToUpperCase(str));
		System.out.println(mt.reverseStr(str));
		System.out.println(mt.reverseStr2(str));
//		System.out.println(mt.isDigit(str));
//		System.out.println(mt.changeEnglish(str));
//		System.out.println(mt.changeToKr(n));

	}

	// 1번. 1 ~ 10 출력하는 메소드
	void print1To10() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	// 2번. 1 ~ 10 합 구해주는 메소드
	int sum1To10() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}

	// 3번. 1 ~ n 합 구해주는 메소드
	int sum1ToN(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum += i;
		}
		return sum;
	}

	// 4번. 두 정수의 나눗셈 결과를 구해주는 메소드
	double divide(int n, int m) {
		return (double) (n / m);
	}

	// 5번. 어떤 문자열을 n번만큼 출력하는 메소드
	void printString(String str, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(str);
		}
	}

	// 6번. n부터 m까지의 합 구해주는 메소드(n이 m보다 작다고 가정)
	int sumFromNtoM(int n, int m) {
		int sum = 0;
		for (int i = n; i <= m; i++) {
			sum += i;
		}
		return sum;
	}

	// 문자열 로직: 한글자씩 뽑아서 연결
	// 7번. 문자열을 전부 대문자로 바꿔주는 메소드(hEllo~123 -> HELLO~123) - 아스키코드 이용
	String changeToUpperCase(String str) {
		String result = "";

		// (반복문을 이용해) 문자열을 문자로 변환 : charAt()메소드 이용
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// (조건문을 이용해) 소문자인 경우, 대문자로 바꿔주는 로직 작성 // 32차이 이용 : (char)(ch-32) // ch - 'a' +
			// 'A' 이런 식도 있구나.
			if (ch >= 'a' && ch <= 'z') {
				result += (char) (ch - 32);
			} else {
				result += ch;
			}
		}
		return result;
	}

	// 8번. 문자열을 거꾸로 바꿔주는 메소드(Hello -> olleH) - 처음 문자가 마지막 문자가 될 수 있도록
	String reverseStr(String str) {
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			result = str.charAt(i) + result;
		}
		return result;
	}
	
	String reverseStr2(String str) {
		String result = "";
			
		for (int i = str.length() - 1; i >= 0 ; i--) {
			result = result + str.charAt(i);
		}
		return result;
	}

	// 9번. 문자열이 숫자로 이루어져 있는지 검사하는 메소드(숫자가 아닌것이 포함되어 있다면 false)
	boolean isDigit(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	// 10번. 문자열의 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드(hEllo~123 -> HeLLO~123)
	String changeEnglish(String str) {
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch >= 'a' && ch <= 'z') {  // 소문자 -> 대문자
				result += (char)(ch - 32);
			} else if(ch >= 'A' && ch <= 'Z') { // 대문자 -> 소문자
				result += (char)(ch + 32);
			} else {
				result += ch;
			}
		}
		return result;
	}

	// 11번. 정수를 한글로 바꿔주는 메소드(1024 -> 일공이사)
	String changeToKr(int n) {
		// 배열말고, 문자열로 만들어서 charAt()를 이용해서 문자로 변환
		String result = "";
		String kr = "공일이삼사오육칠팔구";
		String data = n + ""; // 정수를 문자열로 만듦
		
		for (int i = 0; i < data.length(); i++) {
			result += kr.charAt(data.charAt(i));
		}
		return result;
	}


}
