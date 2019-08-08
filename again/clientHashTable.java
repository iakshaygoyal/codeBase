package again;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import HashTable.Map;

public class clientHashTable {

	public static void main(String[] args) {
//		String[] paragraph = {"this","is","coding","world","this","is","awesome","i","love","this","this","is","coding"};
//		Map<String, Integer> map = new hashTable<String, Integer>();
//			
//			for(int i=0; i<paragraph.length; i++){
//				if(map.get(paragraph[i]) == null){
//					map.put(paragraph[i], 1);
//				}
//				else{
//					map.put(paragraph[i], map.get(paragraph[i])+1);
//				}
//				map.display();
//			}
//			map.display();
//		}

	java.util.Map<String, Integer> map = new HashMap<String, Integer>();
	
	map.put("US", 250);
	map.put("India", 2000);
	map.put("US", 300);
	map.put("China", 3000);
	map.put("Russia", 500);
	map.put("Turkey", 100);
	
	Set<String> allKeys = map.keySet();
	for(String key: allKeys){
		System.out.println(key);
	}
	
	System.out.println();
	
	Collection<Integer> allValues = map.values();
	for(Integer value : allValues){
		System.out.println(value);
	}
	
	System.out.println();
	
	Set<Entry<String,Integer>> allEnteries = map.entrySet();
	for(Entry<String,Integer> entry : allEnteries){
		System.out.println(entry);
	}
}
}
