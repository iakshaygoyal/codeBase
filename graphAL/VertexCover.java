package graphAL;
import java.util.*;
public class VertexCover {

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
			this.adj[u].add(v);
			this.adj[v].add(u);
		}
		
		void printVertexCover(){
			boolean[] visited=new boolean[V];
			for(int u=0;u<V;u++){
				if(!visited[u]){
					Vector<Integer> vector=adj[u];
					for(Integer v:vector){
						if(!visited[v]){
							visited[u]=true;
							visited[v]=true;
							break;
						}
					}
				}
			}
			for(int u=0;u<V;u++){
				if(visited[u]){
					System.out.print(u+" ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
 
        g.printVertexCover();
	}

}
