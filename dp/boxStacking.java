package dp;

import java.util.Arrays;
import java.util.Scanner;

public class boxStacking {

	public static class dimension{
		int h;
		int w;
		int d;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] ht = new int[n];
		int[] wd = new int[n];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++){
			ht[i] = s.nextInt();
			wd[i] = s.nextInt();
			dp[i] = s.nextInt();
		}
		dimension[] arr = new dimension[3 * n];
		for(int i=0; i<arr.length; i++){
			arr[i] = new dimension();
		}
		
		for(int i=0, j=0; i<arr.length; i++){
			if(i%3 == 0){
				arr[i].h = ht[j];
				if(wd[j] > dp[j]){
					arr[i].w = wd[j];
					arr[i].d = dp[j];
				}
				else{
					arr[i].w = dp[j];
					arr[i].d = wd[j];
				}
			}
			else if(i%3 == 1){
				arr[i].h = wd[j];
				if(ht[j] > dp[j]){
					arr[i].w = ht[j];
					arr[i].d = dp[j];
				}
				else{
					arr[i].w = dp[j];
					arr[i].d = ht[j];
				}
			}
			else{
				arr[i].h = dp[j];
				if(ht[j] > wd[j]){
					arr[i].w = ht[j];
					arr[i].d = wd[j];
				}
				else{
					arr[i].w = wd[j];
					arr[i].d = ht[j];
				}
				j++;
			}
		}
		
		for(int i=0; i<arr.length-1; i++){
			for(int j=0; j<arr.length-1-i; j++){
				if((arr[j].w * arr[j].d) < (arr[j+1].w * arr[j+1].d)){
					dimension temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(bs(arr));
	}
	
	static int maxval = Integer.MIN_VALUE;;
	public static int bs(dimension[] arr){
		bs(arr, arr.length-1);
		return maxval;
	}
	
	public static int bs(dimension[] arr, int n){
		if(n == 0){
			return arr[n].h;
		}
		
		int maxm = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			int current = bs(arr, i);
			if(arr[i].w > arr[n].w && arr[i].d > arr[n].d && current + arr[n].h > maxm){
				maxm = current + arr[n].h;
			}
		}
		if(maxm > maxval){
			maxval = maxm;
		}
		
		return maxm;
	}

}
