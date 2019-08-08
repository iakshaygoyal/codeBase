package HashTable;

import java.util.*;
import java.util.Map.Entry;

public class amazonQ {

	public static void main(String[] args) {
		System.out.println();
		String[] arr = {"my", "name", "is", "name", "nkshay", "is", "my", "nkshay", "my", "nkshay", "my", "nkshay", "are", "is"};
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			else{
				map.put(arr[i], 1);
			}
		}
		Set<Entry<String, Integer>> set = map.entrySet();
		String maxs="";
		int maxo=-1;
		for(Entry e : set){
			if((int)e.getValue() > maxo){
				maxs=(String)e.getKey();
				maxo=(int)e.getValue();
			}
		}
		
		for(Entry e : set){
			if((int)e.getValue() == maxo){
				if(((String)e.getKey()).compareTo(maxs) > 0){
					maxs=(String)e.getKey();
				}
			}
		}
		
		System.out.println("STRING : "+maxs);
		System.out.println("OCCURENCES : "+maxo);

	}

}
