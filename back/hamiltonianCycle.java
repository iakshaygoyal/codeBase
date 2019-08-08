package back;
import java.util.*;

//2
//5
//7
//0 1
//0 3
//1 2
//1 3
//1 4
//2 4
//3 4
//5
//6
//0 1
//0 3
//1 2
//1 3
//1 4
//2 4

public class hamiltonianCycle {
	
	static int V;
	static int[][] adj;
	static int[] path;
	static boolean[] visited;
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			V=scn.nextInt();
			adj=new int[V][V];
			path=new int[V];
			visited=new boolean[V];
			int e=scn.nextInt();
			for(int j=0;j<e;j++){
				int x=scn.nextInt();
				int y=scn.nextInt();
				adj[x][y]=1;
				adj[y][x]=1;
			}
			Arrays.fill(path, -1);
			path[0]=0;
			if(isHamiltonian(1)){
				for(int j=0;j<V;j++){
					System.out.print(path[j]+" ");
				}
				System.out.println(path[0]);
			}
			else{
				System.out.println("No Hamiltonian Cycle");
			}
		}
	}
	
	static boolean isHamiltonian(int pos){
		if(pos==V){
			if(adj[path[pos-1]][path[0]]==1){
				return true;
			}
			return false;
		}
		for(int v=0;v<V;v++){
			if(adj[path[pos-1]][v]==1 && !visited[v]){
				visited[v]=true;
				path[pos]=v;
				if(isHamiltonian(pos+1)){
					return true;
				}
				visited[v]=false;
				path[pos]=-1;
			}
		}
		return false;
	}
}