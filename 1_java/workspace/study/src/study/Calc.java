package study;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		
		System.out.println("첫번째 정수를 입력하세요");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요");
		int num2 = sc.nextInt();
		sc.nextLine(); 
		
		
		System.out.println("연산자를 입력하세요(+,-,x,/)");
		String oper = sc.nextLine();
		char op = oper.charAt(0);
		//char로 바로 입력 받는 구문이 없어서 String으로 받은 다음
		//char 배열로 다시 변환해주어야함
        

		
		if (op == '+'){
			result = num1+num2;
		}
			
		else if(op == '-'){
			result = num1-num2;
		}
		else if(op == 'x' || op == 'X'){
			result = num1*num2;
		}
		else if(op == '/'){
			if((num2==0)||(num1/num2 == 0)) {
				System.out.println("0으로 나눌 수 없습니다");
				result = 0;
			}
			else {
				result = num1/num2;
			}
		}
		else {
			System.out.println("연산자 입력이 제대로 되지 않았습니다");
		}
		System.out.printf("%d %s %d = %d",num1,op,num2, result);
	}

}
