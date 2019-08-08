package dprev;
import java.util.*;
public class minJumps {

	static int N=101;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=s.nextInt();
			}
//			int[] dp=new int[n];
//			Arrays.fill(dp,-1);
//			int val=mj(a, 0,dp);
//			if(val>=N){
//				System.out.println("-1");
//			}
//			else{
//				System.out.println(val);
//			}
			
			int val=mj1(a);
			if(val>=N){
				System.out.println("-1");
			}
			else{
				System.out.println(val);
			}
		}
	}

	static int mj(int[] a,int idx,int[] dp){
		if(dp[idx]!=-1){
			return dp[idx];
		}
		if(idx==a.length-1){
			return dp[idx]=0;
		}
		int min=N;
		for(int i=1;i<=a[idx] && idx+i<a.length;i++){
			int curr=mj(a, idx+i,dp);
			if(curr<min){
				min=curr;
			}
		}
		return dp[idx]=1+min;
	}
	
	static int mj1(int[] a){
		int n=a.length;
		int[] dp=new int[n];
		Arrays.fill(dp, N);
		dp[n-1]=0;
		for(int i=n-2;i>=0;i--){
			for(int j=1;j<=a[i] && i+j<n;j++){
				dp[i]=Math.min(dp[i], 1+dp[i+j]);
			}
		}
		return dp[0];
	}
}
