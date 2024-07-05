package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HSetTest2 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		System.out.println(set);
		
		//iterator: 요소들을 가지고 반복 가능한 형태로 나타낸다.
		Iterator<Integer> iter = set.iterator();
		
		//hasNext boolean값이기에 반복문을 이용해줌
		while(iter.hasNext()) {
			System.out.println(iter.next()); //다음분 ~
		}
		
		//iterator는 한 번 조회한 요소를 다시 꺼내올 수 없다. (NoSuchElementException)
//		System.out.println(iter.next()); 
		
		//다시 꺼낼 수 없기 때문에 iterator를 "재객체화" 해서 순서를 부여하고 처음부터 다시 순회를 해야 한다. 
		iter = set.iterator();
		System.out.println(iter.next());
		
		
	}
}
