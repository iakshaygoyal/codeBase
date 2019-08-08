package dp;

import java.util.Scanner;

public class minCostPath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n ; i++){
			for(int j=0; j<m; j++){
				arr[i][j] = s.nextInt();
			}
		}
		
		int si = s.nextInt();
		int ei = s.nextInt();
		
		System.out.println(mcp(arr, si, ei));
		System.out.println(mcp(arr, si, ei, new int[n][m]));
		System.out.println(mcp2(arr, si, ei));

	}
	 
	//you cannot add any positive no. to maxm integer value possible
	public static int mcp(int[][] arr, int i, int j){
		if(i == 0 && j == 0){
			return arr[i][j];
		}
		else if(i < 0 || j <0){
			return Integer.MAX_VALUE;
		}
		
		int factor1 = mcp(arr, i, j-1);
		int factor2 = mcp(arr, i-1, j);
		int factor3 = mcp(arr, i-1, j-1);
		
		return Math.min(factor1, Math.min(factor2, factor3)) + arr[i][j];
	}
	
	//Memoization
	public static int mcp(int[][] arr, int i, int j, int[][] storage){
		if(i < 0 || j <0){
			return Integer.MAX_VALUE;
		}
		if(storage[i][j] != 0){
			return storage[i][j];
		}
		
		int retval;
		
		if(i == 0 && j == 0){
			retval = arr[i][j];
		}
		else{
			int factor1 = mcp(arr, i, j-1, storage);
			int factor2 = mcp(arr, i-1, j, storage);
			int factor3 = mcp(arr, i-1, j-1, storage);
		
			retval = Math.min(factor1, Math.min(factor2, factor3)) + arr[i][j];
		}
		
		storage[i][j] = retval;
		return retval;
	}
	
	//Tabulation
	public static int mcp2(int[][] arr, int si, int ei){
		int[][] temp = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(i==0 && j==0){
					temp[i][j] = arr[0][0];
				}
				else if(i==0){
					temp[i][j] = temp[i][j-1] + arr[i][j];
				}
				else if(j==0){
					temp[i][j] = temp[i-1][j] + arr[i][j];
				}
				else{
					temp[i][j] = Math.min(temp[i-1][j], Math.min(temp[i][j-1], temp[i-1][j-1])) + arr[i][j];
				}
			}
		}
		
		return temp[si][ei];
	}

}
