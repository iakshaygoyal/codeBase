package dpCorrect;
import java.util.*;
public class SumOfDigitsEqualsSum {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int sum=scn.nextInt();
			System.out.println(totalNos(n, sum, 1,new int[n+1][sum+1]));
			System.out.println(totalNos(n, sum));
		}
	}
	
	static int totalNos(int n,int sum,int start,int[][] dp){
		if(dp[n][sum]!=0){
			return dp[n][sum];
		}
		if(n==0 && sum==0){
			return dp[n][sum]=1;
		}
		if(n==0){
			return dp[n][sum]=0;
		}
		int cnt=0;
		for(int i=start;i<10;i++){
			if(i>sum){
				break;
			}
			cnt+=(totalNos(n-1, sum-i, 0, dp));
		}
		return dp[n][sum]=cnt;
	}
	
	static int totalNos(int n,int sum){
		int[][] dp=new int[n+1][sum+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(sum+1);j++){
				if(i==0 && j==0){
					dp[i][j]=1;
				}
				else if(i==0){
					dp[i][j]=0;
				}
				else if(i==1){
					int cnt=0;
					for(int k=1;k<10;k++){
						if(k>j){
							break;
						}
						cnt+=(dp[i-1][j-k]);
					}
					dp[i][j]=cnt;
				}
				else{
					int cnt=0;
					for(int k=0;k<10;k++){
						if(k>j){
							break;
						}
						cnt+=(dp[i-1][j-k]);
					}
					dp[i][j]=cnt;
				}
			}
		}
		return dp[n][sum];
	}

}
