package dpCorrect;
import java.util.*;
public class CountWaysToConstructBuilding {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		System.out.println(evaluate(n));
	}
	
	static int evaluate(int n){
		int[][] dp=new int[n+1][2];
		dp[0][0]=1;
		dp[0][1]=1;
		for(int i=1;i<(n+1);i++){
			dp[i][0]=dp[i-1][1];
			dp[i][1]=dp[i-1][0]+dp[i-1][1];
		}
		return (int)Math.pow(dp[n][1], 2);
	}
}
