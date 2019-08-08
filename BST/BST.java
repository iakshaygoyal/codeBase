package BST; 

import java.util.*;
import java.util.LinkedList;

public class BST {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
		
		public String toString(){
			String retval="";
			
			if(this.left!=null){
				retval+=this.left.data+" => ";
			}
			
			retval+=this.data;
			
			if(this.right!=null){
				retval+=" <= "+this.right.data;
			}
			retval+=" END\n";
			
			if(this.left!=null){
				retval+=this.left.toString();
			}
			
			if(this.right!=null){
				retval+=this.right.toString();
			}
			
			return retval;
		}
		
	}
	
	private Node root;
	private int size;
	
	public BST(){
		
	}
	
	public BST(int[] sortedArray){
		this.root = this.constructTree(sortedArray, 0, sortedArray.length-1);
	}
	
	private Node constructTree(int[] sortedArray, int si,int li){
		if(si>li){
			return null;
		}
//		int mid=(si+li)/2; //(DOES NOT CREATE BALANCED TREE)(BOTH ARE CORRECT THOUGH)
		int mid=(si+li+1)/2;
		Node newNode = new Node(sortedArray[mid], null, null);
		newNode.left = this.constructTree(sortedArray, si, mid-1);
		newNode.right = this.constructTree(sortedArray, mid+1, li);
		return newNode;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		return this.root.toString();
	}
	
	public boolean find(int data){
		return this.find(this.root,data);
	}
	
	private boolean find(Node node,int data){
		if(node==null){
			return false;
		}
		
		if(data==node.data){
			return true;
		}
		else if(data<node.data){
			return this.find(node.left, data);
		}
		else{
			return this.find(node.right, data);
		}
	}
	
	public void add(int data){
		this.root=this.add(this.root, data);
	}
	
	private Node add(Node node,int data){
		if(node == null){
			this.size++;
			Node newNode = new Node(data,null,null);
			return newNode;
		}
		if(data < node.data){
			node.left = this.add(node.left, data);
			return node;
		}
		else if(data > node.data){
			node.right = this.add(node.right, data);
			return node;
		}
		else{
			//Duplicates
			return node;
		}
	}
	
	public void remove(int data){
		this.root=this.remove(this.root,data);
	}
	
	private Node remove(Node node,int data){
		if(node==null){
			return null;
		}
		if(data<node.data){
			node.left=this.remove(node.left, data);
			return node;
		}
		else if(data>node.data){
			node.right=this.remove(node.right, data);
			return node;
		}
		else{
			this.size--;
			if(node.left == null && node.right ==null){
				return null;
			}
			else if(node.left == null){
				return node.right;
			}
			else if(node.right == null){
				return node.left;
			}
			else{
				Node temp = node.left;
				while(temp.right !=null){
					temp=temp.right;
				}
				node.data=temp.data;
				node.left=this.remove(node.left, temp.data);
				return node;
			}
		}
	}
	
	class Pair{
		Node start,end;
		Pair(Node start,Node end){
			this.start=start;
			this.end=end;
		}
	}
	void bstToSortedList(){
		this.root=this.bstToSortedList(this.root).start;
	}
	private Pair bstToSortedList(Node node){
		if(node==null){
			return null;
		}
		Pair leftPair=this.bstToSortedList(node.left);
		Pair rightPair=this.bstToSortedList(node.right);
		if(leftPair!=null){
			leftPair.end.right=node;
		}
		node.left=null;
		if(rightPair!=null){
			node.right=rightPair.start;
		}
		return new Pair(leftPair!=null?leftPair.start:node
				,rightPair!=null?rightPair.end:node);
	}
	
	public void printRange(int k1,int k2){
		this.printRange(this.root, k1, k2);
		System.out.println("END");
	}
	
	private void printRange(Node node,int k1,int k2){
		if(node == null){
			return;
		}
		if(k1<node.data && k2<node.data){
			this.printRange(node.left, k1, k2);
		}
		else if(k1>node.data && k2>node.data){
			this.printRange(node.right, k1, k2);
		}
		else{
			System.out.print(node.data+", ");
			this.printRange(node.left, k1, k2);
			this.printRange(node.right, k1, k2);
		}
	}
	
	public void inorderSuccessor(int data){
		Node node=this.inorderSuccessor(this.root, data);
		if(node!=null){
			System.out.println("Inorder Successor of "+data+" : "+node.data);
		}
	}
	
	private Node inorderSuccessor(Node node,int data){
		if(node==null){
			System.out.println(data+" not present");
			return null;
		}
		if(data<node.data){
			return this.inorderSuccessor(node.left, data);
		}
		else if(data>node.data){
			return this.inorderSuccessor(node.right, data);
		}
		else{
			Node temp=node.right;
			if(temp==null){
				System.out.println(data+" is the largest element");
				return null;
			}
			while(temp.left!=null){
				temp=temp.left;
			}
			return temp;
		}
	}

	public void inorderPredecessor(int data){
		Node node=this.inorderPredecessor(this.root, data);
		if(node!=null){
			System.out.println("inorder Predecessor of "+data+" : "+node.data);
		}
	}
	
	private Node inorderPredecessor(Node node,int data){
		if(node==null){
			System.out.println(data+" not present");
			return null;
		}
		if(data<node.data){
			return this.inorderPredecessor(node.left, data);
		}
		else if(data>node.data){
			return this.inorderPredecessor(node.right, data);
		}
		else{
			Node temp=node.left;
			if(temp==null){
				System.out.println(data+" is the smallest element");
				return null;
			}
			while(temp.right!=null){
				temp=temp.right;
			}
			return temp;
		}
	}
	
	public void inOrder(){
		this.inOrder(this.root);
		System.out.println("END");
	}
	
	private void inOrder(Node node){
		if(node == null){
			return;
		}
		
		this.inOrder(node.left);
		System.out.print(node.data+", ");
		this.inOrder(node.right);
	}
		
	public void inserLeftofEachNode(){
		this.insertLeftofEachNode(this.root);
	}
	
	private Node insertLeftofEachNode(Node node){
		if(node == null){
			return null;
		}
		else{
			Node newNode = new Node(node.data, null, null);
			newNode.left = node.left;
			node.left = newNode;
			newNode.left = this.insertLeftofEachNode(newNode.left);
			node.right = this.insertLeftofEachNode(node.right);
			return node;
		}
	}
	
	
	
	//COMPLEXITY  -  O(h)(IF WE CONSIDER THAT BOTH THE NODES ARE PRESENT IN THE TREE)
	
	
	
	public int lca(int value1, int value2){
		if(!this.find(value1) || !this.find(value2)){
			return -1;
		}
		return this.lca(this.root, value1, value2);
	}
	
	private int lca(Node node, int value1, int value2){
		if(value1 < node.data && value2 < node.data){
			return this.lca(node.left, value1, value2);
		}
		else if(value1 > node.data && value2 > node.data){
			return this.lca(node.right, value1, value2);
		}
		else{
			return node.data;
		}
	}
	
	static int sum=0;
	public void replaceEachNodeWithSumOfAllGreaterNodes(){
		this.replaceEachNodeWithSumOfAllGreaterNodes(this.root);
	}
	
	private void replaceEachNodeWithSumOfAllGreaterNodes(Node node){
		if(node == null){
			return;
		}
		this.replaceEachNodeWithSumOfAllGreaterNodes(node.right);
		int temp=node.data;
		node.data=sum;
		sum+=temp;
		this.replaceEachNodeWithSumOfAllGreaterNodes(node.left);
	}
	
