package dprev;
import java.util.*;
public class palindromePartioning {

	static int N;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String x=s.next();
		N=x.length();
		System.out.println(pp(x, 0, x.length()-1,new int[x.length()][x.length()]));
		System.out.println(pp1(x));
	}

	static int pp(String s,int si,int fi,int[][] dp){
		if(dp[si][fi]!=0){
			return dp[si][fi];
		}
		if(si==fi){
			return dp[si][fi]=0;
		}
		if(isPalindrome(s, si, fi)){
			return dp[si][fi]=0;
		}
		int min=N;
		for(int i=si+1;i<=fi;i++){
			int v1=pp(s, si, i-1,dp);
			int v2=pp(s, i, fi,dp);
			int total=v1+v2+1;
			if(total<min){
				min=total;
			}
		}
		return dp[si][fi]=min;
	}
	
	static int pp1(String s){
		int n=s.length();
		int[][] dp=new int[n][n];
		String[][] sa=new String[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(i==j){
					dp[i][j]=0;
					sa[i][j]=s.charAt(i)+"";
				}
				else if(isPalindrome(s, i, j)){
					dp[i][j]=0;
					sa[i][j]=s.substring(i, j+1);
				}
				else{
					int min=N;
					for(int k=i+1;k<=j;k++){
						int curr=dp[i][k-1]+dp[k][j]+1;
						if(curr<min){
							min=curr;
							sa[i][j]=sa[i][k-1]+"|"+sa[k][j];
						}
					}
					dp[i][j]=min;
				}
			}
		}
		System.out.println(sa[0][n-1]);
		return dp[0][n-1];
	}
	
	static boolean isPalindrome(String s,int si,int fi){
		for(int i=si,j=fi;i<=j;i++,j--){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		return true;
	}
}
