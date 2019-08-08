package dpCorrect;
import java.util.*;
public class IncreasingNumbersWithNDigits {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(totalNumbers(n, 0, new int[n+1][10]));
			System.out.println(totalNumbers(n));
		}
	}
	
	static int totalNumbers(int n,int idx,int[][] dp){
		if(dp[n][idx]!=0){
			return dp[n][idx];
		}
		if(n==0){
			return dp[n][idx]=1;
		}
		int retval=0;
		for(int i=idx;i<10;i++){
			retval+=(totalNumbers(n-1, i, dp));
		}
		return dp[n][idx]=retval;
	}
	
	static int totalNumbers(int n){
		int[][] dp=new int[n+1][10];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<10;j++){
				if(i==0){
					dp[i][j]=1;
				}
				else{
					for(int k=j;k<10;k++){
						dp[i][j]+=(dp[i-1][k]);
					}
				}
			}
		}
		return dp[n][0];
	}
}