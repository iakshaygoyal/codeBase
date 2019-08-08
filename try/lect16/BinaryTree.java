package lect16;

import java.util.Scanner;

import lect13.queues.QueueUsingLinkedLists;
import lect13.shared.IQueue;

public class BinaryTree {
	private class Node implements Comparable<Node> {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			String retVal = "";

			if (this.left != null) {
				retVal += this.left.data + " => ";
			}

			retVal += this.data;

			if (this.right != null) {
				retVal += " <= " + this.right.data;
			}

			retVal += "\n";

			if (this.left != null) {
				retVal += this.left.toString();
			}
			if (this.right != null) {
				retVal += this.right.toString();
			}

			return retVal;
		}

		public int compareTo(Node other) {
			return this.data - other.data;
		}
	}

	private class Pair {
		int height;
		int diameter;

		Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	private class BSTReturnType {
		boolean isBST;
		Node min;
		Node max;
		Node largestBSTRoot;
		int largestBSTSize;

		public BSTReturnType(boolean isBST, Node min, Node max) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
		}
	}

	private Node root;
	private int size;

	public BinaryTree(boolean takeInput) {
		if (takeInput) {
			Scanner scn = new Scanner(System.in);
			this.root = this.takeInput(scn, null, false);
		}
	}

	// type = 0 => make tree from pre and in
	// type = 1 => make tree from post and in
	public BinaryTree(int type, int[] one, int[] two) throws Exception {
		if (type == 0) {
			this.root = this.constructSubtreeFromPreAndIn(one, 0, one.length - 1, two, 0, two.length - 1);
		}
		// else if(type == 1){
		// this.root = this.constructSubtreeFromPostAndIn(one, 0, one.length -
		// 1,
		// two, 0, two.length - 1);
		// }
		else {
			throw new Exception("Invalid arguments");
		}
	}

	private Node constructSubtreeFromPreAndIn(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		if (psi > pei || isi > iei) {
			return null;
		}

		Node retVal = new Node(pre[psi], null, null);

		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == retVal.data) {
				si = i;
				break;
			}
		}
		int nri = si - isi;

		retVal.left = this.constructSubtreeFromPreAndIn(pre, psi + 1, psi + nri, in, isi, si - 1);
		retVal.right = this.constructSubtreeFromPreAndIn(pre, psi + nri + 1, pei, in, si + 1, iei);

		return retVal;
	}

	// private Node constructSubtreeFromPostAndIn(int[] post, int pSi, int pEi,
	// int[] in, int iSi, int iEi){
	//
	// }

	private Node takeInput(Scanner scn, Node parentNode, boolean isParentsLeftChild) {
		if (parentNode == null) {
			System.out.println("Please enter the data for root: ");
		} else {
			if (isParentsLeftChild) {
				System.out.println("Please enter the data for left child of " + parentNode.data);
			} else {
				System.out.println("Please enter the data for right child of " + parentNode.data);
			}
		}

		int cData = scn.nextInt();
		Node child = new Node(cData, null, null);
		this.size++;

		System.out.println("Do you have a left child for " + child.data);
		boolean isChildsLeft = scn.nextBoolean();

		if (isChildsLeft) {
			child.left = this.takeInput(scn, child, true);
		}

		System.out.println("Do you have a right child for " + child.data);
		boolean isChildsRight = scn.nextBoolean();

		if (isChildsRight) {
			child.right = this.takeInput(scn, child, false);
		}

		return child;
	}

	public void display() {
		System.out.println(this);
	}

	public String toString() {
		return this.root.toString();
	}

	public int size() {
		return this.size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}

		int retVal = 1;

		retVal += this.size(node.left);
		retVal += this.size(node.right);

		return retVal;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int diameter() {
		// return this.diameter(this.root);
		return this.diameter2(this.root).diameter;
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int factor1 = diameter(node.left);
		int factor2 = diameter(node.right);
		int factor3 = height(node.left) + height(node.right) + 2;

		return Math.max(factor1, Math.max(factor2, factor3));
	}

	private Pair diameter2(Node node) {
		if (node == null) {
			return new Pair(-1, 0);
		}

		int myHeight = 0, myDiameter = 0;

		Pair lPair = diameter2(node.left);
		Pair rPair = diameter2(node.right);

		// calculating myHeight
		myHeight = Math.max(lPair.height, rPair.height) + 1;

		// calculating myDiameter
		int factor1 = lPair.diameter;
		int factor2 = rPair.diameter;
		int factor3 = lPair.height + rPair.height + 2;

		myDiameter = Math.max(factor1, Math.max(factor2, factor3));

		// creating myPair
		Pair retVal = new Pair(myHeight, myDiameter);
		return retVal;
	}

	public boolean findElement(int item) {
		return this.findElement(this.root, item);
	}

	private boolean findElement(Node node, int item) {
		if (node == null) {
			return false;
		}

		// if(node.data == item){
		// return true;
		// }
		// else{
		// boolean foundInLeft = findElement(node.left, item);
		// if(foundInLeft){
		// return true;
		// }
		// else{
		// boolean foundInRight = findElement(node.right, item);
		// if(foundInRight){
		// return true;
		// }
		// else{
		// return false;
		// }
		// }
		// }
		if (node.data == item) {
			return true;
		} else if (findElement(node.left, item) == true) {
			return true;
		} else if (findElement(node.right, item) == true) {
			return true;
		} else {
			return false;
		}
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}

		this.mirror(node.left);
		this.mirror(node.right);

		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public BinaryTree mirror2() {
		BinaryTree retVal = new BinaryTree(false);

		retVal.root = this.mirror2(this.root);

		return retVal;
	}

	private Node mirror2(Node node) {
		if (node == null) {
			return null;
		}

		Node retVal = new Node(node.data, null, null);

		retVal.left = this.mirror2(node.right);
		retVal.right = this.mirror2(node.left);

		return retVal;
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println("END");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}
	// (preOrder, postOrder) - recursive, preOrder - iterative

	public void levelOrder() {
		IQueue<Node> q = new QueueUsingLinkedLists<>();

		try {
			q.enqueue(this.root);
			while (!q.isEmpty()) {
				Node node = q.dequeue();

				System.out.print(node.data + ", ");

				if (node.left != null) {
					q.enqueue(node.left);
				}

				if (node.right != null) {
					q.enqueue(node.right);
				}
			}
		} catch (Exception ex) {
			// swallow exception - not expecting any
		}

		System.out.println("END");
	}

	public boolean isBST1() {
		return this.isBST1(this.root);
	}

	private boolean isBST1(Node node) {
		if (node == null) {
			return true;
		}

		int lMax = maximum(node.left);
		int rMin = minimum(node.right);

		if (node.data < lMax || node.data > rMin) {
			return false;
		}

		boolean isLeftTreeABST = isBST1(node.left);
		boolean isRightTreeABST = isBST1(node.right);

		return isLeftTreeABST && isRightTreeABST;
	}

	public int maximum() {
		return maximum(this.root);
	}

	private int maximum(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lMax = maximum(node.left);
		int rMax = maximum(node.right);

		return Math.max(node.data, Math.max(lMax, rMax));
	}

	public int minimum() {
		return minimum(this.root);
	}

	private int minimum(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int lMin = minimum(node.left);
		int rMin = minimum(node.right);

		return Math.min(node.data, Math.min(lMin, rMin));
	}

	public boolean isBST2() {
		return this.isBST2(this.root).isBST;
	}

	private BSTReturnType isBST2(Node node) {
		if (node == null) {
			return null;
		}

		BSTReturnType lResult = isBST2(node.left);
		BSTReturnType rResult = isBST2(node.right);

		BSTReturnType retVal = new BSTReturnType(true, node, node);

		// when can retVal's isBST turn false;
		if (lResult != null && ((!lResult.isBST || lResult.max.data > node.data))) {
			retVal.isBST = false;
		}

		if (rResult != null && ((!rResult.isBST || rResult.min.data < node.data))) {
			retVal.isBST = false;
		}

		// calculate min and max for retVal
		if (retVal.isBST) {
			if (lResult != null) {
				retVal.min = lResult.min;
			}

			if (rResult != null) {
				retVal.max = rResult.max;
			}

			retVal.largestBSTRoot = node;
			retVal.largestBSTSize = 1 + (lResult != null ? lResult.largestBSTSize : 0) + (rResult != null ? rResult.largestBSTSize : 0);
		} else {
			if (lResult != null) {
				retVal.largestBSTRoot = lResult.largestBSTRoot;
				retVal.largestBSTSize = lResult.largestBSTSize;
			}

			if (rResult != null && rResult.largestBSTSize > retVal.largestBSTSize) {
				retVal.largestBSTRoot = rResult.largestBSTRoot;
				retVal.largestBSTSize = rResult.largestBSTSize;
			}
		}

		return retVal;
	}

	public boolean isBST3() {
		return this.isBST3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST3(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		boolean isLeftOk = isBST3(node.left, min, node.data);
		boolean isRightOk = isBST3(node.right, node.data, max);

		return isLeftOk && isRightOk;
	}

	private class SPair {
		Node successor;
		Node node;
	}

	public int successsor(int data) {
		SPair sPair = new SPair();
		this.successor(this.root, data, sPair);
		return sPair.successor != null ? sPair.successor.data : -1;
	}

	private void successor(Node node, int data, SPair sPair) {
		if (node == null) {
			return;
		}

		this.successor(node.left, data, sPair);

		if (sPair.node == null) {
			if (node.data == data) {
				sPair.node = node;
			}
		} else {
			if (sPair.successor == null) {
				sPair.successor = node;
			}
		}

		this.successor(node.right, data, sPair);
	}

	private class PPair {
		Node predecessor;
		Node node;
	}

	public int predecessor(int data) {
		PPair pPair = new PPair();
		this.predecessor(this.root, data, pPair);
		return pPair.predecessor != null ? pPair.predecessor.data : -1;
	}

	private void predecessor(Node node, int data, PPair pPair) {
		if (node == null) {
			return;
		}

		this.predecessor(node.left, data, pPair);

		if (pPair.node == null) {
			if (node.data == data) {
				pPair.node = node;
			} else {
				pPair.predecessor = node;
			}
		}

		this.predecessor(node.right, data, pPair);
	}

	public int depth(int data) {
		return this.depth(this.root, data, 0);
	}

	private int depth(Node node, int data, int k) {
		if (node == null) {
			return -1;
		}

		if (node.data == data) {
			return k;
		} else {
			int dil = this.depth(node.left, data, k + 1);

			if (dil != -1) {
				return dil;
			} else {
				int dir = this.depth(node.right, data, k + 1);
				return dir;
			}
		}
	}
	
	public void printAtK(int target, int k){
		
	}
	
	private int printAtK(Node node, int target, int k){
		if(node == null){
			return -1;
		}
		
		if(node.data == target){
			this.printAtKDown(node, k);
			return 0;
		}
		
		int dl = printAtK(node.left, target, k);
		if(dl != -1){
			if (dl + 1 < k){
				printAtKDown(node.right, k - (dl + 2));
			}
			else if(dl + 1 == k){
				System.out.println(node.data);
			}
			
			return dl + 1;
		}
		
		int dr = printAtK(node.right, target, k);
		if(dr != -1){
			if (dr + 1 < k){
				printAtKDown(node.left, k - (dr + 2));
			}
			else if(dr + 1 == k){
				System.out.println(node.data);
			}
			
			return dr + 1;
		}
		
		return -1;
	}
	
	private void printAtKDown(Node node, int k){
		if(node == null){
			return;
		}
		
		if (k == 0){
			System.out.println(node.data);
			return;
		}
		
		printAtKDown(node.left, k - 1);
		printAtKDown(node.right, k - 1);
	}
}
