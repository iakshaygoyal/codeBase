package dpCorrect;
import java.util.*;
public class CountWaysToNthStair {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(totalWays(n));
			int[] steps=new int[]{1,2};
			int m=2;
			System.out.println(totalWays(steps, m, n, new int[m+1][n+1]));
		}
	}
	
	static int totalWays(int n){
		int[] steps=new int[]{1,2};
		int m=2;
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<(m+1);i++){
			for(int j=0;j<(n+1);j++){
				if(j==0){
					dp[i][j]=1;
				}
				else if(i==0){
					dp[i][j]=0;
				}
				else if(steps[i-1]>j){
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=dp[i-1][j]+dp[i][j-steps[i-1]];
				}
			}
		}
		return dp[m][n];
	}
	
	static int totalWays(int[] steps,int idx,int n,int[][] dp){
		if(dp[idx][n]!=0){
			return dp[idx][n];
		}
		if(n==0){
			return dp[idx][n]=1;
		}
		if(idx==0){
			return dp[idx][n]=0;
		}
		if(steps[idx-1]>n){
			return dp[idx][n]=totalWays(steps, idx-1, n, dp);
		}
		return dp[idx][n]=totalWays(steps, idx, n-steps[idx-1], dp)+totalWays(steps, idx-1, n, dp);
	}

}
