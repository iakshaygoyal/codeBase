package DpFinal;
import java.util.*;
public class MaximumPointsInAGridUsing2Traversals {

//	5
//	4
//	3 6 8 2
//	5 2 4 3
//	1 1 20 10
//	1 1 20 10
//	1 1 20 10
	
	static int ROW,COL;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		ROW=scn.nextInt();
		COL=scn.nextInt();
		int[][] matrix=new int[ROW][COL];
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				matrix[i][j]=scn.nextInt();
			}
		}
		System.out.println(maxPoints(matrix));
	}
	
	static int maxPoints(int[][] matrix){
		int[][][] dp=new int[ROW][COL][COL];
		for(int i=ROW-1;i>=-0;i--){
			for(int j=COL-1;j>=0;j--){
				for(int k=0;k<COL;k++){
					if(i==ROW-1 && j==0 && k==COL-1){
						dp[i][j][k]=matrix[i][j]+matrix[i][k];
					}
					else if(i==ROW-1){
						dp[i][j][k]=Integer.MIN_VALUE;
					}
					else{
						if(j==k){
							dp[i][j][k]=matrix[i][j];
						}
						else{
							dp[i][j][k]=matrix[i][j]+matrix[i][k];
						}
						int max=Integer.MIN_VALUE;
						for(int l=-1;l<=1;l++){
							for(int m=-1;m<=1;m++){
								if(isValid(i+1, j+l, k+m)){
									max=Math.max(max, dp[i+1][j+l][k+m]);
								}
							}
						}
						dp[i][j][k]+=(max);
					}
				}
			}
		}
		return dp[0][0][COL-1];
	}
	
	static boolean isValid(int x,int y1,int y2){
		if(x<0 || x>=ROW || y1<0 || y1>=COL || y2<0 || y2>=COL){
			return false;
		}
		return true;
	}

}
