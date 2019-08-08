package dprev;

import java.util.*;
import java.lang.*;
import java.io.*;
class kpsk
 {
	public static void main (String[] args){
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
	    for(int i=0;i<t;i++){
	        int n=s.nextInt();
	        int w=s.nextInt();
	        int[] val=new int[n];
	        for(int j=0;j<n;j++){
	            val[j]=s.nextInt();
	        }
	        int[] wt=new int[n];
	        for(int j=0;j<n;j++){
	            wt[j]=s.nextInt();
	        }
//	        System.out.println(kpsk(val,wt,0,w,new int[n+1][w+1]));
	        System.out.println(kpsk(val,wt,w,n));
	    }
	}
	
	static int kpsk(int[] val,int[] wt,int w,int n){
	    int[][] dp=new int[n][w+1];
	    for(int i=0;i<n;i++){
	        for(int j=1;j<=w;j++){
	            if(i==0){
	                if(wt[i]<=j){
	                    dp[i][j]=val[i];
	                }
	            }
	            else if(wt[i]>j){
	                dp[i][j]=dp[i-1][j];
	            }
	            else{
	                dp[i][j]=Math.max(val[i]+dp[i-1][j-wt[i]],dp[i-1][j]);
	            }
	        }
	    }
	    int i=n-1;
	    int j=w;
	    System.out.println("val  wt");
	    while(j!=0){
	    	if(i==0){
	    		if(dp[i][j]!=0){
	    			System.out.println(val[i]+"    "+wt[i]);
	    		}
	    		break;
	    	}
	    	else{
	    		if(dp[i][j]==dp[i-1][j]){
	    			i--;
	    		}
	    		else{
	    			System.out.println(val[i]+"    "+wt[i]);
	    			j-=(wt[i]);
	    			i--;
	    		}
	    	}
	    }
	    return dp[n-1][w];
	}
	
	static int kpsk(int[] val,int[] wt,int idx,int w,int[][] dp){
	    if(dp[idx][w]!=0){
	        return dp[idx][w];
	    }
	    if(w==0 || idx==val.length){
	        return 0;
	    }
	    if(wt[idx]>w){
	        return dp[idx][w]=kpsk(val,wt,idx+1,w,dp);
	    }
	    return dp[idx][w]=Math.max(kpsk(val,wt,idx+1,w,dp),val[idx]+kpsk(val,wt,idx+1,w-wt[idx],dp));
	}
}