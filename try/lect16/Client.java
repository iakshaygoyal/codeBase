package lect16;

import javax.sound.midi.Synthesizer;

public class Client {

	// 50 true 25 true 37 false false true 12 true 6 false false false true 75
	// true 87 false false true 62 false false
	public static void main(String[] args) {
		// BinaryTree bt = new BinaryTree(true);
		// bt.display();
		// System.out.println(bt.size());
		// System.out.println(bt.height());
		// System.out.println(bt.diameter());
		//
		// System.out.println(bt.findElement(877));
		//
		//
		// System.out.println("Display before mirror");
		// bt.display();
		//
		//
		// bt.mirror();
		//
		// System.out.println("Display after mirror");
		// bt.display();
		//
		// System.out.println("Displaying mirrored new tree");
		// BinaryTree mirroredTree = bt.mirror2();
		// mirroredTree.display();
		//
		// mirroredTree.inOrder();
		// mirroredTree.levelOrder();

		try {
			BinaryTree tree = new BinaryTree(0, new int[] { 50, 25, 12, 32, 75, 62, 87 },
					new int[] { 12, 25, 32, 50, 62, 75, 87 });
			tree.preOrder();
			tree.inOrder();
			
			System.out.println(tree.successsor(87));
			System.out.println(tree.depth(100));
		} catch (Exception ex) {
			// handle
		}
	}

}
