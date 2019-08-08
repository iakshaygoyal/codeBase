package dprev;
import java.util.*;
public class wordWrap {

//	4
//	3 2 2 5
//	6
	static int N;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		int m=s.nextInt();
		N=m;
		System.out.println(ww(a, 0, m,new int[n+1][N+1]));
	}
	
	static int ww(int[] a,int idx,int m,int[][] dp){
		if(dp[idx][m]!=0){
			return dp[idx][m];
		}
		if(idx==a.length){
			return dp[idx][m]=m*m*m;
		}
		if(a[idx]>m){
			return dp[idx][m]=(m*m*m)+ww(a, idx, N,dp);
		}
		if(m==N){
			return dp[idx][m]=ww(a, idx+1, m-a[idx],dp);
		}
		return dp[idx][m]=Math.min(ww(a, idx+1, m-a[idx],dp),(m*m*m)+ww(a, idx, N,dp));
	}

}