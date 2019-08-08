package dpCorrect;
import java.util.*;
public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=scn.nextInt();
			}
			System.out.println(msis(a, n));
		}
	}
	
	static int msis(int[] a,int n){
		int[] dp=new int[n];
		for(int i=0;i<n;i++){
			dp[i]=a[i];
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i] && dp[j]+a[i]>dp[i]){
					dp[i]=dp[j]+a[i];
				}
			}
		}
		int max=-1;
		for(int i=0;i<n;i++){
			if(dp[i]>max){
				max=dp[i];
			}
		}
		return max;
	}

}
