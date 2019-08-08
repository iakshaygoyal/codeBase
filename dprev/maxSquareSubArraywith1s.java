package dprev;
import java.util.*;
public class maxSquareSubArraywith1s {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j]=s.nextInt();
			}
		}
		int[][] dp=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0 || j==0){
					dp[i][j]=a[i][j];
				}
				else{
					if(a[i][j]==1){
						dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]));
					}
					else{
						dp[i][j]=0;
					}
				}
			}
		}
		
		int max=-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(dp[i][j]>max){
					max=dp[i][j];
				}
			}
		}
		System.out.println(max);
	}

}
