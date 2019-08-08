package dpCorrect;
import java.util.*;
public class PalindromicPartitioning {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String s=scn.next();
			System.out.println(pp(s));
		}
	}
	
	static int pp(String s){
		int n=s.length();
		int[][] dp=new int[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(i==j){
					dp[i][j]=0;
				}
				else if(isPalindrome(s, i, j)){
					dp[i][j]=0;
				}
				else{
					int min=j-i;
					for(int k=i;k<j;k++){
						int val=dp[i][k]+dp[k+1][j]+1;
						if(val<min){
							min=val;
						}
					}
					dp[i][j]=min;
				}
			}
		}
		return dp[0][n-1];
	}
	
	static boolean isPalindrome(String s,int si,int ei){
		for(int i=si,j=ei;i<j;i++,j--){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		return true;
	}

}
