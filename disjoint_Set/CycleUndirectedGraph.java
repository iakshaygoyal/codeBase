package disjoint_Set;
import java.util.*;
public class CycleUndirectedGraph {

//	6
//	6
//	0 1
//	0 3
//	1 2
//	2 5
//	4 5
//	1 4
	
	static class DisjointSet{
		int[] parent,rank;
		
		DisjointSet(int n) {
			parent=new int[n];
			rank=new int[n];
			for(int i=0;i<n;i++){
				parent[i]=i;
			}
		}
		
		int find(int i){
			if(parent[i]!=i){
				parent[i]=find(parent[i]);
			}
			return parent[i];
		}
		
		void union(int i,int j){
			int root1=find(i);
			int root2=find(j);
			
			if(root1==root2) return;
			
			if(rank[root1]>rank[root2]){
				parent[root2]=root1;
			}
			else if(rank[root1]<rank[root2]){
				parent[root1]=root2;
			}
			else{
				parent[root1]=root2;
				rank[root2]++;
			}
		}
	}
	
	static class Edge{
		int u,v;
		
		Edge(int u,int v){
			this.u=u;
			this.v=v;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int V=scn.nextInt();
		int E=scn.nextInt();
		
		Edge[] edge=new Edge[E];
		for(int i=0;i<E;i++){
			int u=scn.nextInt();
			int v=scn.nextInt();
			edge[i]=new Edge(u,v);
		}
		
		System.out.println(hasCycle(edge, V));
		scn.close();
	}
	
	static boolean hasCycle(Edge[] edge,int V){
		DisjointSet ds=new DisjointSet(V);
		
		for(Edge e:edge){
			int root1=ds.find(e.u);
			int root2=ds.find(e.v);
			
			if(root1==root2) return true;
			
			ds.union(root1, root2);
		}
		
		return false;
	}
	
}
