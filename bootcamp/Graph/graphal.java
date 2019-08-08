package bootcamp.Graph;
import java.util.*;
public class graphal {
	class node{
		int vtx;
		int wt;
		node(int vtx,int wt){
			this.vtx=vtx;
			this.wt=wt;
		}
	}
	int v;
	LinkedList<node>[] adj;
	graphal(int v){
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList();
		}
	}
	
	void addEdge(int v1,int v2,int wt){
		adj[v1].add(new node(v2,wt));
		adj[v2].add(new node(v1,wt));
	}
	
	void bfs(){
		LinkedList<Integer> q=new LinkedList<>();
		HashSet<Integer> visited=new HashSet<>();
		for(int i=0;i<v;i++){
			if(!visited.contains(i)){
				visited.add(i);
				q.addLast(i);
				while(!q.isEmpty()){
					int curr=q.removeFirst();
					System.out.print(curr+" ");
					LinkedList<node> list=adj[curr];
					for(node n:list){
						int v=n.vtx;
						if(!visited.contains(v)){
							visited.add(v);
							q.addLast(v);
						}
					}
				}
			}
		}
		System.out.println("END");
	}
	
	void dfs(){
		HashSet<Integer> visited=new HashSet<>();
		for(int i=0;i<v;i++){
			if(!visited.contains(i)){
				visited.add(i);
				dfs(i,visited);
			}
		}
		System.out.println("END");
	}
	
	void dfs(int vtx,HashSet<Integer> visited){
		System.out.print(vtx+" ");
		LinkedList<node> list=adj[vtx];
		for(node n:list){
			int v=n.vtx;
			if(!visited.contains(v)){
				visited.add(v);
				dfs(v,visited);
			}
		}
	}
	
	public static void main(String[] args) {
		graphal g=new graphal(8);
		g.addEdge(0, 1, 3);
		g.addEdge(0, 3, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(3, 2, 1);
		g.addEdge(3, 4, 6);
		g.addEdge(2, 5, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(1, 7, 2);
		g.bfs();
		g.dfs();
		LinkedList<Integer> l=new LinkedList<>();
		ArrayList<Integer> a=new ArrayList<>();
	}

}