//	Find k-th smallest element in BST (Order Statistics in BST)
	
	int x;
	public int ksmallest(int k){
		x=k;
		Node node=this.ksmallesthelper(this.root);
		if(node==null){
			return -1;
		}
		else{
			return node.data;
		}
	}
	
	private Node ksmallesthelper(Node node){
		if(node==null){
			return null;
		}
		Node left=this.ksmallesthelper(node.left);
		if(left!=null){
			return left;
		}
		if(x==1){
			return node;
		}
		x--;
		Node right=this.ksmallesthelper(node.right);
		if(right!=null){
			return right;
		}
		return null;
	}
	
	int kthsmallest1(int k){
		Stack<Node> stk=new Stack<>();
		Node node=this.root;
		while(node!=null){
			stk.push(node);
			node=node.left;
		}
		while(!stk.isEmpty()){
			node=stk.pop();
			if(k==1){
				return node.data;
			}
			k--;
			if(node.right!=null){
				node=node.right;
				while(node!=null){
					stk.push(node);
					node=node.left;
				}
			}
		}
		return -1;
	}
	
//	Merge Two Balanced or Unbalanced Binary Search Trees : O(m+n)
	
	public BST merge(BST tree){
		a1=new int[this.size];
		this.bst2array(this.root);
		a2=a1;
		a1=new int[tree.size];
		i=0;
		this.bst2array(tree.root);
		
		int[] a3=new int[a1.length+a2.length];
		int j=0,k=0,l=0;
		while(j<a1.length && k<a2.length){
			if(a1[j]<a2[k]){
				a3[l++]=a1[j++];
			}
			else{
				a3[l++]=a2[k++];
			}
		}
		while(j<a1.length){
			a3[l++]=a1[j++];
		}
		while(k<a2.length){
			a3[l++]=a2[k++];
		}
		BST newTree=new BST();
		newTree.root=this.constructTree(a3, 0, a3.length-1);
		return newTree;
	}
	
	static int i=0;
	static int[] a1;
	static int[] a2;
	private void bst2array(Node node){
		if(node==null){
			return;
		}
		this.bst2array(node.left);
		a1[i++]=node.data;
		this.bst2array(node.right);
	}
	
