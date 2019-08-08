package Graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;


import Heap.Heap;

public class Graph {
	
	private class Edge{
		Vertex one;
		Vertex two;
		int weight;
		
		Edge(Vertex one, Vertex two, int weight){
			this.one = one;
			this.two = two;
			this.weight = weight;
		}
		
		public String toString(){
			return this.one.name + " => " + this.two.name + " = "+this.weight + "\n";
		}
	}
	
	private
	class Vertex{
		String name;
		HashMap<Vertex, Edge> adjacentVertices;
		
		Vertex(String name){
			this.name = name;
			this.adjacentVertices = new HashMap<>();
		}
		
		private void addEdge(Edge edge){
			Vertex other = edge.one == this ? edge.two : edge.one;
			
			if(this.isAdjacentTo(other)){
				return;
			}
			this.adjacentVertices.put(other, edge);
		}
		
		private void removeEdge(Vertex other){
			if(!this.isAdjacentTo(other)){
				return;
			}
			this.adjacentVertices.remove(other);
		}
		
		private boolean isAdjacentTo(Vertex other){
			return this.adjacentVertices.containsKey(other);
		}
		
		private ArrayList<Vertex> getAdjacentVertices(){
			ArrayList<Vertex> retval = new ArrayList<>();
			Set<Vertex> vertices = this.adjacentVertices.keySet();
			
			for(Vertex adjV : vertices){
				retval.add(adjV);
			}
			
			return retval;
		}
		
		public String toString(){
			String retval = "";
			
			retval+=this.name+" => ";
			
			for(Vertex adjV : this.getAdjacentVertices()){
				retval+=adjV.name+", ";
			}
			
			retval+="END\n";
			
			return retval;
		}
		
//		public String toString(){
//			return this.name+", ";
//		}
		
		public int hashCode(){
			return this.name.hashCode();
		}
		
		public boolean equals(Object other) {
			if (other == null) {
				return false;
			}

			Vertex otherVertex = (Vertex) other;
			return this.name.equals(otherVertex.name);
		}
	}

	
	private ArrayList<Vertex> vertices;
	
	public Graph(){
		this.vertices = new ArrayList<>();
	}
	
	public int numVertices(){
		return this.vertices.size();
	}
	
	public void addVertex(String name){
		if(this.containsVertex(name)){
			return;
		}
		
		Vertex newVertex = new Vertex(name);
		this.vertices.add(newVertex);
	}
	
	public void removeVertex(String name){
		if(!this.containsVertex(name)){
			return;
		}
		
		Vertex vtx = this.getVertex(name);
		
		for(Vertex adjV : vtx.getAdjacentVertices()){
			adjV.removeEdge(vtx);
		}
		
		this.vertices.remove(vtx);
	}
	
	public boolean containsVertex(String name){
		return this.getVertex(name) != null;
	}
	
	private Vertex getVertex(String name){
		Vertex retval = null;
		
		for(Vertex v : this.vertices){
			if(v.name.equals(name)){
				retval = v;
				break;
			}
		}
		
		return retval;
	}
	
	public int numEdges(){
		int retval = 0;
		
		for(Vertex v : this.vertices){
			retval+=v.adjacentVertices.size();
		}
		
		retval/=2;
		return retval;
	}
	
	public void addEdge(String v1, String v2, int weight){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || vtx1.isAdjacentTo(vtx2)){
			return;
		}
		
		Edge newEdge = new Edge(vtx1, vtx2, weight);
		
		vtx1.addEdge(newEdge);
		vtx2.addEdge(newEdge);
	}
	
	public void removeEdge(String v1, String v2){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)){
			return;
		}
		
		vtx1.removeEdge(vtx2);
		vtx2.removeEdge(vtx1);
	}
	
	public boolean containsEdge(String v1, String v2){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)){
			return false;
		}
		
		return true;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
//		return this.vertices.toString();
		String retval = "";
		
		for(Vertex v : this.vertices){
			retval+=v.toString();
		}
		
		return retval;
	}
	
//	public String toString(){
//		String retval = "";
//		
//		for(Vertex v : this.vertices){
//			retval+=v.toString();
//		}
//		
//		retval+="END\n\n";
//		
//		for(Edge e : this.getAllEdges()){
//			retval+=e.toString();
//		}
//		
//		return retval;
//	}
	
	public boolean hasPathFromToDFS(String v1, String v2){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null){
			return false;
		}
		
		return this.hasPathFromToDFS(vtx1, vtx2);
	}
	
	private boolean hasPathFromToDFS(Vertex vtx1, Vertex vtx2){
		HashMap<Vertex, Boolean> map = new HashMap<>();
		LinkedList<Vertex> stk = new LinkedList<>();
		stk.addFirst(vtx1);
		map.put(vtx1, true);
		
		while(!stk.isEmpty()){
			Vertex current = stk.removeFirst();
			if(current.isAdjacentTo(vtx2)){
				return true;
			}
			
			for(Vertex adjv : current.getAdjacentVertices()){
				if(!map.containsKey(adjv)){
					stk.addFirst(adjv);
					map.put(adjv, true);
				}
			}
		}
		
		return false;
	}
	
	// Recursive Approach for DFS
