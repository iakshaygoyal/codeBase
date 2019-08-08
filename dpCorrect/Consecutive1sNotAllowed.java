package dpCorrect;
import java.util.*;
public class Consecutive1sNotAllowed {

	static int N=1000000007;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(totalStrings(n, 0, new int[n+1][2]));
			System.out.println(totalStrings(n));
		}
	}
	
	static int totalStrings(int n,int prev,int[][] dp){
		if(dp[n][prev]!=0){
			return dp[n][prev];
		}
		if(n==0){
			return dp[n][prev]=1;
		}
		if(prev==1){
			return dp[n][prev]=(totalStrings(n-1, 0, dp)%N);
		}
		return dp[n][prev]=(totalStrings(n-1, 0, dp)+totalStrings(n-1, 1, dp))%N;
	}
	
	static int totalStrings(int n){
		int[][] dp=new int[n+1][2];
		dp[0][0]=1;
		dp[0][1]=1;
		for(int i=1;i<(n+1);i++){
			dp[i][0]=(dp[i-1][0]+dp[i-1][1])%N;
			dp[i][1]=dp[i-1][0];
		}
		return dp[n][0];
	}

}