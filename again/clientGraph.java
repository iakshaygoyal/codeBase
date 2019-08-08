package again;

public class clientGraph {

	public static void main(String[] args) {
		graph g = new graph();
		
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		
		g.addEdge("a", "b");
		g.addEdge("a", "d");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "e");
		g.addEdge("e", "f");
		g.addEdge("e", "g");
		g.addEdge("f", "g");
		
		g.display();
//		System.out.println(g.numVertices());
//		System.out.println(g.numEdges());
		
//		g.removeEdge("d", "e");
//		g.display();
//		
//		g.removeVertex("d");
//		g.display();
//		System.out.println(g.hasPathFromToDFS("a", "g"));
//		System.out.println(g.hasPathFromToBFS("a", "g"));
//		g.depthFirstTraversal();
//		g.breadthFirstTraversal();
//		System.out.println(g.getConnectedComponents());
		System.out.println(g.isConnected());

	}

}
