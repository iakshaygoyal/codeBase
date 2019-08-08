package dpCorrect;
import java.util.*;
public class WordWrap{

	static int N;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=scn.nextInt();
			}
			int limit=scn.nextInt();
			N=limit;
			System.out.println(ww(a, n, limit));
			System.out.println(f(a, n, limit));
		}
	}
	
	static int ww(int[] a,int n,int limit){
		int[][] dp=new int[n+1][limit+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(limit+1);j++){
				if(i==0){
					dp[i][j]=(j+1)*(j+1);
				}
				else if(j==a[i-1]){
					dp[i][j]=Math.min(dp[i-1][j-a[i-1]],/*dp[i][limit]*/dp[i-1][limit-a[i-1]]+((j+1)*(j+1)));
				}
				else if(j==limit){
					dp[i][j]=dp[i-1][j-a[i-1]-1];
				}
				else if(a[i-1]>j){
					dp[i][j]=/*dp[i][limit]*/dp[i-1][limit-a[i-1]-1]+((j+1)*(j+1));
				}
				else{
					dp[i][j]=Math.min(dp[i-1][j-a[i-1]-1],/*dp[i][limit]*/dp[i-1][limit-a[i-1]-1]+((j+1)*(j+1)));
				}
			}
		}
		return dp[n][limit];
	}
	
	static int f(int[] a,int idx,int m){
		if(idx==0){
			return ((m+1)*(m+1));
		}
		if(a[idx-1]>m){
			return ((m+1)*(m+1))+f(a,idx,N);// or m*m*m+f(a,idx-1,N-a[idx-1]) look for N in here
		}
		if(m==N){
			return f(a,idx-1,m-a[idx-1]-1);
		}
		return Math.min(f(a,idx-1,m-a[idx-1]-1),((m+1)*(m+1))+f(a,idx,N));
	}

}