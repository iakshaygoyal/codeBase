package bootcamp.graphs;
import java.util.*;
import bootcamp.graphs.heapMapDataStructure1.node;
import bootcamp.graphs.undirectedGraphClass.undirectedGraph.vertex;

import java.lang.*;
public class directedGraphClass {

	public static class directedGraph{
		private class edge{
			vertex vtx1;
			vertex vtx2;
			int weight;
			edge(vertex vtx1,vertex vtx2,int weight){
				this.vtx1=vtx1;
				this.vtx2=vtx2;
				this.weight=weight;
			}
		}
		public class vertex{
			String name;
			Map<vertex,edge> adjacentVertices;
			vertex(String name){
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
				String retval=this.name;
				return retval;
			}
		}
		List<vertex> vertices;
		public directedGraph() {
			vertices=new ArrayList<>();
		}
		
		public void addVertex(String name){
			if(getVertex(name)!=null){
				return;
			}
			vertex newVertex=new vertex(name);
			vertices.add(newVertex);
		}
		
		public vertex getVertex(String name){
			vertex retval=null;
			for(vertex v:vertices){
				if(v.name.equals(name)){
					retval=v;
					break;
				}
			}
			return retval;
		}
		
		public void addEdge(String s1,String s2,int weight){
			vertex vtx1=getVertex(s1);
			vertex vtx2=getVertex(s2);
			edge newEdge=new edge(vtx1, vtx2, weight);
			vtx1.adjacentVertices.put(vtx2, newEdge);
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
		
		
		//ALWAYS USE THE RECURSIVE DFS AS IT SHOWS WHEN DID WE EXPLORE A PARTICULAR VERTEX COMPLETELY
		
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
		
		
		//IN ALL THE HAS PATH FUNCTIONS DO REMEMBER THE POSITION OF VTX1 AND VTX2 WHILE CHECKING FOR ADJACENT VERTEX		
		
		public boolean hasPathdfs(String s1,String s2){
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
		
		public boolean hasPathdfsRecursive(String s1,String s2){
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
					if(this.hasPathdfsRecursive(v,vtx2, visited)){
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean hasPathbfs(String s1,String s2){
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
			HashMap<vertex,vertex> visited=new HashMap<>();
			HashSet<vertex> marked=new HashSet<>();
			for(vertex v:this.vertices){
				if(!visited.containsKey(v)){
					visited.put(v, null);
					if(this.isCyclic(v, visited, marked)){
						return true;
					}
				}
			}
			return false;
		}
		
		private boolean isCyclic(vertex vtx,HashMap<vertex,vertex> visited,HashSet<vertex> marked){
			for(vertex v:vtx.getAdjacentVertices()){
				if(!visited.containsKey(v)){
					visited.put(v, vtx);
					if(this.isCyclic(v,visited,marked)){
						return true;
					}
				}
				else{
					if(!marked.contains(v)){
						return true;
					}
				}
			}
			marked.add(vtx);
			return false;
		}
		
		public boolean isTree(){
			return this.isConnected() && !this.isCyclic();
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
		
		public void topologicalSorting(){
			HashSet<vertex> visited=new HashSet<>();
			LinkedList<vertex> stk=new LinkedList<>();
			for(vertex v:this.vertices){
				if(!visited.contains(v)){
					this.topologicalSorting(v,visited,stk);
				}
			}
			while(!stk.isEmpty()){
				System.out.print(stk.removeFirst().name+", ");
			}
			System.out.println("END");
		}
		
		private void topologicalSorting(vertex vtx,HashSet<vertex> visited,LinkedList<vertex> stk){
			for(vertex v:vtx.getAdjacentVertices()){
				if(!visited.contains(v)){
					visited.add(v);
					this.topologicalSorting(v, visited, stk);
				}
			}
			stk.addFirst(vtx);
		}
		
		public void dijkstra(String s){
			vertex src=this.getVertex(s);
			if(src==null){
				return;
			}
			heapMapDataStructure1 heap=new heapMapDataStructure1();
			HashMap<vertex,vertex> parent=new HashMap<>();
			HashMap<vertex,Integer> distance=new HashMap<>();
			for(vertex v:this.vertices){
				heap.add(Integer.MAX_VALUE, v);
			}
			heap.decrease(0, src);
			parent.put(src, null);
			while(!heap.isEmpty()){
				 node heapNode=heap.remove();
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
			
			//FOR PRINTING PATHS
			
			System.out.println("PATHS");
			Set<vertex> set=parent.keySet();
			for(vertex v:set){
				LinkedList<vertex> stk=new LinkedList<>();
				vertex v1=v;
				while(v1!=null && !v1.equals(src)){//THE CHECK FOR V1!=NULL IS APPLIED FOR THOSE VERTICES THT CANT BE REACHED THROUGH SOURCE
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
	}
	
	public static void main(String[] args) {
		directedGraph g=new directedGraph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		
		g.addEdge("a", "b",3);
//		g.addEdge("b", "a", 4);
		g.addEdge("a", "d",7);
		g.addEdge("b", "c",1);
		g.addEdge("c", "d",9);
		g.addEdge("d", "e",5);
		g.addEdge("e", "f",2);
		g.addEdge("e", "g",4);
		g.addEdge("f", "g",11);
//		g.addEdge("g", "f", 3);
		
		g.display();
		g.dijkstra("c");
//		g.depthFirstTraversalrecursive();
//		g.topologicalSorting();
//		g.removeVertex("f");
//		g.removeEdge("a", "b");
//		g.display();
//		System.out.println(g.hasPathbfs("c", "c"));
//		System.out.println(g.hasPathdfs("c", "c"));
//		System.out.println(g.hasPathdfsRecursive("c", "c"));
//		
//		System.out.println(g.hasPathbfs("c", "g"));
//		System.out.println(g.hasPathdfs("c", "g"));
//		System.out.println(g.hasPathdfsRecursive("c", "g"));
//
//		System.out.println(g.hasPathbfs("g", "c"));
//		System.out.println(g.hasPathdfs("g", "c"));
//		System.out.println(g.hasPathdfsRecursive("g", "c"));
//		g.breadthFirstTraversal();
//		g.depthFirstTraversal();
		
		
		
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isCyclic());
//		System.out.println(g.isConnected());
//		g.removeEdge("d", "e");
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isCyclic());
//		System.out.println(g.isConnected());
//		g.removeEdge("b", "a");
//		g.removeEdge("g", "f");
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isCyclic());
//		System.out.println(g.isConnected());
//		g.removeEdge("e", "f");
//		g.addEdge("a", "a", 11);
//		g.display();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isCyclic());
//		System.out.println(g.isConnected());
		
		
		
//		g.breadthFirstTraversal();
//		g.depthFirstTraversal();
	}

}
