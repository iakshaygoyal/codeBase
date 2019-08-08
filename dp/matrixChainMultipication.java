package dp;

import java.util.Scanner;

public class matrixChainMultipication {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0; i<t; i++){
			int n = s.nextInt();
			int[] arr = new int[n];
			
			for(int j=0; j<n; j++){
				arr[j] = s.nextInt();
			}
			
			System.out.println(mcm(arr, 0, arr.length-1));
			System.out.println(mcm2(arr, 0, arr.length-1, new int[arr.length][arr.length]));
		}

	}
	
	public static int mcm(int[] arr, int si, int ei){
		if(si+1 == ei){
			return 0;
		}
		
		int retval = Integer.MAX_VALUE;
		
		for(int i=si+1; i<ei; i++){
			int factor1 = mcm(arr, si, i);
			int factor2 = mcm(arr, i, ei);
			int factor3 = arr[si] * arr[i] * arr[ei];
			
			int cost = factor1 + factor2 + factor3;
			
			if(cost < retval){
				retval = cost;
			}
		}
		
		return retval;
	}
	
	public static int mcm2(int[] arr, int si, int ei, int[][] storage){
		if(storage[si][ei] != 0){
			return storage[si][ei];
		}
		
		int retval = Integer.MAX_VALUE;
		
		for(int i=si+1; i<ei; i++){
			int factor1 = mcm2(arr, si, i, storage);
			int factor2 = mcm2(arr, i, ei, storage);
			int factor3 = arr[si] * arr[i] * arr[ei];
			
			int cost = factor1 + factor2 + factor3;
			
			if(cost < retval){
				retval = cost;
			}
		}
		
		storage[si][ei] = retval;
		return retval;
	}

}
