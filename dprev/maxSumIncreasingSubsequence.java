package dprev;

import java.util.*;
import java.lang.*;
import java.io.*;
class maxSumIncreasingSubsequence
 {
	public static void main (String[] args)
	 {
	     Scanner s=new Scanner(System.in);
	     int t=s.nextInt();
	     for(int i=0;i<t;i++){
	         int n=s.nextInt();
	         int[] a=new int[n];
	         int[] dp=new int[n];
	         Vector<Integer>[] a1=new Vector[n];
	         for(int j=0;j<n;j++){
	             a[j]=s.nextInt();
	             dp[j]=a[j];
	             a1[j]=new Vector<>(0,1);
	             a1[j].add(a[j]);
	         }
	         for(int j=1;j<n;j++){
	             for(int k=0;k<j;k++){
	                 if(a[k]<a[j] && dp[k]+a[j]>dp[j]){
	                     dp[j]=dp[k]+a[j];
	                     a1[j]=new Vector<>(a1[k]);
	                     a1[j].add(a[j]);
	                 }
	             }
	         }
	         int max=-1;
	         Vector<Integer> vec=new Vector<>(0,1);
	         for(int j=0;j<n;j++){
	             if(dp[j]>max){
	                 max=dp[j];
	                 vec=a1[j];
	             }
	         }
	         System.out.println(vec);
	         System.out.println(max);
	     }
	 }
}
