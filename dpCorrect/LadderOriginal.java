package dpCorrect;
import java.util.*;
public class LadderOriginal {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] steps=new int[n];
		for(int i=0;i<n;i++){
			steps[i]=scn.nextInt();
		}
		int N=scn.nextInt();
		System.out.println(evaluate(steps, N));
	}
	
	static int evaluate(int[] steps,int N){
		int n=steps.length;
		int[] dp=new int[N+1];
		dp[0]=1;
		for(int i=1;i<N+1;i++){
			for(int j=0;j<n;j++){
				if(steps[j]<=i){
					dp[i]+=(dp[i-steps[j]]);
				}
			}
		}
		return dp[N];
	}

}
