package alg;

import java.util.Scanner;

public class countingSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int[] arr = new int[n];
			
			for(int j=0; j<n; j++){
				arr[j] = s.nextInt();
			}
			
			arr = cs(arr);
			
			for(int k=0; k<arr.length; k++){
				System.out.print(arr[k]+", ");
			}
			System.out.println("END");
	}
	
	public static int[] cs(int[] arr){
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
			count[arr[i] - min]++;
		}
		
		for(int i=1; i<count.length; i++){
			count[i] = count[i] + count[i-1];
		}
		
		int[] output = new int[arr.length];
		
		for(int i=0; i<arr.length; i++){
			int idx = count[arr[i] - min];
			count[arr[i] - min]--;
			output[idx - 1] = arr[i];
		}
		
		return output;
	}

}
