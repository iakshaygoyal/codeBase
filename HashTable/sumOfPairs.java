package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class sumOfPairs {

	public static void main(String[] args) {
		int[] a={3,6,2,4,3,7,3,5,8,3,6,9,2,4,1,6,7,12,14,1,9,5};
		Scanner s = new Scanner(System.in);
		int sum = s.nextInt();
		fun(a,sum);
		System.out.println();
		fun2(a,sum);
	}

	//O(NLOGN) (NO UNIQUE PAIRS)
	public static void fun(int[] a, int sum){
		Arrays.sort(a);
		int i=0, j=a.length-1;
		while(i<j){
			if(a[i]+a[j]<sum){
				i++;
			}
			else if(a[i]+a[j]>sum){
				j--;
			}
			else{
				System.out.println(a[i]+" "+a[j]);
				i++;
				j--;
			}
		}
	}
	
	//O(N) (GIVES UNIQUE PAIRS MEANS IF THERE ARE TWO 3S AND TWO 9S AND SUM IS 12 THEN IT WOULD PRINT ONLY ONE 3 AND 9)
	public static void fun2(int[] a, int sum){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<a.length; i++){
			map.put(a[i], a[i]);
		}
		HashMap<Integer,Integer> visited = new HashMap<>();
		Set<Integer> allkeys = map.keySet();
		for(Integer i : allkeys){
			if(!visited.containsKey(i)){
				int cp=sum-i;
				if(map.containsKey(cp)){
					System.out.println(i + " " + cp);
					visited.put(cp, cp);
				}
			}
		}
	}
}
