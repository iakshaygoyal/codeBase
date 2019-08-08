package DpFinal;
import java.util.*;
public class Consecutive1sNotAllowed {

	static int N=1000000007;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(totalStrings(n));
		}
	}
	
	static long totalStrings(int n){
		long[][] dp=new long[n+1][2];
		dp[0][0]=1;
		dp[0][1]=1;
		for(int i=1;i<(n+1);i++){
			dp[i][1]=dp[i-1][0];
			dp[i][0]=(dp[i-1][0]+dp[i-1][1])%1000000007;
		}
		return dp[n][0];
	}

}