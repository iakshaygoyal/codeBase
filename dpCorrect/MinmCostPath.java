package dpCorrect;
import java.util.*;

//1
//3
//3
//1 2 3 
//4 8 2
//1 5 3

public class MinmCostPath {

	static int N=1000000007;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int row=scn.nextInt();
			int col=scn.nextInt();
			int[][] cost=new int[row][col];
			for(int j=0;j<row;j++){
				for(int k=0;k<col;k++){
					cost[k][j]=scn.nextInt();
				}
			}
			System.out.println(minCost(cost, row, col, new int[row+1][col+1]));
			System.out.println(minCost(cost, row, col));
		}
	}
	
	static int minCost(int[][] cost,int i,int j, int[][] dp){
		if(dp[i][j]!=0){
			return dp[i][j];
		}
		if(i==0 || j==0){
			return dp[i][j]=N;
		}
		if(i==1 && j==1){
			return dp[i][j]=cost[i-1][j-1];
		}
		return dp[i][j]=cost[i-1][j-1]+Math.min(minCost(cost, i-1, j-1, dp)
				,Math.min(minCost(cost, i-1, j, dp),minCost(cost, i, j-1, dp)));
	}
	
	static int minCost(int[][] cost,int row,int col){
		int[][] dp=new int[row+1][col+1];
		for(int i=0;i<(row+1);i++){
			for(int j=0;j<(col+1);j++){
				if(i==0 || j==0){
					dp[i][j]=N;
				}
				else if(i==1 && j==1){
					dp[i][j]=cost[i-1][j-1];
				}
				else{
					dp[i][j]=cost[i-1][j-1]+Math.min(dp[i-1][j-1]
							,Math.min(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		return dp[row][col];
	}
	
}
