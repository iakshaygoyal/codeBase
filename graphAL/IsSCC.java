package graphAL;
import java.util.*;
public class IsSCC {

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
		
		boolean isSCC(){
			boolean[] visited=new boolean[V];
			visited[0]=true;
			dfs(0, visited);
			
			for(int i=0;i<V;i++){
				if(!visited[i]){
					return false;
				}
			}
			
			Graph g=getTranspose();
			Arrays.fill(visited, false);
			visited[0]=true;
			g.dfs(0, visited);
			
			for(int i=0;i<V;i++){
				if(!visited[i]){
					return false;
				}
			}
			return true;
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
		
		void dfs(int u,boolean[] visited){
			Vector<Integer> vector=adj[u];
			for(Integer v:vector){
				if(!visited[v]){
					visited[v]=true;
					dfs(v, visited);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		  Graph g1 = new Graph(5);
	        g1.addEdge(0, 1);
	        g1.addEdge(1, 2);
	        g1.addEdge(2, 3);
	        g1.addEdge(3, 0);
	        g1.addEdge(2, 4);
	        g1.addEdge(4, 2);
	        if (g1.isSCC())
	            System.out.println("Yes");
	        else
	            System.out.println("No");
	 
	        Graph g2 = new Graph(4);
	        g2.addEdge(0, 1);
	        g2.addEdge(1, 2);
	        g2.addEdge(2, 3);
	        if (g2.isSCC())
	            System.out.println("Yes");
	        else
	            System.out.println("No");
	}
}