package DpFinal;
import java.util.Scanner;
public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			System.out.println(kpsk(val, wt, w));
		}
	
	}

	static int kpsk(int[] val, int[] wt, int w) {
		int n=val.length;
		int[][] dp=new int[n+1][w+1];
		for(int i=n;i>=0;i--){
			for(int j=0;j<(w+1);j++){
				if(j==0 || i==n){
					dp[i][j]=0;
				}
				else if(wt[i]>j){
					dp[i][j]=dp[i+1][j];
				}
				else{
					dp[i][j]=Math.max(dp[i+1][j], val[i]+dp[i+1][j-wt[i]]);
				}
			}
		}
		return dp[0][w];
	}

}
