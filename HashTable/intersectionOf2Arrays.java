package HashTable;

import java.util.*;

public class intersectionOf2Arrays {

	public static void main(String[] args) {
		int[] a={0, 18, 111, 24, 3, 5, 7, 2, 4, 9, 21, 1, 14, 71, 2, 3, 4, 2, 3, 3, 3, 3, 3, 3};
		int[] b={11, 7, 4, 8, 13, 21, 9, 1, 2, 2, 3, 4, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		intersection(a, b);
		System.out.println();
		intersection2(a, b);
	}
	
	//O(NLOGN)(UNSORTED)
	//O(N+M)(SORTED)
	public static void intersection(int[] a, int[] b){
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0,j=0;
		while(i<a.length && j<b.length){
			if(a[i]<b[j]){
				i++;
			}
			else if(a[i]>b[j]){
				j++;
			}
			else{
				System.out.print(a[i] + " ");
				i++;
				j++;
			}
		}
	}
	
	//O(N)(SORTED OR UNSORTED)(THINK OF THE DUPLICATES)
	public static void intersection2(int[] a, int[] b){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<a.length; i++){
			if(map.containsKey(a[i])){
				map.put(a[i], map.get(a[i]) + 1);
			}
			else{
				map.put(a[i], 1);
			}
		}
		for(int i=0; i<b.length; i++){
			if(map.containsKey(b[i])){
				System.out.print(b[i] + " ");
				if(map.get(b[i]) == 1){
					map.remove(b[i]);
				}
				else{
					map.put(b[i], map.get(b[i]) - 1);
				}
			}
		}
	}

}
