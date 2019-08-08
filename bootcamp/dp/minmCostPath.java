package bootcamp.dp;

import java.util.Scanner;

public class minmCostPath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[][] c=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				c[i][j]=s.nextInt();
			}
		}
		System.out.println(minmcost(c, n-1, n-1));
		System.out.println(minmcost1(c, n-1, n-1));
	}
	
	public static int minmcost(int[][] c,int i,int j){
		if(i==0 && j==0){
			return c[i][j];
		}
		else if(i==0){
			return c[i][j]+minmcost(c, i, j-1);
		}
		else if(j==0){
			return c[i][j]+minmcost(c, i-1, j);
		}
		int value1=c[i][j]+minmcost(c, i-1, j);
		int value2=c[i][j]+minmcost(c, i, j-1);
		return Math.min(value1, value2);
	}
	
	public static int minmcost1(int[][] c,int row,int col){
		int[][] dp=new int[row+1][col+1];
		for(int i=0;i<=row;i++){
			for(int j=0;j<=col;j++){
				if(i==0&&j==0){
					dp[i][j]=c[i][j];
				}
				else if(i==0){
					dp[i][j]=c[i][j]+dp[i][j-1];
				}
				else if(j==0){
					dp[i][j]=c[i][j]+dp[i-1][j];
				}
				else{
					int value1=c[i][j]+dp[i-1][j];
					int value2=c[i][j]+dp[i][j-1];
					dp[i][j]=Math.min(value1,value2);
				}
			}
		}
		return dp[row][col];
	}

}
