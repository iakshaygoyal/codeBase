package lect17;

import lect13.queues.QueueUsingLinkedLists;
import lect13.shared.IQueue;

public class BST {
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

	private Node root;
	private int size;

	public BST() {

	}

	public BST(int[] sortedArray) {
		this.root = this.constructTree(sortedArray, 0, sortedArray.length - 1);
	}

	private Node constructTree(int[] sortedArray, int si, int li) {
		if (si > li) {
			return null;
		}

		int mid = (si + li) / 2;
		Node retVal = new Node(sortedArray[mid], null, null);

		retVal.left = this.constructTree(sortedArray, si, mid - 1);
		retVal.right = this.constructTree(sortedArray, mid + 1, li);

		return retVal;
	}

	// new function
	public void addElement(int data) {
		this.root = this.addElement(data, this.root);
	}

	// add the element in node and return the root of new tree
	private Node addElement(int data, Node node) {
		if (node == null) {
			this.size++;
			return new Node(data, null, null);
		}

		if (data > node.data) {
			node.right = this.addElement(data, node.right);
			return node;
		} else if (data < node.data) {
			node.left = this.addElement(data, node.left);
			return node;
		} else {
			// data exists - nothing to add
			return node;
		}
	}

	// new function
	public void removeElement(int data) {
		this.root = this.removeElement(data, this.root);
	}

	private Node removeElement(int data, Node node) {
		if (node == null) {
			return null;
		}

		if (data > node.data) {
			node.right = this.removeElement(data, node.right);
			return node;
		} else if (data < node.data) {
			node.left = this.removeElement(data, node.left);
			return node;
		} else {
			// reached node which needs deletion
			this.size--;
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.right == null) {
				return node.left;
			} else if (node.left == null) {
				return node.right;
			} else {
				Node leftMax = node.left;

				while (leftMax.right != null) {
					leftMax = leftMax.right;
				}

				node.data = leftMax.data;
				node.left = this.removeElement(leftMax.data, node.left);

				return node;
			}
		}
	}

	public void display() {
		System.out.println(this);
	}

	public String toString() {
		return this.root.toString();
	}

	public int size() {
		return this.size;
		// return this.size(this.root);
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

	public boolean isEmpty() {
		return this.size() == 0;
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

	// find changes
	public boolean findElement(int item) {
		return this.findElement(this.root, item);
	}

	private boolean findElement(Node node, int item) {
		if (node == null) {
			return false;
		}

		if (item == node.data) {
			return true;
		} else if (item > node.data) {
			return this.findElement(node.right, item);
		} else {
			return this.findElement(node.left, item);
		}
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

	public void printInRange(int k1, int k2) {
		this.printInRange(this.root, k1, k2);
	}

	private void printInRange(Node node, int k1, int k2) {
		if (node == null) {
			return;
		}

		if (k1 > node.data && k2 > node.data) {
			this.printInRange(node.right, k1, k2);
		} else if (k1 < node.data && k2 < node.data) {
			this.printInRange(node.left, k1, k2);
		} else {
			this.printInRange(node.left, k1, k2);

			System.out.print(node.data + ", ");

			this.printInRange(node.right, k1, k2);
		}
	}

	// changes
	public int maximum() {
		return maximum(this.root).data;
	}

	private Node maximum(Node node) {
		if (node == null) {
			return null;
		}

		Node maxNode = maximum(node.right);
		if (maxNode == null) {
			maxNode = node;
		}

		return maxNode;
	}

	// changes
	public int minimum() {
		return minimum(this.root);
	}

	private int minimum(Node node) {
		int minData = node.data;

		if (node.left != null) {
			minData = minimum(node.left);
			;
		}

		return minData;
	}

	public int successor(int data) {
		Node retVal = null;
		Node temp = this.root;

		while (temp != null) {
			if (data > temp.data) {
				temp = temp.right;
			} else if (data < temp.data) {
				retVal = temp;
				temp = temp.left;
			} else {
				// reached
				if (temp.right != null) {
					retVal = temp.right;

					while (retVal.left != null) {
						retVal = retVal.left;
					}
				}

				break;
			}
		}

		return retVal != null ? retVal.data : -1;
	}

	private class ListPair {
		Node head;
		Node tail;
	}

	public void makeSortedLinkedList() {
		this.root = this.makeSortedLinkedList(this.root).head;
	}

	private ListPair makeSortedLinkedList(Node node) {
		if (node == null) {
			return null;
		}

		ListPair lList = this.makeSortedLinkedList(node.left);
		ListPair rList = this.makeSortedLinkedList(node.right);

		if (lList != null) {
			lList.tail.right = node;
		}
		node.left = null;

		if (rList != null) {
			node.right = rList.head;
		}

		ListPair retVal = new ListPair();
		
		retVal.head = lList != null? lList.head: node;
		retVal.tail = rList != null? rList.tail: node;

		return retVal;
	}
}
