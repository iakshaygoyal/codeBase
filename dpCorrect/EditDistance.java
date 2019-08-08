package dpCorrect;
import java.util.*;
public class EditDistance {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int m=scn.nextInt();
			int n=scn.nextInt();
			String s1=scn.next();
			String s2=scn.next();
			System.out.println(ed(s1, s2, m, n));
		}
	}
	
	static int ed(String s1,String s2,int m,int n){
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<(m+1);i++){
			for(int j=0;j<(n+1);j++){
				if(i==0 || j==0){
					dp[i][j]=(i==0?j:i);
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1];
				}
				else{
					dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
				}
			}
		}
		return dp[m][n];
	}

}