//	private boolean hasPathFromToDFS(Vertex vtx1, Vertex vtx2){
//		HashMap<Vertex, Boolean> map = new HashMap<>();
//		map.put(vtx1, true);
//		return this.hasPathFromToDFS(vtx1, vtx2, map);
//	}
//
//	private boolean hasPathFromToDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> map){
//		if(vtx1.isAdjacentTo(vtx2)){
//			return true;
//		}
//		
//		for(Vertex adjV : vtx1.getAdjacentVertices()){
//			if(!map.containsKey(adjV)){
//				map.put(adjV, true);
//				if(this.hasPathFromToDFS(adjV, vtx2, map)){
//					return true;
//				}
//			}
//		}
//		
//		return false;
//	}
	
	public boolean hasPathFromToBFS(String v1, String v2){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null){
			return false;
		}
		
		return this.hasPathFromToBFS(vtx1, vtx2);
	}
	
	private boolean hasPathFromToBFS(Vertex vtx1, Vertex vtx2){
		HashMap<Vertex, Boolean> map = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.addLast(vtx1);
		map.put(vtx1, true);
		
		while(!queue.isEmpty()){
			Vertex vtx = queue.removeFirst();
			if(vtx.isAdjacentTo(vtx2)){
				return true;
			}
			
			for(Vertex adjV : vtx.getAdjacentVertices()){
				if(!map.containsKey(adjV)){
					queue.addLast(adjV);
					map.put(adjV, true);
				}
			}
		}
		
		return false;
	}
	
	public void depthFirstTraversal(){
		HashMap<Vertex, Boolean> map = new HashMap<>();
		LinkedList<Vertex> stk = new LinkedList<>();
		
		for(Vertex v : this.vertices){
			if(!map.containsKey(v)){
				stk.addFirst(v);
				map.put(v, true);
				
				while(!stk.isEmpty()){
					Vertex vtx = stk.removeFirst();
					System.out.print(vtx.name+", ");
					for(Vertex adjV : vtx.getAdjacentVertices()){
						if(!map.containsKey(adjV)){
							stk.addFirst(adjV);
							map.put(adjV, true);
						}
					}
				}
			}
		}
		System.out.println("END");
	}

	
	public void breadthFirstTraversal(){
		HashMap<Vertex, Boolean> map = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		
		for(Vertex v : this.vertices){
			if(!map.containsKey(v)){
				queue.addLast(v);
				map.put(v, true);
				
				while(!queue.isEmpty()){
					Vertex vtx = queue.removeFirst();
					System.out.print(vtx.name+", ");
					for(Vertex adjV : vtx.getAdjacentVertices()){
						if(!map.containsKey(adjV)){
							queue.addLast(adjV);
							map.put(adjV, true);
						}
					}
				}
			}
		}
		System.out.println("END");
	}
	
	// Wrong method (if the graph is not connected)
