package DpFinal;
import java.util.*;
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int m=scn.nextInt();
			int n=scn.nextInt();
			String s1=scn.next();
			String s2=scn.next();
			System.out.println(lcs(s1, s2, m, n));
		}
	}
	
	static int lcs(String s1,String s2,int m,int n){
		int[][] dp=new int[m+1][n+1];
		for(int i=m;i>=0;i--){
			for(int j=n;j>=0;j--){
				if(i==m || j==n){
					dp[i][j]=0;
				}
				else if(s1.charAt(i)==s2.charAt(j)){
					dp[i][j]=1+dp[i+1][j+1];
				}
				else{
					dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
	}

}
