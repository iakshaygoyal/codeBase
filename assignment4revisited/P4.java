package assignment4revisited;

import lec03.ArrayBasic;

public class P4 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		sort012(a);
		ArrayBasic.PRINT_ARRAY(a);

	}
	
	public static void sort012(int[] arr){
		int lo = 0, mid = 0, hi = arr.length-1;
		
		while(mid <= hi){
			if(arr[mid] == 0){
				int temp = arr[mid];
				arr[mid] = arr[lo];
				arr[lo] = temp;
				lo++;
				mid++;
			}
			else if(arr[mid] == 1){
				mid++;
			}
			else{
				int temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] =temp;
				hi--;
			}
		}
		
	}

}
