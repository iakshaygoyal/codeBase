package graphAL;
import java.util.*;
public class GraphColoring {

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
		
		void greedyColoring(){
			int[] result=new int[V];
			boolean[] color=new boolean[V];
			Arrays.fill(result, -1);
			Arrays.fill(color, false);
			result[0]=0;
			
			for(int u=1;u<V;u++){
				Vector<Integer> vector=adj[u];
				for(Integer v:vector){
					if(result[v]!=-1){
						color[result[v]]=true;
					}
				}
				
				for(int i=0;i<V;i++){
					if(!color[i]){
						result[u]=i;
						break;
					}
				}
				
				for(Integer v:vector){
					if(result[v]!=-1){
						color[result[v]]=false;
					}
				}
			}
			
			for(int u=0;u<V;u++){
				System.out.println(u+"  ==>  "+result[u]);
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
 
        System.out.println();
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2 ");
        g2.greedyColoring();
	}

}
