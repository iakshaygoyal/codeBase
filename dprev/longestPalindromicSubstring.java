package dprev;
import java.util.*;
public class longestPalindromicSubstring {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			String x=s.next();
			int n=x.length();
			boolean[][] dp=new boolean[n][n];
			for(int j=n-1;j>=0;j--){
				for(int k=0;k<n;k++){
					if(j>k){
						continue;
					}
					else if(j==k){
						dp[j][k]=true;
					}
					else{
						if(x.charAt(j)==x.charAt(k) && (dp[j+1][k-1] || k==j+1)){
							dp[j][k]=true;
						}
						else{
							dp[j][k]=false;
						}
					}
				}
			}
			int max=Integer.MIN_VALUE;
			String y="";
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					if(dp[j][k]==true && k-j+1>max){
						max=k-j+1;
						y=x.substring(j,k+1);
					}
				}
			}
			System.out.println(y);
		}
	}

}
