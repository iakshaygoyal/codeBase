package dpCorrect;
import java.util.*;
public class MininmumSquaresWhoseSumEqualsN {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(evaluate(n, new int[n+1]));
			System.out.println(evaluate(n));
		}
	}
	
	static int evaluate(int n,int[] dp){
		if(dp[n]!=0){
			return dp[n];
		}
		if(n<=3){
			return dp[n]=n;
		}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
			int sq=i*i;
			if(sq>n){
				break;
			}
			int current=1+evaluate(n-sq,dp);
			if(current<min){
				min=current;
			}
		}
		return dp[n]=min;
	}
	
	static int evaluate(int n){
		if(n<=3){
			return n;
		}
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		for(int i=4;i<(n+1);i++){
			int min=Integer.MAX_VALUE;
			for(int j=1;j<i;j++){
				int sq=j*j;
				if(sq>i){
					break;
				}
				int current=1+dp[i-sq];
				if(current<min){
					min=current;
				}
			}
			dp[i]=min;
		}
		return dp[n];
	}
}
