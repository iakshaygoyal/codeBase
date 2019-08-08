package graphAL;
import java.util.*;
public class CountPathsOfSizeK {

	//Considering self loop (since no (i==j || k==0))
	static class Graph{
		int V;
		Vector<Integer>[] adj;
		
		Graph(int V){
			this.V=V;
			this.adj=new Vector[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector<>(0,1);
			}
		}
		
		void addEdge(int u,int v){
			adj[u].add(v);
		}
		
		int countPaths(int u,int v,int K){
			int[][][] dp=new int[V][V][K+1];
			for(int i=0;i<V;i++){
				for(int j=0;j<V;j++){
					for(int k=0;k<(K+1);k++){
						if(k==0 && i==j){
							dp[i][j][k]=1;
						}
						else if(k==0){
							dp[i][j][k]=0;
						}
						else{
							dp[i][j][k]=0;
							Vector<Integer> vector=adj[i];
							for(Integer l:vector){
								dp[i][j][k]+=(countPaths(l, v, k-1));
							}
						}
					}
				}
			}
			return dp[u][v][K];
		}
	}
	
	public static void main(String[] args) {
//		Graph g=new Graph(4);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//		g.addEdge(0, 3);
//		g.addEdge(1, 3);
//		g.addEdge(2, 3);
//		System.out.println(g.countPaths(0, 3, 2));
		
		Graph g=new Graph(5);
		g.addEdge(0, 4);
		g.addEdge(1, 0);
		g.addEdge(1, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 0);
		g.addEdge(2, 2);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 3);
		g.addEdge(4, 4);
		System.out.println(g.countPaths(1, 2, 3));
	}
}
