package dpCorrect;
import java.util.*;
public class MinimumPointsToReachDestination {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int row=scn.nextInt();
			int col=scn.nextInt();
			int[][] a=new int[row][col];
			for(int j=0;j<row;j++){
				for(int k=0;k<col;k++){
					a[j][k]=scn.nextInt();
				}
			}
			System.out.println(minimumPoints(a, row, col));
		}
	}
	
	static int minimumPoints(int[][] a,int row,int col){
		int[][] dp=new int[row][col];
		for(int i=row-1;i>=0;i--){
			for(int j=col-1;j>=0;j--){
				if(i==row-1 && j==col-1){
					dp[i][j]=(a[i][j]>0?1:Math.abs(a[i][j])+1);
				}
				else if(i==row-1){
					dp[i][j]=Math.max(dp[i][j+1]-a[i][j], 1);
				}
				else if(j==col-1){
					dp[i][j]=Math.max(dp[i+1][j]-a[i][j], 1);
				}
				else{
					dp[i][j]=Math.max(Math.min(dp[i+1][j], dp[i][j+1])-a[i][j], 1);
				}
			}
		}
		return dp[0][0];
	}
}