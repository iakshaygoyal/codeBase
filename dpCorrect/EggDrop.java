package dpCorrect;
import java.util.*;
public class EggDrop {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int k=scn.nextInt();
	        System.out.println(eggDrop(n,k));
	    }
	    scn.close();
	}
	
	static int eggDrop(int n,int k){
	    int[][] dp=new int[n+1][k+1];
	    
	    for(int i=1;i<(n+1);i++){
	        for(int j=0;j<(k+1);j++){
	            if(j==0 || j==1 || i==1){
	                dp[i][j]=j;
	            }
	            else{
	                dp[i][j]=Integer.MAX_VALUE;
	                for(int l=1;l<=j;l++){
	                    dp[i][j]=Math.min(dp[i][j]
	                    ,1+Math.max(dp[i][j-l],dp[i-1][l-1]));
	                }
	            }
	        }
	    }
	    
	    return dp[n][k];
	}
}