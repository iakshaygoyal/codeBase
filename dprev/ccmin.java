package dprev;

import java.util.*;
import java.lang.*;
import java.io.*;
//TOP DOWN IS GIVING STACK OVERFLOW ERROR ON GEEKS
class ccmin
 {
     static int N=100001;
 	public static void main (String[] args){
 	    Scanner s=new Scanner(System.in);
 	    int t=s.nextInt();
 	    for(int i=0;i<t;i++){
 	        int n=s.nextInt();
 	        int amt=s.nextInt();
 	        int[] a=new int[n];
 	        for(int j=0;j<n;j++){
 	            a[j]=s.nextInt();
 	        }
 	        System.out.println(cc(a,amt));
 	        
// 	       int val=cc(a,0,amt,new int[n+1][amt+1]);
//	        if(val>=N){
//	            System.out.println("-1");
//	        }
//	        else{
//	            System.out.println(val);
//	        }
 	    }
 	}
 
 	static int cc(int[] a,int n){
 	    int m=a.length;
 	    int[][] dp=new int[m][n+1];
 	    for(int i=0;i<a.length;i++){
 	        dp[i][0]=0;
 	    }
 	    for(int i=0;i<a.length;i++){
 	        for(int j=1;j<=n;j++){
 	            if(i==0){
 	                if(j>=a[i]){
 	                    dp[i][j]=1+dp[i][j-a[i]];
 	                }
 	                else{
 	                    dp[i][j]=N;
 	                }
 	            }
 	            else{
 	                if(j>=a[i]){
 	                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-a[i]]);
 	                }
 	                else{
 	                    dp[i][j]=dp[i-1][j];
 	                }
 	            }
 	        }
 	    }
 	    Vector<Integer> vec=new Vector<>();
 	    if(dp[m-1][n]>=N){
 	        return -1;
 	    }
 	    else{
 	    	int i=m-1;
 	    	int j=n;
 	    	while(j!=0){
 	    		if(i==0){
 	    			vec.add(a[i]);
 	    			j-=(a[i]);
 	    		}
 	    		else{
 	    			if(dp[i-1][j]==dp[i][j]){
 	    				i--;
 	    			}
 	    			else{
 	    				vec.add(a[i]);
 	    				j-=(a[i]);
 	    			}
 	    		}
 	    	}
 	    }
 	    System.out.println(vec);
 	    return dp[m-1][n];
 	}
 	
 	static int cc(int[] a,int idx,int amt,int[][] dp){
 	    if(dp[idx][amt]!=0){
 	        return dp[idx][amt];
 	    }
 	    if(amt==0){
 	        return dp[idx][amt]=0;
 	    }
 	    if(idx==a.length){
 	        return N;
 	    }
 	    if(a[idx]>amt){
 	        return dp[idx][amt]=cc(a,idx+1,amt,dp);
 	    }
 	    return dp[idx][amt]=Math.min(cc(a,idx+1,amt,dp),cc(a,idx,amt-a[idx],dp)+1);
 	}
}

