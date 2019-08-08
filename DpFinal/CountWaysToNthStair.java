package DpFinal;
import java.util.*;
public class CountWaysToNthStair {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(totalWays(n));
		}
	}
	
	static int totalWays(int n){
		int[] steps=new int[]{1,2};
		int[][] dp=new int[n+1][3];
		for(int i=0;i<(n+1);i++){
			for(int j=2;j>=0;j--){
				if(i==0){
					dp[i][j]=1;
				}
				else if(j==2){
					dp[i][j]=0;
				}
				else if(steps[j]>i){
					dp[i][j]=dp[i][j+1];
				}
				else{
					dp[i][j]=dp[i][j+1]+dp[i-steps[j]][j];
				}
			}
		}
		return dp[n][0];
	}
}
