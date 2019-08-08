package bootcamp.dp;

import java.util.Scanner;

public class spogMST1 {

	//(BOTTOM UP WITH MEMOIZATION)
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int[] dp=new int[20000002];
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			dp[0]=0;
			dp[1]=0;
			for(int j=2;j<n+1;j++){
				if(dp[j]!=0){
					int value1=dp[j-1];
					int value2=Integer.MAX_VALUE;
					if(j%2==0){
						value2=dp[j/2];
					}
					int value3=Integer.MAX_VALUE;
					if(j%3==0){
						value3=dp[j/3];
					}
					dp[j]=1+Math.min(value1,Math.min(value2,value3));
				}
			}
			System.out.println("Case "+(i+1)+": "+dp[n]);
		}
	}
	
//	public static int minmSteps(int n,int[] dp){
//		if(n<=1){
//			return 0;
//		}
//		if(dp[n]!=0){
//			return dp[n];
//		}
//		else{
//			int value1=minmSteps(n-1,dp);
//			int value2=Integer.MAX_VALUE;
//			if(n%2==0){
//				value2=minmSteps(n/2,dp);
//			}
//			int value3=Integer.MAX_VALUE;
//			if(n%3==0){
//				value3=minmSteps(n/3,dp);
//			}
//			return dp[n]=1+Math.min(value1,Math.min(value2,value3));
//		}
//	}

}
