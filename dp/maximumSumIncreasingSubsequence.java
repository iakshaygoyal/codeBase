package dp;

import java.util.Scanner;

public class maximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n ;i++){
			arr[i] = s.nextInt();
		}
		
//		System.out.println(msis(arr));
		System.out.println(msis2(arr, new int[arr.length + 1]));
	}
	
	static int maxsum = Integer.MIN_VALUE;
	
//	public static int msis(int[] arr){
//		msis(arr, arr.length-1);
//		return maxsum;
//	}
//	
//	public static int msis(int[] arr, int n){
//		
//		int maxval = arr[n];
//		
//		for(int i=0; i<n; i++){
//			int current = msis(arr, i);
//			
//			if(arr[i] < arr[n] && current + arr[n] > maxval){
//				maxval = current + arr[n];
//			}
//		}
//		
//		if(maxval > maxsum){
//			maxsum = maxval;
//		}
//		
//		return maxval;
//	}
	
	public static int msis2(int[] arr, int[] storage){
		msis2(arr, arr.length-1, storage);
		return maxsum;
	}
	
	public static int msis2(int[] arr, int n, int[] storage){
		if(storage[n] != 0){
			return storage[n];
		}
		
		int maxval = arr[n];
		
		for(int i=0; i<n; i++){
			int current = msis2(arr, i, storage);
			
			if(arr[i] < arr[n] && current + arr[n] > maxval){
				maxval = current + arr[n];
			}
		}
		
		if(maxval > maxsum){
			maxsum = maxval;
		}
		
		storage[n] = maxval;
		return maxval;
	}

}
