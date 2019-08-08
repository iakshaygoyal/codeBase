package assignmentHeapsandHashmap;

import java.util.*;
import java.util.Map.Entry;

public class p4 {

	public static void main(String[] args) {
		int[] arr = new int[]{2,4,3,6,9,2,9,9,2,5,2,9,6,3,8,4,2,6,6,6};
		maxmOccurences(arr);
	}
	
	public static void maxmOccurences(int[] a){
		Map<Integer,Integer> map=new HashMap<>();
		for(int i:a){
			if(map.containsKey(i)){
				map.put(i, map.get(i) + 1);
			}
			else{
				map.put(i, 1);
			}
		}
		Set<Entry<Integer,Integer>> set=map.entrySet();
		int mo=-1;
		int me=-1;
		for(Entry e:set){
			if((int)e.getValue() > mo){
				me=(int)e.getKey();
				mo=(int)e.getValue();
			}
		}
		System.out.println("Element : "+me);
		System.out.println("Occurences : "+mo);
	}

}
