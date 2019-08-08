package dpCorrect;
import java.util.*;
public class LongestPalindromicSubsequence {

//2
//BBABCBCAB
//GEEKSFORGEEKS
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String s=scn.next();
			System.out.println(lps(s));
		}
	}
	
	static int lps(String s){
		int n=s.length();
		int[][] dp=new int[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(i==j){
					dp[i][j]=1;
				}
				else if(s.charAt(i)==s.charAt(j)){
					dp[i][j]=2+dp[i+1][j-1];
				}
				else{
					dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
				}
			}
		}
		return dp[0][n-1];
	}

}