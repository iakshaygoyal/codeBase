package graphAL;
import java.util.*;
public class Print_All_Paths {

	static class Graph{
		int V;
		Vector<Integer>[] adj;
		
		@SuppressWarnings("unchecked")
		Graph(int V){
			this.V=V;
			adj=new Vector[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector<>();
			}
		}
		
		void addEdge(int u,int v){
			adj[u].add(v);
		}
		
		int idx;
		void allPaths(int u,int v){
			int[] path=new int[V];
			boolean[] visited=new boolean[V];
			visited[u]=true;
			path[0]=u;
			idx=1;
			print(u,v,path,visited);
		}
		
		void print(int u,int v,int[] path,boolean[] visited){
			if(u==v){
				for(int i=0;i<idx;i++){
					System.out.print(path[i]+" ");
				}
				System.out.println();
			}
			else{
				for(Integer i:adj[u]){
					if(!visited[i]){
						visited[i]=true;
						path[idx++]=i;
						print(i,v,path,visited);
					}
				}
			}
			visited[u]=false;
			idx--;
		}
	}
	
//	1
//	11 17
//	0 1
//	0 1
//	0 1
//	1 0
//	1 2
//	1 10
//	2 3
//	2 4
//	3 4
//	4 10
//	4 9
//	10 9
//	4 5
//	5 6
//	5 8
//	6 4
//	6 7
//	0 9
	
	public static void main(String[] args) {
		Graph g=new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.allPaths(2, 3);
		
		System.out.println();
		
		Graph g1=new Graph(11);
		g1.addEdge(0, 1);
		g1.addEdge(0, 1);
		g1.addEdge(0, 1);
		g1.addEdge(1, 0);
		g1.addEdge(1, 10);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(2, 4);
		g1.addEdge(4, 10);
		g1.addEdge(10, 9);
		g1.addEdge(3, 4);
		g1.addEdge(4, 9);
		g1.addEdge(4, 5);
		g1.addEdge(5, 6);
		g1.addEdge(5, 8);
		g1.addEdge(6, 7);
		g1.addEdge(6, 4);
		g1.allPaths(0, 9);
	}

}
