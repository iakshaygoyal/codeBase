package bootcamp.dp;

import java.util.Scanner;

public class wine {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[] p=new int[n];
		for(int i=0;i<n;i++){
			p[i]=s.nextInt();
		}
		int size=p.length;
		System.out.println(maxProfit(p, 0, size-1, 1));
		System.out.println(maxProfit1(p, 0, size-1, 1, new int[size][size]));
		System.out.println(maxProfit2(p));
	}
	
	public static int maxProfit(int[] price,int si,int fi,int year){
		if(si>fi){
			return 0;
		}
		int value1=price[si]*year+maxProfit(price, si+1, fi, year+1);
		int value2=price[fi]*year+maxProfit(price, si, fi-1, year+1);
		return Math.max(value1,value2);
	}
	
	public static int maxProfit1(int[] price,int si,int fi,int year,int[][] dp){
		if(si>fi){
			return 0;
		}
		if(dp[si][fi]!=0){
			return dp[si][fi];
		}
		else{
			int value1=price[si]*year+maxProfit1(price, si+1, fi, year+1,dp);
			int value2=price[fi]*year+maxProfit1(price, si, fi-1, year+1,dp);
			return dp[si][fi]=Math.max(value1, value2);
		}
	}
	
	public static int maxProfit2(int[] price){
		int n=price.length;
		int[][] dp=new int[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				int year=n-(j-i);
				if(i>j){
					dp[i][j]=0;
				}
				else if(i==n-1){
					dp[i][j]=price[j]*year+dp[i][j-1];;
				}
				else if(j==0){
					dp[i][j]=price[i]*year+dp[i+1][j];
				}
				else{
					int value1=price[i]*year+dp[i+1][j];
					int value2=price[j]*year+dp[i][j-1];
					dp[i][j]=Math.max(value1,value2);
				}
			}
		}
		return dp[0][n-1];
	}

}