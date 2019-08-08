package HashTable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import again.hashTable;

import java.util.Set;

public class client {

	public static void main(String[] args) {
	
		
		String[] paragraph = {"this","is","the","best","this","is","great","this"};
		
		Map<String, Integer> freq = new HashTable<String, Integer>(2);
		freq.display();
		for(int i=0; i<paragraph.length; i++){
			if(freq.get(paragraph[i]) == null){
				freq.put(paragraph[i], 1);
			}
			else{
				freq.put(paragraph[i], freq.get(paragraph[i])+1);
			}
			freq.display();
		}
		System.out.println();
		
	java.util.Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("US", 250);
		map.put("India", 2000);
		map.put("US", 300);
		map.put("China", 3000);
		map.put("Russia", 500);
		map.put("Turkey", 100);
		System.out.println(map.toString());
		
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
