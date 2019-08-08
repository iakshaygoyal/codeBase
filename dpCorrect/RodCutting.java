package dpCorrect;
import java.util.*;
public class RodCutting {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] p=new int[n];
			for(int j=0;j<n;j++){
				p[j]=scn.nextInt();
			}
			System.out.println(rc(p, n));
		}
	}
	
	static int rc(int[] p,int n){
		int[][] dp=new int[n+1][n+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(n+1);j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else if(i>j){
					dp[i][j]=dp[i-1][j];
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j],p[i-1]+dp[i][j-i]);
				}
			}
		}
		return dp[n][n];
	}

}
