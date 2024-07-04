package teamProject;

import java.util.Random;

//난수까지의 합계 완료
public class RandomNum2 {
	public RandomNum2() {
	//1~100 랜덤 정수 하나, 1부터 정수까지 합계 출력
		int randomNum = new Random().nextInt(100);
		int sum = 0;
		
		for (int i = 0; i <= randomNum; i++) {
			sum += i;
		}
		System.out.println("1부터 " + randomNum + "까지의 합: " + sum);
	}
	
	
	
}
