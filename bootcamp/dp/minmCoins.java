package bootcamp.dp;
import java.util.*;
public class minmCoins {

	static int N=100000000;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int m=scn.nextInt();
		int[] c=new int[m];
		for(int i=0;i<m;i++){
			c[i]=scn.nextInt();
		}
		int val1=minmCoins(c, 0, n);
		if(val1>=N){
			System.out.println("-1");
		}
		else{
			System.out.println(val1);
		}
		int val2=minmCoins1(c, n);
		if(val2>=N){
			System.out.println("-1");
		}
		else{
			System.out.println(val2);
		}
	}
	
	public static int minmCoins(int[] c,int idx,int n){
		if(n==0){
			return 0;
		}
		if(idx==c.length){
			return N;
		}
		if(c[idx]>n){
			return minmCoins(c, idx+1, n);
		}
		return Math.min(1+minmCoins(c,idx,n-c[idx]),minmCoins(c,idx+1,n));
	}

	public static int minmCoins1(int[] c,int n){
		int[] dp=new int[n+1];
		dp[0]=0;
		for(int i=1;i<n+1;i++){
			dp[i]=N;
			for(int j=0;j<c.length;j++){
				if(c[j]<=i){
					dp[i]=Math.min(dp[i],dp[i-c[j]]);
				}
			}
//			//(YOU CANNOT ADD 1 TO INFINITE VALUE) if dp[i]=Integer.MAX_VALUE
//			if(dp[i]!=Integer.MAX_VALUE){
//				dp[i]+=1;
//			}
			dp[i]+=1;
		}
		return dp[n];
	}
}