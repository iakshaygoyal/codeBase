package dprev;
import java.util.*;
public class longestCommonSubstring {
//	zxabcdezy
//	yzabcdezx
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String s1=s.next();
		String s2=s.next();
		int m=s1.length();
		int n=s2.length();
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<(m+1);i++){
			for(int j=0;j<(n+1);j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=1+dp[i-1][j-1];
				}
				else{
					dp[i][j]=0;
				}
			}
		}
		int max=-1;
		int k=-1;
		int l=-1;
		for(int i=0;i<(m+1);i++){
			for(int j=0;j<(n+1);j++){
				if(dp[i][j]>max){
					max=dp[i][j];
					k=i;
					l=j;
				}
			}
		}
		System.out.println(max);
		System.out.println(s1.substring(k-max, k));
		System.out.println(s2.substring(l-max, l));
	}

}
