package study;

import java.util.Random;

//난수까지의 합계
public class RandomNum {
	public static void main(String[] args) {
		int ranNum = new Random().nextInt(100); // 난수 생성
		int sum = 0;

		for (int i = 1; i <= ranNum; i++) { // 1부터 ranNum까지 누적합
			sum += i;

		}
		System.out.println("1부터 " + ranNum + "까지의 합 : " + sum);

	}
}
