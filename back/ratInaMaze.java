package back;

import java.util.Scanner;

public class ratInaMaze {

	static int n;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = s.nextInt();
			}
		}
		
		int[][] sol = new int[n][n];
		sol[0][0] = 1;
		
		if(rm(0, 0, arr, sol)){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					System.out.print(sol[i][j] + " ");
				}
				System.out.println();
			}
		}
		else{
			System.out.println("Solution do not exist");
		}
	}
	
	public static boolean rm(int x, int y, int[][] arr, int[][] sol){
		if(x == n-1 && y == n-1){
			sol[x][y] = 1;
			return true;
		}
		
		int nextx = x + 1;
		int nexty = y;
		if(feasiableMove(nextx, nexty, arr)){
			sol[nextx][nexty] = 1;
			if(rm(nextx, nexty, arr, sol)){
				return true;
			}
			else{
				sol[nextx][nexty] = 0;//backtrack
			}
		}
		
		nextx = x;
		nexty = y + 1;
		if(feasiableMove(nextx, nexty, arr)){
			sol[nextx][nexty] = 1;
			if(rm(nextx, nexty, arr, sol)){
				return true;
			}
			else{
				sol[nextx][nexty] = 0;//backtrack
			}
		}
		
		return false;
	}
	
	public static boolean feasiableMove(int x, int y, int[][] arr){
		return (x>=0 && x<n && y>=0 && y<n && arr[x][y] == 1);
	}

}
