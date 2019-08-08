package bootcamp.dp;
import java.io.*;
import java.util.*;

public class hkAbbreviation {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
        	String a=s.next();
        	String b=s.next();
        	String c=b.toLowerCase();
        	Object[][] dp=new Object[a.length()+1][b.length()+1];
        	for(int j=0;j<dp.length;j++){
        		for(int k=0;k<dp[0].length;k++){
        			dp[j][k]=null;
        		}
        	}
        	if(check(a, b, c,dp)){
        		System.out.println("YES");
        	}
        	else{
        		System.out.println("NO");
        	}
        }
    }
    
    public static boolean check(String a,String b,String c,Object[][] dp){
    	if(dp[a.length()][b.length()]!=null){
    		return (boolean)dp[a.length()][b.length()];
    	}
    	if(a.length()==0 && b.length()==0){
    		return true;
    	}
    	if(a.length()==0 && b.length()!=0){
    		return false;
    	}
    	if(a.length()!=0 && b.length()!=0 && (a.charAt(0)!=b.charAt(0) && a.charAt(0)!=c.charAt(0))){
    		if(a.charAt(0)-'A'>=0 && a.charAt(0)-'A'<26){
    			return false;
    		}
    		dp[a.length()][b.length()]=check(a.substring(1),b,c,dp);
    		return (boolean)dp[a.length()][b.length()];
    	}
    	if(a.length()!=0 && b.length()!=0 && (a.charAt(0)==b.charAt(0) || a.charAt(0)==c.charAt(0))){
    		dp[a.length()][b.length()]= check(a.substring(1),b.substring(1),c.substring(1),dp) || check(a.substring(1),b,c,dp);
    		return (boolean)dp[a.length()][b.length()];
    	}
    	if(b.length()==0 && (a.charAt(0)-'A'>=0 && a.charAt(0)-'A'<26)){
    		dp[a.length()][b.length()]=false;
    		return false;
    	}
    	else{
    		dp[a.length()][b.length()]= check(a.substring(1),b,c,dp);
    		return (boolean)dp[a.length()][b.length()];
    	}
    }
}