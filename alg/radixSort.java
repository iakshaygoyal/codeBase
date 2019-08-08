package alg;

import java.util.Scanner;

public class radixSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int j=0; j<n; j++){
			arr[j] = s.nextInt();
		}
		
		arr = rs(arr);
		
		for(int k=0; k<arr.length; k++){
			System.out.print(arr[k]+", ");
		}
		System.out.println("END");

	}
	
	public static int[] rs(int[] arr){
		int max=arr[0];
		
		for(int i=1; i<arr.length; i++){
			if(arr[i] > max){
				max=arr[i];
			}
		}
		
		int p=1;
		while(max != 0){
			arr=cs(arr, p);
			p*=10;
			max/=10;
		}
		
		return arr;
	}
	
	public static int[] cs(int[] arr, int p){
		int max=arr[0];
		int min=arr[0];
		
		for(int i=1; i<arr.length; i++){
			if(arr[i] > max){
				max=arr[i];
			}
			if(arr[i]<min){
				min=arr[i];
			}
		}
		
		int[] count = new int[max-min+1];
		
		for(int i=0; i<arr.length; i++){
			count[((arr[i] - min)/p)%10]++;
		}
		
		for(int i=1; i<count.length; i++){
			count[i] = count[i] + count[i-1];
		}
		
		int[] output = new int[arr.length];
		
		// Enter from end
//		for(int i=0; i<arr.length; i++){
//			int idx = count[((arr[i] - min)/p)%10];
//			count[((arr[i] - min)/p)%10]--;
//			output[idx - 1] = arr[i];
//		}
		
		for(int i=arr.length-1; i>=0; i--){
			int idx = count[((arr[i] - min)/p)%10];
			count[((arr[i] - min)/p)%10]--;
			output[idx - 1] = arr[i];
		}
		
		return output;
	}

}
