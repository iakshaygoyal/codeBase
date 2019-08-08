package graphAL;
import java.util.*;
public class ShortestPathOfSizeK {

	static class Graph{
		
		class Node{
			int vtx;
			int wt;
			Node(int vtx,int wt){
				this.vtx=vtx;
				this.wt=wt;
			}
			public String toString(){
				return vtx+"";
			}
		}
		
		int V;
		Vector<Node>[] adj;
		
		Graph(int V){
			this.V=V;
			this.adj=new Vector[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector<>(0,1);
			}
		}
		
		void addEdge(int u,int v,int wt){
			adj[u].add(new Node(v,wt));
		}
		
		void display(){
			for(int i=0;i<V;i++){
				System.out.println(i+" => "+adj[i]);
			}
		}
		
		int shortestPath(int u,int v,int k, int[][][] dp){
			if(k==0 && u==v){
				return 0;
			}
			else if(k==0 || u==v){
				return Integer.MAX_VALUE;
			}
			if(dp[u][v][k]!=0){
				return dp[u][v][k];
			}
			int retval=Integer.MAX_VALUE;
			for(Node node:adj[u]){
				int value=shortestPath(node.vtx, v, k-1, dp);
				if(value!=Integer.MAX_VALUE){
					retval=Math.min(retval, node.wt+value);
				}
			}
			return dp[u][v][k]=retval;
		}
		
		//On changing the order of i,j,k in the loop answer would change
		int shortestPath1(int u,int v,int K){
			int[][][] dp=new int[V][V][K+1];
			for(int k=0;k<(K+1);k++){
				for(int i=0;i<V;i++){
					for(int j=0;j<V;j++){
						if(k==0 && i==j){
							dp[i][j][k]=0;
						}
						else if(k==0 || i==j){
							dp[i][j][k]=Integer.MAX_VALUE;
						}
						else{
							dp[i][j][k]=Integer.MAX_VALUE;
							Vector<Node> vector=adj[i];
							for(Node node:vector){
								if(dp[node.vtx][v][k-1]!=Integer.MAX_VALUE){
									dp[i][j][k]=Math.min(dp[i][j][k], node.wt+dp[node.vtx][v][k-1]);
								}
							}
						}
					}
				}
			}
			return dp[u][v][K];
		}
	}
	
	public static void main(String[] args) {
		Graph g=new Graph(5);
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 3);
		g.addEdge(0, 3, 2);
		g.addEdge(0, 4, 4);
		g.addEdge(1, 3, 7);
		g.addEdge(2, 3, 6);
		g.addEdge(4, 3, 4);
		g.addEdge(4, 4, 14);
		g.display();
		System.out.println(g.shortestPath(0, 3, 2, new int[6][6][3]));
		System.out.println(g.shortestPath1(0, 3, 2));
	}
}
