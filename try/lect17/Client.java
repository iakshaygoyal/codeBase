package lect17;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST();
		
		tree.addElement(50);
		tree.addElement(25);
		tree.addElement(75);
		tree.addElement(12);
		tree.addElement(37);
		tree.addElement(62);
		tree.addElement(87);
		
		tree.display();
		tree.makeSortedLinkedList();
		tree.display();
	}

}
