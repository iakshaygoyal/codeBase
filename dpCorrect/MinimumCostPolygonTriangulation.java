package dpCorrect;
import java.util.*;

//5
//0 0
//1 0
//2 1
//1 2
//0 2

public class MinimumCostPolygonTriangulation {

	static class pair{
		int x;
		int y;
		pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		pair[] vertex=new pair[n];
		for(int i=0;i<n;i++){
			vertex[i]=new pair(scn.nextInt(),scn.nextInt());
		}
		System.out.println(minmCost(vertex, 0, n-1, new double[n][n]));
		System.out.println(minmCost(vertex, n));
	}
	
	static double minmCost(pair[] vertex,int si,int ei, double[][] dp){
		if(dp[si][ei]!=0){
			return dp[si][ei];
		}
		if(si+1==ei){
			return dp[si][ei]=0;
		}
		double min=Double.MAX_VALUE;
		for(int i=si+1;i<ei;i++){
			double val=minmCost(vertex, si, i, dp)
					+minmCost(vertex, i, ei, dp)
					+perimeter(vertex,si,i,ei);
			if(val<min){
				min=val;
			}
		}
		return dp[si][ei]=min;
	}

	static double perimeter(pair[] vertex, int i, int j, int k) {
		return distance(vertex,i,j)
				+distance(vertex,j,k)
				+distance(vertex,k,i);
	}

	static double distance(pair[] vertex, int i, int j) {
		return Math.sqrt(Math.pow((vertex[i].x-vertex[j].x), 2) 
				+ Math.pow((vertex[i].y-vertex[j].y), 2));
	}
	
	static double minmCost(pair[] vertex, int n){
		double[][] dp=new double[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(i+1==j){
					dp[i][j]=0;
				}
				else{
					double min=Double.MAX_VALUE;
					for(int k=i+1;k<j;k++){
						double val=dp[i][k]+dp[k][j]
								+perimeter(vertex, i, j, k);
						if(val<min){
							min=val;
						}
					}
					dp[i][j]=min;
				}
			}
		}
		return dp[0][n-1];
	}

}