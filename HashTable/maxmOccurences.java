package HashTable;

import java.util.*;
import java.util.Map.Entry;

public class maxmOccurences {

	public static void main(String[] args) {
		
		
		//FOR ARRAY OF STRINGS(O(N))
		
		
		String[] arr = {"my", "name", "is", "name", "akshay", "is", "my", "akshay", "my", "akshay", "my"};
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
		System.out.println("STRING : "+maxs);
		System.out.println("OCCURENCES : "+maxo);
		System.out.println();
		
		
		//FOR ARRAY OF INTEGERS(O(NLOGN))
		
		
		
		int[] arr1 = new int[]{2,4,3,6,9,2,9,9,2,5,2,9,6,3,8,9,9,4,2,6,6,6,9,9};
		Arrays.sort(arr1);
		int maxme=-1;
		int maxmo=0;
		int curre=arr1[0];
		int curro=1;
		for(int i=1; i<arr1.length; i++){
			if(arr1[i] == curre){
				curro++;
			}
			else{
				if(curro>maxmo){
					maxme=curre;
					maxmo=curro;
				}
				curre=arr1[i];
				curro=1;
			}
		}
		if(curro>maxmo){
			maxme=curre;
			maxmo=curro;
		}
		System.out.println("ELEMENT : "+maxme);
		System.out.println("OCCURENCES : "+maxmo);
	}
}
