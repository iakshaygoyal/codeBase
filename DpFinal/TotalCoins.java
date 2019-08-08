package DpFinal;
import java.util.*;
public class TotalCoins {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] coins=new int[n];
			for(int j=0;j<n;j++){
				coins[j]=scn.nextInt();
			}
			int amt=scn.nextInt();
			System.out.println(total(coins, n, amt));
		}
	}
	
	static int total(int[] coins,int n,int amt){
		int[][] dp=new int[n+1][amt+1];
		for(int i=n;i>=0;i--){
			for(int j=0;j<(amt+1);j++){
				if(i==n){
					dp[i][j]=0;
				}
				else if(j==0){
					dp[i][j]=1;
				}
				else if(coins[i]>j){
					dp[i][j]=dp[i+1][j];
				}
				else{
					dp[i][j]=dp[i+1][j]+dp[i][j-coins[i]];
				}
			}
		}
		return dp[0][amt];
	}

}
