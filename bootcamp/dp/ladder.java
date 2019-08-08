package bootcamp.dp;

import java.util.*;

public class ladder {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int k=scn.nextInt();
			System.out.println(ladder1(n,k,new int[n+1]));
			System.out.println(ladder(n,k));
			System.out.println(ladder2(n,k));
			System.out.println(ladder3(n, k));
		}
	}
	
	//COMPLEXITY-EXPO
	public static int ladder(int n,int k){
		if(n==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		int retval=0;
		for(int i=1;i<=k;i++){
			retval+=(ladder(n-i,k));
		}
		return retval;
	}
	
	//COMPLEXITY-(O(NK))
	public static int ladder1(int n,int k,int[] dp){
		if(n==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(dp[n]!=0){
			return dp[n];
		}
		else{
			int retval=0;
			for(int i=1;i<=k;i++){
				retval+=(ladder1(n-i,k,dp));
			}
			dp[n]=retval;
			return retval;
		}
	}
	
	//COMPLEXITY-(O(NK))
	public static int ladder2(int n,int k){
		int[] dp=new int[n+1];
		dp[0]=1;
		for(int i=1;i<n+1;i++){
			for(int j=1;j<=k;j++){
				if(i-j>=0){
					dp[i]+=dp[i-j];
				}
			}
		}
		return dp[n];
	}
	
	//COMPLEXITY-(O(N))
	public static int ladder3(int n,int k){
		int[] dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			dp[i]=2*dp[i-1];
			if(i-(k+1)>=0){
				dp[i]-=dp[i-(k+1)];
			}
		}
		return dp[n];
	}

}