//	public void breadthFirstTraversal(){
//		HashMap<Vertex, Boolean> map = new HashMap<>();
//		LinkedList<Vertex> queue = new LinkedList<>();
//		
//			Vertex v = this.vertices.get(0);
//			if(!map.containsKey(v)){
//				queue.addLast(v);
//				map.put(v, true);
//				
//				while(!queue.isEmpty()){
//					Vertex vtx = queue.removeFirst();
//					System.out.print(vtx.name+", ");
//					for(Vertex adjV : vtx.getAdjacentVertices()){
//						if(!map.containsKey(adjV)){
//							queue.addLast(adjV);
//							map.put(adjV, true);
//						}
//					}
//				}
//			}
//			System.out.println("END");
//	}	
	
	public ArrayList<ArrayList<String>> getConnectedComponents(){
		HashMap<Vertex, Boolean> map = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		
		for(Vertex v : this.vertices){
			if(!map.containsKey(v)){
				queue.addLast(v);
				map.put(v, true);
				ArrayList<String> arrList = new ArrayList<>();
				
				while(!queue.isEmpty()){
					Vertex vtx = queue.removeFirst();
					arrList.add(vtx.name);
					for(Vertex adjV : vtx.getAdjacentVertices()){
						if(!map.containsKey(adjV)){
							queue.addLast(adjV);
							map.put(adjV, true);
						}
					}
				}
				list.add(arrList);
			}
		}
		return list;
	}
	
	public boolean isConnected(){
		if(this.getConnectedComponents().size() == 1){
			return true;
		}
		return false;
	}
	
	public boolean isAcyclic(){
			HashMap<Vertex, Vertex> map = new HashMap<>();
			LinkedList<Vertex> stk = new LinkedList<>();
			
			for(Vertex v : this.vertices){
				if(!map.containsKey(v)){
					stk.addFirst(v);
					map.put(v, null);
					
					while(!stk.isEmpty()){
						Vertex vtx = stk.removeFirst();
						for(Vertex adjV : vtx.getAdjacentVertices()){
							if(!map.containsKey(adjV)){
								stk.addFirst(adjV);
								map.put(adjV, vtx);
							}
							else{
								if(map.get(vtx) != adjV){
									return false;
								}
							}
						}
					}
				}
			}
			return true;
	}
	
	public boolean isTree(){
		return this.isAcyclic() && this.isConnected();
	}
	
	public boolean isBipartite(){
		HashMap<Vertex, String> map = new HashMap<>();
		LinkedList<Vertex> stk = new LinkedList<>();
		
		for(Vertex v : this.vertices){
			if(!map.containsKey(v)){
				stk.addFirst(v);
				map.put(v, "red");
				
				while(!stk.isEmpty()){
					Vertex vtx = stk.removeFirst();
					for(Vertex adjV : vtx.getAdjacentVertices()){
						if(!map.containsKey(adjV)){
							stk.addFirst(adjV);
							String x="blue";
							if(map.get(vtx).equals("blue")){
								x="red";
							}
							map.put(adjV, x);
						}
						else{
							if(map.get(vtx).equals(map.get(adjV))){
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
//	public void primsMininmumSpanningTree(String s){
//		Vertex sourceVertex = this.getVertex(s);
//		if(sourceVertex == null){
//			return;
//		}
//		
//		Heap<Integer, Vertex> heap = new Heap<Integer, Graph.Vertex>();
//		HashMap<Vertex, Integer> map1 = new HashMap<>();
//		
//		HashMap<Vertex, Edge> map2 = new HashMap<>();
//		ArrayList<Edge> spanningTreeEdges = new ArrayList<>();
//		
//		int i=0;
//		for(Vertex v : this.vertices){
//			heap.add(Integer.MAX_VALUE, v);
//			map1.put(v, i);
//			i++;
//		}
//		
//		int sourceIndex = map1.get(sourceVertex);
//		heap.decrease(sourceIndex, 0, map1);
//		
//		Vertex currentVertex = null;
//		while(!heap.isEmpty()){
//			try {
//				currentVertex = heap.removePrim(map1);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			
//			if(map2.containsKey(currentVertex)){
//				spanningTreeEdges.add(map2.get(currentVertex));
//			}
//			
//			for(Vertex adjv : currentVertex.getAdjacentVertices()){
//					if(map1.containsKey(adjv)){
//						int currentIndex = map1.get(adjv);
//						Integer currentValue = heap.getKey(currentIndex);
//						Edge currentEdge = currentVertex.adjacentVertices.get(adjv);
//						int wt = currentEdge.weight;
//						if(currentValue > wt){
//							heap.decrease(currentIndex, wt, map1);
//							map2.put(adjv, currentEdge);
//						}
//					}
//			}
//			
//		}
//		
//		for(Edge e : spanningTreeEdges){
//			System.out.print(e);
//		}
//	}
//	
//	public void dijkstra(String s){
//		Vertex sourceVertex = this.getVertex(s);
//		if(sourceVertex == null){
//			return;
//		}
//		
//		Heap<Integer, Vertex> heap = new Heap<Integer, Graph.Vertex>();
//		HashMap<Vertex, Integer> map = new HashMap<>();
//		
//		HashMap<Vertex, Integer> distance = new HashMap<>();
//		HashMap<Vertex, Vertex> path = new HashMap<>();
//		
//		int i=0;
//		for(Vertex v : this.vertices){
//			heap.add(Integer.MAX_VALUE, v);
//			map.put(v, i);
//			i++;
//		}
//		int sourceIndex = map.get(sourceVertex);
//		heap.decrease(sourceIndex, 0, map);
//		
//		while(!heap.isEmpty()){
//			int dis = heap.getKey(0);
//			Vertex currentVertex = null;
//			try {
//				currentVertex = heap.removePrim(map);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			distance.put(currentVertex, dis);
//			
//			for(Vertex adjv : currentVertex.getAdjacentVertices()){
//				if(map.containsKey(adjv)){
//					int currentIndex = map.get(adjv);
//					Integer currentValue = heap.getKey(currentIndex);
//					Edge currentEdge = currentVertex.adjacentVertices.get(adjv);
//					int wt = currentEdge.weight;
//					int distanceToReachCurrentVertex = distance.get(currentVertex);
//					if(currentValue > wt + distanceToReachCurrentVertex){
//						heap.decrease(currentIndex, wt + distanceToReachCurrentVertex, map);
//						path.put(adjv, currentVertex);
//					}
//				}
//			}
//		}
//		0
//		System.out.println(distance);
//	}
	
}
