package dpCorrect;
import java.util.*;
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String s=scn.next();
			int n=s.length();
			lps(s, n);
		}
	}
	
	static void lps(String s,int n){
		boolean[][] dp=new boolean[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(i==j){
					dp[i][j]=true;
				}
				else if(i+1==j && s.charAt(i)==s.charAt(j)){
					dp[i][j]=true;
				}
				else if(s.charAt(i)==s.charAt(j)){
					dp[i][j]=dp[i+1][j-1];
				}
				else{
					dp[i][j]=false;
				}
			}
		}
		int max=0;
		int k=-1;
		int l=-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(dp[i][j] && (j-i+1)>max){
					max=(j-i+1);
					k=i;
					l=j;
				}
			}
		}
		System.out.println(s.substring(k, l+1));
	}

}