//	Merge and print in sorted form two BSTs with limited extra space(space - O(height of the first tree + height of the second tree))
//  otherwise this question can be done by the above method only with same time complexity but large space complexity
	
	public void mergeandPrint(BST tree){
		LinkedList<Node> stk1=new LinkedList<>();
		LinkedList<Node> stk2=new LinkedList<>();
		Node node=this.root;
		while(node!=null){
			stk1.addFirst(node);
			node=node.left;
		}
		node=tree.root;
		while(node!=null){
			stk2.addFirst(node);
			node=node.left;
		}
		while(!(stk1.isEmpty() || stk2.isEmpty())){
			if(stk1.getFirst().data<stk2.getFirst().data){
				Node node1=stk1.removeFirst();
				System.out.print(node1.data+" ");
				node1=node1.right;
				while(node1!=null){
					stk1.addFirst(node1);
					node1=node1.left;
				}
			}
			else{
				Node node2=stk2.removeFirst();
				System.out.print(node2.data+" ");
				node2=node2.right;
				while(node2!=null){
					stk2.addFirst(node2);
					node2=node2.left;
				}
			}
		}
		while(!stk1.isEmpty()){
			Node node1=stk1.removeFirst();
			System.out.print(node1.data+" ");
			node1=node1.right;
			while(node1!=null){
				stk1.addFirst(node1);
				node1=node1.left;
			}
		}
		while(!stk2.isEmpty()){
			Node node2=stk2.removeFirst();
			System.out.print(node2.data+" ");
			node2=node2.right;
			while(node2!=null){
				stk2.addFirst(node2);
				node2=node2.left;
			}
		}
	}
	
//	Two nodes of a BST are swapped, correct the BST
	
	Node a=null,b=null,c=null,prev=null;
	public void correctbst(){
		this.correctbst(this.root);
		if(c==null){
			this.swap(a,b);
		}
		else{
			this.swap(a,c);
		}
	}
	
	private void correctbst(Node node){
		if(node==null){
			return;
		}
		this.correctbst(node.left);
		if(prev!=null && prev.data>node.data){
			if(a==null){
				a=prev;
				b=node;
			}
			else{
				c=node;
			}
		}
		prev=node;
		this.correctbst(node.right);
	}
	
	private void swap(Node node1,Node node2){
		int temp=node1.data;
		node1.data=node2.data;
		node2.data=temp;
	}
	
//	Sorted Linked List to Balanced BST(O(N) BUT USES SPACE)
	
	public BST ll2bst(LinkedList<Integer> list){
		int[] a=new int[list.size()];
		for(int i=0;i<a.length;i++){
			a[i]=list.removeFirst();
		}
		BST tree=new BST();
		tree.root=this.constructTree(a, 0, a.length-1);
		return tree;
	}
	
//	 Balanced BST to Sorted Linked List
	
	static LinkedList<Integer> list;
	public LinkedList<Integer> bst2ll(){
		list=new LinkedList<>();
		this.bst2ll(this.root);
		return list;
	}
	
	private void bst2ll(Node node){
		if(node==null){
			return;
		}
		this.bst2ll(node.left);
		list.addLast(node.data);
		this.bst2ll(node.right);
	}
	
}