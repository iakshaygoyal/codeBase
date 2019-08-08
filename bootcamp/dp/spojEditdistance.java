package bootcamp.dp;
import java.util.*;
import java.lang.*;
public class spojEditdistance {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			String s1=s.next();
			String s2=s.next();
			int n=s1.length();
			int m=s2.length();
			int[][] dp=new int[n+1][m+1];
			for(int j=0;j<n+1;j++){
				for(int k=0;k<m+1;k++){
					if(j==0 && k==0){
						dp[j][k]=0;
					}
					else if(j==0){
						dp[j][k]=k;
					}
					else if(k==0){
						dp[j][k]=j;
					}
					else if(s1.charAt(j-1)==s2.charAt(k-1)){
						dp[j][k]=dp[j-1][k-1];
					}
					else{
						int cost1=dp[j-1][k-1];
						int cost2=dp[j-1][k];
						int cost3=dp[j][k-1];
						dp[j][k]=Math.min(cost1, Math.min(cost2, cost3))+1;
					}
				}
			}
			System.out.println(dp[n][m]);
		}
	}

}
