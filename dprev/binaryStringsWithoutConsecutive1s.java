package dprev;
import java.util.*;
public class binaryStringsWithoutConsecutive1s {

	static int N=1000000007;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
//			System.out.println(f(n,1,new int[n+1][2]));
			int[][] dp=new int[n+1][2];
			dp[0][0]=1;
			dp[0][1]=1;
			for(int j=1;j<=n;j++){
				dp[j][0]=dp[j-1][1]%N;
				dp[j][1]=(dp[j-1][0]%N+dp[j-1][1]%N)%N;
			}
			System.out.println(dp[n][1]);
		}
	}
	
	static int f(int n,int i,int[][] dp){
		if(dp[n][i]!=0){
			return dp[n][i]%N;
		}
		if(n==0){
			dp[n][i]=1;
			return dp[n][i]%N;
		}
		if(i==1){
			dp[n][i]=(f(n-1,1,dp)%N+f(n-1,0,dp)%N)%N;
			return dp[n][i]%N;
		}
		else{
			dp[n][i]=f(n-1,1,dp);
			return dp[n][i]%N;
		}
	}

}
