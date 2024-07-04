package day03;


//2continue
public class Continue {
	public static void main(String[] args) {
		//4만 제외하고 출력이 된다.
		for(int i = 1; i <= 10; i++) {
			if(i == 4) {
				continue; 
			}
			System.out.println(i);
		}
		
		
		
		//if - else문과 동일하다.
		for(int i = 1; i <= 10; i++) {
			if(i == 4) {
				
			} else {
				System.out.println(i);
			}
		}
		
		
		
		
	}
}
