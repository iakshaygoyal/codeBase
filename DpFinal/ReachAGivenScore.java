package DpFinal;
import java.util.*;
public class ReachAGivenScore {

	int[] DP=new int[1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(minmScore(n));
		}
	}
	static int minmScore(int n){
		int[] score=new int[]{3,5,10};
		int m=3;
		int[][] dp=new int[m+1][n+1];
		for(int i=m;i>=0;i--){
			for(int j=0;j<(n+1);j++){
				if(j==0){
					dp[i][j]=1;
				}
				else if(i==m){
					dp[i][j]=0;
				}
				else if(score[i]>j){
					dp[i][j]=dp[i+1][j];
				}
				else{
					dp[i][j]=dp[i+1][j]+dp[i][j-score[i]];
				}
			}
		}
		return dp[0][n];
	}

}
