package dpCorrect;
import java.util.*;
public class MaximumSizeSquareSubMatrixWithAll1s {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				arr[i][j]=scn.nextInt();
			}
		}
		int[][] dp=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0 || j==0){
					dp[i][j]=arr[i][j];
				}
				else if(arr[i][j]==0){
					dp[i][j]=0;
				}
				else{
					dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
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
