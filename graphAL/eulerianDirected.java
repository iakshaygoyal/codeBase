package graphAL;
import java.util.*;
public class eulerianDirected {

	static class Graph{
		int V;
		Vector<Integer>[] adj;
		int[] in;
		
		@SuppressWarnings("unchecked")
		Graph(int V){
			this.V=V;
			this.adj=new Vector[V];
			this.in=new int[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector<>(0,1);
			}
		}
		
		void addEdge(int u,int v){
			adj[u].add(v);
			in[v]++;
		}
		
		boolean isEulerian(){
			if(!isSC()){
				return false;
			}
			for(int i=0;i<V;i++){
				if(in[i]!=adj[i].size()){
					return false;
				}
			}
			return true;
		}
		
		boolean isSC(){
			boolean[] visited=new boolean[V];
			visited[0]=true;
			dfs(0,visited);
			
			for(int i=0;i<V;i++){
				if(!visited[i] && adj[i].size()>0){
					return false;
				}
			}
			
			Graph g=getTranspose();
			Arrays.fill(visited, false);
			visited[0]=true;
			g.dfs(0, visited);
			
			for(int i=0;i<V;i++){
				if(!visited[i] && adj[i].size()>0){
					return false;
				}
			}
			return true;
		}
		
		void dfs(int u,boolean[] visited){
			Vector<Integer> vector=adj[u];
			for(Integer v:vector){
				if(!visited[v]){
					visited[v]=true;
					dfs(v,visited);
				}
			}
		}
		
		Graph getTranspose(){
			Graph g=new Graph(V);
			for(int i=0;i<V;i++){
				Vector<Integer> vector=adj[i];
				for(Integer j:vector){
					g.addEdge(j, i);
				}
			}
			return g;
		}
	}
	
	public static void main(String[] args){
		 Graph g = new Graph(5);
	        g.addEdge(1, 0);
	        g.addEdge(0, 2);
	        g.addEdge(2, 1);
	        g.addEdge(0, 3);
	        g.addEdge(3, 4);
	        g.addEdge(4, 0);
	 
	        if (g.isEulerian())
	            System.out.println("Given directed graph is eulerian ");
	        else
	            System.out.println("Given directed graph is NOT eulerian ");
	}
}
