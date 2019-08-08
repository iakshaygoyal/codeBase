package dpCorrect;
import java.util.*;
public class MaximumProfitByBuyingAndSellingAShare {

//4
//6
//10 22 5 75 65 80
//7
//2 30 15 10 8 25 80
//7
//100 30 15 10 8 25 80
//5
//90 80 70 60 50
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int j=0;j<t;j++){
			int n=scn.nextInt();
			int[] share=new int[n];
			int max=0;
			for(int i=0;i<n;i++){
				share[i]=scn.nextInt();
				max=Math.max(max, share[i]);
			}
			System.out.println(maxProfit(share, n, 0, 0, new int[n+1][max+1][3]));
			System.out.println(maxProfit(share, n, max));
		}
	}
	
	static int maxProfit(int[] share,int idx,int amt,int T, int[][][] dp){
		if(dp[idx][amt][T]!=0){
			return dp[idx][amt][T];
		}
		if(idx==0 || T==2){
			return 0;
		}
		if(amt==0){
			return dp[idx][amt][T]=Math.max(maxProfit(share, idx-1, amt, T, dp)
					, maxProfit(share, idx-1, share[idx-1], T, dp));
		}else{
			return dp[idx][amt][T]=Math.max(maxProfit(share, idx-1, amt, T, dp)
					, (amt-share[idx-1])+maxProfit(share, idx-1, 0, T+1, dp));
		}
	}	
	
	static int maxProfit(int[] share,int n,int max){
		int[][][] dp=new int[n+1][max+1][3];
		for(int i=0;i<(n+1);i++){
			for(int j=max;j>=0;j--){
				for(int k=2;k>=0;k--){
					if(i==0 || k==2){
						dp[i][j][k]=0;
					}
					else if(j==0){
						dp[i][j][k]=Math.max(dp[i-1][j][k], dp[i-1][share[i-1]][k]);
					}
					else{
						dp[i][j][k]=Math.max(dp[i-1][j][k], (j-share[i-1])+dp[i-1][0][k+1]);
					}
				}
			}
		}
		return dp[n][0][0];
	}	
}