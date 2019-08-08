package bootcamp.graphs;
import java.util.*;

import bootcamp.graphs.heapMapDataStructure.node;

import java.lang.*;
public class undirectedGraphClass {

	public static class undirectedGraph{
		private class edge{
			vertex vtx1;
			vertex vtx2;
			int weight;
			edge(vertex vtx1,vertex vtx2,int weight){
				this.vtx1=vtx1;
				this.vtx2=vtx2;
				this.weight=weight;
			}
			public String toString(){
				String retval=this.vtx1.name+"=>"+this.vtx2.name;
				return retval;
			}
		}
		public class vertex{
			int name;
			Map<vertex,edge> adjacentVertices;
			vertex(int name){
				this.name=name;
				adjacentVertices=new HashMap<>();
			}
			public ArrayList<vertex> getAdjacentVertices(){
				return new ArrayList<>(this.adjacentVertices.keySet());
			}
			public ArrayList<edge> getAdjacentEdges(){
				return new ArrayList<>(this.adjacentVertices.values());
			}
			public String toString(){
				String retval=this.name+"";
				return retval;
			}
			public boolean equals(Object o){
				vertex v=(vertex)o;
				return v.name==this.name;
			}
		}
		List<vertex> vertices;
		public undirectedGraph() {
			vertices=new ArrayList<>();
		}
		
