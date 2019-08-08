package lect21;

import java.util.*;

import org.xml.sax.HandlerBase;

public class Graph {
	private class Edge {
		Vertex one;
		Vertex two;

		Edge(Vertex one, Vertex two) {
			this.one = one;
			this.two = two;
		}
	}

	private class Vertex {
		String name;
		HashMap<Vertex, Edge> adjacentVertices;

		Vertex(String name) {
			this.name = name;
			this.adjacentVertices = new HashMap<>();
		}

		public void addEdge(Edge edge) {
			Vertex other = edge.one == this ? edge.two : edge.one;

			if (this.isAdjacentTo(other)) {
				return;
				// throw Exception
			}

			this.adjacentVertices.put(other, edge);
		}

		public void removeEdge(Vertex other) {
			if (!this.isAdjacentTo(other)) {
				return;
			}

			this.adjacentVertices.remove(other);
		}

		public boolean isAdjacentTo(Vertex other) {
			return this.adjacentVertices.containsKey(other);
		}

		public ArrayList<Vertex> getAdjacentVertices() {
			ArrayList<Vertex> retVal = new ArrayList<>();
			Set<Vertex> vertices = this.adjacentVertices.keySet();

			for (Vertex adjV : vertices) {
				retVal.add(adjV);
			}

			return retVal;
		}

		public String toString() {
			String retVal = this.name + " => ";
			Set<Vertex> vertices = this.adjacentVertices.keySet();

			for (Vertex adjV : vertices) {
				retVal += adjV.name + ", ";
			}

			retVal += "END\n";

			return retVal;
		}

		public boolean equals(Object other) {
			if (other == null) {
				return false;
			}

			Vertex otherVertex = (Vertex) other;
			return this.name.equals(otherVertex.name);
		}

		public int hashCode() {
			return this.name.hashCode();
		}
	}

	private ArrayList<Vertex> vertices;

	public Graph() {
		this.vertices = new ArrayList<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public void addVertex(String name) {
		if (this.containsVertex(name)) {
			return;
		}

		Vertex newVertex = new Vertex(name);
		this.vertices.add(newVertex);
	}

	public void removeVertex(String name) {
		if (!this.containsVertex(name)) {
			return;
		}

		Vertex vtbr = this.getVertex(name);
		for (Vertex adjV : vtbr.getAdjacentVertices()) {
			adjV.removeEdge(vtbr);
		}

		this.vertices.remove(vtbr);
	}

	public boolean containsVertex(String name) {
		return this.getVertex(name) != null;
	}

	private Vertex getVertex(String name) {
		Vertex retVal = null;

		for (Vertex v : this.vertices) {
			if (v.name.equals(name)) {
				retVal = v;
				break;
			}
		}

		return retVal;
	}

	public int numEdges() {
		int retVal = 0;

		for (Vertex v : this.vertices) {
			retVal += v.adjacentVertices.size();
		}
		retVal /= 2;

		return retVal;
	}

	public void addEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || vtx1.isAdjacentTo(vtx2)) {
			return;
		}

