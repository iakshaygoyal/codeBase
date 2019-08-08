package dp;

import java.util.ArrayList;
import java.util.Scanner;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0; i<t; i++){
			int n = s.nextInt();
			int[] arr = new int[n];
			
			for(int j=0; j<n; j++){
				arr[j] = s.nextInt();
			}
//			System.out.println(lis(arr, 0).length);
			
//			ArrayList<Integer> list = lis(arr, 0, 0, Integer.MIN_VALUE);
//			
//			int maxm=list.get(0);
//			for(int k=1; k<list.size(); k++){
//				if(list.get(k) > maxm){
//					maxm = list.get(k);
//				}
//			}
//			System.out.println(maxm);

			
			System.out.println(lis2(arr));
			System.out.println(lis3(arr));
			System.out.println(lis4(arr));
		}

	}
	
	
// Wrong Process	
//	private static class Pair{
//		int min;
//		int length;
//		
//		Pair(int min, int length){
//			this.min=min;
//			this.length=length;
//		}
//	}
//	
//	public static Pair lis(int[] arr, int idx){
//		if(idx == arr.length-1){
//			return new Pair(arr[idx], 1);
//		}
//		
//		Pair prev = lis(arr, idx+1);
//		int currentmin = arr[idx];
//		int currentlength;
//		if( prev.min < currentmin){
//			currentmin = prev.min;
//			currentlength = prev.length;
//		}
//		else{
//			currentlength = prev.length+1;
//		}
//		
//		return new Pair(currentmin, currentlength);
//	}
	
	//Bad Solution(considered every possible case)(2^n)
//	public static ArrayList<Integer> lis(int[] arr, int idx, int len, int max){
//		if(idx == arr.length){
//			ArrayList<Integer> retval = new ArrayList<>();
//			retval.add(len);
//			return retval;
//		}
//		
//		ArrayList<Integer> a1 = null;
//		
//		if(arr[idx] > max){
//			a1 = lis(arr, idx+1, len+1, arr[idx]);
//		}
//		
//		ArrayList<Integer> a2 = lis(arr, idx+1, len, max);
//		
//		if(a1 != null){
//			a2.addAll(a1);
//		}
//		
//		return a2;
//	}
	
	//n^2
	//(Bottoms Up or Iterative)
	public static int lis2(int[] arr){
		int[] temp = new int[arr.length];
		
		for(int i=0; i< temp.length; i++){
			temp[i] = 1;
		}
		
		for(int i=1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j] && temp[j] + 1 > temp[i]){
					temp[i] = temp[j] + 1;
				}
			}
		}
		
		int maxm = temp[0];
		for(int i=1; i<temp.length; i++){
			if(temp[i] > maxm){
				maxm = temp[i];
			}
		}
		
		return maxm;
	}
	
	static int maxlis = 1;

	//simple recursion
	public static int lis3(int[] arr){
		_lis3(arr, arr.length-1);
		return maxlis;
	}
	
	//this function is returning the longest increasing subsequence ending at n
	public static int _lis3(int[] arr, int n){
		// no need of base case
//		if(n == 0){
//			return 1;
//		}
		
		int maxval = 1;
		
		for(int i=0; i<n ;i++){
			int currentlis = _lis3(arr, i);
			if(arr[i] < arr[n] && currentlis + 1 > maxval){
				maxval = currentlis + 1;
			}
		}
		
		if(maxval > maxlis){
			maxlis = maxval;
		}
		
		return maxval;
	}
	
	//(top-down)
	public static int lis4(int[] arr){
		_lis4(arr, arr.length-1, new int[arr.length]);
		return maxlis;
	}
	
	public static int _lis4(int[] arr, int n, int[] storage){
		if(storage[n] != 0){
			return storage[n];
		}
		
		int maxval = 1;
		
		for(int i=0; i<n ;i++){
			int currentlis = _lis4(arr, i, storage);
			if(arr[i] < arr[n] && currentlis + 1 > maxval){
				maxval = currentlis + 1;
			}
		}
		
		if(maxval > maxlis){
			maxlis = maxval;
		}
		
		storage[n] = maxval;
		return maxval;
	}
}
