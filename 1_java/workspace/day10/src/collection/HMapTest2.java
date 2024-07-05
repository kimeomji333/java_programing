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
		
		String[] keys = {"fly","walk","run"};
		
//						HashMap의 쌍의 개수
		for (int i = 0; i < dict.size(); i++) {
			System.out.println(dict.get(keys[i]));
		}
		
		System.out.println("======================================");
		
		Set<String> keyset = dict.keySet();
		Iterator<String> keyiter = keyset.iterator();
		while(keyiter.hasNext()) {
			String key = keyiter.next();
			System.out.println(key);
		}
		
		System.out.println("======================================");
		
		Collection<String> values = dict.values();
		Iterator<String> valueiter = values.iterator();
		while(valueiter.hasNext()) {
			String value = valueiter.next();
			System.out.println(value);
		}
		
		System.out.println("======================================");
		
		Set<     Entry<    String, String   >      > entryset = dict.entrySet();
		Iterator<Entry<String,String>> entryiter = entryset.iterator();
		
		while(entryiter.hasNext()) {
			Entry<String,String> entry = entryiter.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("========");
		}
		
	}
}














