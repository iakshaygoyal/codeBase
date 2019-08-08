package dpCorrect;
import java.util.*;
public class MinimumNumberOfJumps {

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
			int[] dp=new int[n];
			Arrays.fill(dp, -1);
			int val=mnoj(arr, n);
			if(val>=101){
				System.out.println("-1");
			}
			else{
				System.out.println(val);
			}		}
	}
	
	static int mnoj(int[] arr,int n){
		int[] dp=new int[n];
		Arrays.fill(dp, N);
		dp[0]=0;
		for(int i=0;i<n;i++){
			for(int j=1;j<=arr[i] && i+j<n;j++){
				if(dp[i]+1<dp[i+j]){
					dp[i+j]=dp[i]+1;
				}
			}
		}
		return dp[n-1];
	}

}
