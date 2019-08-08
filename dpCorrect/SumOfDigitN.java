package dpCorrect;
import java.util.*;
public class SumOfDigitN {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(computeSum(n,new int[n+1]));
		}
	}
	
	static int computeSum(int n, int[] dp){
		if(dp[n]!=0){
			return dp[n];
		}
		if(n<10){
			return dp[n]=(n*(n+1))/2;
		}
		int d=(int)(Math.log(n)/Math.log(10));
		int p=(int)Math.pow(10, d);
		int msd=n/p;
		
		return dp[n]=(msd*computeSum(p-1, dp))
				+(((msd)*(msd-1)*p)/2)
				+(((n%p)+1)*msd)
				+(computeSum(n%p, dp));
	}

}
