package bootcamp.dp;
import java.util.*;
import java.lang.*;
public class spojKnapsack {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int w=s.nextInt();
		int n=s.nextInt();
		int[] size=new int[n];
		int[] value=new int[n];
		for(int i=0;i<n;i++){
			size[i]=s.nextInt();
			value[i]=s.nextInt();
		}
		System.out.println(kpsk(size, value, 0, w, new int[n][w+1]));
	}
	
	public static int kpsk(int[] size,int[] value,int idx,int w,int[][] dp){
		if(w==0 || idx==size.length){
			return 0;
		}
		if(dp[idx][w]!=0){
			return dp[idx][w];
		}
		if(size[idx]>w){
			return dp[idx][w]=kpsk(size, value, idx+1, w,dp);
		}
		return dp[idx][w]=Math.max(value[idx]+kpsk(size, value, idx+1, w-size[idx],dp), kpsk(size, value, idx+1, w,dp));
	}

}
