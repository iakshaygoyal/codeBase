package dprev;

import java.util.*;
import java.io.*;
//1
//6 7
//aggtab
//gxtxayb
class ed
 {
	public static void main (String[] args)
	 {
	     Scanner s=new Scanner(System.in);
	     int t=s.nextInt();
	     for(int k=0;k<t;k++){
	         int n=s.nextInt();
	         int m=s.nextInt();
	         String s1=s.next();
	         String s2=s.next();
//	         System.out.println(ed(s1,s2,new int[n+1][m+1]));
	         int[][] dp=new int[n+1][m+1];
	         for(int i=0;i<=n;i++){
	             for(int j=0;j<=m;j++){
	                 if(i==0 || j==0){
	                     dp[i][j]=(i==0?j:i);
	                 }
	                 else if(s1.charAt(i-1)==s2.charAt(j-1)){
	                     dp[i][j]=dp[i-1][j-1];
	                 }
	                 else{
	                     dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
	                 }
	             }
	         }
	         int i=n;
	         int j=m;
	         Vector<String> vec=new Vector<>(0,1);
	         while(i!=0 && j!=0){
	        	 if(s1.charAt(i-1)==s2.charAt(j-1)){
	        		 i--;
	        		 j--;
	        	 }
	        	 else{
	        		 int a=dp[i-1][j];
	        		 int b=dp[i][j-1];
	        		 int c=dp[i-1][j-1];
	        		 if(a<=b && a<=c){
	        			 vec.add("delete : "+s1.charAt(i-1));
	        			 i--;
	        		 }
	        		 else if(b<=a && b<=c){
	        			 vec.add("add : "+s2.charAt(j-1));
	        			 j--;
	        		 }
	        		 else{
	        			 vec.add("replace : "+s1.charAt(i-1)+" ==> "+s2.charAt(j-1));
	        			 i--;
	        			 j--;
	        		 }
	        	 }
	         }
	         while(i!=0){
	        	 vec.add("delete : "+s1.charAt(i-1));
	        	 i--;
	         }
	         Collections.reverse(vec);
	         System.out.println(vec);
	         System.out.println(dp[n][m]);
	     }
	 }
	 static int ed(String s1,String s2,int[][] dp){
	     if(dp[s1.length()][s2.length()]!=0){
	         return dp[s1.length()][s2.length()];
	     }
	     if(s1.length()==0 || s2.length()==0){
	         return dp[s1.length()][s2.length()]=s1.length()==0?s2.length():s1.length();
	     }
	     if(s1.charAt(0)==s2.charAt(0)){
	         return dp[s1.length()][s2.length()]=ed(s1.substring(1),s2.substring(1),dp);
	     }
	     else{
	         int val1=ed(s1,s2.substring(1),dp);
	         int val2=ed(s1.substring(1),s2,dp);
	         int val3=ed(s1.substring(1),s2.substring(1),dp);
	         return dp[s1.length()][s2.length()]=1+Math.min(val1,Math.min(val2,val3));
	     }
	 }
}