package dprev;

import java.util.*;
import java.lang.*;
import java.io.*;
class lcs
 {
	public static void main (String[] args){
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
	    for(int k=0;k<t;k++){
	        int n=s.nextInt();
	        int m=s.nextInt();
	        String s1=s.next();
	        String s2=s.next();
//	        System.out.println(lcs(s1,s2,new int[n+1][m+1]));
	        
	        int[][] dp=new int[n+1][m+1];
	        for(int i=0;i<=n;i++){
	            for(int j=0;j<=m;j++){
	                if(i==0 || j==0){
	                	dp[i][j]=0;
	                    continue;
	                }
	                if(s1.charAt(i-1)==s2.charAt(j-1)){
	                    dp[i][j]=1+dp[i-1][j-1];
	                }
	                else{
	                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	                }
	            }
	        }
	        int i=n;
	        int j=m;
	        Vector<Character> vec=new Vector<>(0,1);
	        while(i!=0 && j!=0){
	        	if(s1.charAt(i-1)==s2.charAt(j-1)){
	        		vec.add(s1.charAt(i-1));
	        		i--;
	        		j--;
	        	}
	        	else{
	        		if(dp[i-1][j]>dp[i][j-1]){
	        			i--;
	        		}
	        		else{
	        			j--;
	        		}
	        	}
	        }
	        Collections.reverse(vec);
	        System.out.println(vec);
	        System.out.println(dp[n][m]);
	    }
	}
	
	static int lcs(String s1,String s2,int[][] dp){
	    if(dp[s1.length()][s2.length()]!=0){
	        return dp[s1.length()][s2.length()];
	    }
	    if(s1.length()==0 || s2.length()==0){
	        return dp[s1.length()][s2.length()]=0;
	    }
	    if(s1.charAt(0)==s2.charAt(0)){
	        return dp[s1.length()][s2.length()]=1+lcs(s1.substring(1),s2.substring(1),dp);
	    }
	    else{
	        int val1=lcs(s1,s2.substring(1),dp);
	        int val2=lcs(s1.substring(1),s2,dp);
	        return dp[s1.length()][s2.length()]=Math.max(val1,val2);
	    }
	}
}
