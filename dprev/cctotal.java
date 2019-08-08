package dprev;
import java.io.*;
import java.util.*;
public class cctotal {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[] c=new int[m];
        for(int i=0;i<m;i++){
            c[i]=s.nextInt();
        }
        System.out.println(tc(c,n));
//        System.out.println(cc(c,0,n,new long[m][n+1]));
    }
    
    static long tc(int[] c,int n){
        int m=c.length;
        long[][] dp=new long[m][n+1];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<m;i++){
            for(int j=1;j<=n;j++){
                if(i==0){
                    if(c[i]<=j){
                        dp[i][j]=dp[i][j-c[i]];
                    }
                    else{
                        dp[i][j]=0;
                    }
                }
                else{
                    if(c[i]<=j){
                        dp[i][j]=dp[i-1][j]+dp[i][j-c[i]];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        print(dp, c, m-1, n, new Vector<>(0,1));
        return dp[m-1][n];
    }
    
    static void print(long[][] dp,int[] a,int i,int j,Vector<Integer> vec){
    	if(j==0){
    		System.out.println(vec);
    		return;
    	}
    	if(dp[i][j]==0){
    		return;
    	}
    	if(i!=0){
    		print(dp, a, i-1, j, vec);
    	}
    	if(j>=a[i]){
    		Vector<Integer> vec1=new Vector<>(vec);
    		vec1.add(a[i]);
        	print(dp, a, i, j-a[i], vec1);
    	}
    }
    
    public static long cc(int[] c,int idx,int n,long[][] dp){
        if(idx==c.length){
            return 0;
        }
        if(dp[idx][n]!=0){
            return dp[idx][n];
        }
        if(n==0){
            return 1;
        }
        if(c[idx]>n){
            return dp[idx][n]=cc(c,idx+1,n,dp);
        }
        return dp[idx][n]=cc(c,idx+1,n,dp) + cc(c,idx,n-c[idx],dp);
    }
}