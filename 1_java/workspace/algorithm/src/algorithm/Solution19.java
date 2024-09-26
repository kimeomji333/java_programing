package algorithm;

public class Solution19 {
	public static void main(String[] args) {
		// 중간 저장소 temp 필요
        // s -> temp에 저장
        // e -> s에 저장
        // temp -> e에 저장
        
        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;
        int temp = 0;
        //문자열을 문자배열에 담아둬서 인덱스로 방의 내용물을 바꿔야 할까?
        //toCharArray()
        //반복문을 돌면서 범위 내에서 줄어들며 바껴야 함
        //s++; e--;
        char[] ch = my_string.toCharArray();
        for(int i = s; i <= e; i++) {
        	temp = s;
        	s = e;
        	e = temp;
        	//어떻게 다시 문자열로 만들 수 있을까
        	s++;
        	e--;
        }
        //s=6 ~ e=12
        //temp=6
        //s=12
        //e=6
        //s=7, e=11
        System.out.println(ch[s]);
        System.out.println(temp);
        System.out.println(ch);
	}

}
