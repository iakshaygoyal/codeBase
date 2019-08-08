package Questions.DpWithBitmasking;

import java.util.Scanner;

public class NQueen {
	static int n;
	static int ans;
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			ans=0;
			n=scn.nextInt();
			int[][] sol=new int[n][n];
			nQueen(sol, 0, "");
			System.out.println(ans);
		}
		scn.close();
	}
	
	static void nQueen(int[][] sol,int col,String s){
		if(col==n){
			ans++;
			return;
		}
		for(int row=0;row<n;row++){
			if(isSafe(row, col, sol)){
				sol[row][col]=1;
				nQueen(sol, col+1, s+(row+1)+" ");
				sol[row][col]=0;
			}
		}
		return;
	}
	
	static boolean isSafe(int row,int col,int[][] sol){
		int x=row;
		int y=col-1;
		while(y>=0){
			if(sol[x][y--]==1){
				return false;
			}
		}
		
		x=row-1;
		y=col-1;
		while(x>=0 && y>=0){
			if(sol[x--][y--]==1){
				return false;
			}
		}
		
		x=row+1;
		y=col-1;
		while(x<n && y>=0){
			if(sol[x++][y--]==1){
				return false;
			}
		}
		return true;
	}
}