package GraphAdjacencyMatrix;
import java.util.*;
public class DirectedGraph {

	static class Graph{
		int V;
		int[][] adj;
		Graph(int V){
			this.V=V;
			this.adj=new int[V][V];
		}
		
		void addEdge(int u,int v,int wt){
			this.adj[u][v]=wt;
		}
		
		void display(){
			for(int i=0;i<V;i++){
				for(int j=0;j<V;j++){
					System.out.print(adj[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		//SINGLE SOURCE SHORTEST PATH
      	//O(V^3)
      	//WORK FOR NEGATIVE WEIGHTS
      	//DETECT NEGATIVE WEIGHT CYCLE
		void bellmanFord(int src){
			int[] dist=new int[V];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[src]=0;
			for(int i=0;i<(V-1);i++){
				for(int j=0;j<V;j++){
					for(int k=0;k<V;k++){
						if(adj[j][k]!=0 && dist[j]!=Integer.MAX_VALUE && dist[j]+adj[j][k]<dist[k]){
							dist[k]=dist[j]+adj[j][k];
						}
					}
				}
			}
			for(int j=0;j<V;j++){
				for(int k=0;k<V;k++){
					if(adj[j][k]!=0 && dist[j]!=Integer.MAX_VALUE && dist[j]+adj[j][k]<dist[k]){
						System.out.println("Negative Weight Cycle");
						return;
					}
				}
			}
			for(int i=0;i<V;i++){
				if(dist[i]==Integer.MAX_VALUE){
					System.out.print("-1 ");
				}
				else{
					System.out.print(dist[i]+" ");
				}
			}
		}
		
		//Problem may occur here (Look for the 0 distances)
		//On changing the order of i j and k the answer may change
		void floydWarshall(){
			int[][] dist=new int[V][V];
			for(int i=0;i<V;i++){
				for(int j=0;j<V;j++){
					if(i==j){
						dist[i][j]=0;
					}
					else if(adj[i][j]!=0){
						dist[i][j]=adj[i][j];
					}
					else{
						dist[i][j]=Integer.MAX_VALUE;
					}
				}
			}
			for(int k=0;k<V;k++){
				for(int i=0;i<V;i++){
					for(int j=0;j<V;j++){
						if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
							continue;
						}
						else if(dist[i][k]+dist[k][j]<dist[i][j]){
							dist[i][j]=dist[i][k]+dist[k][j];
						}
					}
				}
			}
			for(int i=0;i<V;i++){
				if(dist[i][i]<0){
					System.out.println("Negative Weight Cycle");
					return;
				}
			}
			for(int i=0;i<V;i++){
				for(int j=0;j<V;j++){
					System.out.print(dist[i][j]+" ");
				}
				System.out.println();
			}
		}
		
//		Count all possible walks from a source to a destination with exactly k edges
		
		int countPaths(int u,int v,int k,int[][][] dp){
			if(k==0 && u==v){
				return 1;
			}
			else if(k==0){
				return 0;
			}
			if(dp[u][v][k]!=0){
				return dp[u][v][k];
			}
			int retval=0;
			for(int i=0;i<V;i++){
				if(adj[u][i]!=0){
					retval+=(countPaths(i, v, k-1, dp));
				}
			}
			return dp[u][v][k]=retval;
		}
		
	}
	
	public static void main(String[] args) {
//		Graph g=new Graph(5);
//		g.addEdge(0, 1, -1);
//		g.addEdge(0, 2, 4);
//		g.addEdge(1, 2, 3);
//		g.addEdge(1, 3, 2);
//		g.addEdge(1, 4, 2);
//		g.addEdge(3, 1, 1);
//		g.addEdge(3, 2, 5);
//		g.addEdge(4, 3, -3);
//		g.display();
//		g.bellmanFord(0);
		
		Graph g=new Graph(4);
		g.addEdge(0, 1, 3);
		g.addEdge(0, 2, 6);
		g.addEdge(1, 3, 15);
		g.addEdge(1, 2, -2);
		g.addEdge(2, 3, 2);
		g.addEdge(3, 0, 1);
		g.display();
		g.floydWarshall();;
	}

}
