package again;

public class classGenericTree {

	public static void main(String[] args) {
		// 111 3 2 2 5 0 66 0 3 0 4 2 7 0 88 1 99 0
		genericTree<Integer> tree = new genericTree<>();
		tree.display();
//		System.out.println(tree.countNodes());
//		System.out.println(tree.largestData());
//		System.out.println(tree.height());
//		tree.printAtDepth(4);
//		System.out.println(tree.nodesGreaterThanX(0));
		System.out.println(tree.maxSumOfNodeAndChildren());
//		tree.preOrderIterative();

	}

}
