package dprev;
import java.util.*;
public class binomialCoff {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		System.out.println(bc(n,k,new int[n+1][k+1]));
		System.out.println(bc1(n, k));
	}

	static int bc(int n,int k,int[][] dp){
		if(dp[n][k]!=0){
			return dp[n][k];
		}
		if(k==0 || k==n){
			return dp[n][k]=1;
		}
		return dp[n][k]=bc(n-1,k-1,dp)+bc(n-1,k,dp);
	}
	
	static int bc1(int n,int k){
		int[][] dp=new int[n+1][k+1];
		for(int i=1;i<=n;i++){
			for(int j=0;j<=k;j++){
				if(j==0 || j==i){
					dp[i][j]=1;
				}
				else if(j>i){
					continue;
				}
				else{
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
			}
		}
		return dp[n][k];
	}
}
