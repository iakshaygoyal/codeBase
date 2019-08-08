package again;

import java.util.LinkedList;

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


	private Node root;
	private int size;
	
	public BST(){}
	
	public BST(int[] arr){
		this.root = this.constructbstFromSortedArray(arr, 0, arr.length-1);
	}
	
	private Node constructbstFromSortedArray(int[] arr, int si, int li){
		if(si>li){
			return null;
		}
		
		int mid=(si+li)/2;
		Node newNode = new Node(arr[mid], null, null);
		
		newNode.left = this.constructbstFromSortedArray(arr, si, mid-1);
		newNode.right = this.constructbstFromSortedArray(arr, mid+1, li);
		
		return newNode;
		
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		return this.root.toString();
	}
	
	public void addElement(int data){
		this.root = this.addElement(this.root, data);
	}
	
	private Node addElement(Node node, int data){
		if(node == null){
			this.size++;
			return new Node(data, null, null);
		}
		else if(data < node.data){
			node.left=this.addElement(node.left, data);
			return node;
		}
		else if(data > node.data){
			node.right=this.addElement(node.right, data);
			return node;
		}
		else{
			System.out.println("Duplicates");
			return node;
		}
	}
	
	public void removeElement(int data){
		this.root=this.removeElement(this.root, data);
	}
	
	private Node removeElement(Node node, int data){
		if(node == null){
			System.out.println("Not present");
			return null;
		}
		else if(data < node.data){
			node.left=this.removeElement(node.left, data);
			return node;
		}
		else if(data > node.data){
			node.right=this.removeElement(node.right, data);
			return node;
		}
		else{
			if(node.left == null && node.right == null){
				this.size--;
				return null;
			}
			else if(node.left == null){
				this.size--;
				return node.right;
			}
			else if(node.right == null){
				this.size--;
				return node.left;
			}
			else{
				Node temp=node.left;
				
				while(temp.right != null){
					temp=temp.right;
				}
				
				node.data=temp.data;
				node.left=this.removeElement(node.left, temp.data);
				
				return node;
			}
		}
	}
	
	public int size(){
		return this.size(this.root);
	}
	
	private int size(Node node){
		if(node == null){
			return 0;
		}
		
		int retval=1;
		
		retval+=this.size(node.left);
		retval+=this.size(node.right);
		
		return retval;
	}
	
	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node){
		if(node == null){
			return -1;
		}
		
		int hleft=this.height(node.left);
		int hright=this.height(node.right);
		
		return 1+Math.max(hleft, hright);
	}
	
	public int max(){
		return this.max(this.root).data;
	}
	
	private Node max(Node node){
		while(node.right != null){
			node=node.right;
		}
		
		return node;
	}
	
	public int min(){
		return this.min(this.root).data;
	}
	
	private Node min(Node node){
		while(node.left != null){
			node=node.left;
		}
		
		return node;
	}
	
	public boolean findElement(int data){
		return this.findElement(this.root, data);
	}
	
	private boolean findElement(Node node, int data){
		if(node == null){
			return false;
		}
		else if(data < node.data){
			return this.findElement(node.left, data);
		}
		else if(data > node.data){
			return this.findElement(node.right, data);
		}
		else{
			return true;
		}
	}
	
	public void printInRange(int k1, int k2){
		this.printInRange(this.root, k1, k2);
		System.out.println("END");
	}
	
	private void printInRange(Node node, int k1, int k2){
		if(node == null){
			return;
		}
		else if(k1<node.data && k2>node.data){
			this.printInRange(node.left, k1, k2);
			System.out.print(node.data+", ");
			this.printInRange(node.right, k1, k2);
		}
		else if(k1<node.data){
			this.printInRange(node.left, k1, k2);
		}
		else{
			this.printInRange(node.right, k1, k2);
		}
	}
	
	private class Pair{
		Node head;
		Node tail;
		
		Pair(Node head, Node tail){
			this.head=head;
			this.tail=tail;
		}
		
	}
	
	public void bst2SortedLinkedList(){
		this.root=this.bst2SortedLinkedList(this.root).head;
	}
	
	private Pair bst2SortedLinkedList(Node node){
		if(node == null){
			return null;
		}
		
		Pair lpair = this.bst2SortedLinkedList(node.left);
		Pair rpair = this.bst2SortedLinkedList(node.right);
		Pair retval = new Pair(node, node);
		
		if(lpair != null){
			retval.head = lpair.head;
			lpair.tail.right = node;
			node.left=null;
		}
		
		if(rpair != null){
			retval.tail = rpair.tail;
			node.right = rpair.head;
		}
		
		return retval;
	}
	
	public int sum(){
		return this.sum(this.root);
	}
	
	private int sum(Node node){
		if(node == null){
			return 0;
		}
		
		int retval = node.data;
		
		retval+=this.sum(node.left);
		retval+=this.sum(node.right);
		
		return retval;
	}
	
	int sum;
	
	public void replace(){
		sum = this.sum();
		this.replace(this.root);
	}
	
	public void replace(Node node){
		if(node == null){
			return;
		}
		this.replace(node.left);
		sum-=node.data;
		node.data = sum;
		this.replace(node.right);
	}
}