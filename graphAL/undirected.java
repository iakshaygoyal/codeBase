package graphAL;
import java.util.*;
public class undirected {

	static class Graph{
		class Node{
			int vtx;
			int wt;
			Node(int vtx,int wt){
				this.vtx=vtx;
				this.wt=wt;
			}
			public String toString(){
				return vtx+"";
			}
			public boolean equals(Object o){
				Node n=(Node)o;
				return this.vtx==n.vtx;
			}
		}
		int V;
		Vector<Node>[] adj;
		Graph(int V){
			this.V=V;
			adj=new Vector[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector(0,1);
			}
		}
		
		void addEdge(int i,int j,int wt){
			adj[i].add(new Node(j,wt));
			adj[j].add(new Node(i,wt));
		}
		
		void display(){
			for(int i=0;i<V;i++){
				System.out.println(i+" => "+adj[i]);
			}
		}
		
		void bfs(){
			System.out.print("BFS : ");
			LinkedList<Integer> q=new LinkedList<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					q.addLast(i);
					while(!q.isEmpty()){
						int v1=q.removeFirst();
						System.out.print(v1+", ");
						Vector<Node> v=adj[v1];
						for(Node n:v){
							int v2=n.vtx;
							if(visited[v2]==false){
								visited[v2]=true;
								q.addLast(v2);
							}
						}
					}
				}
			}
			System.out.println("END");
		}
		
		void dfs(){
			System.out.print("DFS : ");
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					dfs(i,visited);
				}
			}
			System.out.println("END");
		}
		void dfs(int v,boolean[] visited){
			System.out.print(v+", ");
			Vector<Node> vec=adj[v];
			for(Node n:vec){
				int v1=n.vtx;
				if(visited[v1]==false){
					visited[v1]=true;
					dfs(v1,visited);
				}
			}
		}
		
		boolean hasPathbfs(int i,int j){
			boolean[] visited=new boolean[V];
			LinkedList<Integer> q=new LinkedList<>();
			q.addLast(i);
			visited[i]=true;
			while(!q.isEmpty()){
				int v=q.removeFirst();
				Vector<Node> vec=adj[v];
				for(Node n1:vec){
					int v1=n1.vtx;
					if(v1==j){
						return true;
					}
					if(visited[v1]==false){
						visited[v1]=true;
						q.addLast(v1);
					}
				}
			}
			return false;
		}
		
		
		boolean hasPathdfs(int i,int j){
			boolean[] visited=new boolean[V];
			visited[i]=true;
			return hasPathdfs(i, j, visited);
		}
		private boolean hasPathdfs(int i,int j,boolean[] visited){
			Vector<Node> vec=adj[i];
			for(Node n1:vec){
				int v1=n1.vtx;
				if(v1==j){
					return true;
				}
				if(visited[v1]==false){
					visited[v1]=true;
					if(hasPathdfs(v1, j, visited)){
						return true;
					}
				}
			}
			return false;
		}
		
		Vector<Vector<Integer>> connectedComponents(){
			Vector<Vector<Integer>> major=new Vector<>(0,1);
			Vector<Integer> minor;
			LinkedList<Integer> q=new LinkedList<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					minor=new Vector<>(0,1);;
					visited[i]=true;
					q.addLast(i);
					while(!q.isEmpty()){
						int v=q.removeFirst();
						minor.add(v);
						Vector<Node> vec=adj[v];
						for(Node n:vec){
							int v1=n.vtx;
							if(visited[v1]==false){
								visited[v1]=true;
								q.add(v1);
							}
						}
					}
					major.add(minor);
				}
			}
			return major;
		}
		
		boolean isConnected(){
			boolean[] visited=new boolean[V];
			LinkedList<Integer> q=new LinkedList<>();
			int flag=0;
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					if(flag==1){
						return false;
					}
					visited[i]=true;
					q.addLast(i);
					while(!q.isEmpty()){
						flag=1;
						int v=q.removeFirst();
						Vector<Node> vec=adj[v];
						for(Node n:vec){
							int v1=n.vtx;
							if(visited[v1]==false){
								visited[v1]=true;
								q.add(v1);
							}
						}
					}
				}
			}
			return true;
		}
		
		//HERE '-1' CORRESPONDS TO NULL
		boolean isCyclic(){
			LinkedList<Integer> q=new LinkedList<>();
			int[] visited=new int[V];
			Arrays.fill(visited, -2);
			for(int i=0;i<V;i++){
				if(visited[i]==-2){
					visited[i]=-1;
					q.addLast(i);
					while(!q.isEmpty()){
						int v=q.removeFirst();
						Vector<Node> vec=adj[v];
						for(Node n:vec){
							int v1=n.vtx;
							if(visited[v1]==-2){
								visited[v1]=v;
								q.addLast(v1);
							}
							else{
								if(visited[v]!=v1){
									return true;
								}
							}
						}
					}
				}
			}
			return false;
		}
		
		boolean isBipartite(){
			LinkedList<Integer> q=new LinkedList<>();
			int[] visited=new int[V];
			for(int i=0;i<V;i++){
				if(visited[i]==0){
					visited[i]=1;
					q.addLast(i);
					while(!q.isEmpty()){
						int v=q.removeFirst();
						Vector<Node> vec=adj[v];
						for(Node n:vec){
							int v1=n.vtx;
							if(visited[v1]==0){
								if(visited[v]==1){
									visited[v1]=2;
								}
								else{
									visited[v1]=1;
								}
								q.addLast(v1);
							}
							else{
								if(visited[v]==visited[v1]){
									return false;
								}
							}
						}
					}
				}
			}
			return true;
		}
		
		//SINGLE SOURCE SHORTEST PATH
	    //O(ELOG(V))
	    //DOESNT WORK FOR NEGATIVE WEIGHTS
		class Pair implements Comparable<Pair>{
			int vtx;
			int dist;
			Pair(int vtx,int dist){
				this.vtx=vtx;
				this.dist=dist;
			}
			
			public int compareTo(Pair p){
				return Integer.compare(this.dist, p.dist);
			}
			
			public boolean equals(Object o){
				if(o==this){
					return true;
				}
				if(o==null || o.getClass()!=this.getClass()){
					return false;
				}
				Pair p=(Pair)o;
				return (this.vtx==p.vtx && this.dist==p.dist);
			}
		}
		void dijkstra(int src){
			int[] dist=new int[V];
			int[] par=new int[V];
			boolean[] visited=new boolean[V];
			Arrays.fill(dist, -1);
			Arrays.fill(visited, false);
			PriorityQueue<Pair> pq=new PriorityQueue<>();
			pq.offer(new Pair(src, 0));
			while(!pq.isEmpty()){
				Pair p=pq.poll();
				int u=p.vtx;
				dist[u]=p.dist;
				visited[u]=true;
				Vector<Node> vector=adj[u];
				for(Node node:vector){
					int v=node.vtx;
					if(visited[v]==false){
						int newD=dist[u]+node.wt;
						if(dist[v]==-1){
							par[v]=u;
							dist[v]=newD;
							pq.offer(new Pair(v, newD));
						}
						else if(newD<dist[v]){
							pq.remove(new Pair(v, dist[v]));
							par[v]=u;
							dist[v]=newD;
							pq.offer(new Pair(v, newD));
						}
					}
				}
			}
			for(int i=0;i<V;i++){
				if(i==src){
					continue;
				}
				System.out.print(dist[i]+" ");
			}
			
			System.out.println();
			for(int i=0;i<V;i++){
				LinkedList<Integer> stk=new LinkedList<>();
				int p=i;
				while(p!=src && p!=-1){
					stk.addFirst(p);
					p=par[p];
				}
				stk.addFirst(p);
				while(!stk.isEmpty()){
					System.out.print(stk.removeFirst()+" => ");
				}
				System.out.println("END");
			}
		}
		
		
	    //O(ELOG(V))
		void primMST(){
			int[] dist=new int[V];
			int[] par=new int[V];
			boolean[] visited=new boolean[V];
			Arrays.fill(dist, -1);
			Arrays.fill(visited, false);
			PriorityQueue<Pair> pq=new PriorityQueue<>();
			pq.offer(new Pair(0, 0));
			while(!pq.isEmpty()){
				Pair p=pq.poll();
				int u=p.vtx;
				dist[u]=p.dist;
				visited[u]=true;
				Vector<Node> vector=adj[u];
				for(Node node:vector){
					int v=node.vtx;
					if(visited[v]==false){
						int newD=node.wt;
						if(dist[v]==-1){
							par[v]=u;
							dist[v]=newD;
							pq.offer(new Pair(v, newD));
						}
						else if(newD<dist[v]){
							pq.remove(new Pair(v, dist[v]));
							par[v]=u;
							dist[v]=newD;
							pq.offer(new Pair(v, newD));
						}
					}
				}
			}
			for(int i=1;i<V;i++){
				System.out.println(par[i]+" ==> "+i+" = "+dist[i]);
			}
		}
		
		//USE 2ND
		
