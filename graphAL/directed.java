package graphAL;
import java.util.*;

public class directed {

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
		
		//HERE '-2' CORRESPONDS TO NOT VISITED AND '-1' CORRESPONDS TO NULL
		//TO PRINT THE CYCLE JUST DE-COMMENT THE CODE
		
		boolean isCyclic(){
			int[] visited=new int[V];
			boolean[] marked=new boolean[V];
			Arrays.fill(visited, -2);
			for(int i=0;i<V;i++){
				if(visited[i]==-2){
					visited[i]=-1;
					if(isCyclic(i, visited, marked)){
						return true;
					}
				}
			}
			return false;
		}
		
		//Connected components is not valid here
		
		boolean isCyclic(int v,int[] visited,boolean[] marked){
			Vector<Node> vec=adj[v];
			for(Node n:vec){
				int v1=n.vtx;
				if(visited[v1]==-2){
					visited[v1]=v;
					if(isCyclic(v1, visited, marked)){
						return true;
					}
				}
				else{
					if(marked[v1]==false){
						LinkedList<Integer> stk=new LinkedList<>();
						stk.addFirst(v1);
						stk.addFirst(v);
						System.out.println("hi");
						int x=visited[v];
						while(x!=v1){
							stk.addFirst(x);
							x=visited[x];
						}
						stk.addFirst(v1);
						System.out.print("CYCLE : ");
						while(!stk.isEmpty()){
							System.out.print(stk.removeFirst()+" => ");
						}
						System.out.println("END");
						return true;
					}
				}
			}
			marked[v]=true;
			return false;
		}
		
		void topologicalSorting(){
			Stack<Integer> stk=new Stack<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(visited[i]==false){
					visited[i]=true;
					topologicalSorting(i, stk, visited);
				}
			}
			while(!stk.isEmpty()){
				System.out.print(stk.pop()+" ");
			}
			System.out.println("END");
		}
		
		private void topologicalSorting(int v,Stack<Integer> stk,boolean[] visited){
			Vector<Node> vec=adj[v];
			for(Node n:vec){
				int v1=n.vtx;
				if(visited[v1]==false){
					visited[v1]=true;
					topologicalSorting(v1, stk, visited);
				}
			}
			stk.push(v);
		}
		
//		Shortest Path in Directed Acyclic Graph
//		Complexity : O(V+E)
		
		void shortestPathForDAG(int s){
			Stack<Integer> stk=new Stack<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(!visited[i]){
					visited[i]=true;
					topologicalSorting(i, stk, visited);
				}
			}
			
			int[] distance=new int[V];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[s]=0;
			while(!stk.isEmpty()){
				int u=stk.pop();
				if(distance[u]!=Integer.MAX_VALUE){
					Vector<Node> vector=adj[u];
					for(Node node:vector){
						Integer v=node.vtx;
						if(distance[v]>distance[u]+node.wt){
							distance[v]=distance[u]+node.wt;
						}
					}
				}
			}
			for(int i=0;i<V;i++){
				if(distance[i]!=Integer.MAX_VALUE){
					System.out.print(distance[i]+" ");
				}
				else{
					System.out.print("-1 ");
				}
			}
			System.out.println("END");
		}
		
