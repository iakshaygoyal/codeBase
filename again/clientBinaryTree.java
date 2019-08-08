package again;

public class clientBinaryTree {

	public static void main(String[] args) {
		// 50 true 25 true 37 false false true 12 true 6 false false false true 75 true 87 false false true 62 false false
		//bst 50 true 25 true 5 false false true 40 true 30 false false false true 75 true 63 false false true 100 false false
		// 50 true 25 true 32 false false true 12 true 6 false false false true 75 true 57 true 47 true 11 false true 12 false false true 50 true 49 false false false false true 92 true 78 false false true 102 false true 104 false false
		binaryTree tree = new binaryTree(true);
		tree.display();
//		System.out.println(tree.size());
//		System.out.println(tree.height());
//		System.out.println(tree.diameter());
//		System.out.println(tree.findElement(104));
//		tree.mirror();
//		tree.display();
//		tree.inOrder();
//		binaryTree tree2 = new binaryTree(1, new int[] {50, 25, 37, 12, 6, 75, 87, 62}, new int[] {37, 25, 6, 12, 50, 87, 75, 62});
//		tree2.display();
//		System.out.println(tree.max());
//		System.out.println(tree.min());
		System.out.println(tree.isBST());
//		System.out.println(tree.isBST());
//		System.out.println(tree.isBST4());
//		System.out.println(tree.justGreaterThan(87));
//		System.out.println(tree.justLessThan(999));
//		System.out.println(tree.inorderSuccessor(37));
//		System.out.println(tree.inorderPredecessor(37));
//		System.out.println(tree.sumOfTwoNodesEqualValue(124));
//		System.out.println(tree.LCA(7, 50));
//		tree.decode("1001011");

	}

}
