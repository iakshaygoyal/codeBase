package bootcamp.dp;

import java.util.Scanner;

public class rook {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(totalWays(n));
	}
	
	public static int totalWays(int n){
		int row=n,col=n;
		int[][] dp=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0 && j==0){
					dp[i][j]=1;
				}
				else if(i==0){
					for(int k=0;k<j;k++){
						dp[i][j]+=dp[i][k];
					}
				}
				else if(j==0){
					for(int k=0;k<i;k++){
						dp[i][j]+=dp[k][j];
					}
				}
				else{
					for(int k=0;k<i;k++){
						dp[i][j]+=dp[k][j];
					}
					for(int k=0;k<j;k++){
						dp[i][j]+=dp[i][k];
					}
				}
			}
		}
		return dp[n-1][n-1];
	}

}
