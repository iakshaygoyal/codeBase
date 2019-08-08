package dpCorrect;
import java.util.*;
public class BinomialCoffecient {

	static int N=1000000007;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int k=scn.nextInt();
			System.out.println(bc(n, k));
		}
		
	}
	
	static int bc(int n,int k){
		int[][] dp=new int[n+1][k+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(k+1);j++){
				if(i==j || j==0){
					dp[i][j]=1;
				}
				else if(j>i){
					continue;
				}
				else{
					dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%N;
				}
			}
		}
		return dp[n][k];
	}

}
