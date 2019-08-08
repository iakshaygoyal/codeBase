package dpCorrect;
import java.util.*;
public class TilingProblem {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(totalWays(n));
		}
	}
	
	static int totalWays(int n){
		int[] dp=new int[n+1];
		dp[0]=1;
		for(int i=1;i<(n+1);i++){
			for(int j=1;j<=2;j++){
				if(j>i){
					break;
				}
				dp[i]+=(dp[i-j]);
			}
		}
		return dp[n];
	}

}
