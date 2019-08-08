package dp;

import java.util.Scanner;

public class wordWrap {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		double[] arr = new double[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextDouble();
		}
		value = s.nextDouble();
		System.out.println(wordWrap(arr, 0, value));
	}
	
	static double value;
	public static double wordWrap(double[] arr,int idx,double m){
		if(idx == arr.length){
			return Math.pow(m, 3);
		}
		if(m == value){
			return wordWrap(arr, idx+1, m-arr[idx]);
		}
		else if(m < arr[idx]){
			return Math.pow(m, 3) + wordWrap(arr, idx+1, value-arr[idx]);
		}
		return Math.min(Math.pow(m, 3) + wordWrap(arr, idx+1, value-arr[idx]), wordWrap(arr, idx+1, m-arr[idx]));
	}

}