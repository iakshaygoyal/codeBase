package GraphAdjacencyMatrix;
import java.util.*;
public class UndirectedGraph {
	
	static class Graph{
		int V;
		int[][] adj;
		Graph(int V){
			this.V=V;
			adj=new int[V][V];
		}
		
		void addEdge(int u,int v,int wt){
			adj[u][v]=wt;
			adj[v][u]=wt;
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
		
//		O(V^2)
		void bfs(){
			System.out.print("BFS : ");
			Queue<Integer> q=new LinkedList<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					q.offer(i);
					while(!q.isEmpty()){
						int u=q.poll();
						System.out.print(u+" ");
						for(int j=0;j<V;j++){
							if(adj[u][j]!=0 && visited[j]==false){
								visited[j]=true;
								q.offer(j);
							}
						}
					}
				}
			}
			System.out.println("END");
		}
		
//		O(V^2)
		void dfsWithoutRecursion(){
			System.out.print("DFS : ");
			Stack<Integer> stk=new Stack<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					stk.push(i);
					while(!stk.isEmpty()){
						int u=stk.pop();
						System.out.print(u+" ");
						for(int j=0;j<V;j++){
							if(adj[u][j]!=0 && visited[j]==false){
								visited[j]=true;
								stk.push(j);
							}
						}
					}
				}
			}
			System.out.println("END");
		}
		
//		O(V^2)
		void dfs(){
			System.out.print("DFS : ");
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					this.dfs(i, visited);
				}
			}
			System.out.println("END");
		}
		private void dfs(int u,boolean[] visited){
			System.out.print(u+" ");
			for(int i=0;i<V;i++){
				if(adj[u][i]!=0 && visited[i]==false){
					visited[i]=true;
					this.dfs(i, visited);
				}
			}
		}
		
		boolean isBipartite(){
			int[] visited=new int[V];
			Queue<Integer> q=new LinkedList<>();
			for(int i=0;i<V;i++){
				if(visited[i]==0){
					visited[i]=1;
					q.offer(i);
					while(!q.isEmpty()){
						int u=q.poll();
						for(int j=0;j<V;j++){
							if(adj[u][j]!=0 && visited[j]==0){
								if(visited[u]==1){
									visited[j]=2;
								}
								else{
									visited[j]=1;
								}
								q.offer(j);
							}
							else if(adj[u][j]!=0 && visited[u]==visited[j]){
								return false;
							}
						}
					}
				}
			}
			return true;
		}
		
		//O(V^2)
		void unweightedShortestPath(int src){
			int[] dist=new int[V];
			Arrays.fill(dist, -1);
			dist[src]=0;
			Queue<Integer> q=new LinkedList<>();
			q.offer(src);
			while(!q.isEmpty()){
				int u=q.poll();
				for(int v=0;v<V;v++){
					if(adj[u][v]!=0 && dist[v]==-1){
						dist[v]=dist[u]+1;
						q.offer(v);
					}
				}
			}
			for(int i=0;i<V;i++){
				System.out.print(dist[i]+" ");
			}
		}

		//O(V^2)
		void primMST(){
			int[] key=new int[V];
			int[] par=new int[V];
			boolean[] visited=new boolean[V];
			Arrays.fill(key, Integer.MAX_VALUE);
			Arrays.fill(par, -1);
			key[0]=0;
			for(int i=0;i<(V-1);i++){
				int min=Integer.MAX_VALUE;
				int u=-1;
				for(int j=0;j<V;j++){
					if(!visited[j] && key[j]<min){
						min=key[j];
						u=j;
					}
				}
				visited[u]=true;
				for(int v=0;v<V;v++){
					if(adj[u][v]!=0 && !visited[v] && adj[u][v]<key[v]){
						key[v]=adj[u][v];
						par[v]=u;
					}
				}
			}
			for(int i=1;i<V;i++){
				System.out.println(par[i]+" ==> "+i+" = "+key[i]);
			}
		}
		
//		SINGLE SOURCE SHORTEST PATH
//		O(V^2)
		void dijkstra(int src){
			int[] dist=new int[V];
			int[] par=new int[V];
			boolean[] visited=new boolean[V];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(par, -1);
			dist[src]=0;
			for(int i=0;i<(V-1);i++){
				int min=Integer.MAX_VALUE;
				int u=-1;
				for(int j=0;j<V;j++){
					if(!visited[j] && dist[j]<min){
						min=dist[j];
						u=j;
					}
				}
				visited[u]=true;
				for(int v=0;v<V;v++){
					if(adj[u][v]!=0 && !visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+adj[u][v]<dist[v]){
						dist[v]=dist[u]+adj[u][v];
						par[v]=u;
					}
				}
			}
			for(int i=0;i<V;i++){
				if(dist[i]==Integer.MAX_VALUE){
					System.out.println("-1");
				}
				else{
					System.out.print(dist[i]+" ");
				}
			}
		}

	}

	public static void main(String[] args) {
//		Graph g=new Graph(11);
//		g.addEdge(0, 1, 1);
//		g.addEdge(1, 10, 1);
//		g.addEdge(1, 2, 1);
//		g.addEdge(2, 3, 1);
//		g.addEdge(2, 4, 1);
//		g.addEdge(4, 10, 1);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 9, 1);
//		g.addEdge(4, 5, 1);
//		g.addEdge(5, 6, 1);
//		g.addEdge(5, 8, 1);
//		g.addEdge(6, 7, 1);
//		Graph g=new Graph(11);
//		g.addEdge(0, 1, 1);
//		g.addEdge(0, 2, 1);
//		g.addEdge(1, 3, 1);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 5, 1);
//		g.addEdge(2, 4, 1);
//		g.addEdge(3, 6, 1);
//		g.addEdge(7, 9, 1);
//		g.bfs();
//		g.dfsWithoutRecursion();
//		g.dfs();
//		g.display();
//		g.unweightedShortestPath(2);
		
//		Graph g=new Graph(5);
//		g.addEdge(0, 1, 2);
//		g.addEdge(0, 3, 6);
//		g.addEdge(1, 2, 3);
//		g.addEdge(1, 3, 8);
//		g.addEdge(1, 4, 5);
//		g.addEdge(2, 4, 7);
//		g.addEdge(3, 4, 9);
//		g.display();
//		g.primMST();
		
//		Graph g=new Graph(9);
//		g.addEdge(0, 1, 4);
//		g.addEdge(0, 7, 8);
//		g.addEdge(1, 7, 11);
//		g.addEdge(1, 2, 8);
//		g.addEdge(2, 8, 2);
//		g.addEdge(2, 5, 4);
//		g.addEdge(2, 3, 7);
//		g.addEdge(3, 5, 14);
//		g.addEdge(3, 4, 9);
//		g.addEdge(4, 5, 10);
//		g.addEdge(5, 6, 2);
//		g.addEdge(6, 7, 1);
//		g.addEdge(6, 8, 6);
//		g.addEdge(7, 8, 7);
//		g.display();
//		g.dijkstra(0);
	}
}