package dprev;

import java.util.*;
import java.lang.*;
import java.io.*;

class lis {
	public static void main (String[] args) {
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
	    for(int i=0;i<t;i++){
	        int n=s.nextInt();
	        int[] a=new int[n];
	        for(int j=0;j<n;j++){
	            a[j]=s.nextInt();
	        }
//	        System.out.println(lis(a,n));
	        
	        Vector<Integer>[] a1=new Vector[n];
	        for(int j=0;j<n;j++){
	        	a1[j]=new Vector<>(0,1);
	        	a1[j].add(a[j]);
	        }
	        int[] dp=new int[n];
	        Arrays.fill(dp, 1);
	        for(int j=1;j<n;j++){
	            for(int k=0;k<j;k++){
	               if(a[k]<a[j] && dp[k]+1>dp[j]){
	                   dp[j]=dp[k]+1;
	                   a1[j]=new Vector<>(a1[k]);
	                   a1[j].add(a[j]);
	               } 
	            }
	        }
	        int max=-1;
	        Vector<Integer> v=new Vector<>(0,1);
	        for(int j=0;j<n;j++){
	            if(dp[j]>max){
	                max=dp[j];
	                v=a1[j];
	            }
	        }
	        System.out.println(v);
	        System.out.println(max);
	    }
	}
	
	static int maxm=-1;
	static int lis(int[] a,int n){
	    maxm=-1;
	    lis(a,n-1,new int[n]);
	    return maxm;
	}
	static int lis(int[] a,int n,int[] dp){
	    if(dp[n]!=0){
	        return dp[n];
	    }
	    int max=1;
	    for(int i=0;i<n;i++){
	        int curr=lis(a,i,dp);
	        if(a[i]<a[n] && curr+1>max){
	            max=curr+1;
	        }
	    }
	    if(max>maxm){
	        maxm=max;
	    }
	    return dp[n]=max;
	}
}