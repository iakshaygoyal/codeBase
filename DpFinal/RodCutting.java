package DpFinal;
import java.util.*;
public class RodCutting {

//	8
//	1 5 8 9 10 17 17 20
	
//	8
//	3 5 8 9 10 17 17 20
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=scn.nextInt();
		}
		System.out.println(maxProfit(a, n));
	}
	
	static int maxProfit(int[] a,int n){
		int[][] dp=new int[n+1][n+1];
		for(int i=n;i>=0;i--){
			for(int j=0;j<(n+1);j++){
				if(i==n || j==0){
					dp[i][j]=0;
				}
				else if((i+1)>j){
					dp[i][j]=dp[i+1][j];
				}
				else{
					dp[i][j]=Math.max(dp[i+1][j], dp[i][j-(i+1)]+a[i]);
				}
			}
		}
		return dp[0][n];
	}

}
