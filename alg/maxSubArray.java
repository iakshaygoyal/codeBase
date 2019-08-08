package alg;

import java.util.ArrayList;
import java.util.Scanner;

public class maxSubArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		
		System.out.println(msa(arr));
	}
	
	public static int msa(int[] arr){		
		int retval = arr[0];
		int current = arr[0];
		
		ArrayList<Integer> retvalarr = new ArrayList<>();
		ArrayList<Integer> currentarr = new ArrayList<>();
		retvalarr.add(arr[0]);
		currentarr.add(arr[0]);
		
		for(int i=1; i<arr.length; i++){
			if(arr[i] > current + arr[i]){
				current = arr[i];
				currentarr = new ArrayList<>();
				currentarr.add(arr[i]);
			}
			else{
				current = current + arr[i];
				currentarr.add(arr[i]);
			}
			
			if(current > retval){
				retvalarr = new ArrayList<>();
				retvalarr.addAll(currentarr);
				retval = current;
			}
		}
		
		System.out.println(retvalarr);
		return retval;
	}

}