//		void allPaths(int i,int j){
//        	LinkedHashSet<Integer> visited=new LinkedHashSet<>();
//        	visited.add(i);
//        	allPaths(i, j, visited);
//        }
//        void allPaths(int i,int j,LinkedHashSet<Integer> visited){
//        	if(i==j){
//        		System.out.println(visited);
//        		visited.remove(j);
//        		return;
//        	}
//        	Vector<Node> vec=adj[i];
//        	for(Node n:vec){
//        		int v1=n.vtx;
//        		if(!visited.contains(v1)){
//        			visited.add(v1);
//        			allPaths(v1, j, visited);
//        		}
//        	}
//        	visited.remove(i);
//        }
        
        void allPaths2(int i,int j){
			Vector<Integer> paths=new Vector<>(0,1);
        	boolean[] visited=new boolean[V];
        	visited[i]=true;
        	paths.add(i);
        	allPaths2(i, j, paths,visited);
        }
        void allPaths2(int i,int j,Vector<Integer> paths,boolean[] visited){
        	if(i==j){
        		System.out.println(paths);
        		paths.remove((Object)j);
        		visited[j]=false;
        		return;
        	}
        	Vector<Node> vec=adj[i];
        	for(Node n:vec){
        		int v1=n.vtx;
        		if(visited[v1]==false){
        			visited[v1]=true;
        			paths.add(v1);
        			allPaths2(v1, j, paths,visited);
        		}
        	}
        	visited[i]=false;
        	paths.remove((Object)i);
        }
	}
	
	public static void main(String[] args) {
		Graph g=new Graph(3);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
//		g.addEdge(1, 3, 1);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 5, 1);
//		g.addEdge(2, 4, 1);
//		g.addEdge(3, 6, 1);
//		g.addEdge(7, 9, 1);
		
		g.display();
		g.bfs();
		g.dfs();
//		g.dijkstra(0);
		System.out.println(g.hasPathdfs(0,0));
		System.out.println(g.hasPathbfs(0,0));
//		System.out.println();
//		
//		System.out.println(g.hasPathdfs(2,6));
//		System.out.println(g.hasPathbfs(2,6));
//		System.out.println();
//		
//		System.out.println(g.hasPathdfs(4,7));
//		System.out.println(g.hasPathbfs(4,7));
//		System.out.println();
//		
//		System.out.println(g.hasPathdfs(7,9));
//		System.out.println(g.hasPathbfs(7,9));
//		System.out.println();
//		
//		System.out.println(g.hasPathdfs(7,8));
//		System.out.println(g.hasPathbfs(7,8));
//		System.out.println();
//		
//		System.out.println(g.hasPathdfs(7,7));
//		System.out.println(g.hasPathbfs(7,7));
//		System.out.println();
//		
//		System.out.println(g.hasPathdfs(8,8));
//		System.out.println(g.hasPathbfs(8,8));
//		System.out.println();
//		
//		System.out.println(g.connectedComponents());
		
//		g.addEdge(0, 1, 1);
//		g.addEdge(0, 1, 2);
//		g.addEdge(0, 1, 3);
//		g.addEdge(1, 10, 1);
//		g.addEdge(1, 2, 1);
//		g.addEdge(2, 3, 1);
//		g.addEdge(2, 4, 1);
//		g.addEdge(4, 10, 1);
////		g.addEdge(9, 10, 1);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 9, 1);
//		g.addEdge(4, 5, 1);
//		g.addEdge(5, 6, 1);
//		g.addEdge(5, 8, 1);
//		g.addEdge(6, 7, 1);
//		g.display();
//		g.bfs();
//		System.out.println(g.isCyclic());
//		System.out.println(g.isBipartite());
//		g.allPaths2(0, 9);
		
//		Graph g=new Graph(9);
//		g.addEdge(0, 1, 4);
//		g.addEdge(0, 7, 8);
//		g.addEdge(1, 7, 11);
//		g.addEdge(1, 2, 8);
//		g.addEdge(2, 8, 2);
//		g.addEdge(2, 5, 4);
//		g.addEdge(2, 3, 7);
//		g.addEdge(3, 5, 14);
//		g.addEdge(3, 4, 9);
//		g.addEdge(4, 5, 10);
//		g.addEdge(5, 6, 2);
//		g.addEdge(6, 7, 1);
//		g.addEdge(6, 8, 6);
//		g.addEdge(7, 8, 7);
//		g.display();
//		g.dijkstra(0);
		
//		Graph g=new Graph(5);
//		g.addEdge(0, 1, 2);
//		g.addEdge(0, 3, 6);
//		g.addEdge(1, 2, 3);
//		g.addEdge(1, 3, 8);
//		g.addEdge(1, 4, 5);
//		g.addEdge(2, 4, 7);
//		g.addEdge(3, 4, 9);
//		g.display();
//		g.primMST();
	}

}
