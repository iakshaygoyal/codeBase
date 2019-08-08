package again;

public class clientBST {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.addElement(50);
		tree.addElement(25);
		tree.addElement(75);
		tree.addElement(63);
		tree.addElement(100);
		tree.addElement(40);
		tree.addElement(5);
		tree.addElement(30);

		tree.display();
		tree.replace();
		tree.display();
//		tree.removeElement(50);
//		tree.display();
//		System.out.println(tree.max());
//		System.out.println(tree.min());
//		System.out.println(tree.findElement(63));
//		tree.printInRange(31, 98);
//		tree.bst2SortedLinkedList();
//		tree.display();
//		BST tree1 = new BST(new int[] {5, 25, 30, 40, 50, 63, 75, 100});
//		tree1.display();

	}

}
