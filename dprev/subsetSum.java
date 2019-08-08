package dprev;

import java.util.*;
import java.lang.*;
import java.io.*;
class subsetSum
 {
	static int N;
	public static void main (String[] args){
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			int[] a=new int[n];
			int sum=0;
			for(int j=0;j<n;j++){
				a[j]=s.nextInt();
				sum+=(a[j]);
			}
			N=sum;
			if(sum%2!=0){
				System.out.println("NO");
			}
//			else if(f(a, 0, 0, new Object[n+1][N/2+1])){
//				System.out.println("YES");
//			}
			else if(f1(a)){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}
	
	static boolean f(int[] a,int idx,int s,Object[][] dp){
		if(dp[idx][s]!=null){
			return (boolean)dp[idx][s];
		}
		if(s==N/2){
			dp[idx][s]=true;
			return (boolean)dp[idx][s];
		}
		if(idx==a.length){
			dp[idx][s]=false;
			return (boolean)dp[idx][s];
		}
		if(s+a[idx]>N/2){
			dp[idx][s]=f(a, idx+1, s, dp);
			return (boolean)dp[idx][s];
		}
		dp[idx][s]=f(a, idx+1, s,dp) || f(a, idx+1, s+a[idx],dp);
		return (boolean)dp[idx][s];
	}
	 
	
	static boolean f1(int[] a){
		int n=a.length;
		Object[][] dp=new Object[n][N/2+1];
		for(int i=0;i<n;i++){
			dp[i][0]=true;
		}
		for(int i=0;i<n;i++){
			for(int j=1;j<(N/2+1);j++){
				if(i==0){
					if(j==a[i]){
						dp[i][j]=true;
					}
					else{
						dp[i][j]=false;
					}
				}
				else{
					if(j<a[i]){
						dp[i][j]=dp[i-1][j];
					}
					else{
						dp[i][j]=(boolean)dp[i-1][j] || (boolean)dp[i-1][j-a[i]];
					}
				}
			}
		}
		int i=n-1;
		int j=N/2;
		Vector<Integer> vec=new Vector<>(0,1);
		while(j!=0){
			if(i==0){
				if(j==a[i]){
					vec.add(a[i]);
				}
				break;
			}
			else{
				if(dp[i-1][j]==dp[i][j]){
					i--;
				}
				else{
					vec.add(a[i]);
					i--;
					j-=(a[i]);
				}
			}
		}
		System.out.println(vec);
		return (boolean)dp[n-1][N/2];
	}
}