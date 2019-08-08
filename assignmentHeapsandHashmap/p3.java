package assignmentHeapsandHashmap;

import java.util.*;
import java.util.Map.Entry;

public class p3 {

	public static void main(String[] args) {
		int[] a={2,12,9,16,10,5,3,20,25,11,1,8,6,8};
		consecutiveNumbers(a);
		System.out.println();
		int[] b={15,13,23,21,19,11,16};
		consecutiveNumbers(b);
		System.out.println();
		int[] c=consecutiveNumbers2(a);
		System.out.println(Arrays.toString(c));
		int[] d=consecutiveNumbers2(b);
		System.out.println(Arrays.toString(d));
	}
	
	//O(NLOGN)
	public static void consecutiveNumbers(int[] a){
		Arrays.sort(a);
		int mo=-1;
		int me=-1;
		int co=1;
		int ce=a[0];
		for(int i=0;i<a.length-1;i++){
			if(a[i]+1==a[i+1]){
				co++;
			}
			else{
				if(co>mo){
					me=ce;
					mo=co;
				}
				ce=a[i+1];
				co=1;
			}
		}
		for(int i=0;i<mo;i++){
			System.out.print(me+i+" ");
		}
	}
	
	//O(N)
	public static int[] consecutiveNumbers2(int[] a){
		Map<Integer,Integer> map = new HashMap<>();
		Map<Integer,Integer> visited = new HashMap<>();
		for(int i : a){
			if(!visited.containsKey(i)){
				visited.put(i, i);
				int lo,hi;
				lo=hi=i;
				if(map.containsKey(i-1)){
					lo=map.remove(i-1);
				}
				if(map.containsKey(i+1)){
					hi=map.remove(i+1);
				}
				map.put(lo, hi);
				map.put(hi, lo);
			}
		}
		Set<Entry<Integer,Integer>> set = map.entrySet();
		int lo=0,hi=0;
		for(Entry e : set){
			if((int)e.getValue()-(int)e.getKey() > hi-lo){
				hi=(int)e.getValue();
				lo=(int)e.getKey();
			}
		}
		int[] b = new int[hi-lo+1];
		for(int i=0;i<b.length;i++){
			b[i]=lo+i;
		}
		return b;
	}

}
