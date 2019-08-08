package bootcamp.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class robotandPaths {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r=s.nextInt();
		int c=s.nextInt();
		int p=s.nextInt();
		int[][] dp=new int[r][c];
		for(int i=0;i<p;i++){
			dp[s.nextInt()-1][s.nextInt()-1]=-1;
		}
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(totalWays(r, c, dp));
	}
	
	public static int totalWays(int r,int c,int[][] dp){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(dp[i][j]==-1){
					dp[i][j]=0;
				}
				else if(i==0&&j==0){
					dp[i][j]=1;
				}
				else if(i==0){
					dp[i][j]=dp[i][j-1];
				}
				else if(j==0){
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
				}
			}
		}
		return dp[r-1][c-1];
	}

}
