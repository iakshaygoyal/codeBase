package Graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import Graphs.Interfaces.negativeCycleException;
import Heap.Heap;


public class directedGraph {
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
	
	private class Vertex{
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
			return this.name;
		}
		
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
	
	public directedGraph(){
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
		
		for(Vertex v : this.vertices){
			if(v.adjacentVertices.containsKey(vtx)){
				v.adjacentVertices.remove(vtx);
			}
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
	}
	
	public void removeEdge(String v1, String v2){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)){
			return;
		}
		
		vtx1.removeEdge(vtx2);
	}
	
	public boolean containsEdge(String v1, String v2){
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)){
			return false;
		}
		
		return true;
	}
	
	public ArrayList<Edge> getAllEdges(){
		ArrayList<Edge> allEdges = new ArrayList<>();
		
		for(Vertex v : this.vertices){
			Collection<Edge> edges = v.adjacentVertices.values();
			
			for(Edge e : edges){
				allEdges.add(e);
			}
		}
		
		return allEdges;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		String retval = "";
		
//		for(Vertex v : this.vertices){
//			retval+=v.toString();
//		}
//		
//		retval+="END\n\n";
		
		for(Edge e : this.getAllEdges()){
			retval+=e.toString();
		}
		
		return retval;
	}
	
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
	
//	public void topologicalSorting(){
//		HashMap<Vertex, Boolean> visited = new HashMap<>();
//		LinkedList<Vertex> stk1 = new LinkedList<>();
//		LinkedList<Vertex> stk2 = new LinkedList<>();
//		
//		for(Vertex v : this.vertices){
//			if(!visited.containsKey(v)){
//				visited.put(v, true);
//				stk1.addFirst(v);
//				
//				while(!stk1.isEmpty()){
//					Vertex vtx = stk1.getFirst();
//					int flag=0;
//					
//					for(Vertex adjv : vtx.getAdjacentVertices()){
//						if(!visited.containsKey(adjv)){
//							stk1.addFirst(adjv);
//							visited.put(adjv, true);
//							flag=1;
//						}
//					}
//					if(flag == 0){
//						stk2.addFirst(stk1.removeFirst());
//					}
//				}
//				
//			}
//		}
//		while(!stk2.isEmpty()){
//			System.out.print(stk2.removeFirst().name+", ");
//		}
//		System.out.println("END");
//	}
	
	//Recursive Approach
	public void topologicalSorting(){
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> stk = new LinkedList<>();
		
		for(Vertex v : this.vertices){
			if(!visited.containsKey(v)){
				visited.put(v, true);
				this.topologicalSorting(v, visited, stk);
			}
		}
		
		while(!stk.isEmpty()){
		System.out.print(stk.removeFirst().name+", ");
	}
	}
	
	private void topologicalSorting(Vertex v, HashMap<Vertex, Boolean> visited, LinkedList<Vertex> stk){
		for(Vertex adjv : v.getAdjacentVertices()){
			if(!visited.containsKey(adjv)){
				visited.put(adjv, true);
				this.topologicalSorting(adjv, visited, stk);
			}
		}
		stk.addFirst(v);
	}
	
	public void bellmanFord(String s) throws negativeCycleException{
		Vertex sourceVertex = this.getVertex(s);
		
		if(sourceVertex == null){
			return;
		}
		
		HashMap<Vertex, Integer> distance = new HashMap<>();
		HashMap<Vertex, Vertex> parent = new HashMap<>();
		
		for(Vertex v : this.vertices){
			distance.put(v, Integer.MAX_VALUE);
			parent.put(v, null);
		}
		
		distance.put(sourceVertex, 0);
		
		for(int i=0; i<this.numVertices()-1; i++){
			
			for(Edge e : this.getAllEdges()){
				if(distance.get(e.two) > distance.get(e.one) + e.weight){
					distance.put(e.two, distance.get(e.one) + e.weight);
					parent.put(e.two, e.one);
				}
			}
		}
		
		for(Edge e : this.getAllEdges()){
			if(distance.get(e.two) > distance.get(e.one) + e.weight){
				throw new negativeCycleException();
			}

		}
		
		System.out.println(distance);
		
		for(Vertex v : this.vertices){
			while(v != sourceVertex){
				System.out.print(v.name + "<=");
				v = parent.get(v);
			}
			System.out.println(sourceVertex.name);
		}
	}
	
	public Edge getEdge(String v1, String v2){
		if(!this.containsEdge(v1, v2)){
			return null;
		}
		
		Vertex vtx1 = this.getVertex(v1);
		Vertex vtx2 = this.getVertex(v2);
		
		return vtx1.adjacentVertices.get(vtx2);
	}
	
	public void floydWarshall() throws negativeCycleException{
		int[][] distance = new int[this.numVertices()][this.numVertices()];
		int[][] path = new int[this.numVertices()][this.numVertices()];
		
		for(int i=0; i<this.numVertices(); i++){
			for(int j=0; j<this.numVertices(); j++){
				if(this.containsEdge(this.vertices.get(i).name, this.vertices.get(j).name)){
					distance[i][j] = this.getEdge(this.vertices.get(i).name, this.vertices.get(j).name).weight;
					path[i][j] = i;
				}
				else{
					if(i == j){
						distance[i][j] = 0;
					}
					else{
						distance[i][j] = Integer.MAX_VALUE;
					}
					path[i][j] = -1;
				}
			}
		}
		
		for(int k=0; k<this.numVertices(); k++){
			for(int j=0; j<this.numVertices(); j++){
				for(int i=0; i<this.numVertices(); i++){
					if(distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE){
						continue;
					}
					
					if(distance[i][j] > distance[i][k] + distance[k][j]){
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<this.numVertices(); i++){
			if(distance[i][i] < 0){
				throw new negativeCycleException();
			}
		}
		
		for(int i=0; i<this.numVertices(); i++){
			for(int j=0; j<this.numVertices(); j++){
				System.out.println(i+" => " + j + " = " + distance[i][j]);
			}
		}
	}
	
}
