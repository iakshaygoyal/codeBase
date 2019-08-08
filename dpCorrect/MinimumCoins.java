package dpCorrect;
import java.util.*;
public class MinimumCoins {

	static int N=100001;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int amt=scn.nextInt();
			int n=scn.nextInt();
			int[] c=new int[n];
			for(int j=0;j<n;j++){
				c[j]=scn.nextInt();
			}
			System.out.println(mc(c, n, amt));
		}
	}
	
	static int mc(int[] c,int n,int amt){
		int[][] dp=new int[n+1][amt+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(amt+1);j++){
				if(j==0){
					dp[i][j]=0;
				}
				else if(i==0){
					dp[i][j]=N;
				}
				else if(c[i-1]>j){
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-c[i-1]]);
				}
			}
		}
		if(dp[n][amt]>=N){
			return -1;
		}
		return dp[n][amt];
	}

}
