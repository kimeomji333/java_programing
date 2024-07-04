package day03;


//6 2차배열
public class ArrTest {
	public static void main(String[] args) {
		//선언방법1
		int[][] arrData1 = {
				{10,20,30}, //0행 안에 인덱스
				{40,50,60}  //1행
		};
		
		//선언방법2
		int[][] arrData2 = new int[3][5];
		
		arrData2[1][3] = 20;
		System.out.println(arrData2[1][3]);
		
		//행의 개수만 지정한 채 선언
		int[][] arrData3 = new int[3][];
		//null: 주소값의 초기값, 비어있다, 연결되지 않았다 라는 뜻
		//행의 개수만 지정한 채 배열을 선언하면 한 번 접근해서 찾아갔을 때 
		//연결되어 있는 공간들(소배열들)이 존재하지 않기 때문에 주소값의 초기값인 null값을 담고있다.
		//2차원 배열을 제대로 사용하려면 -> 소배열들을 만들어서 연결해주는 작업부터 하고 사용해야 한다.
		for(int i =0; i < arrData3.length; i++) {
			System.out.println(arrData3[i]);
		}
		arrData3[0] = new int[5];
		arrData3[1] = new int[2];
		arrData3[2] = new int[4];
		
		System.out.println("행의 개수: " + arrData3.length); 	//2차원배열명.length : 행의 개수
		System.out.println("0행의 열수: " + arrData3[0].length); //2차원배열명[행번호].length : 0행의 열의 개수
		System.out.println("1행의 열수: " + arrData3[1].length); 
		System.out.println("2행의 열수: " + arrData3[2].length); 
		
	}
}
