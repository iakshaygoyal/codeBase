package Graphs;

import bootcamp.graphs.undirectedGraphClass.undirectedGraph;

public class client {

	public static void main(String[] args) {
		Graph g=new Graph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		
		g.addEdge("a", "b",3);
		g.addEdge("a", "d",7);
		g.addEdge("b", "c",1);
		g.addEdge("c", "d",9);
		g.addEdge("d", "e",5);
		g.addEdge("e", "f",2);
		g.addEdge("e", "g",4);
		g.addEdge("f", "g",11);
		
		
		g.display();
		g.depthFirstTraversal();
		g.breadthFirstTraversal();
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
//		g.addEdge("c", "d");
//		g.addEdge("d", "e");
//		g.addEdge("e", "f");
//		g.addEdge("e", "g");
//		g.addEdge("f", "g");
		
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("e");
//		g.addVertex("f");
//		g.addVertex("g");
//		g.addVertex("h");
//		
//		g.addEdge("a", "b");
//		g.addEdge("a", "d");
//		g.addEdge("b", "c");
//		g.addEdge("c", "d");
//		g.addEdge("d", "e");
//		g.addEdge("e", "f");
//		g.addEdge("e", "g");
//		g.addEdge("f", "h");
//		g.addEdge("g", "h");
		
//		g.display();
		
//		System.out.println(g.numVertices());
//		System.out.println(g.numEdges());
		
//		g.removeEdge("a", "d");
//		g.removeEdge("e", "d");
//		g.removeVertex("d");
//		g.display();
////		
//		g.removeVertex("d");
//		g.display();
		
//		System.out.println(g.hasPathFromToDFS("a", "g"));
//		System.out.println(g.hasPathFromToBFS("a", "g"));
//		
//		g.depthFirstTraversal();
//		g.breadthFirstTraversal();
//		System.out.println(g.getConnectedComponents());
//		System.out.println(g.isConnected());
//		System.out.println(g.isAcyclic());
//		System.out.println(g.isBipartite());
		
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("e");
//		g.addVertex("f");
//		
//		g.addEdge("a", "b", 3);
//		g.addEdge("a", "d", 1);
//		g.addEdge("d", "b", 3);
//		g.addEdge("b", "c", 1);
//		g.addEdge("c", "d", 1);
//		g.addEdge("d", "e", 6);
//		g.addEdge("c", "e", 5);
//		g.addEdge("c", "f", 4);
//		g.addEdge("e", "f", 2);
//		
//		g.display();
//		
//		g.primsMininmumSpanningTree("a");
		
//		g.addVertex("a");
//		g.addVertex("b");
//		g.addVertex("c");
//		g.addVertex("d");
//		g.addVertex("e");
//		g.addVertex("f");
//		
//		g.addEdge("a", "b", 5);
//		g.addEdge("a", "e", 2);
//		g.addEdge("d", "d", 9);
//		g.addEdge("b", "c", 2);
//		g.addEdge("c", "d", 3);
//		g.addEdge("d", "f", 2);
//		g.addEdge("e", "f", 3);
//		
//		g.display();
		
//		g.dijkstra("a");
	}

}
