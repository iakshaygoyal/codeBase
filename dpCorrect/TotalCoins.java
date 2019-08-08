package dpCorrect;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TotalCoins {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        System.out.println(getWays(n, c));
    }

    static long getWays(int amt, int[] c){
    	int n=c.length;
    	long[][] dp=new long[n+1][amt+1];
    	for(int i=0;i<(n+1);i++){
    		for(int j=0;j<(amt+1);j++){
    			if(j==0){
    				dp[i][j]=1;
    			}
    			else if(i==0){
    				dp[i][j]=0;
    			}
    			else if(c[i-1]>j){
    				dp[i][j]=dp[i-1][j];
    			}
    			else{
    				dp[i][j]=dp[i-1][j]+dp[i][j-c[i-1]];
    			}
    		}
    	}
    	return dp[n][amt];
    }
}
