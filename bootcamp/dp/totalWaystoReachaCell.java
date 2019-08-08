package bootcamp.dp;

import java.util.Scanner;

public class totalWaystoReachaCell {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int row=s.nextInt();
		int col=s.nextInt();
		System.out.println(totalWays(row, col));
	}
	
	public static int totalWays(int row,int col){
		int[][] dp=new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i==0&&j==0){
					dp[i][j]=1;
				}
				else if(i==0){
					dp[i][j]=1;
				}
				else if(j==0){
					dp[i][j]=1;
				}
				else{
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[row-1][col-1];
	}

}
