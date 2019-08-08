package dprev;
import java.util.*;
import java.lang.*;
import java.io.*;

class eggDrop {
	static int N=1000000000;
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
		    int n=s.nextInt();
		    int k=s.nextInt();
		    System.out.println(ed(n,k,new int[n+1][k+1]));
		    System.out.println(ed1(n,k));
		}
	}
	
	static int ed(int n,int k,int[][] dp){
	    if(dp[n][k]!=0){
	        return dp[n][k];
	    }
	    if(k==0 || k==1){
	        return dp[n][k]=k;
	    }
	    if(n==1){
	        return dp[n][k]=k;
	    }
	    int min=N;
	    for(int i=1;i<=k;i++){
	        int curr=Math.max(ed(n-1,i-1,dp),ed(n,k-i,dp))+1;
	        if(curr<min){
	            min=curr;
	        }
	    }
	    return dp[n][k]=min;
	}
	
	static int ed1(int n,int k){
	    int[][] dp=new int[n+1][k+1];
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=k;j++){
	            if(i==1){
	                dp[i][j]=j;
	            }
	            else if(j==1){
	                dp[i][j]=j;
	            }
	            else{
	                int min=N;
	                for(int l=1;l<=j;l++){
	                    int curr=Math.max(dp[i-1][l-1],dp[i][j-l])+1;
	                    if(curr<min){
	                        min=curr;
	                    }
	                }
	                dp[i][j]=min;
	            }
	        }
	    }
	    return dp[n][k];
	}
}