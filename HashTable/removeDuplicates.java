package HashTable;

import java.util.*;

public class removeDuplicates {

	public static void main(String[] args) {
		int[] a={3,6,2,4,3,7,3,5,8,3,6,9,2,4,1,6,7,12,14,1};
		int[] b=remove(a);
		for(int i=0; i<b.length; i++){
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		int[] c=remove2(a);
		for(int i=0; i<c.length; i++){
			System.out.print(c[i] + " ");
		}
		System.out.println();
	}
	
	//O(NLOGN)
	public static int[] remove(int[] a){
		Arrays.sort(a);
		ArrayList<Integer> list = new ArrayList<>();
		int i;
		for(i=0; i<a.length-1; i++){
			if(a[i] != a[i+1]){
				list.add(a[i]);
			}
		}
		list.add(a[i]);
		int[] b = new int[list.size()];
		for(int j=0; j<list.size(); j++){
			b[j]=list.get(j);
		}
		return b;
	}
	
	
	//O(N)
	public static int[] remove2(int[] a){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<a.length; i++){
			map.put(a[i], a[i]);
		}
		int[] b = new int[map.size()];
		Set<Integer> keys = map.keySet();
		int j=0;
		for(Integer value : keys){
			b[j++]=value;
		}
		return b;
	}

}
