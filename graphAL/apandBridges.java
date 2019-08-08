package graphAL;
import java.util.*;
public class apandBridges {

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
		void display(){
			for(int i=0;i<V;i++){
				System.out.println(i+" ==> "+adj[i]);
			}
		}
		
		//ARTICULATION POINTS
        //TARJAN'S ALGORITHM
		//FOR UNDIRECTED CONNECTED GRAPH(CAN BE MODIFIED TO UNDIRECTED DISCONNECTED)
        //COMPLEXITY: O(V+E)
        
		int time;
        boolean[] visited;;
    	int[] par;
    	boolean[] ap;
    	int[] disc;
    	int[] low;
        void ap(){
        	System.out.println("ARTICULATION POINTS : \n");
        	time=0;
        	visited=new boolean[V];
        	par=new int[V];
        	ap=new boolean[V];
        	disc=new int[V];
        	low=new int[V];
        	visited[0]=true;
        	par[0]=-1;
        	dfs(0);
        }
        private void dfs(int u){
        	low[u]=disc[u]=++time;
        	for(Integer v:adj[u]){
        		int child=0;
        		if(visited[v]==false){
        			visited[v]=true;
        			child++;
        			par[v]=u;
        			dfs(v);
        			low[u]=Math.min(low[u], low[v]);
        			if(par[u]==-1 && child>1){
        				ap[u]=true;
        			}
        			if(par[u]!=-1 && low[v]>=disc[u]){
        				ap[u]=true;
        			}
        		}
        		else{
        			if(v!=par[u]){
        				low[u]=Math.min(low[u], disc[v]);
        			}
        		}
        	}
        }
        
        //BRIDGES
        //FOR UNDIRECTED CONNECTED GRAPH
        //COMPLEXITY: O(V+E)
        void bridges(){
        	System.out.println("BRIDGES : \n");
        	time=0;
        	visited=new boolean[V];
        	par=new int[V];
        	disc=new int[V];
        	low=new int[V];
        	visited[0]=true;
        	par[0]=-1;
        	dfs1(0);
        }
        void dfs1(int u){
        	disc[u]=low[u]=++time;
        	Vector<Integer> vec=adj[u];
        	for(Integer v:vec){
        		if(visited[v]==false){
        			visited[v]=true;
        			par[v]=u;
        			dfs1(v);
        			low[u]=Math.min(low[u], low[v]);
        			if(low[v]>disc[u]){
        				System.out.println(u+" ==> "+v);
        			}
        		}
        		else{
        			if(v!=par[u]){
        				low[u]=Math.min(low[u], disc[v]);
        			}
        		}
        	}
        }
	}
	public static void main(String[] args) {
		graph g=new graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(6, 4);
		g.addEdge(6, 5);
		g.addEdge(5, 4);
		g.addEdge(5, 7);
		g.display();
		g.ap();
		for(int i=0;i<g.V;i++){
			System.out.println(i+"  ==>  "+g.ap[i]);
		}
		g.bridges();
	}

}
