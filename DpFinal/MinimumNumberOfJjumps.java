package DpFinal;
import java.util.*;
public class MinimumNumberOfJjumps {

	static int N=101;
	public static void main(String[] args) {		
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=scn.nextInt();
			}
			int val=mnoj(arr, n);
			if(val>=101){
				System.out.println("-1");
			}
			else{
				System.out.println(val);
			}		
		}
	}
	
	static int mnoj(int[] arr,int n){
		int[] dp=new int[n];
		for(int i=n-1;i>=0;i--){
			if(i==n-1){
				dp[i]=0;
			}
			else{
				dp[i]=N;
				for(int j=1;j<=arr[i] && (i+j)<n;j++){
					dp[i]=Math.min(dp[i], dp[i+j]);
				}
				dp[i]+=1;
			}
		}
		return dp[0];
	}

}
