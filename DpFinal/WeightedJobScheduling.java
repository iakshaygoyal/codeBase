package DpFinal;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedJobScheduling {

//	2
//	4
//	1 2 50
//	3 5 20
//	6 19 100
//	2 100 200
//	
//	6
//	5 8 11
//	4 6 5
//	7 9 2
//	1 3 5
//	6 7 4
//	2 5 6
	
	static class tri implements Comparable<tri>{
		int st;
		int ft;
		int profit;
		tri(int st,int ft,int profit){
			this.st=st;
			this.ft=ft;
			this.profit=profit;
		}
		public int compareTo(tri t){
			return this.ft-t.ft;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			tri[] arr=new tri[n];
			for(int j=0;j<n;j++){
				arr[j]=new tri(scn.nextInt(),scn.nextInt(),scn.nextInt());
			}
			System.out.println(maxProfit(arr, n));
		}
	}
	
	static int maxProfit(tri[] arr,int n){
		Arrays.sort(arr);
		int[] dp=new int[n];
		for(int i=0;i<n;i++){
			dp[i]=arr[i].profit;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[j].ft<=arr[i].st){
					dp[i]=Math.max(dp[i], dp[j]+arr[i].profit);
				}
			}
		}
		int max=-1;
		for(int i=0;i<n;i++){
			max=Math.max(max, dp[i]);
		}
		return max;
	}

}
