package dp;

import java.util.Scanner;

public class longestBitonicSubsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		
		int[] storage1 = new int[arr.length];
		int[] storage2 = new int[arr.length];
		
		lis(arr, storage1);
		lds(arr, storage2);
		
		int max = storage1[0] + storage2[0] - 1;
		
		for(int i=1; i<storage1.length; i++){
			if( storage1[i] + storage2[i] - 1 > max){
				max =  storage1[i] + storage2[i] - 1;
			}
		}
		
		System.out.println(max);

	}
	
	static int maxlis = 1;
	
	public static int lis(int[] arr, int[] storage1){
		_lis(arr, arr.length-1, storage1);
		return maxlis;
	}
	
	public static int _lis(int[] arr, int n, int[] storage){
		if(storage[n] != 0){
			return storage[n];
		}
		
		int maxval = 1;
		
		for(int i=0; i<n ;i++){
			int currentlis = _lis(arr, i, storage);
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
	
	static int maxlds;
	
	public static int lds(int[] arr, int[] storage2){
		_lds(arr, 0, storage2);
		return maxlds;
	}
	
	public static int _lds(int[] arr, int n, int[] storage){
		if(storage[n] != 0){
			return storage[n];
		}
		
		int maxval = 1;
		
		for(int i=arr.length-1; i>n ;i--){
			int currentlds = _lds(arr, i, storage);
			if(arr[i] < arr[n] && currentlds + 1 > maxval){
				maxval = currentlds + 1;
			}
		}
		
		if(maxval > maxlds){
			maxlds = maxval;
		}
		
		storage[n] = maxval;
		return maxval;
	}
}
