package dprev;
import java.util.*;
public class cuttingRod {

//	8
//	8
//	5 2 7 1 3 4 8 6
//	1 5 8 9 10 17 17 20
	static int N=1000000000;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int L=s.nextInt();
		int n=s.nextInt();
		int[] l=new int[n];
		int[] p=new int[n];
		for(int i=0;i<n;i++){
			l[i]=s.nextInt();
		}
		for(int i=0;i<n;i++){
			p[i]=s.nextInt();
		}
		System.out.println(cr(l, p, 0, L, new int[l.length][L+1]));
		System.out.println(cr1(l, p, L));
	}
	
	static int cr(int[] l,int[] p,int idx,int L,int[][] dp){
		if(idx==l.length){
			return -N;
		}
		if(dp[idx][L]!=0){
			return dp[idx][L];
		}
		if(L==0){
			return dp[idx][L]=0;
		}
		if(l[idx]>L){
			return dp[idx][L]=cr(l, p, idx+1, L,dp);
		}
		return dp[idx][L]=Math.max(cr(l, p, idx+1, L,dp), cr(l, p, idx, L-l[idx],dp)+p[idx]);
	}
	
	static int cr1(int[] l,int[] p,int L){
		int n=l.length;
		int[][] dp=new int[n][L+1];
		for(int i=0;i<n;i++){
			for(int j=1;j<=L;j++){
				if(i==0){
					if(j>=l[i]){
						dp[i][j]=p[i]+dp[i][j-l[i]];
					}
					else{
						dp[i][j]=0;
					}
				}
				else{
					if(j>=l[i]){
						dp[i][j]=Math.max(dp[i-1][j], p[i]+dp[i][j-l[i]]);
					}
					else{
						dp[i][j]=dp[i-1][j];
					}
				}
			}
		}
		int i=n-1;
		int j=L;
		System.out.println("price  length");
		while(j!=0){
			if(i==0){
				if(dp[i][j]==0){
					break;
				}
				else{
					System.out.println(p[i]+"     "+l[i]);
					j-=(l[i]);
				}
			}
			else{
				if(dp[i-1][j]==dp[i][j]){
					i--;
				}
				else{
					System.out.println(p[i]+"     "+l[i]);
					j-=(l[i]);
				}
			}
		}
		return dp[n-1][L];
	}

}
