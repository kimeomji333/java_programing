package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----- welcom to java final project -----");
		
		while(true) {
			System.out.print("1. join\n2. login\n3. exit");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				new JoinView();
			} else if(choice == 2) {
				new LoginView();
			} else if(choice == 3) {
				System.out.println("Bye! See you later!");
				break;
			} else {
				System.out.println("you're wrong! try again!");
			}
		}
	}
}
