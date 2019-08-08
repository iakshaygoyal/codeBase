package dprev;
import java.util.*;
public class longestPalindromicSubsequence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String x=s.next();
//		System.out.println(lps(x,0,x.length()-1,new int[x.length()][x.length()]));
		System.out.println(lps(x, x.length()));
	}

	static int lps(String s,int i,int j,int[][] dp){
		if(dp[i][j]!=0){
			return dp[i][j];
		}
		if(i==j){
			return dp[i][j]=1;
		}
		else if(i>j){
			return dp[i][j]=0;
		}
		if(s.charAt(i)==s.charAt(j)){
			return dp[i][j]=2+lps(s, i+1, j-1,dp);
		}
		else{
			return dp[i][j]=Math.max(lps(s, i+1, j,dp),lps(s, i, j-1,dp));
		}
	}
	
	static int lps(String s,int n){
		int[][] dp=new int[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					dp[i][j]=0;
				}
				else if(i==j){
					dp[i][j]=1;
				}
				else{
					if(s.charAt(i)==s.charAt(j)){
						dp[i][j]=2+dp[i+1][j-1];
					}
					else{
						dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
					}
				}
			}
		}
		int i=0;
		int j=n-1;
		Vector<Character> vec=new Vector<>(0,1);
		while(i<=j){
			if(s.charAt(i)==s.charAt(j)){
				vec.add(s.charAt(i));
				i++;
				j--;
			}
			else{
				if(dp[i+1][j]>dp[i][j-1]){
					i++;
				}
				else{
					j--;
				}
			}
		}
		int size=dp[0][n-1]/2-1;
		for(int k=size;k>=0;k--){
			vec.add(vec.get(k));
		}
		System.out.println(vec);
		return dp[0][n-1];
	}
}