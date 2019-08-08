package dpCorrect;
import java.util.*;
public class MaximumNoOfAUsing4Keys {

	static int[] dp=new int[76];
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		for(int i=1;i<=6;i++){
			dp[i]=i;
		}
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(maxA(n));
//			System.out.println(maxA(n, 1, 0, 0));
		}
	}
	
	
	// Not able to memoize this recursion
//	static int maxA(int n,int printValue,int b,int totalValue){
//		if(n==0){
//			return 0;
//		}
//
//		if(b==0 || n==1){
//			return printValue+maxA(n-1, printValue, 1, totalValue+printValue);
//		}
//		return Math.max(printValue+maxA(n-1, printValue, 1, totalValue+printValue)
//		,maxA(n-2, totalValue, 0, totalValue));
//	}
	
	static int maxA(int n){
		if(dp[n]!=0){
			return dp[n];
		}
		for(int i=7;i<(n+1);i++){
			if(dp[i]==0){
				for(int j=3;j<n && i>j;j++){
					dp[i]=Math.max(dp[i], (j-1)*dp[i-j]);
				}
			}
		}
		return dp[n];
	}

}
