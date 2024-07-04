package study;

import java.util.Scanner;

public class Gugudan {
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("정수를 입력하세요: ");
      int n = sc.nextInt();
      
      if(n>0 && n<=9) {
         for (int i = n; i <= n; i++) {
            System.out.println("-----"+n+"단-----");
            for (int j = 1; j <= 9; j++) {
               if(j%n != 0)
               System.out.printf("%d × %d = %d\n",i,j,i*j);         
            }
         }
         
      }
      else { System.out.println("잘못 입력하셨습니다.");
      }
   }
}
