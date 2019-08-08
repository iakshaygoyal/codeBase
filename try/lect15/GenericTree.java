package lect15;

import java.util.ArrayList;
import java.util.Scanner;

import lect13.queues.*;
import lect13.stacks.*;
import lect13.shared.*;

public class GenericTree<T extends Comparable<T>> {
	private class Node implements Comparable<Node> {
		T data;
		ArrayList<Node> children;

		Node(T data, ArrayList<Node> children) {
			this.data = data;
			this.children = children;
		}

		public String toString() {
			String retVal = "";

			retVal += this.data + " => ";
			for (Node child : this.children) {
				retVal += child.data + ", ";
			}

			retVal += "END\n";

			for (int i = 0; i < this.children.size(); i++) {
				retVal += this.children.get(i).toString();
			}

			return retVal;
		}

		public Integer sumOfNodeAndChildren() {
			System.out.println("hi");
			Integer retVal = (Integer) this.data;

			for (Node child : this.children) {
				retVal += (Integer) child.data;
			}

			return retVal;
		}

		public int compareTo(Node o) {
			return this.data.compareTo(o.data);
		}
	}

	private class Pair {
		Node node;
		int sumOfNodeAndChildren;

		Pair(Node node) {
			this.node = node;
			this.sumOfNodeAndChildren = node.sumOfNodeAndChildren();
		}
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, -1);
	}

	private Node takeInput(Scanner scn, Node parentNode, int ithChild) {
		if (parentNode == null) {
			System.out.println("Enter data for root node");
		} else {
			System.out.println("Enter data for " + ithChild + "th child of " + parentNode.data);
		}

		Integer cData = scn.nextInt();

		System.out.println("Enter number of children for " + cData);
		Integer numChildren = scn.nextInt();

		Node child = new Node((T) cData, new ArrayList<>());
		this.size++;

		for (int i = 0; i < numChildren; i++) {
			Node grandChild = this.takeInput(scn, child, i + 1);
			child.children.add(grandChild);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(this);
	}

	public String toString() {
		return this.root.toString();
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int retVal = 0;

		for (int i = 0; i < node.children.size(); i++) {
			int sizeOfChild = this.size2(node.children.get(i));
			retVal += sizeOfChild;
		}

		retVal += 1; // fore the node itself

		return retVal;
	}

	public T max() {
		return this.max(this.root);
	}

	private T max(Node node) {
		T retVal = node.data;

		for (Node child : node.children) {
			T maxOfChild = this.max(child);
			if (maxOfChild.compareTo(retVal) > 0) {
				retVal = maxOfChild;
			}
		}

		return retVal;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int maxHeight = -1;

		for (Node child : node.children) {
			int heightOfChild = this.height(child);
			if (heightOfChild > maxHeight) {
				maxHeight = heightOfChild;
			}
		}

		return maxHeight + 1;
	}

	public void printAtDepth(int depth) {
		this.printAtDepth(this.root, depth);
		System.out.println("END");
	}

	private void printAtDepth(Node node, int depth) {
		if (depth == 0) {
			System.out.print(node.data + ", ");
			return;
		}

		for (Node child : node.children) {
			this.printAtDepth(child, depth - 1);
		}
	}

	public Integer maxSumOfNodes() {
		// return (Integer)this.maxSumOfNodes(this.root).data;
		return (Integer) this.maxSumOfNodes2(this.root).node.data;
	}

	private Node maxSumOfNodes(Node node) {
		Node retVal = node;

		for (Node child : node.children) {
			Node maxOfChild = this.maxSumOfNodes(child);
			if (maxOfChild.sumOfNodeAndChildren() > retVal.sumOfNodeAndChildren()) {
				retVal = maxOfChild;
			}
		}

		return retVal;
	}

	private Pair maxSumOfNodes2(Node node) {
		Pair retVal = new Pair(node);

		for (Node child : node.children) {
			Pair maxOfChild = this.maxSumOfNodes2(child);
			if (maxOfChild.sumOfNodeAndChildren > retVal.sumOfNodeAndChildren) {
				retVal = maxOfChild;
			}
		}

		return retVal;
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		System.out.print(node.data + ", ");
		for (Node child : node.children) {
			this.preOrder(child);
		}
	}

	public void levelOrder() {
		IQueue<Node> queue = new QueueUsingLinkedLists<>();

		try {
			queue.enqueue(this.root);
			while (!queue.isEmpty()) {
				Node n2P = queue.dequeue();

				System.out.print(n2P.data + ", ");

				for (int i = 0; i < n2P.children.size(); i++) {
					queue.enqueue(n2P.children.get(i));
				}
			}
		} catch (Exception ex) {
			// never going to come here
		}

		System.out.println("END");
	}

	public void preOrderIterative() {
		IStack<Node> stack = new StackUsingLinkedLists<>();

		try {
			stack.push(this.root);
			while (!stack.isEmpty()) {
				Node n2P = stack.pop();

				System.out.print(n2P.data + ", ");

				for (int i = n2P.children.size() - 1; i >= 0; i--) {
					stack.push(n2P.children.get(i));
				}
			}
		} catch (Exception ex) {
			// never going to come here
		}

		System.out.println("END");
	}

}