//		Longest Path in Directed Acyclic Graph
//		Complexity : O(V+E)
		
		void longestPathForDAG(int s){
			Stack<Integer> stk=new Stack<>();
			boolean[] visited=new boolean[V];
			for(int i=0;i<V;i++){
				if(!visited[i]){
					visited[i]=true;
					topologicalSorting(i, stk, visited);
				}
			}
			
			int[] distance=new int[V];
			Arrays.fill(distance, Integer.MIN_VALUE);
			distance[s]=0;
			while(!stk.isEmpty()){
				int u=stk.pop();
				if(distance[u]!=Integer.MIN_VALUE){
					Vector<Node> vector=adj[u];
					for(Node node:vector){
						Integer v=node.vtx;
						if(distance[v]<distance[u]+node.wt){
							distance[v]=distance[u]+node.wt;
						}
					}
				}
			}
			for(int i=0;i<V;i++){
				if(distance[i]!=Integer.MIN_VALUE){
					System.out.print(distance[i]+" ");
				}
				else{
					System.out.print("-1 ");
				}
			}
			System.out.println("END");
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
        
//        void allPaths2(int i,int j){
//			Vector<Integer> paths=new Vector<>(0,1);
//        	boolean[] visited=new boolean[V];
//        	visited[i]=true;
//        	paths.add(i);
//        	allPaths2(i, j, paths,visited);
//        }
//        void allPaths2(int i,int j,Vector<Integer> paths,boolean[] visited){
//        	if(i==j){
//        		System.out.println(paths);
//        		paths.remove((Object)i);
//        		visited[i]=false;
//        		return;
//        	}
//        	Vector<Node> vec=adj[i];
//        	for(Node n:vec){
//        		int v1=n.vtx;
//        		if(visited[v1]==false){
//        			visited[v1]=true;
//        			paths.add(v1);
//        			allPaths2(v1, j, paths,visited);
//        		}
//        	}
//        	visited[i]=false;
//        	paths.remove((Object)i);
//        }
        
//        SINGLE SOURCE SHORTEST PATH(FOR UNWEIGHTED GRAPH)
//        O(V+E)
        void unweightedShortestPath(int src){
        	int[] dist=new int[V];
        	int[] par=new int[V];
        	Arrays.fill(dist, -1);
        	Arrays.fill(par, -1);
        	Queue<Integer> q=new LinkedList<>();
        	dist[src]=0;
        	q.offer(src);
        	while(!q.isEmpty()){
        		int u=q.poll();
        		Vector<Node> vec=adj[u];
        		for(Node n:vec){
        			int v=n.vtx;
        			if(dist[v]==-1){
        				dist[v]=dist[u]+1;
        				par[v]=u;
        				q.offer(v);
        			}
        		}
        	}
        	for(int i=0;i<V;i++){
        		System.out.println(src+" => "+i+" : "+dist[i]);
        	}
        	for(int i=0;i<V;i++){
        		Stack<Integer> stk=new Stack<>();
        		stk.push(i);
        		int j=par[i];
        		while(j!=src && j!=-1){
        			stk.push(j);
        			j=par[j];
        		}
        		stk.push(j);
        		while(!stk.isEmpty()){
        			System.out.print(stk.pop()+" => ");
        		}
        		System.out.println("END");
        	}
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
			boolean[] visited=new boolean[V];
			Arrays.fill(dist, -1);
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
							dist[v]=newD;
							pq.offer(new Pair(v, newD));
						}
						else if(newD<dist[v]){
							pq.remove(new Pair(v, dist[v]));
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
        
      	//SINGLE SOURCE SHORTEST PATH
      	//O(VE)
      	//WORK FOR NEGATIVE WEIGHTS
      	//DETECT NEGATIVE WEIGHT CYCLE
      		
        void bellmanFord(int src){
        	int[] dist=new int[V];
        	int[] par=new int[V];
        	for(int i=0;i<V;i++){
        		dist[i]=Integer.MAX_VALUE;
        		par[i]=-1;
        	}
        	dist[src]=0;
        	for(int i=0;i<V-1;i++){
        		for(int j=0;j<V;j++){
        			Vector<Node> vec=adj[j];
        			for(Node n:vec){
        				int vtx=n.vtx;
        				int wt=n.wt;
        				if(dist[j]!=Integer.MAX_VALUE && dist[vtx]>dist[j]+wt){
        					dist[vtx]=dist[j]+wt;
        					par[vtx]=j;
        				}
        			}
        		}
        	}
        	for(int j=0;j<V;j++){
    			Vector<Node> vec=adj[j];
    			for(Node n:vec){
    				int vtx=n.vtx;
    				int wt=n.wt;
    				if(dist[j]!=Integer.MAX_VALUE && dist[vtx]>dist[j]+wt){
    					System.out.println("Negative Cycle");
    					return;
    				}
    			}
    		}
        	for(int i=0;i<V;i++){
        		if(dist[i]==Integer.MAX_VALUE){
        			System.out.print(src+"=>"+i+"=-1"+", ");
        		}
        		else{
        			System.out.print(src+"=>"+i+"="+dist[i]+", ");
        		}
        	}
        	System.out.println("END");
        }
        
        
        //ALL PAIR SHORTEST PATH
        //0(V^3)
        //WORK FOR NEGATIVE WEIGHTS
      	//DETECT NEGATIVE WEIGHT CYCLE
        
        void floydWarshall(){
        	int[][] dist=new int[V][V];
        	for(int i=0;i<V;i++){
        		for(int j=0;j<V;j++){
        			Vector<Node> vec=adj[i];
        			int flag=0;
        			for(Node n:vec){
        				if(n.vtx==j){
        					dist[i][j]=n.wt;
        					flag=1;
        					break;
        				}
        			}
        			if(flag==0){
        				if(i==j){
        					dist[i][j]=0;
        				}
        				else{
        					dist[i][j]=Integer.MAX_VALUE;
        				}
        			}
        		}
        	}
        	for(int k=0;k<V;k++){
        		for(int j=0;j<V;j++){
        			for(int i=0;i<V;i++){
        				if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
        					continue;
        				}
        				else if(dist[i][j]>dist[i][k]+dist[k][j]){
        					dist[i][j]=dist[i][k]+dist[k][j];
        				}
        			}
        		}
        	}
        	for(int i=0;i<V;i++){
        		if(dist[i][i]<0){
        			System.out.println("Negative Weight Cycle");
        			return;
        		}
        	}
        	
        	for(int i=0;i<V;i++){
        		for(int j=0;j<V;j++){
        			if(dist[i][j]==Integer.MAX_VALUE){
        				System.out.print(i+"=>"+j+"= -1, ");
        			}
        			else{
        				System.out.print(i+"=>"+j+"="+dist[i][j]+", ");
        			}
        		}
        		System.out.println("END");
        	}
        }
	}
	
	public static void main(String[] args) {
		Graph g=new Graph(11);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 6, 1);
		g.addEdge(7, 8, 1);
		
		g.display();
		g.bfs();
		g.dfs();
		System.out.println(g.hasPathdfs(0,1));
		System.out.println(g.hasPathbfs(0,1));
		System.out.println();
		
		System.out.println(g.hasPathdfs(2,6));
		System.out.println(g.hasPathbfs(2,6));
		System.out.println();
		
		System.out.println(g.hasPathdfs(4,7));
		System.out.println(g.hasPathbfs(4,7));
		System.out.println();
		
		System.out.println(g.hasPathdfs(7,9));
		System.out.println(g.hasPathbfs(7,9));
		System.out.println();
		
		System.out.println(g.hasPathdfs(7,8));
		System.out.println(g.hasPathbfs(7,8));
		System.out.println();
		
		System.out.println(g.hasPathdfs(7,7));
		System.out.println(g.hasPathbfs(7,7));

		System.out.println();
		System.out.println(g.hasPathdfs(0,4));
		System.out.println(g.hasPathbfs(0,4));
		System.out.println();
		
