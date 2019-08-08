package DpFinal;
import java.util.*;
public class MinimumCostToReachDestination {

//	4
//	0 15 80 90
//    -1 0 40 50
//    -1 -1 0 70
//    -1 -1 -1 0
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[][] matrix=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				matrix[i][j]=scn.nextInt();
			}
		}
		System.out.println(minimumCost(matrix, n));
	}
	
	static int minimumCost(int[][] matrix,int n){
		int[][] dp=new int[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(j==n-1){
					dp[i][j]=0;
				}
				else{
					dp[i][j]=matrix[i][n-1];
					for(int k=i+1;k<n;k++){
						dp[i][j]=Math.min(dp[i][j], matrix[i][k]+dp[k][j]);
					}
				}
			}
		}
		return dp[0][0];
	}

}