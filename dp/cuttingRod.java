package dp;

import java.util.Scanner;

public class cuttingRod {

	// Compare with knapsack01
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] l = new int[n];
		int[] p = new int[n];
		
		for(int i=0; i<n ;i++){
			l[i] = s.nextInt();
		}
		
		for(int i=0; i<n ;i++){
			p[i] = s.nextInt();
		}
		
		int length = s.nextInt();
		
		System.out.println(cr(l, p, 0, length));
		System.out.println(cr(l, p, 0, length, new int[p.length + 1][length + 1]));

	}
	
	public static int cr(int[] l, int[] p, int idx, int length){
		if(idx == p.length || length == 0){
			return 0;
		}
		
		if(l[idx] > length){
			return cr(l, p, idx+1, length);
		}
		return Math.max(cr(l, p, idx + 1, length), p[idx] + cr(l, p, idx, length - l[idx]));
	}

	public static int cr(int[] l, int[] p, int idx, int length, int[][] storage){
		if(storage[idx][length] != 0){
			return storage[idx][length];
		}
		
		int retval = 0;
		
		if(idx == p.length || length == 0){
			retval = 0;
		}
		else if(l[idx] > length){
			retval = cr(l, p, idx+1, length, storage);
		}
		else{
			retval = Math.max(cr(l, p, idx + 1, length, storage), p[idx] + cr(l, p, idx, length - l[idx], storage));
		}
		
		storage[idx][length] = retval;
		return retval;
	}
}
