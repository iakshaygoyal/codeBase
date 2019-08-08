package graphHackerrank;
import java.util.*;
public class DijkstraShortestReach2 {
public static class graph{
	public class vertex{
		int name;
		HashMap<vertex,Integer> map;
		vertex(int name){
			this.name=name;
			map=new HashMap<>();
		}
		public ArrayList<vertex> getAdjacentVertices(){
			return new ArrayList<>(this.map.keySet());
		}
	}
	ArrayList<vertex> vertices;
	graph(){
		vertices=new ArrayList<>();
	}
	int size(){
		return this.vertices.size();
	}
	public void addVertex(int name){
		vertex newVertex=new vertex(name);
		vertices.add(newVertex);
	}
	public vertex getVertex(int name){
		vertex retval=null;
		for(vertex v:this.vertices){
			if(v.name==name){
				retval=v;
				break;
			}
		}
		return retval;
	}
	public void addEdge(int name1,int name2,int wt){
		vertex v1=this.getVertex(name1);
		vertex v2=this.getVertex(name2);
		v1.map.put(v2, wt);
		v2.map.put(v1, wt);
	}
	public int check(int name1,int name2){
		vertex v1=this.getVertex(name1);
		vertex v2=this.getVertex(name2);
		if(v1.map.containsKey(v2)){
			return v1.map.get(v2);
		}
		return Integer.MAX_VALUE;
	}
	static class pair implements Comparable<pair>{
		int key;
		vertex val;
		pair(int key,vertex val){
			this.key=key;
			this.val=val;
		}
		pair(){}
		public int compareTo(pair p){
			return this.key-p.key;
		}
	}
	void dijkstra2(int src){
		PriorityQueue<pair> pq=new PriorityQueue<>();
		int[] dist=new int[this.size()+1];
		boolean[] visited=new boolean[this.size()+1];
		for(int i=0;i<dist.length;i++){
			dist[i]=-1;
			visited[i]=false;
		}
		pq.offer(new pair(0,this.getVertex(src)));
		while(!pq.isEmpty()){
			pair p=pq.poll();
			vertex curr=p.val;
			visited[curr.name]=true;
			dist[curr.name]=p.key;
			for(vertex adjv:curr.getAdjacentVertices()){
				if(visited[adjv.name]==false){
					int newD=dist[curr.name]+curr.map.get(adjv);
					if(dist[adjv.name]==-1){
						pq.offer(new pair(newD,adjv));
						dist[adjv.name]=newD;
					}
					else{
						Iterator<pair> it=pq.iterator();
						while(it.hasNext()){
							pair p1=it.next();
							if(p1.val.name==adjv.name){
								if(newD<p1.key){
									it.remove();
									pq.offer(new pair(newD,adjv));
									dist[adjv.name]=newD;
								}
								break;
							}
						}
					}
				}
			}
		}
		for(int i=1;i<dist.length;i++){
			if(dist[i]==0){
				continue;
			}
			if(dist[i]==-1){
				System.out.print("-1 ");
			}
			else{
				System.out.print(dist[i]+" ");
			}
		}
	}
}
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			graph g=new graph();
			for(int j=1;j<=n;j++){
				g.addVertex(j);
			}
			int m=s.nextInt();
			for(int j=0;j<m;j++){
				int x=s.nextInt();
				int y=s.nextInt();
				int r=s.nextInt();
				int wt=g.check(x, y);
				if(r<wt){
					g.addEdge(x, y, r);
				}
			}
			int src=s.nextInt();
			g.dijkstra2(src);
			System.out.println();
		}
	}
}