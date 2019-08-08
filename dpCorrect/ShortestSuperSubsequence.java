package dpCorrect;
import java.util.*;
public class ShortestSuperSubsequence {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String s1=scn.next();
			String s2=scn.next();
			System.out.println(sss(s1, s2));
		}
	}
	
	static int sss(String s1,String s2){
		int m=s1.length();
		int n=s2.length();
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(m+1);j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=1+dp[i-1][j-1];
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return (m+n-dp[m][n]);
	}

}
