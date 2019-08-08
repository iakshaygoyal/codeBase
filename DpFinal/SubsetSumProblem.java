package DpFinal;
import java.util.*;
public class SubsetSumProblem {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] a=new int[n];
			int sum=0;
			for(int j=0;j<n;j++){
				a[j]=scn.nextInt();
				sum+=(a[j]);
			}
			if(sum%2!=0){
				System.out.println("NO");
			}
			else{
				if(ssp(a, sum/2, n)){
					System.out.println("YES");
				}
				else{
					System.out.println("NO");
				}
			}
		}
	}
	
	static boolean ssp(int[] a,int sum,int n){
		boolean[][] dp=new boolean[n+1][sum+1];
		for(int i=n;i>=0;i--){
			for(int j=0;j<(sum+1);j++){
				if(j==0){
					dp[i][j]=true;
				}
				else if(i==n){
					dp[i][j]=false;
				}
				else if(a[i]>j){
					dp[i][j]=dp[i+1][j];
				}
				else{
					dp[i][j]=dp[i+1][j] || dp[i+1][j-a[i]];
				}
			}
		}
		return dp[0][sum];
	}

}
