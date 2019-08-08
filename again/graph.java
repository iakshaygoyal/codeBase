package again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class graph {
	private class edge{
		vertex one;
		vertex two;
		
		public edge(vertex one, vertex two){
			this.one=one;
			this.two=two;
		}
	}
	
	private class vertex{
		String name;
		HashMap<vertex, edge> adjacentVertices;
		
		public vertex(String name){
			this.name=name;
			this.adjacentVertices = new HashMap<>();
		}
		
		public void addEdge(edge e){
			vertex other = e.one == this ? e.two : e.one;
			
			if(this.isAdjacentTo(other)){
				return;
			}
			
			this.adjacentVertices.put(other, e);
		}
		
		public void removeEdge(vertex other){
			if(!this.isAdjacentTo(other)){
				return;
			}
			
			this.adjacentVertices.remove(other);
		}
		
		public boolean isAdjacentTo(vertex other){
			if(this.adjacentVertices.containsKey(other)){
				return true;
			}
			return false;
		}
		
		public ArrayList<vertex> getAdjacentVertices(){
			ArrayList<vertex> list = new ArrayList<>();
			Set<vertex> adjVertices = this.adjacentVertices.keySet();
			
			for(vertex v : adjVertices){
				list.add(v);
			}
			
			return list;
		}
		
		public String toString(){
			String retval = "";
			
			retval+=this.name + " => ";
			for(vertex adjVertex : this.getAdjacentVertices()){
				retval+=adjVertex.name+", ";
			}
			retval+="\n";
			
			return retval;
		}
	}
	ArrayList<vertex> vertices;
	
	public graph(){
		this.vertices = new ArrayList<>();
	}
	
	public int numVertices(){
		return this.vertices.size();
	}
	
	public void addVertex(String name){
		if(this.containsVertex(name)){
			return;
		}
		
		vertex newVertex = new vertex(name);
		this.vertices.add(newVertex);
	}
	
	public void removeVertex(String name){
		if(!this.containsVertex(name)){
			return;
		}
		vertex v = this.getVertex(name);
		
		for(vertex adjVertex : v.getAdjacentVertices()){
			adjVertex.removeEdge(v);
		}
		
		this.vertices.remove(v);
	}
	
	public boolean containsVertex(String name){
		return this.getVertex(name) != null;
	}
	
	private vertex getVertex(String name){
		vertex retval = null;
		
		for(vertex v : this.vertices){
			if(v.name.equals(name)){
				retval=v;
				break;
			}
		}
		
		return retval;
	}
	
	public int numEdges(){
		int retval = 0;
		
		for(vertex v : vertices){
			retval+=v.adjacentVertices.size();
		}
		
		retval/=2;
		return retval;
	}
	
	public void addEdge(String v1, String v2){
		vertex vtx1=this.getVertex(v1);
		vertex vtx2=this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || vtx1.isAdjacentTo(vtx2)){
			return;
		}
		
		edge e = new edge(vtx1, vtx2);
		vtx1.addEdge(e);
		vtx2.addEdge(e);
	}
	
	public void removeEdge(String v1, String v2){
		vertex vtx1=this.getVertex(v1);
		vertex vtx2=this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)){
			return;
		}
		
		vtx1.removeEdge(vtx2);
		vtx2.removeEdge(vtx1);
	}
	
	public boolean containsEdge(String v1, String v2){
		vertex vtx1=this.getVertex(v1);
		vertex vtx2=this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)){
			return false;
		}
		
		return true;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		String retVal = "";

		for (vertex v : this.vertices) {
			retVal += v.toString();
		}

		return retVal;
	}
	
	public boolean hasPathFromToDFS(String v1, String v2){
		vertex vtx1=this.getVertex(v1), vtx2=this.getVertex(v2);
		
		if(vtx1 == null || vtx2 == null){
			return false;
		}
		
		HashMap<vertex, Boolean> map = new HashMap<>();
		map.put(vtx1, true);
		return this.hasPathFromToDFS(vtx1, vtx2, map);
		
	}
	
	private boolean hasPathFromToDFS(vertex v1, vertex v2, HashMap<vertex, Boolean> map){
		if(v1.isAdjacentTo(v2)){
			return true;
		}
		
		for(vertex adjVertex : v1.getAdjacentVertices()){
			if(!map.containsKey(adjVertex)){
				map.put(adjVertex, true);
				if(this.hasPathFromToDFS(adjVertex, v2, map)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean hasPathFromToBFS(String v1, String v2){
		vertex vtx1=this.getVertex(v1), vtx2=this.getVertex(v2);
		
		if(v1 == null || v2 == null){
			return false;
		}
		
		return this.hasPathFromToBFS(vtx1, vtx2);
	}
	
	private boolean hasPathFromToBFS(vertex vtx1, vertex vtx2){
		HashMap<vertex, Boolean> map = new HashMap<>();
		LinkedList<vertex> queue = new LinkedList<>();
		queue.addLast(vtx1);
		map.put(vtx1, true);
		
		while(!queue.isEmpty()){
			vertex current = queue.removeFirst();
				if(vtx2.isAdjacentTo(current)){
				return true;
			}
			
			for(vertex v : current.getAdjacentVertices()){
				if(!map.containsKey(v)){
					queue.addLast(v);
					map.put(v, true);
				}
			}
		}
		
		return false;
	}
	
	
	public void depthFirstTraversal(){
		HashMap<vertex, Boolean> map = new HashMap<>();
		LinkedList<vertex> stk = new LinkedList<>();
		
		for(vertex v : this.vertices){
			if(!map.containsKey(v)){
				stk.addFirst(v);
				map.put(v, true);
				
				while(!stk.isEmpty()){
					vertex vtx = stk.removeFirst();
					System.out.print(vtx.name+", ");
					for(vertex adjV : vtx.getAdjacentVertices()){
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
		HashMap<vertex, Boolean> map = new HashMap<>();
		LinkedList<vertex> queue = new LinkedList<>();
		
		for(vertex v : this.vertices){
			if(!map.containsKey(v)){
				queue.addLast(v);
				map.put(v, true);
				
				while(!queue.isEmpty()){
					vertex vtx = queue.removeFirst();
					System.out.print(vtx.name+", ");
					for(vertex adjV : vtx.getAdjacentVertices()){
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
	
	public ArrayList<ArrayList<String>> getConnectedComponents(){
		ArrayList<ArrayList<String>> retval = new ArrayList<>();
		ArrayList<String> list;
		
		HashMap<vertex, Boolean> map = new HashMap<>();
		LinkedList<vertex> queue = new LinkedList<>();
		
		for(vertex v : this.vertices){
			if(!map.containsKey(v)){
				queue.addLast(v);
				map.put(v, true);
				list = new ArrayList<>();
				
				while(!queue.isEmpty()){
					vertex vtx = queue.removeFirst();
					list.add(vtx.name);
					for(vertex adjV : vtx.getAdjacentVertices()){
						if(!map.containsKey(adjV)){
							queue.addLast(adjV);
							map.put(adjV, true);
						}
					}
				}
				
				retval.add(list);
			}
		}
		
		return retval;
	}
	
	public boolean isConnected(){
		if(this.getConnectedComponents().size() == 1){
			return true;
		}
		return false;
	}

}
