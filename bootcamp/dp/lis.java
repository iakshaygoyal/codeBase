package bootcamp.dp;
import java.util.*;
import java.lang.*;
public class lis {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		int[] dp=new int[n];
		for(int i=0;i<n;i++){
			dp[i]=1;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i]){
					dp[i]=Math.max(dp[i], 1+dp[j]);
				}
			}
		}
		int max=dp[0];
		for(int i=1;i<n;i++){
			if(dp[i]>max){
				max=dp[i];
			}
		}
		
		System.out.println(max);

	}

}