		Edge newEdge = new Edge(vtx1, vtx2);
		vtx1.addEdge(newEdge);
		vtx2.addEdge(newEdge);
	}

	public void removeEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)) {
			return;
		}

		vtx1.removeEdge(vtx2);
		vtx2.removeEdge(vtx1);
	}

	public boolean containsEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || !vtx1.isAdjacentTo(vtx2)) {
			return false;
		}

		return true;
	}

	public void display() {
		System.out.println(this);
	}

	public String toString() {
		String retVal = "";

		for (Vertex v : this.vertices) {
			retVal += v.toString();
		}

		return retVal;
	}

	/*
	 * Graph Questions
	 */
	public boolean hasPathFromTo(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return this.hasPathFromTo_DFS(vtx1, vtx2);
	}

	private boolean hasPathFromTo_DFS(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		visited.put(vtx1, true);

		return this.hasPathFromTo_DFS(vtx1, vtx2, visited);
	}

	private boolean hasPathFromTo_DFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> visited) {
		if (vtx1.isAdjacentTo(vtx2)) {
			return true;
		}

		for (Vertex adjV : vtx1.getAdjacentVertices()) {
			if (!visited.containsKey(adjV)) {
				visited.put(adjV, true);
				if (this.hasPathFromTo_DFS(adjV, vtx2, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean hasPathFromTo_BFS(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Boolean> visited = new HashMap();
		LinkedList<Vertex> queue = new LinkedList<>();

		queue.addLast(vtx1);
		visited.put(vtx1, true);

		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			if (vtx.isAdjacentTo(vtx2)) {
				return true;
			}

			for (Vertex adjV : vtx.getAdjacentVertices()) {
				if (!visited.containsKey(adjV)) {
					queue.addLast(adjV);
					visited.put(adjV, true);
				}
			}
		}

		return false;
	}

	public void depthFirstTraversal() {
		HashMap<Vertex, Boolean> visited = new HashMap();
		LinkedList<Vertex> stack = new LinkedList<>();

		for (Vertex v : this.vertices) {
			if (!visited.containsKey(v)) {
				stack.addLast(v);
				visited.put(v, true);

				while (!stack.isEmpty()) {
					Vertex vtx = stack.removeLast();

					System.out.print(vtx.name + ", ");

					for (Vertex adjV : vtx.getAdjacentVertices()) {
						if (!visited.containsKey(adjV)) {
							stack.addLast(adjV);
							visited.put(adjV, true);
						}
					}
				}
			}
		}

		System.out.println("END");
	}

	public void breadthFirstTraversal() {
		HashMap<Vertex, Boolean> visited = new HashMap();
		LinkedList<Vertex> queue = new LinkedList<>();

		for (Vertex v : this.vertices) {
			if (!visited.containsKey(v)) {
				queue.addLast(v);
				visited.put(v, true);

				while (!queue.isEmpty()) {
					Vertex vtx = queue.removeFirst();

					System.out.print(vtx.name + ", ");

					for (Vertex adjV : vtx.getAdjacentVertices()) {
						if (!visited.containsKey(adjV)) {
							queue.addLast(adjV);
							visited.put(adjV, true);
						}
					}
				}
			}
		}

		System.out.println("END");
	}

	public boolean isConnected() {
		return false;
	}

	public boolean isACyclic() {
		HashMap<Vertex, Vertex> visited = new HashMap();
		LinkedList<Vertex> stack = new LinkedList<>();

		for (Vertex v : this.vertices) {
			if (!visited.containsKey(v)) {
				stack.addLast(v);
				visited.put(v, null);

				while (!stack.isEmpty()) {
					Vertex vtx = stack.removeLast();

					for (Vertex adjV : vtx.getAdjacentVertices()) {
						if (!visited.containsKey(adjV)) {
							stack.addLast(adjV);
							visited.put(adjV, vtx);
						}
						else {
							// some vertex gets visited and you were not the reason for visiting that vertex
							if(adjV != visited.get(vtx)){
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

	public boolean isTree() {
		return this.isACyclic() && this.isConnected();
	}

	public boolean isBipartite() {
		HashMap<Vertex, String> visited = new HashMap();
		LinkedList<Vertex> stack = new LinkedList<>();

		for (Vertex v : this.vertices) {
			if (!visited.containsKey(v)) {
				stack.addLast(v);
				visited.put(v, "Red");

				while (!stack.isEmpty()) {
					Vertex vtx = stack.removeLast();

					System.out.print(vtx.name + ", ");

					for (Vertex adjV : vtx.getAdjacentVertices()) {
						String colorOnVtx = visited.get(vtx);
						
						if (!visited.containsKey(adjV)) {
							stack.addLast(adjV);
							visited.put(adjV, colorOnVtx.equals("Red")? "Green": "Red");
						}
						else {
							String actualColor = visited.get(adjV);
							String attemptedColor = colorOnVtx.equals("Red")? "Green": "Red";
							
							if(!actualColor.equals(attemptedColor)){
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {
		ArrayList<ArrayList<String>> retVal = new ArrayList<>();
		HashMap<Vertex, Boolean> visited = new HashMap();
		LinkedList<Vertex> queue = new LinkedList<>();

		for (Vertex v : this.vertices) {
			if (!visited.containsKey(v)) {
				ArrayList<String> component = new ArrayList<>();
				
				queue.addLast(v);
				visited.put(v, true);

				while (!queue.isEmpty()) {
					Vertex vtx = queue.removeFirst();

					component.add(vtx.name);

					for (Vertex adjV : vtx.getAdjacentVertices()) {
						if (!visited.containsKey(adjV)) {
							queue.addLast(adjV);
							visited.put(adjV, true);
						}
					}
				}
				
				retVal.add(component);
			}
		}

		return retVal;
	}
}
