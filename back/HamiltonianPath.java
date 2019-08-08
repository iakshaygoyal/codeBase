package back;
import java.util.*;
public class HamiltonianPath {

	static int V;
	static int[][] adj;
	static boolean[] visited;
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			V=scn.nextInt();
			adj=new int[V][V];
			visited=new boolean[V];
			int e=scn.nextInt();
			for(int j=0;j<e;j++){
				int x=scn.nextInt()-1;
				int y=scn.nextInt()-1;
				adj[x][y]=1;
				adj[y][x]=1;
			}
			int u;
			for(u=0;u<V;u++){
				visited[u]=true;
				if(isHamiltonian(u, 0)){
					System.out.println("1");
					break;
				}
				Arrays.fill(visited, false);
			}
			if(u==V){
				System.out.println("0");
			}
			
		}
	}
	
	static boolean isHamiltonian(int u,int cnt){
		if(cnt==V-1){
			return true;
		}
		
		for(int v=0;v<V;v++){
			if(adj[u][v]==1 && !visited[v]){
				visited[v]=true;
				if(isHamiltonian(v, cnt+1)){
					return true;
				}
				visited[v]=false;
			}
		}
		return false;
	}
}