//		System.out.println(g.connectedComponents());
		
//		g.addEdge(0, 1, 1);
//		g.addEdge(0, 1, 2);
//		g.addEdge(0, 1, 3);
////		g.addEdge(1, 0, 12);
//		g.addEdge(1, 10, 1);
//		g.addEdge(1, 2, 1);
//		g.addEdge(2, 3, 1);
//		g.addEdge(2, 4, 1);
//		g.addEdge(4, 10, 1);
//		g.addEdge(9, 10, 1);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 9, 1);
//		g.addEdge(4, 5, 1);
//		g.addEdge(5, 6, 1);
//		g.addEdge(5, 8, 1);
//		g.addEdge(6, 7, 1);
//		g.addEdge(6, 4, -3);
//		g.display();
//		System.out.println(g.isCyclic());
//		g.topologicalSorting();
//		g.bellmanFord(2);
//		g.dijkstra(2);
//		g.allPaths(0, 9);
		
//		Graph g1=new Graph(4);
//		g1.addEdge(0, 3, 15);
//		g1.addEdge(3, 0, 1);
//		g1.addEdge(0, 1, 3);
//		g1.addEdge(1, 2, -2);
//		g1.addEdge(0, 2, 6);
//		g1.addEdge(2, 3, 2);
//		g1.floydWarshall();
//		Graph g=new Graph(8);
//		g.addEdge(0, 1,0);
//		g.addEdge(1, 2,0);
//		g.addEdge(2, 0,0);
//		g.addEdge(2, 4,0);
//		g.addEdge(3, 4,0);
//		g.addEdge(4, 5,0);
//		g.addEdge(5, 3,0);
//		g.addEdge(6, 5,0);
//		g.addEdge(6, 7,0);
//		System.out.println(g.connectedComponents());
		
//		Graph g=new Graph(8);
//		g.addEdge(0, 1, 1);
//		g.addEdge(0, 3, 1);
//		g.addEdge(1, 3, 1);
//		g.addEdge(2, 0, 1);
//		g.addEdge(1, 4, 1);
//		g.addEdge(2, 5, 1);
//		g.addEdge(3, 5, 1);
//		g.addEdge(3, 6, 1);
//		g.addEdge(6, 5, 1);
//		g.addEdge(4, 6, 1);
//		g.display();
//		System.out.println(g.isCyclic());
//		g.unweightedShortestPath(2);
		
//		Graph g=new Graph(7);
//		g.addEdge(0, 1, 5);
//		g.addEdge(0, 2, 3);
//		g.addEdge(1, 2, 2);
//		g.addEdge(1, 3, 6);
//		g.addEdge(2, 3, 7);
//		g.addEdge(2, 4, 4);
//		g.addEdge(2, 5, 2);
//		g.addEdge(3, 4, -1);
//		g.addEdge(3, 5, 1);
//		g.addEdge(4, 5, -2);
//		g.topologicalSorting();
//		g.shortestPathForDAG(1);
//		g.longestPathForDAG(1);

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
	}
}