package GenericTree;

public class client {

	public static void main(String[] args) {
//		111 3 2 2 5 0 66 0 3 0 4 2 7 0 88 1 99 0 
		GenericTree<Integer> tree=new GenericTree<>();
		tree.display();
		
//		11 3 2 2 22 0 6 0 98 0 7 2 71 0 -8 0
//		GenericTree<Integer> tree1=new GenericTree<>();
//		tree1.display();
//		System.out.println(tree.isStructureSame(tree1));
//		System.out.println(tree.size());
//		System.out.println(tree.size2());
//		System.out.println(tree.max());
//		System.out.println(tree.height());
//		System.out.println(tree.height2());
//		tree.printAtDepth(8);
//		tree.printAtDepth(2);
//		tree.printAtDepth(1);
//		tree.printAtDepth(0);
//		System.out.println(tree.greaterThanX(23));
//		System.out.println(tree.greaterThanX2(23));
//		System.out.println(tree.maxSumOfNodes());
//		System.out.println(tree.maxSumOfNodes());
//
//		tree.preOrder();
//		tree.postOrder();
//		tree.postOrder();
//		tree.levelOrder();
//		tree.preOrder2();
//		tree.justGreaterThan(12);
//		System.out.println(tree.sum());
//		System.out.println(tree.secondLargest());
//		System.out.println(tree.countLeafNodes());
//		tree.replaceByDepthValue();
//		tree.display();
		
//		System.out.println(tree.sumOfNodes());
//		System.out.println(tree.isStructureSame(tree1));
//		tree.justGreaterThan(1121);
//		System.out.println(tree.secondLargest());
//		System.out.println(tree.totalLeafNodes());
		tree.replaceEachNodeByDepthValue();
		tree.display();

	}

}
