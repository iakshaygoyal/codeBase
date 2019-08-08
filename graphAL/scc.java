package graphAL;
import java.util.*;
public class scc {

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
		}
		
		void display(){
			for(int i=0;i<V;i++){
				System.out.println(i+" ==> "+adj[i]);
			}
		}
		
		//STRONGLY CONNECTED COMPONENTS
		//FOR DIRECTED GRAPHS
		//KOSARAJU'S ALGORITHM
		//COMPLEXITY : O(V+E)
		Stack<Integer> stk;
		void findscc(){
			System.out.println("SCCS : \n");
			stk=new Stack<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					dfs(i,visited);
				}
			}
			Arrays.fill(visited, false);
			graph gr=getTranspose();
			int j=0;
			while(!stk.isEmpty()){
				Integer i=stk.pop();
				if(visited[i]==false){
					visited[i]=true;
					System.out.print(++j+" : ");
					gr.printscc(i, visited);
					System.out.println();
				}
			}
		}
		void dfs(int u,boolean[] visited){
			Vector<Integer> vec=adj[u];
			for(Integer v:vec){
				if(visited[v]==false){
					visited[v]=true;
					dfs(v,visited);
				}
			}
			stk.push(u);
		}
		graph getTranspose(){
			graph g=new graph(V);
			for(int i=0;i<V;i++){
				Vector<Integer> vec=adj[i];
				for(Integer j:vec){
					g.addEdge(j, i);
				}
			}
			return g;
		}
		void printscc(int u,boolean[] visited){
			Vector<Integer> vec=adj[u];
			for(Integer v:vec){
				if(visited[v]==false){
					visited[v]=true;
					printscc(v,visited);
				}
			}
			System.out.print(u+" ");
		}
	}
	public static void main(String[] args) {
		graph g=new graph(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 3);
		g.addEdge(6, 5);
		g.addEdge(6, 7);
		g.display();
		g.findscc();
		
		graph g1=new graph(5);
	    g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 1);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    g1.display();
	    g1.findscc();
	}

}
