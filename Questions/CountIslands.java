package Questions;
import java.util.*;
public class CountIslands {

//	5
//	1 1 0 0 0
//	0 1 0 0 1
//	1 0 0 1 1
//	0 0 0 0 0
//	1 0 1 0 1
	
	static int[] xarr=new int[]{-1,-1,-1,0,0,1,1,1};
	static int[] yarr=new int[]{-1,0,1,-1,1,-1,0,1};
	static int n;
	static int[][] adj;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		n=scn.nextInt();
		adj=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				adj[i][j]=scn.nextInt();
			}
		}
		
		boolean[][] visited=new boolean[n][n];
		
		int cnt=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(adj[i][j]==1 && !visited[i][j]){
					dfs(visited, i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(boolean[][] visited,int x,int y){
		visited[x][y]=true;
		for(int i=0;i<8;i++){
			if(isSafe(visited, x+xarr[i], y+yarr[i])){
				dfs(visited, x+xarr[i], y+yarr[i]);
			}
		}
	}
	
	static boolean isSafe(boolean[][] visited,int x,int y){
		if(x>=0 && y>=0 && x<n && y<n && !visited[x][y] && adj[x][y]==1){
			return true;
		}
		return false;
	}

}
