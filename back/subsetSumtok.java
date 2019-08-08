package back;

import java.util.Scanner;

public class subsetSumtok {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		
		int sum = 0;
		for(int i=0; i<n; i++){
			sum+=arr[i];
		}
		int k = s.nextInt();
		if(k > sum){
			System.out.println("k is greater then sum");
		}
		else{
			subset(arr, 0, k, "");
		}

	}
	
	public static void subset(int[] arr, int idx, int k, String s){
		if(k == 0){
			System.out.println(s);
			return;
		}
		else if(idx == arr.length || k<0){// k<0 is backtrack
			return;
		}
		subset(arr, idx + 1, k, s);
		subset(arr, idx + 1, k - arr[idx], arr[idx] + " " + s);
	}

}
