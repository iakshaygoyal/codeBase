package graphHackerrank;
import java.util.*;
public class SnakesandLaddersTheQuickestWayUp {
	public static class graph {
		private class edge{
			vertex v1;
			vertex v2;
			int wt;
			edge(vertex v1,vertex v2,int wt){
				this.v1=v1;
				this.v2=v2;
				this.wt=wt;
			}
		}
		private class vertex{
			int name;
			HashMap<vertex,edge> map;
			vertex(int name){
				this.name=name;
				map=new HashMap<>();
			}
			public ArrayList<vertex> getAdjacentVertices(){
				return new ArrayList<>(this.map.keySet());
			}
			public ArrayList<edge> getAdjacentEdges(){
				return new ArrayList<>(this.map.values());
			}
		}
		ArrayList<vertex> vertices;
		graph(){
			vertices=new ArrayList<>();
		}
		public void addVertex(int name){
			vertex newvertex=new vertex(name);
			vertices.add(newvertex);
		}
		public vertex getVertex(int name){
			vertex retval=null;
			for(vertex v:vertices){
				if(v.name==name){
					retval=v;
					break;
				}
			}
			return retval;
		}
		public void addEdge(int name1,int name2,int wt){
			vertex v1=getVertex(name1);
			vertex v2=getVertex(name2);
			edge newedge=new edge(v1,v2,wt);
			v1.map.put(v2,newedge);
		}
		public int dijkstra(){
			int[] key=new int[101];
			boolean[] spt=new boolean[101];
			for(int i=1;i<101;i++){
				key[i]=Integer.MAX_VALUE;
				spt[i]=false;
			}
			key[1]=0;
			for(int i=1;i<100;i++){
				int min=Integer.MAX_VALUE;
				int idx=-1;
				for(int j=1;j<101;j++){
					if(spt[j]==false && key[j]<min){
						min=key[j];
						idx=j;
					}
				}
				if(idx==-1){
					continue;
				}
				if(idx==100){
					break;
				}
				spt[idx]=true;
				vertex vtx=this.getVertex(idx);
				for(edge e:vtx.getAdjacentEdges()){
					vertex other=e.v1==vtx?e.v2:e.v1;
					if(spt[other.name]==false && key[idx]+e.wt<key[other.name]){
						key[other.name]=key[idx]+e.wt;
					}
				}
			}
			if(key[100]>0 && key[100]!=Integer.MAX_VALUE){
				return key[100];
			}
			return -1;
		}
	}
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int k=0;k<t;k++){
			graph g=new graph();
			for(int i=1;i<=100;i++){
				g.addVertex(i);
			}
			for(int i=1;i<=100;i++){
				for(int j=i+1;j<=i+6 && j<=100;j++){
					g.addEdge(i, j, 1);
				}
			}
			int n=s.nextInt();
			for(int j=0;j<n;j++){
				int si=s.nextInt();
				int fi=s.nextInt();
				g.getVertex(si).map.clear();
				g.addEdge(si, fi, 0);
			}
			int m=s.nextInt();
			for(int j=0;j<m;j++){
				int si=s.nextInt();
				int fi=s.nextInt();
				g.getVertex(si).map.clear();
				g.addEdge(si, fi, 0);
			}
			System.out.println(g.dijkstra());
		}
	}

}
