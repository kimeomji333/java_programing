package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HMapTest2 {
	public static void main(String[] args) {
		HashMap<String, String> dict = new HashMap<>();
		dict.put("fly", "날다");
		dict.put("walk", "걷다");
		dict.put("run", "뛰다");
		
//		System.out.println(dict.get("fly"));
//		System.out.println(dict.get("walk"));
//		System.out.println(dict.get("run"));
		
		String[] keys = {"fly", "walk", "run"};
		
		//반복문으로 
						//HashMap의 쌍의 개수
		for (int i = 0; i < dict.size(); i++) {
			System.out.println(dict.get(keys[i]));
		}
		//->key들의 배열을 다 알고 있는 경우 반복문을 사용할 수 있어. key들이 모르는 경우는  ↓

		
		//keySet()	:key들만 모여있는 Set을 리턴
		Set<String> keyset = dict.keySet(); //key들이 Set타입에 들어있음. Set안에는 String 타입
		Iterator<String> keyiter = keyset.iterator();
		while(keyiter.hasNext()) {
			String key = keyiter.next();
			System.out.println(key);
		}
		
		//values()	:value들만 모여있는 Collection을 리턴
		Collection<String> values = dict.values();
		Iterator<String> valueiter = values.iterator();
		while(valueiter.hasNext()) {
			String value = valueiter.next();
			System.out.println(value);
		}
		
		//entrySet()	:Entry들이 모여있는 Set을 리턴
		Set<Entry<String,String>> entrySet = dict.entrySet();
		Iterator<Entry<String, String>> entryiter = entrySet.iterator();
		while(entryiter.hasNext()) {
			Entry<String,String> entry = entryiter.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("-----------");
			
		}
		
		
		
		
		
	}
}