		public void addVertex(int name){
			vertex newVertex=new vertex(name);
			vertices.add(newVertex);
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
		
		public void addEdge(int s1,int s2,int weight){
			vertex vtx1=getVertex(s1);
			vertex vtx2=getVertex(s2);
			edge newEdge=new edge(vtx1, vtx2, weight);
			vtx1.adjacentVertices.put(vtx2, newEdge);
			vtx2.adjacentVertices.put(vtx1, newEdge);
		}
		
		public void display(){
			System.out.println(this);
		}
		
		public String toString(){
			String retval="";
			for(vertex v:this.vertices){
				retval+=v.name+" => ";
				Set<vertex> s=v.adjacentVertices.keySet();
				for(vertex adjv:s){
					retval+=adjv.name+", ";
				}
				retval+="\n";
			}
			return retval;
		}
		
		public void depthFirstTraversal(){
			LinkedList<vertex> stk=new LinkedList<>();
			HashSet<vertex> visited=new HashSet<>();
			for(vertex v:this.vertices){
				if(!visited.contains(v)){
					stk.addFirst(v);
					visited.add(v);
					while(!stk.isEmpty()){
						vertex curr=stk.removeFirst();
						System.out.print(curr.name+", ");
						for(vertex adjv:curr.getAdjacentVertices()){
							if(!visited.contains(adjv)){
								stk.addFirst(adjv);
								visited.add(adjv);
							}
						}
					}
				}
			}
			System.out.println("END");
		}
		
		public void depthFirstTraversalrecursive(){
			HashSet<vertex> visited=new HashSet<>();
			for(vertex v:this.vertices){
				if(!visited.contains(v)){
					visited.add(v);
					this.depthFirstTraversalrecursive(v, visited);
				}
			}
			System.out.println("END");
		}
		
		private void depthFirstTraversalrecursive(vertex vtx,HashSet<vertex> visited){
			System.out.print(vtx.name+" ");
			for(vertex v:vtx.getAdjacentVertices()){
				if(!visited.contains(v)){
					visited.add(v);
					this.depthFirstTraversalrecursive(v, visited);
				}
			}
		}
		
		public void breadthFirstTraversal(){
			LinkedList<vertex> q=new LinkedList<>();
			HashSet<vertex> visited=new HashSet<>();
			for(vertex v:this.vertices){
				if(!visited.contains(v)){
					q.addLast(v);
					visited.add(v);
					while(!q.isEmpty()){
						vertex curr=q.removeFirst();
						System.out.print(curr.name+", ");
						for(vertex adjv:curr.getAdjacentVertices()){
							if(!visited.contains(adjv)){
								q.addLast(adjv);
								visited.add(adjv);
							}
						}
					}
				}
			}
			System.out.println("END");
		}
		
		public boolean hasPathdfs(int s1,int s2){
			vertex vtx1=this.getVertex(s1);
			vertex vtx2=this.getVertex(s2);
			if(vtx1==null || vtx2==null){
				return false;
			}
			LinkedList<vertex> stk=new LinkedList<>();
			HashSet<vertex> visited=new HashSet<>();
			stk.addFirst(vtx1);
			visited.add(vtx1);
			while(!stk.isEmpty()){
				vertex curr=stk.removeFirst();
				if(curr.adjacentVertices.containsKey(vtx2)){
					return true;
				}
				for(vertex v:curr.getAdjacentVertices()){
					if(!visited.contains(v)){
						stk.addFirst(v);
						visited.add(v);
					}
				}
			}
			return false;
		}
		
		public boolean hasPathdfsRecursive(int s1,int s2){
			vertex vtx1=this.getVertex(s1);
			vertex vtx2=this.getVertex(s2);
			if(vtx1==null || vtx2==null){
				return false;
			}
			HashSet<vertex> visited=new HashSet<>();
			visited.add(vtx1);
			return hasPathdfsRecursive(vtx1,vtx2,visited);
		}
		
		private boolean hasPathdfsRecursive(vertex vtx1,vertex vtx2,HashSet<vertex> visited){
			if(vtx1.adjacentVertices.containsKey(vtx2)){
				return true;
			}
			for(vertex v:vtx1.getAdjacentVertices()){
				if(!visited.contains(v)){
					visited.add(v);
					if(this.hasPathdfsRecursive(v, vtx2, visited)){
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean hasPathbfs(int s1,int s2){
			vertex vtx1=this.getVertex(s1);
			vertex vtx2=this.getVertex(s2);
			if(vtx1==null || vtx2==null){
				return false;
			}
			LinkedList<vertex> q=new LinkedList<>();
			HashSet<vertex> visited=new HashSet<>();
			q.addLast(vtx1);
			visited.add(vtx1);
			while(!q.isEmpty()){
				vertex curr=q.removeFirst();
				if(curr.adjacentVertices.containsKey(vtx2)){
					return true;
				}
				for(vertex v:curr.getAdjacentVertices()){
					if(!visited.contains(v)){
						q.addLast(v);
						visited.add(v);
					}
				}
			}
			return false;
		}
		
		public ArrayList<ArrayList<String>> getConnectedComponents(){
			ArrayList<ArrayList<String>> major=new ArrayList<>();
			ArrayList<String> minor=new ArrayList<>();
			HashSet<vertex> visited=new HashSet<>();
			LinkedList<vertex> stk=new LinkedList<>();
			for(vertex v:this.vertices){
				if(!visited.contains(v)){
					minor=new ArrayList<>();
					visited.add(v);
					stk.addFirst(v);
					while(!stk.isEmpty()){
						vertex curr=stk.removeFirst();
						minor.add(curr.name+", ");
						for(vertex adjv:curr.getAdjacentVertices()){
							if(!visited.contains(adjv)){
								visited.add(adjv);
								stk.addFirst(adjv);
							}
						}
					}
					major.add(minor);
				}
			}
			return major;
		}
		
		public boolean isConnected(){
			LinkedList<vertex> q=new LinkedList<>();
			HashSet<vertex> visited=new HashSet<>();
			int flag=0;
			for(vertex v:this.vertices){
				if(!visited.contains(v)){
					q.addLast(v);
					visited.add(v);
					if(flag==1){
						return false;
					}
					flag++;
					while(!q.isEmpty()){
						vertex curr=q.removeFirst();
						for(vertex adjv:curr.getAdjacentVertices()){
							if(!visited.contains(adjv)){
								q.addLast(adjv);
								visited.add(adjv);
							}
						}
					}
				}
			}
			return true;
		}
		
		public boolean isCyclic(){
			LinkedList<vertex> q=new LinkedList<>();
			HashMap<vertex,vertex> visited=new HashMap<>();
			for(vertex v:this.vertices){
				if(!visited.containsKey(v)){
					q.addLast(v);
					visited.put(v,null);
					while(!q.isEmpty()){
						vertex curr=q.removeFirst();
						for(vertex adjv:curr.getAdjacentVertices()){
							if(!visited.containsKey(adjv)){
								q.addLast(adjv);
								visited.put(adjv,curr);
							}
							else{
								if(visited.get(curr)!=adjv){
									return true;
								}
							}
						}
					}
				}
			}
			return false;
		}
		
		public boolean isTree(){
			return this.isConnected()&&!this.isCyclic();
		}
		
		public boolean isBipartite(){
			LinkedList<vertex> q=new LinkedList<>();
			HashMap<vertex,Boolean> visited=new HashMap<>();
			for(vertex v:this.vertices){
				if(!visited.containsKey(v)){
					visited.put(v, true);
					q.addLast(v);
					while(!q.isEmpty()){
						vertex curr=q.removeFirst();
						for(vertex adjv:curr.getAdjacentVertices()){
							if(!visited.containsKey(adjv)){
								if(visited.get(curr)==true){
									visited.put(adjv,false);
								}
								else{
									visited.put(adjv, true);
								}
								q.addLast(adjv);
							}
							else{
								if(visited.get(curr)==visited.get(adjv)){
									return false;
								}
							}
						}
					}
				}
			}
			return true;
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
			int size=this.vertices.size();
			int[] dist=new int[size];
			for(int i=0;i<size;i++){
				dist[i]=-1;
			}
			HashSet<vertex> visited=new HashSet<>();
			pq.offer(new pair(0,this.getVertex(src)));
			dist[src]=0;
			while(!pq.isEmpty()){
				pair p=pq.poll();
				visited.add(p.val);
				vertex v=p.val;
				for(edge e:v.getAdjacentEdges()){
					vertex v1=e.vtx1==v?e.vtx2:e.vtx1;
					if(!visited.contains(v1)){
						int newD=p.key+e.weight;
						if(dist[v1.name]==-1){
							pq.offer(new pair(newD,v1));
							dist[v1.name]=newD;
						}
						else{
							Iterator<pair> it=pq.iterator();
							while(it.hasNext()){
								pair p1=it.next();
								if(p1.val.name==v1.name){
									if(newD<p1.key){
										p1.key=newD;
										dist[p1.val.name]=newD;
									}
									break;
								}
							}
						}
					}
				}
			}
			for(int i=0;i<dist.length;i++){
				if(dist[i]==0){
					continue;
				}
				if(dist[i]<0){
					System.out.print("-1 ");
				}
				else{
					System.out.print(dist[i]+" ");
				}
			}
		}
		
		//DIJKSTRA THROUGH BINARY HEAP AND MAP(O(ELOGV))
		
		public void dijkstra(int s){
			vertex src=this.getVertex(s);
			if(src==null){
				return;
			}
			heapMapDataStructure heap=new heapMapDataStructure();
			HashMap<vertex,vertex> parent=new HashMap<>();
			HashMap<vertex,Integer> distance=new HashMap<>();
			int[] dist=new int[this.vertices.size()];
			for(vertex v:this.vertices){
				heap.add(Integer.MAX_VALUE, v);
			}
			heap.decrease(0, src);
			parent.put(src, null);
			while(!heap.isEmpty()){
				 node heapNode=heap.remove();
				 dist[heapNode.v.name]=heapNode.dist;
				 distance.put(heapNode.v, heapNode.dist);
				 
				 for(edge e:heapNode.v.getAdjacentEdges()){
					 vertex vtx=e.vtx1==heapNode.v?e.vtx2:e.vtx1;
					 if(heap.contains(vtx)){
						 int newdistance=heapNode.dist+e.weight;
						 if(newdistance<heap.get(vtx)){
							 heap.decrease(newdistance, vtx);
							 parent.put(vtx, heapNode.v);
						 }
					 }
				 }
			}
			System.out.println(distance);
			for(int i=0;i<dist.length;i++){
				System.out.print(i+"="+dist[i]+", ");
			}
			
			//FOR PRINTING PATHS
			
			System.out.println("PATHS");
			Set<vertex> set=parent.keySet();
			for(vertex v:set){
				LinkedList<vertex> stk=new LinkedList<>();
				vertex v1=v;
				while(v1!=null && !v1.equals(src)){
					stk.addFirst(v1);
					v1=parent.get(v1);
				}
				if(v1==null){
					continue;
				}
				stk.addFirst(src);
				while(!stk.isEmpty()){
					System.out.print(stk.removeFirst().name+", ");
				}
				System.out.println("END");
			}
		}
		
		//DONT USE
		
		public void dijkstra1(int src){
			int v=this.vertices.size();
			int[] key=new int[v];
			int[] par=new int[v];
			boolean[] spt=new boolean[v];
			for(int i=0;i<v;i++){
				key[i]=Integer.MAX_VALUE;
				spt[i]=false;
			}
			key[src]=0;
			par[src]=-1;
			for(int i=0;i<v-1;i++){
				int min=Integer.MAX_VALUE;
				int idx=-1;
				for(int j=0;j<v;j++){
					if(spt[j]==false && key[j]<=min){
						min=key[j];
						idx=j;
					}
				}
				spt[idx]=true;
				vertex vtx=this.getVertex(idx);
				for(edge e:vtx.getAdjacentEdges()){
					vertex other=e.vtx1==vtx?e.vtx2:e.vtx1;
					if(spt[other.name]==false && key[idx]+e.weight<key[other.name]){
						key[other.name]=key[idx]+e.weight;
						par[other.name]=idx;
					}
				}
			}
			for(int i=0;i<v;i++){
				System.out.print(i+"="+key[i]+", ");
			}
			System.out.println("END");
		}
	
		//PRIM MST THROUGH BINARY HEAP AND MAP(O(ELOGV))
		
		public void primMST(){
			heapMapDataStructure heap=new heapMapDataStructure();
			HashMap<vertex,edge> map=new HashMap<>();
			for(vertex v:this.vertices){
				heap.add(Integer.MAX_VALUE, v);
			}
			vertex src=this.vertices.get(0);
			heap.decrease(0, src);
			while(!heap.isEmpty()){
				node heapNode=heap.remove();
				for(edge e:heapNode.v.getAdjacentEdges()){
					vertex vtx=e.vtx1==heapNode.v?e.vtx2:e.vtx1;
					if(heap.contains(vtx)){
						int newDistance=e.weight;
						if(newDistance<heap.get(vtx)){
							heap.decrease(newDistance, vtx);
							map.put(vtx, e);
						}
					}
				}
			}
			ArrayList<edge> list=new ArrayList<>(map.values());
			System.out.println(list);
		}
		
		public void primMST1(){
			int v=this.vertices.size();
			int[] key=new int[v];
			int[] par=new int[v];
			boolean[] spt=new boolean[v];
			for(int i=0;i<v;i++){
				key[i]=Integer.MAX_VALUE;
				spt[i]=false;
			}
			key[0]=0;
			par[0]=-1;
			for(int i=0;i<v-1;i++){
				int min=Integer.MAX_VALUE;
				int idx=-1;
				for(int j=0;j<v;j++){
					if(spt[j]==false && key[j]<=min){
						min=key[j];
						idx=j;
					}
				}
				spt[idx]=true;
				vertex vtx=this.getVertex(idx);
				for(edge e:vtx.getAdjacentEdges()){
					vertex other=e.vtx1==vtx?e.vtx2:e.vtx1;
					if(spt[other.name]==false && e.weight<key[other.name]){
						key[other.name]=e.weight;
						par[other.name]=idx;
					}
				}
			}
			for(int i=0;i<v;i++){
				System.out.print(i+"="+key[i]+", ");
			}
			System.out.println("END");
		}
	}
	public static void main(String[] args) {
		undirectedGraph g=new undirectedGraph();
		
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("e");
//		g.addVertex("f");
//		g.addEdge("a", "b", 5);
//		g.addEdge("b", "c", 2);
//		g.addEdge("c", "d", 3);
//		g.addEdge("a", "d", 9);
//		g.addEdge("a", "e", 2);
//		g.addEdge("e", "f", 3);
//		g.addEdge("d", "f", 2);
//		g.display();
//		g.dijkstra("a");
		
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		
		g.addEdge(0, 1, 3);
		g.addEdge(0, 3, 1);
		g.addEdge(1, 3, 3);
		g.addEdge(1, 2, 1);
		g.addEdge(3, 2, 1);
		g.addEdge(3, 4, 6);
		g.addEdge(2, 4, 5);
		g.addEdge(2, 5, 4);
		g.addEdge(4, 5, 2);
		g.addEdge(6, 7, 2);
		
		g.display();
		g.dijkstra(4);
		g.dijkstra1(4);
		g.dijkstra2(4);
//		g.primMST();
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("e");
//		g.addVertex("f");
//		g.addVertex("g");
//		
//		g.addEdge("a", "b",3);
//		g.addEdge("a", "d",2);
//		g.addEdge("b", "c",1);
//		g.addEdge("c", "d",9);
//		g.addEdge("d", "e",5);
//		g.addEdge("e", "f",2);
//		g.addEdge("e", "g",4);
//		g.addEdge("f", "g",11);
//		
//		g.display();
//		g.dijkstra("c");
//		g.primMST();
//		g.depthFirstTraversal();
//		g.depthFirstTraversalrecursive();
//		System.out.println(g.isBipartite());
//		g.removeEdge("e", "g");
//		g.display();
//		System.out.println(g.isBipartite());
//		g.display();
//		System.out.println(g.isTree());
//		g.removeEdge("a", "b");
//		g.removeEdge("f", "g");
//		g.display();
//		System.out.println(g.isTree());
		
//		g.depthFirstTraversal();
//		g.breadthFirstTraversal();
//		System.out.println(g.hasPathdfs("a", "g"));
//		System.out.println(g.hasPathbfs("a", "g"));
//		System.out.println(g.hasPathdfsRecursive("a", "g"));	
//		g.depthFirstTraversal();
//		g.breadthFirstTraversal();
//		System.out.println(g.hasPathdfs("a", "g"));
//		System.out.println(g.hasPathbfs("a", "g"));
//		System.out.println(g.hasPathdfsRecursive("a", "g"));
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isConnected());
//		System.out.println(g.isCyclic());
//		g.removeEdge("d", "e");
//		System.out.println();
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isConnected());
//		System.out.println(g.isCyclic());
//		g.removeEdge("c", "d");
//		g.removeEdge("a", "d");
//		System.out.println();
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isConnected());
//		System.out.println(g.isCyclic());
//		g.removeEdge("e", "g");
//		System.out.println();
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isConnected());
//		System.out.println(g.isCyclic());
//		g.removeEdge("a", "d");
//		g.removeEdge("e", "d");
//		g.display();
//		
//		g.removeVertex("d");
//		g.display();
		
	}

}
