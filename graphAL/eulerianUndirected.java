package graphAL;
import java.util.*;
public class eulerianUndirected {

	static class graph{
		int V;
		Vector<Integer>[] adj;
		graph(int V){
			this.V=V;
			this.adj=new Vector[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector<>(0,1);
			}
		}
		void addEdge(int u,int v){
			adj[u].add(v);
			adj[v].add(u);
		}
		void test(){
			int x=isEulerian();
			if(x==0){
				System.out.println("NOT EULERIAN");
			}
			else if(x==1){
				System.out.println("EULERIAN CYCLE");
			}
			else{
				System.out.println("EULERIAN PATH");
			}
		}
		int isEulerian(){
			if(isConnected()==false){
				return 0;
			}
			int odd=0;
			for(int i=0;i<V;i++){
				if(adj[i].size()%2!=0){
					odd++;
				}
			}
			if(odd>2){
				return 0;
			}
			if(odd==0){
				return 1;
			}
			else{
				return 2;
			}
		}
		boolean isConnected(){
			int u=-1;
			for(int i=0;i<V;i++){
				if(adj[i].size()!=0){
					u=i;
					break;
				}
			}
			if(u==-1){
				return true;
			}
			boolean[] visited=new boolean[V];
			dfs(u,visited);
			for(int i=0;i<V;i++){
				if(visited[i]==false && adj[i].size()!=0){
					return false;
				}
			}
			return true;
		}
		void dfs(int u,boolean[] visited){
			Vector<Integer> vec=adj[u];
			for(Integer v:vec){
				if(visited[v]==false){
					visited[v]=true;
					dfs(v,visited);
				}
			}
		}
	}
	public static void main(String[] args) {
		// Let us create and test graphs shown in above figures
	    graph g1=new graph(5);
	    g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 1);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    g1.test();
	 
	    graph g2=new graph(5);
	    g2.addEdge(1, 0);
	    g2.addEdge(0, 2);
	    g2.addEdge(2, 1);
	    g2.addEdge(0, 3);
	    g2.addEdge(3, 4);
	    g2.addEdge(4, 0);
	    g2.test();
	 
	    graph g3=new graph(5);
	    g3.addEdge(1, 0);
	    g3.addEdge(0, 2);
	    g3.addEdge(2, 1);
	    g3.addEdge(0, 3);
	    g3.addEdge(3, 4);
	    g3.addEdge(1, 3);
	    g3.test();
	 
	    // Let us create a graph with 3 vertices
	    // connected in the form of cycle
	    graph g4=new graph(3);
	    g4.addEdge(0, 1);
	    g4.addEdge(1, 2);
	    g4.addEdge(2, 0);
	    g4.test();
	 
	    // Let us create a graph with all veritces
	    // with zero degree
	    graph g5=new graph(3);
	    g5.test();
	 
	}

}
