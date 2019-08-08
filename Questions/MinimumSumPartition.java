package Questions;
import java.util.*;
public class MinimumSumPartition {

	static int total;
	static int n;
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			total=0;
			n=scn.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=scn.nextInt();
				total+=(a[j]);
			}
			System.out.println(total);
			System.out.println(minDifference(a, 0, 0, new int[n+1][total+1]));
			System.out.println(minDifference(a));
		}
	}
	
	static int minDifference(int[] a){
		int[][] dp=new int[n+1][total+1];
		for(int i=n;i>=0;i--){
			for(int j=total;j>=0;j--){
				if(i==n){
					dp[i][j]=Math.abs(2*j-total);
				}
				else if(j+a[i]>total){//We don't require these 
					continue;
				}
				else{
					dp[i][j]=Math.min(dp[i+1][j], dp[i+1][j+a[i]]);
				}
			}
		}
		return dp[0][0];
	}
	
	static int minDifference(int[] a,int idx,int sum,int[][] dp){
		if(dp[idx][sum]!=0){
			return dp[idx][sum];
		}
		if(idx==n){
			return dp[idx][sum]=Math.abs(2*sum-total);
		}
		return dp[idx][sum]=Math.min(minDifference(a, idx+1, sum, dp)
				,minDifference(a, idx+1, sum+a[idx], dp));
	}
}