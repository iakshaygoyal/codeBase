package BST;

import java.util.LinkedList;

public class client {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.add(50);
		tree.add(100);
		tree.add(63);
		tree.add(25);
		tree.add(40);
		tree.add(5);
		tree.add(30);
		tree.add(75);
//		tree.display();
		tree.add(12);
		tree.add(104);
		tree.add(98);
		tree.add(45);
		tree.add(54);
		tree.add(7);
		tree.add(23);
		tree.add(70);
		tree.display();
//		tree.remove(25);
//		tree.remove(1);
//		tree.display();
		tree.bstToSortedList();
		tree.display();
//		tree.display();
//		int[] a={1,2,3,4,5,6};
//		BST tree1 = new BST(a);
//		tree1.display();
//		tree.printRange(22,64);
//		tree.inorderSuccessor(50);
//		tree.inorderPredecessor(12);
//		tree.insertLeftOfEachNode();
//		tree.display();
//		System.out.println(tree.isSumOf2NodesEqualValue(25));
//		tree.lowestValueAncestor(50);
//		tree.LCA(50, 98);
//		System.out.println(tree.sumOfAllNodesGreaterThanX(25));
//		tree.replaceEachNodeBySumOfAllGreaterNodes();
//		tree.display();
//		tree.LCA(40,30);
//		tree.replaceEachNodeBySumOfAllGreaterNodes();
//		tree.display();
		
//		tree.inserLeftofEachNode();
//		tree.display();
//		System.out.println(tree.lca(30,75));
//		tree.replaceEachNodeWithSumOfAllGreaterNodes();
//		tree.display();
		
//		tree.inOrder();
//		System.out.println(tree.ksmallest(1));
//		System.out.println(tree.kthsmallest1(1));

		
//		BST tree1 = new BST();
//		tree1.add(15);
//		tree1.add(20);
//		tree1.add(39);
//		tree1.add(29);
//		tree1.add(70);
//		tree1.add(1);
//		tree1.add(200);
//		tree1.display();
//		BST tree2=tree.merge(tree1);
//		tree2.display();
//		tree.mergeandPrint(tree1);
//		LinkedList<Integer> list=new LinkedList<>();
//		list.addFirst(7);
//		list.addFirst(6);
//		list.addFirst(5);
//		list.addFirst(4);
//		list.addFirst(3);
//		list.addFirst(2);
//		list.addFirst(1);
//		System.out.println(list.toString());
//		BST tree1=new BST();
//		tree1=tree1.ll2bst(list);
//		tree1.display();
//		System.out.println(tree.bst2ll().toString());

	}

}
