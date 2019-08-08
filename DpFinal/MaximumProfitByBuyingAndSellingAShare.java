package DpFinal;
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
			System.out.println(f(share, 0, 0, 0));
			System.out.println(maxProfit(share, n, max));
		}
	}
	
	static int f(int[] share,int idx,int amt,int T){
		if(T==2 || idx==share.length){
			return 0;
		}
		if(amt==0){
			return Math.max(f(share, idx+1, amt, T), f(share, idx+1, share[idx], T));
		}
		return Math.max(f(share, idx+1, amt, T), (share[idx]-amt)+f(share, idx+1, 0, T+1));
	}
	
	static int maxProfit(int[] share,int n,int max){
		int[][][] dp=new int[n+1][max+1][3];
		for(int i=n;i>=0;i--){
			for(int j=max;j>=0;j--){
				for(int k=2;k>=0;k--){
					if(k==2 || i==n){
						dp[i][j][k]=0;
					}
					else if(j==0){
						dp[i][j][k]=Math.max(dp[i+1][j][k],dp[i+1][share[i]][k]);
					}
					else{
						dp[i][j][k]=Math.max(dp[i+1][j][k], (share[i]-j)+dp[i+1][0][k+1]);
					}
				}
			}
		}
		return dp[0][0][0];
	}	
}