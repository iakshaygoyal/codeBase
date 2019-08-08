package back;
import java.util.Scanner;
public class knightTour {

	static int n;
	static int[] xarr=new int[]{-1,-1,-2,-2,1,1,2,2};
	static int[] yarr=new int[]{-2,2,-1,1,-2,2,-1,1};
	public static void main(String[] args){
		Scanner scn=new Scanner(System.in);
		n=scn.nextInt();
		int[][] sol=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				sol[i][j]=-1;
			}
		}
		sol[0][0]=0;
		kt(0, 0, sol, 1);
	}
	
	static boolean kt(int x,int y,int[][] sol,int move){
		if(move==(n*n)){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(sol[i][j]+"  ");
				}
				System.out.println();
			}
			return true;
		}
		for(int i=0;i<8;i++){
			int nextx=x+xarr[i];
			int nexty=y+yarr[i];
			if(isSafe(nextx, nexty, sol)){
				sol[nextx][nexty]=move;
				if(kt(nextx, nexty, sol, move+1)){
					return true;
				}
				sol[nextx][nexty]=-1;
			}
		}
		return false;
	}
	
	static boolean isSafe(int x,int y,int[][] sol){
		if(x>=0 && x<n && y>=0 && y<n && sol[x][y]==-1){
			return true;
		}
		return false;
	}
}