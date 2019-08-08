package dpCorrect;
import java.util.*;
public class Knapsack01 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int w=scn.nextInt();
			int[] val=new int[n];
			int[] wt=new int[n];
			for(int j=0;j<n;j++){
				val[j]=scn.nextInt();
			}
			for(int j=0;j<n;j++){
				wt[j]=scn.nextInt();
			}
			System.out.println(kpsk(val, wt, n, w));
		}
	}
	
	static int kpsk(int[] val,int[] wt,int n,int w){
		int[][] dp=new int[n+1][w+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(w+1);j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else if(wt[i-1]>j){
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
				}
			}
		}
		return dp[n][w];
	}

}
