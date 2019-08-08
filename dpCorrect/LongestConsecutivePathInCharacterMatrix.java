package dpCorrect;
import java.util.*;
public class LongestConsecutivePathInCharacterMatrix {

	static int[] xarr={0,0,1,1,1,-1,-1,-1};
	static int[] yarr={1,-1,-1,0,1,-1,0,1};
	static int ROW;
	static int COL;
	static int[][] dp;
	public static void main(String[] args) {
		char[][] matrix={{'a','c','d'}
		,{'h','b','a'}
		,{'i','g','f'}};
		ROW=matrix.length;
		COL=matrix[0].length;
		dp=new int[ROW][COL];
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			char c=scn.next().charAt(0);
			System.out.println(longestPath(matrix, c));
		}
		scn.close();
	}
	
	static int longestPath(char[][] matrix,char c){
		int max=0;
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				if(matrix[i][j]==c){
					for(int k=0;k<8;k++){
						int current=1+longestPath(matrix, i+xarr[k], j+yarr[k], c);
						if(current>max){
							max=current;
						}
					}
				}
			}
		}
		return max;
	}
	
	static int longestPath(char[][] matrix,int i,int j,char prev){
		if(!isValid(i, j) || !isAdjacent(prev, matrix[i][j])){
			return 0;
		}
		if(dp[i][j]!=0){
			return dp[i][j];
		}
		int max=0;
		for(int k=0;k<8;k++){
			int current=1+longestPath(matrix, i+xarr[k], j+yarr[k], matrix[i][j]);
			if(current>max){
				max=current;
			}
		}
		return dp[i][j]=max;
	}
	
	static boolean isValid(int x,int y){
		if(x<0 || y<0 || x>=ROW || y>=COL){
			return false;
		}
		return true;
	}
	
	static boolean isAdjacent(char prev,char current){
		return (current-prev)==1;
	}

}