package dpCorrect;
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
		System.out.println(maxPoints(matrix, ROW-1, 0, COL-1, new int[ROW][COL][COL]));
	}
	
	static int maxPoints(int[][] matrix,int x,int y1,int y2,int[][][] dp){
		if(!isValid(x, y1, y2)){
			return Integer.MIN_VALUE;
		}
		if(dp[x][y1][y2]!=0){
			return dp[x][y1][y2];
		}
		if(x==0 && y1==0 && y2==COL-1){
			return dp[x][y1][y2]=matrix[x][y1]+matrix[x][y2];
		}
		else if(x==0){
			return dp[x][y1][y2]=Integer.MIN_VALUE;
		}
		int retval=0;
		if(y1==y2){
			retval+=(matrix[x][y1]);
		}
		else{
			retval+=(matrix[x][y1]+matrix[x][y2]);
		}
		int max=0;
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				max=Math.max(max, maxPoints(matrix, x-1, y1+i, y2+j, dp));
			}
		}
		retval+=(max);
		return dp[x][y1][y2]=retval;
	}
	
	static boolean isValid(int x,int y1,int y2){
		if(x<0 || x>=ROW || y1<0 || y1>=COL || y2<0 || y2>=COL){
			return false;
		}
		return true;
	}

}
