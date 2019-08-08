package DpFinal;
import java.util.*;
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		for(int i=m;i>=0;i--){
			for(int j=n;j>=0;j--){
				if(i==m || j==n){
					dp[i][j]=(i==m?n-j:m-i);
				}
				else if(s1.charAt(i)==s2.charAt(j)){
					dp[i][j]=dp[i+1][j+1];
				}
				else{
					dp[i][j]=1+Math.min(dp[i+1][j]
							, Math.min(dp[i][j+1], dp[i+1][j+1]));
				}
			}
		}
		return dp[0][0];
	}

}
