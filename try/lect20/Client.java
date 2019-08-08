package lect20;

import java.util.*;
import java.util.Map.Entry;

public class Client {

	public static void main(String[] args) {
		String[] strings = { "this", "is", "coding", "world", "this", "is", "amazing", "coding", "this" };

		Map<String, Integer> freqs = new HashTable<>(2);
		for (int i = 0; i < strings.length; i++) {
			if (freqs.get(strings[i]) == null) {
				freqs.put(strings[i], 1);
			} else {
				freqs.put(strings[i], freqs.get(strings[i]) + 1);
			}

			freqs.display();
		}

		java.util.Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("US", 250);
		map.put("India", 2000);
		map.put("US", 300);
		
		Integer usPopl = map.get("China");

		
		map.remove("US");
		
		Set<String> allKeys = map.keySet();
		for(String key: allKeys){
			
		}
		
		Collection<Integer> allValues = map.values();
		for(Integer value: allValues){
			
		}
		
	
		Set<Entry<String, Integer>> allEntries = map.entrySet();
		for(Entry<String, Integer> entry: allEntries){
			entry.getValue();
			entry.getKey();
		}
		
	}
}
