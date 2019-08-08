package Graphs;

import Graphs.Interfaces.negativeCycleException;

public class clientDirectedGraph {

	public static void main(String[] args) {
	directedGraph g = new directedGraph();
		
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("e");
//		g.addVertex("f");
//		g.addVertex("g");
//		
//		g.addEdge("a", "b");
//		g.addEdge("a", "d");
//		g.addEdge("b", "c");
//		g.addEdge("d", "c");
//		g.addEdge("e", "d");
//		g.addEdge("e", "f");
//		g.addEdge("e", "g");
//		g.addEdge("f", "g");
//		
//		g.display();
		
//		g.removeVertex("d");
//		g.display();
		
//		g.removeEdge("d", "a");
//		g.display();
		
//		g.addEdge("d", "a");
//		g.display();
		
//		g.depthFirstTraversal();
//		g.breadthFirstTraversal();
		
//		System.out.println(g.hasPathFromToDFS("a", "g"));
//		System.out.println(g.hasPathFromToDFS("a", "c"));
//		System.out.println(g.hasPathFromToBFS("a", "g"));
//		System.out.println(g.hasPathFromToBFS("a", "c"));
		
//	g.addVertex("a");
//	g.addVertex("b");
//	g.addVertex("c");
//	g.addVertex("d");
//	g.addVertex("e");
//	g.addVertex("f");
//	g.addVertex("g");
//	g.addVertex("h");
//	
//	g.addEdge("a", "c");
//	g.addEdge("b", "c");
//	g.addEdge("b", "d");
//	g.addEdge("c", "e");
//	g.addEdge("e", "f");
//	g.addEdge("e", "h");
//	g.addEdge("d", "f");
//	g.addEdge("f", "g");
//	
//	g.display();
//	
//	g.topologicalSorting();
	
	g.addVertex("a");
	g.addVertex("b");
	g.addVertex("c");
	g.addVertex("d");
	g.addVertex("e");
	g.addVertex("f");
	
	g.addEdge("a", "b", 4);
	g.addEdge("a", "d", 6);
	g.addEdge("a", "c", 5);
	g.addEdge("b", "c", -3);
	g.addEdge("c", "f", 4);
	g.addEdge("d", "e", 2);
	g.addEdge("e", "f", 2);
	g.addEdge("f", "e", 1);
	
	g.display();
	
//	try {
//		g.bellmanFord("a");
//	} catch (negativeCycleException e) {
//		System.out.println(e);
//	}
	
//	g.addVertex("a");
//	g.addVertex("b");
//	g.addVertex("c");
//	g.addVertex("d");
//	
//	g.addEdge("a", "b", 3);
//	g.addEdge("a", "c", 6);
//	g.addEdge("a", "d", 15);
//	g.addEdge("b", "c", -2);
//	g.addEdge("c", "d", 2);
//	g.addEdge("d", "a", 1);
//	
//	g.display();
//	
	try {
		g.floydWarshall();
	} catch (negativeCycleException e) {
		System.out.println(e);
	}
	
	
	
	}

}
