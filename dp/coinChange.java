package dp;

import java.util.Scanner;

public class coinChange {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int m = s.nextInt();
		int[] arr = new int[m];
		
		for(int i=0; i<m ;i++){
			arr[i] = s.nextInt();
		}
		
//		System.out.println(cc(n, arr));
//		System.out.println(cc(n, arr.length, arr));
		System.out.println(coinChange(arr, n, 0, new int[n+1][arr.length]));
		System.out.println(coinChange(arr, n, 0));
//		System.out.println(cc(n, arr.length, arr, new int[n + 1][arr.length + 1]));

	}

	public static int coinChange(int[] arr, int n, int idx){
		if(n == 0){
			return 1;
		}
		else if(n < 0){
			return 0;
		}
		else if(idx == arr.length){
			return 0;
		}
		return coinChange(arr, n - arr[idx], idx) + coinChange(arr, n, idx + 1);
	}
	
	public static int coinChange(int[] arr, int n, int idx, int[][] storage){
		if(n < 0){
			return 0;
		}
		else if(idx == arr.length){
			return 0;
		}
		if(storage[n][idx] != 0){
			return storage[n][idx];
		}
		
		int retval;
		if(n == 0){
			retval = 1;
		}
		else{
			retval = coinChange(arr, n - arr[idx], idx) + coinChange(arr, n, idx + 1);
		}
		return retval;
	}
}
