package disjoint_Set;
import java.util.*;
public class KruskalsAlgo {

	static class DisjointSet{
		int[] parent,rank;
		
		public DisjointSet(int n) {
			parent=new int[n];
			rank=new int[n];
			for(int i=0;i<n;i++){
				parent[i]=i;
			}
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
		
		int find(int i){
			if(parent[i]!=i){
				parent[i]=find(parent[i]);
			}
			return parent[i];
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u,v,weight;
		
		Edge(int u,int v,int weight){
			this.u=u;
			this.v=v;
			this.weight=weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight-e.weight;
		}
		
		public String toString(){
			return this.u + "-->" + this.v + " = " + this.weight;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int V=scn.nextInt();
		int E=scn.nextInt();
		
		Edge[] edges=new Edge[E];
		for(int i=0;i<E;i++){
			edges[i]=new Edge(scn.nextInt(),scn.nextInt(),scn.nextInt());
		}
		
		System.out.println(Arrays.toString(getMST(edges, V, E)));
		scn.close();
	}
	
	static Edge[] getMST(Edge[] edges,int V,int E){
		Edge[] result=new Edge[V-1];
		DisjointSet ds=new DisjointSet(V);
		Arrays.sort(edges);
		int i=0;
		for(Edge e:edges){
			int root1=ds.find(e.u);
			int root2=ds.find(e.v);
			
			if(root1==root2) continue;
			
			result[i++]=new Edge(e.u,e.v,e.weight);
			ds.union(e.u, e.v);
		}
		return result;
	}

}
