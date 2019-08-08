package BinaryTree;
import java.util.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import LL.LinkedList;
import Queue.DifferentQueues.queueUsingLinkedList;
import Queue.Interfaces.iQueue;
import Stack.DifferentStacks.stackUsingLinkedList;
import Stack.Interfaces.iStack;
public class BinaryTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
		int liss;
		int vc;
		
		public Node(int data, Node left, Node right){
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
			retval+="END\n";
			
			if(this.left!=null){
				retval+=this.left.toString();
			}
			
			if(this.right!=null){
				retval+=this.right.toString();
			}
			
			return retval;
		}
		
	}

	private static final Comparator<? super Integer> I = null;
	
	private Node root;
	private int size;	
	
	//NO NEED OF THE TERM ISBST
	
	
	
//	private class Penta{
//		Boolean isBST;
//		Node root;
//		Node min;
//		Node max;
//		int height;
//		
//		Penta(Boolean isBST, Node root, Node min, Node max, int height){
//			this.isBST = isBST;
//			this.root = root;
//			this.min = min;
//			this.max = max;
//			this.height = height;
//		}
//		
//		Penta(){}
//	}
	
	public BinaryTree(){}
	
	public BinaryTree(boolean b){
		Scanner scn=new Scanner(System.in);
		this.root=this.takeInput(scn, null, false);
	}
	
	private Node takeInput(Scanner scn, Node parentNode, boolean isParentsLeftChild){
		if(parentNode == null){
			System.out.println("Enter data for root");
		}
		else{
			if(isParentsLeftChild){
				System.out.println("Enter data for left child of "+parentNode.data);
			}
			else{
				System.out.println("Enter data for right child of "+parentNode.data);
			}
		}
		
		int cData=scn.nextInt();
		Node child=new Node(cData,null,null);
		this.size++;
		
		System.out.println("Do you have a left child for "+child.data);
		boolean isChildLeft=scn.nextBoolean();
		
		if(isChildLeft){
			child.left = this.takeInput(scn, child, true);
		}
		
		System.out.println("Do you have a right child for "+child.data);
		boolean isChildRight=scn.nextBoolean();
		
		if(isChildRight){
			child.right = this.takeInput(scn, child, false);
		}
		
		return child;
	}

	public int size(){
		return this.size;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		return this.root.toString();
	}
	
	public int size2(){
		return this.size2(this.root);
	}
	
	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int retVal = 1;
		retVal += this.size2(node.left);
		retVal += this.size2(node.right);
		return retVal;
	}
	
	public int height(){
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
	
	public int diameter(){
		return this.diameter(this.root);
	}
	
	private int diameter(Node node){
		if(node == null){
			return 0;
		}
		
		int factor1 = this.diameter(node.left);
		int factor2 = this.diameter(node.right);
		int factor3 = this.height(node.left) + this.height(node.right) + 2;
		
		return Math.max(factor1, Math.max(factor2, factor3));
	}
	
	class Pair{
		int height;
		int diameter;
		Pair(int height,int diameter){
			this.height=height;
			this.diameter=diameter;
		}
	}
	int diameter2(){
		return this.diameter2(this.root).diameter;
	}
	private Pair diameter2(Node node){
		if(node==null){
			return new Pair(-1,0);
		}
		Pair leftpair=this.diameter2(node.left);
		Pair rightpair=this.diameter2(node.right);
		return new Pair(Math.max(leftpair.height, rightpair.height)+1
				,Math.max(leftpair.diameter, Math.max(rightpair.diameter, leftpair.height+rightpair.height+2)));
	}
	
	public void mirror(){
		this.mirror(this.root);
	}
	
	private void mirror(Node node){
		if(node == null){
			return;
		}
		
		this.mirror(node.left);
		this.mirror(node.right);
		Node temp=node.left;
		node.left=node.right;
		node.right=temp;	
	}
	
	public boolean isPresent(int x){
		return this.isPresent(this.root,x);
	}
	
	private boolean isPresent(Node node, int x){

		if(node == null){
			return false;
		}
		if(node.data == x){
			return true;
		}
		else if(this.isPresent(node.left,x)){
			return true;
		}
		else if(this.isPresent(node.right,x)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public BinaryTree(int type , int[] one , int[] two){
		if(type == 0){
			this.root = this.constructSubtreeFromPreAndIn(one, 0, one.length-1, two, 0, two.length-1);
		}
		else if(type == 1){
			this.root = this.constructSubtreeFromPostAndIn(one, 0, one.length-1, two, 0, two.length-1);
		}
		else{
			System.out.println("Invalid Input");
		}
		System.out.println();
	}
	
	private Node constructSubtreeFromPreAndIn(int[] pre, int pSi, int pEi, int[] in, int iSi, int iEi){
		if(pSi > pEi || iSi > iEi){
			return null;
		}
		
		Node node = new Node(pre[pSi], null,null);
		
		int idx = iSi;
		while(idx <= iEi && in[idx] != pre[pSi]){
			idx++;
		}
		
		int nre = idx-iSi;
		
		node.left = this.constructSubtreeFromPreAndIn(pre, pSi+1, pSi+(nre), in, iSi, idx-1);
		node.right = this.constructSubtreeFromPreAndIn(pre, pSi+(nre)+1, pEi, in, idx+1, iEi);
		System.out.print(pre[pSi]+" ");
		return node;
	}
	
	private Node constructSubtreeFromPostAndIn(int[] post, int pSi, int pEi, int[] in, int iSi, int iEi){
		if(pSi > pEi || iSi > iEi){
			return null;
		}
		Node node = new Node(post[pEi], null, null);
		
		int idx=iSi;
		while(in[idx] != post[pEi]){
			idx++;
		}
		int nre = idx-iSi;
		
		node.left = this.constructSubtreeFromPostAndIn(post, pSi, pSi + nre - 1, in, iSi, idx-1);
		node.right = this.constructSubtreeFromPostAndIn(post, pSi + nre, pEi-1, in, idx+1, iEi);
				
		return node;
	}
	
	public void preOrder(){
		this.preOrder(this.root);
		System.out.println("END");
	}
	
	private void preOrder(Node node){
		if(node == null){
			return;
		}
		
		System.out.print(node.data+", ");
		this.preOrder(node.left);
		this.preOrder(node.right);
	}
	
	public void postOrder(){
		this.postOrder(this.root);
		System.out.println("END");
	}
	
	private void postOrder(Node node){
		if(node == null){
			return;
		}
		
		this.postOrder(node.left);
		this.postOrder(node.right);
		System.out.print(node.data+", ");
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

	
	public void inOrderIterative1(){
		java.util.LinkedList<Node> stk=new java.util.LinkedList<>();
		Node node=this.root;
		while(node!=null){
			stk.addFirst(node);
			node=node.left;
		}
		while(!stk.isEmpty()){
			Node node1=stk.removeFirst();
			System.out.print(node1.data+" ");
			if(node1.right!=null){
				node1=node1.right;
				while(node1!=null){
					stk.addFirst(node1);
					node1=node1.left;
				}
			}
		}
		System.out.println();
	}
	
	public void levelOrder(){
		iQueue<Node> q = new queueUsingLinkedList<>();
		try{
		q.enqueue(this.root);
		while(!q.isEmpty()){
			Node node = q.dequeue();
			System.out.print(node.data+", ");
			
			if(node.left != null){
				q.enqueue(node.left);
			}
			if(node.right != null){
				q.enqueue(node.right);
			}
		}
		System.out.println();
		}catch(Exception ex){
			// Unreachable code
		}
	}
	
	public void preOrderIterative(){
		iStack<Node> stk = new stackUsingLinkedList<>();
		try{
		stk.push(this.root);
		while(!stk.isEmpty()){
			Node node = stk.pop();
			System.out.print(node.data+", ");
			
			if(node.right != null){
				stk.push(node.right);
			}
			if(node.left != null){
				stk.push(node.left);
			}
		}
		System.out.println();
		}catch(Exception ex){
			//Unreachable Code
		}
	}
	
	public int minimum(){
		return this.minimum(this.root);
	}
	
	private int minimum(Node node){
		if(node == null){
			return Integer.MAX_VALUE;
		}
		
		int lMin = this.minimum(node.left);
		int rMin = this.minimum(node.right);
		
		return Math.min(node.data, Math.min(lMin, rMin));
	}
	
	public int maximum(){
		return this.maximum(this.root);
	}
	
	private int maximum(Node node){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		
		int lMax = this.maximum(node.left);
		int rMax = this.maximum(node.right);
		
		return Math.max(node.data, Math.max(lMax, rMax));
	}
	
	public boolean isBST1(){
		return this.isBST1(this.root);
	}
	
	private boolean isBST1(Node node){
		if(node == null){
			return true;
		}
		int lmax=this.maximum(node.left);
		int rmin=this.minimum(node.right);
		if(node.data<lmax || node.data>rmin){
			return false;
		}
		else if(!this.isBST1(node.left)){
			return false;
		}
		else if(!this.isBST1(node.right)){
			return false;
		}
		else{
			return true;
		}
	}
	
	class Tri{
		int min,max;
		boolean isbst;
		Tri(int min,int max,boolean isbst){
			this.min=min;
			this.max=max;
			this.isbst=isbst;
		}
	}
	boolean isBST2(){
		return this.isBST2(this.root).isbst;
	}
	private Tri isBST2(Node node){
		if(node==null){
			return new Tri(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
		}
		Tri leftTri=this.isBST2(node.left);
		Tri rightTri=this.isBST2(node.right);
		return new Tri(Math.min(node.data, Math.min(leftTri.min, rightTri.min))
				,Math.max(node.data, Math.max(leftTri.max, rightTri.max))
				,(leftTri.isbst && rightTri.isbst && node.data>leftTri.max && node.data<rightTri.min));
	}
	
	public boolean isBST3(){
		return this.isBST3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST3(Node node, int minlimit, int maxlimit){
		if(node == null){
			return true;
		}
	    else if(node.data<=minlimit || node.data>=maxlimit){
			return false;
		}
		else if(!this.isBST3(node.left, minlimit, node.data)){
			return false;
		}
		else if(!this.isBST3(node.right, node.data, maxlimit)){
			return false;
		}
		else{
			return true;
		}
	}
	

		
	
	
	//Crux Assignment
	
//	public void printAtK(int k, int value){
//		this.printAtK(this.root, value, k);
//		System.out.println("END");
//	}
//	
//	private int printAtK(Node node, int value, int k){
//		if(node == null){
//			return 0;
//		}
//		if(node.data == value){
//			this.kdown(node, k);
//			return 1;
//		}
//		
//		int left = this.printAtK(node.left, value, k);
//		if(left != 0){
//			if(left == k){
//				System.out.print(node.data + ", ");
//			}
//			else if(left < k){
//				this.kdown(node.right, k - left - 1);
//			}
//			return left + 1;
//		}
//		
//		int right = this.printAtK(node.right, value, k);
//		if(right != 0){
//			if(right == k){
//				System.out.print(node.data + ", ");
//			}
//			else if(right < k){
//				this.kdown(node.left, k - right - 1);
//			}
//			return right + 1;
//		}
//		
//		return 0;
//	}
//	
//	private void kdown(Node node, int k){
//		if(node == null){
//			return;
//		}
//		if(k == 0){
//			System.out.print(node.data + ", ");
//		}
//		this.kdown(node.left, k - 1);
//		this.kdown(node.right, k - 1);
//	}
//	
	
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
	
	public boolean isStructureSame(BinaryTree tree){
		return this.isStructureSame(this.root, tree.root);
	}
	
	private boolean isStructureSame(Node node1, Node node2){
		if((node1 == null && node2 != null) || (node1 != null && node2 == null)){
			return false;
		}
		else if(node1 == null && node2 == null){
			return true;
		}
		else if(node1.data != node2.data){
			return false;
		}
		else if(!isStructureSame(node1.left, node2.left)){
			return false;
		}
		else if(!isStructureSame(node1.right, node2.right)){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean isBalanced(){
		return this.isBalanced(this.root);				
	}
	
	private boolean isBalanced(Node node){
		if(node == null){
			return true;
		}
		if(Math.abs(this.height(node.left) - this.height(node.right)) > 1){
			return false;
		}
		else if(!this.isBalanced(node.left)){
			return false;
		}
		else if(!this.isBalanced(node.right)){
			return false;
		}
		else{
			return true;
		}
	}
	
	class Pair1{
		int height;
		boolean isBalanced;
		Pair1(int height,boolean isBalanced){
			this.height=height;
			this.isBalanced=isBalanced;
		}
	}
	boolean isBalanced2(){
		return this.isBalanced2(this.root).isBalanced;
	}
	private Pair1 isBalanced2(Node node){
		if(node==null){
			return new Pair1(-1,true);
		}
		Pair1 leftPair=this.isBalanced2(node.left);
		Pair1 rightPair=this.isBalanced2(node.right);
		return new Pair1(Math.max(leftPair.height, rightPair.height)+1
				,(leftPair.isBalanced && rightPair.isBalanced && Math.abs(leftPair.height-rightPair.height)<=1));
	}
	
	public ArrayList<java.util.LinkedList<Integer>> seperateLinkedList(){
		ArrayList<java.util.LinkedList<Integer>> majorList = new ArrayList<>();
		java.util.LinkedList<Integer> minorList = new java.util.LinkedList<>();
		java.util.LinkedList<Node> primaryQ = new java.util.LinkedList<>();
		java.util.LinkedList<Node> secondaryQ = new java.util.LinkedList<>();
		primaryQ.addLast(this.root);
		while(!primaryQ.isEmpty()){
			Node currentNode = primaryQ.removeFirst();
			minorList.add(currentNode.data);
			if(currentNode.left != null){
				secondaryQ.addLast(currentNode.left);
			}
			if(currentNode.right != null){
				secondaryQ.addLast(currentNode.right);
			}
			if(primaryQ.isEmpty()){
				primaryQ = secondaryQ;
				secondaryQ = new java.util.LinkedList<>();
				majorList.add(minorList);
				minorList = new java.util.LinkedList<>();
			}
		}
		return majorList;
	}
	
	public void printNodesWithoutSibling(){
		this.printNodesWithoutSibling(this.root);
	}
	
	private void printNodesWithoutSibling(Node node){
		if(node == null){
			return;
		}
		if((node.left == null && node.right != null) || (node.left != null && node.right == null)){
			System.out.println(node.data);
		}
		this.printNodesWithoutSibling(node.left);
		this.printNodesWithoutSibling(node.right);
	}
	
	public void removeLeafNodes(){
		this.root = this.removeLeafNodes(this.root);
	}
	
	private Node removeLeafNodes(Node node){
		if(node == null){
			return null;
		}
		if(node.left == null && node.right == null){
			return null;
		}
		node.left = this.removeLeafNodes(node.left);
		node.right = this.removeLeafNodes(node.right);
		return node;
	}
	
	public void smartLevelOrder(){
		java.util.LinkedList<Node> primaryQ = new java.util.LinkedList<>();
		java.util.LinkedList<Node> secondaryQ = new java.util.LinkedList<>();
		primaryQ.addLast(this.root);
		while(!primaryQ.isEmpty()){
			Node node = primaryQ.removeFirst();
			System.out.print(node.data + " ");
			if(node.left != null){
				secondaryQ.addLast(node.left);
			}
			if(node.right != null){
				secondaryQ.addLast(node.right);
			}
			if(primaryQ.isEmpty()){
				System.out.println();
				primaryQ = secondaryQ;
				secondaryQ = new java.util.LinkedList<>();
			}
		}
	}
	
	
	//best Method
	//if you have three linkedlist p, q, and r and u write p=r and q=r then p and q are
	//	pointing to the same linked list if u make any change in p then same change occurs in q
	
	
	public void zigzag(){
		java.util.LinkedList<Node> stk1 = new java.util.LinkedList<>();
		java.util.LinkedList<Node> stk2 = new java.util.LinkedList<>();
		stk1.addLast(this.root);
		int i=0;
		while(!stk1.isEmpty()){
			Node node = stk1.removeFirst();
			System.out.print(node.data + " ");
			if(i%2 == 0){
				if(node.left != null){
					stk2.addFirst(node.left);
				}
				if(node.right != null){
					stk2.addFirst(node.right);
				}
			}
			else{
				if(node.right != null){
					stk2.addFirst(node.right);
				}
				if(node.left != null){
					stk2.addFirst(node.left);
				}
			}
			if(stk1.isEmpty()){
				System.out.println();
				stk1 = stk2;
				stk2 = new java.util.LinkedList<>();
				i++;
			}
		}
	}
	
	void zigzag2(){
		Queue<Node> pq=new java.util.LinkedList<>();
		Queue<Node> sq=new java.util.LinkedList<>();
		Vector<Integer> vec=new Vector<>(0,1);
		pq.offer(this.root);
		int flag=0;
		while(!pq.isEmpty()){
			Node node=pq.poll();
			vec.add(node.data);
			if(node.left!=null){
				sq.offer(node.left);
			}
			if(node.right!=null){
				sq.offer(node.right);
			}
			if(pq.isEmpty()){
				if(flag==0){
					System.out.println(vec);
					vec.clear();
					flag=1;
				}
				else{
					Collections.reverse(vec);
					System.out.println(vec);
					vec.clear();
					flag=0;
				}
				pq=sq;
				sq=new java.util.LinkedList<>();
			}
		}
	}
	
	static boolean bool1=false;
	static Node is=null;
	
	public int inorderSuccessor(int data){
		this.inorderSuccessor(this.root, data);
		return is != null ? is.data : -1;
	}
	
	private void inorderSuccessor(Node node, int data){
		if(node == null){
			return;
		}
		this.inorderSuccessor(node.left, data);
		if(node.data == data){
			bool1 = true;
		}
		else if(bool1 == true && is == null){
			is = node;
		}
		this.inorderSuccessor(node.right, data);
	}
	
	static boolean bool2=false;
	static Node ip=null;
	
	public int inorderPredecessor(int data){
		this.inorderPredecessor(this.root, data);
		return ip != null ? ip.data : -1;
	}
	
	private void inorderPredecessor(Node node, int data){
		if(node == null){
			return;
		}
		this.inorderPredecessor(node.right, data);
		if(node.data == data){
			bool2 = true;
		}
		else if(bool2 == true && ip == null){
			ip = node;
		}
		this.inorderPredecessor(node.left, data);
	}	
	
	static int val=Integer.MAX_VALUE;
	int justGreaterThen(int data){
		justGreaterThen(this.root, data);
		if(val==Integer.MAX_VALUE){
			return -1;
		}
		return val;
	}
	
	void justGreaterThen(Node node,int data){
		if(node==null){
			return;
		}
		if(node.data>data && node.data<val){
			val=node.data;
		}
		justGreaterThen(node.left, data);
		justGreaterThen(node.right, data);
	}
	
	//(NEVER USE THIS)
	
	
	
//	public void bt2arraylist(){
//		ArrayList<Integer> al = this.bt2arraylist(this.root);
//		System.out.println(al);
//	}
//	
//	private ArrayList<Integer> bt2arraylist(Node node){
//		if(node == null){
////			return null;
//			return new ArrayList<>();
//		}
//		ArrayList<Integer> left = this.bt2arraylist(node.left);
//		ArrayList<Integer> right = this.bt2arraylist(node.right);
//		left.add(node.data);
//		left.addAll(right);
//		return left;
//	}
	
	
	
	
	//METHODS TO CREATE TREE INTO ARRAY OR ARRAYLIST
	
	
	
	
	static int i=0;
	// if we try to initialize array in this fashion then actually the value of size is 0 before the tree is created therefore the size of array is also zero
//	private int[] arr = new int[this.size];
	static int[] arr;
	
	public int[] bt2array(){
		arr = new int[this.size];
		this.bt2array(this.root);
		return arr;
	}
	
	private void bt2array(Node node){
		if(node == null){
			return;
		}
		this.bt2array(node.left);
		arr[i++] = node.data;
		this.bt2array(node.right);
	}
	
	static ArrayList<Integer> al = new ArrayList<>();
	
	public ArrayList<Integer> bt2arraylist(){
		this.bt2arraylist(this.root);
		return al;
	}
	
	private void bt2arraylist(Node node){
		if(node == null){
			return;
		}
		this.bt2arraylist(node.left);
		al.add(node.data);
		this.bt2arraylist(node.right);
	}
	
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	public HashMap<Integer, Integer> bt2hashmap(){
		this.bt2hashmap(this.root);
		return map;
	}
	
	private void bt2hashmap(Node node){
		if(node == null){
			return;
		}
		this.bt2hashmap(node.left);
		map.put(node.data, node.data);
		this.bt2hashmap(node.right);
	}
	
	
	//COMPLEXITY  -  O(n^2)
	
	
	public boolean sumOf2NodesEqualValue(int value){
		return this.sumOf2NodesEqualValue(this.root, value);
	}
	
	private boolean sumOf2NodesEqualValue(Node node, int value){
		if(node == null){
			return false;
		}
		int cp = value - node.data;
		if(cp != node.data && this.isPresent(cp)){
			return true;
		}
		else if(this.sumOf2NodesEqualValue(node.left, value)){
			return true;
		}
		else if(this.sumOf2NodesEqualValue(node.right, value)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	//COMPLEXITY  -  O(nlogn)
	
	
	public boolean sumof2NodesEqualValue2(int value){
		int[] arr = this.bt2array();
		Arrays.sort(arr);
		int i=0, j=arr.length-1;
		while(i<j){
			if(arr[i] + arr[j] == value){
				return true;
			}
			else if(arr[i] + arr[j] < value){
				i++;
			}
			else{
				j--;
			}
		}
		return false;
	}
	
	
	//COMPLEXITY  -  O(n)
	
	
	public void sumof2NodesEqualValue3(int value){
		HashSet<Integer> set = this.bt2HashSet();
		Set<Integer> visited=new HashSet<>();
		for(Integer k : set){
			visited.add(k);
			int cp = value - k;
			if(!visited.contains(cp) && set.contains(cp)){
				System.out.println(k + " " + cp);
			}
		}
	}
	
	HashSet<Integer> set;
	HashSet<Integer> bt2HashSet(){
		set=new HashSet<>();
		this.bt2HashSet(this.root);
		return set;
	}	
	private void bt2HashSet(Node node){
		if(node==null){
			return;
		}
		this.bt2HashSet(node.left);
		set.add(node.data);
		this.bt2HashSet(node.right);
	}
	
	
	
	//LCA
	
	//COMPLEXITY  -  O(n)(REQUIRES 3 TRAVERSALS PLUS SPACE)
	
	public int lca(int value1, int value2){
		ArrayList<Integer> list1 = this.listOfAncestors(this.root, value1);
		ArrayList<Integer> list2 = this.listOfAncestors(this.root, value2);
		if(list1 == null || list2 == null){
			return -1;
		}
		int i=list1.size()-1, j=list2.size()-1;
		int retval=-1;
		while(i>=0 && j>=0){
			if(list1.get(i) == list2.get(j)){
				retval = list1.get(i);
				i--; 
				j--;
			}
			else{
				break;
			}
		}
		return retval;
	}
	
	private ArrayList<Integer> listOfAncestors(Node node, int value){
		if(node == null){
			return null;
		}
		if(node.data == value){
			ArrayList<Integer> al = new ArrayList<>();
			al.add(node.data);
			return al;
		}
		ArrayList<Integer> left = this.listOfAncestors(node.left, value);
		if(left != null){
			left.add(node.data);
			return left;
		}
		ArrayList<Integer> right = this.listOfAncestors(node.right, value);
		if(right != null){
			right.add(node.data);
			return right;
		}
		return null;
	}
	
	//COMPLEXITY  -  O(n)(CONSIDERS THE ELEMENTS TO BE PRESENT)
	
	public int lca2(int value1, int value2){
		return this.lca2(this.root, value1, value2).data;
	}
	
	private Node lca2(Node node, int value1, int value2){
		if(node==null){
			return null;
		}
		if(value1 == node.data || value2 == node.data){
			return node;
		}
		Node left = this.lca2(node.left, value1, value2);
		Node right = this.lca2(node.right, value1, value2);
		if(left!=null && right!=null){
			return node;
		}
		return left!=null?left:right;
	}
	
	//COMPLEXITY  -  O(n) BEST METHOD
	
	boolean v1,v2;
	public int lca3(int value1, int value2){
		v1=false;
		v2=false;
		int lca = this.lca3(this.root, value1, value2).data;
		if(v1 && v2){
			return lca;
		}
		else{
			return -1;
		}
	}
	
	private Node lca3(Node node, int value1, int value2){
		if(node==null){
			return null;
		}
		if(value1 == node.data){
			v1=true;
		}
		if(value2 == node.data){
			v2=true;
		}
		Node left = this.lca3(node.left, value1, value2);
		Node right = this.lca3(node.right, value1, value2);
		if(value1==node.data || value2==node.data){
			return node;
		}
		if(left!=null && right!=null){
			return node;
		}
		return left!=null?left:right;
	}
	
	class Quad{
		int min,max,ht;
		Node node;
		Quad(int min,int max,int ht,Node node){
			this.min=min;
			this.max=max;
			this.ht=ht;
			this.node=node;
		}
		Quad(){}
	}
	BinaryTree largestBST(){
		BinaryTree tree=new BinaryTree();
		tree.root=this.largestBST(this.root).node;
		return tree;
	}
	Quad largestBST(Node node){
		if(node==null){
			return new Quad(Integer.MAX_VALUE,Integer.MIN_VALUE,-1,null);
		}
		Quad leftQuad=this.largestBST(node.left);
		Quad rightQuad=this.largestBST(node.right);
		if(node.left==leftQuad.node && node.right==rightQuad.node && node.data>leftQuad.max && node.data<rightQuad.min){
			return new Quad(leftQuad.node!=null?leftQuad.min:node.data
					,rightQuad.node!=null?rightQuad.max:node.data
							,Math.max(leftQuad.ht, rightQuad.ht)+1
							,node);
		}
		else if(leftQuad.ht>rightQuad.ht){
			return leftQuad;
		}
		else{
			return rightQuad;
		}
	}
	
	public void printatk(int value, int k){
		this.printatk(this.root, value, k);
	}
	
	private int printatk(Node node, int value, int k){
		if(node == null){
			return -1;
		}
		if(node.data == value){
			this.kdown(node, k);
			return k-1;
		}
		int left = this.printatk(node.left, value, k);
		if(left==0){
			System.out.println(node.data);
			return -2;
		}
		else if(left>0){
			this.kdown(node.right, left-1);
			return left-1;
		}else if(left==-2){
			return -2;
		}
		
		int right = this.printatk(node.right, value, k);
		if(right==0){
			System.out.println(node.data);
			return -2;
		}
		else if(right>0){
			this.kdown(node.left, right-1);
			return right-1;
		}
		else if(right==-2){
			return  -2;
		}
		return -1;
	}
	
	private void kdown(Node node, int k){
		if(node == null){
			return;
		}
		if(k==0){
			System.out.println(node.data);
			return;
		}
		this.kdown(node.left, k-1);
		this.kdown(node.right, k-1);
	}
	
	
	//DONT USE ARRAYLIST BECAUSE THINGS STAYS IN ARRAYLIST
	
	
	public void printPathsWhichSumTok1(int k){
		this.printPathsWhichSumTok1(this.root, k, new String());
	}
	
	private void printPathsWhichSumTok1(Node node, int k, String s){
		if(k<0 || node==null){
			return;
		}
		k-=node.data;
		s+=node.data+" ";
		this.printPathsWhichSumTok1(node.left, k, s);
		this.printPathsWhichSumTok1(node.right, k, s);
		if(k==0 && node.left==null && node.right==null){
			System.out.println(s);
		}
	}
	
//	Check if a binary tree is subtree of another binary tree | Set 1
	
	public boolean check(BinaryTree tree){
		return this.check(this.root,tree.root);
	}
	
	private boolean check(Node node1,Node node2){
		if(node1==null){
			return false;
		}
		if(node1.data==node2.data){
			return this.checkhelper(node1, node2);
		}
		if(this.check(node1.left, node2)){
			return true;
		}
		else if(this.check(node1.right, node2)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean checkhelper(Node node1,Node node2){
		if(node1==null && node2==null){
			return true;
		}
		if(node1==null || node2==null){//cool
			return false;
		}
		if(node1.data!=node2.data){
			return false;
		}
		if(!this.checkhelper(node1.left, node2.left)){
			return false;
		}
		else if(!this.checkhelper(node1.right, node2.right)){
			return false;
		}
		else{
			return true;
		}
	}

	
//	Dynamic Programming | Set 31 (Largest Independent Set Problem)
	
	public int LISS(){
		return this.LISS(this.root);
	}
	
	private int LISS(Node node){
		if(node==null){
			return 0;
		}
		if(node.liss!=0){
			return node.liss;
		}
		int val1=LISS(node.left)+LISS(node.right);
		int val2=1;
		if(node.left!=null){
			val2+=(LISS(node.left.left)+LISS(node.left.right));
		}
		if(node.right!=null){
			val2+=(LISS(node.right.left)+LISS(node.right.right));
		}
		return node.liss=Math.max(val1,val2);
	}
	
//	Convert a given Binary Tree to Doubly Linked List | Set 1
//	Can't use the display method in here as it would call a node an infinite number of times
	void displayDll(Node node){
		while(node.right!=null){
			System.out.print(node.data+" ");
			node=node.right;
		}
		System.out.println(node.data);
		while(node.left!=null){
			System.out.print(node.data+" ");
			node=node.left;
		}
		System.out.println(node.data);
	}
	void bt2Dll(){
		Node node=this.bt2Dll(this.root);
		while(node.left!=null){
			node=node.left;
		}
		this.root=node;
		this.displayDll(this.root);
	}
	private Node bt2Dll(Node node){
		if(node==null){
			return null;
		}
		if(node.left!=null){
			Node leftNode=this.bt2Dll(node.left);
			while(leftNode.right!=null){
				leftNode=leftNode.right;
			}
			leftNode.right=node;
			node.left=leftNode;
		}
		if(node.right!=null){
			Node rightNode=this.bt2Dll(node.right);
			while(rightNode.left!=null){
				rightNode=rightNode.left;
			}
			rightNode.left=node;
			node.right=rightNode;
		}
		return node;
	}
	
//	Convert a Binary Tree to a Circular Doubly Link List
	void displayCDll(Node node){
		do{
			System.out.print(node.data+" ");
			node=node.right;
		}while(node!=this.root);
	}
	void bt2CDll(){
		this.root=this.bt2CDll(this.root);
		this.displayCDll(this.root);
	}
	private Node bt2CDll(Node node){
		if(node==null){
			return null;
		}
		Node leftNode=this.bt2CDll(node.left);
		Node rightNode=this.bt2CDll(node.right);
		node.left=node.right=node;
		return this.joinCDll(leftNode, this.joinCDll(node, rightNode));
	}
	private Node joinCDll(Node node1,Node node2){
		if(node1==null || node2==null){
			return node1!=null?node1:node2;
		}
		Node leftEnd=node1.left;
		Node rightEnd=node2.left;
		
		leftEnd.right=node2;
		node2.left=leftEnd;
		rightEnd.right=node1;
		node1.left=rightEnd;
		
		return node1;
	}
	
//	Convert a given Binary Tree to Doubly Linked List | Set 2
	Node prevNode=null;
	void bt2Dll2(){
		this.bt2Dll2Left(this.root);
		this.root=this.bt2Dll2Right(prevNode);
		this.displayDll(this.root);
	}
	private void bt2Dll2Left(Node node){
		if(node==null){
			return;
		}
		this.bt2Dll2Left(node.left);
		node.left=prevNode;
		prevNode=node;
		this.bt2Dll2Left(node.right);
	}
	private Node bt2Dll2Right(Node node){
		Node nextNode=null;
		while(node.left!=null){
			node.right=nextNode;
			nextNode=node;
			node=node.left;
		}
		node.right=nextNode;
		return node;
	}
	
//	Vertex Cover Problem | Set 2 (Dynamic Programming Solution for Tree)
	
	int vertexCover(){
		return this.vertexCover(this.root);
	}
	private int vertexCover(Node node){
		if(node==null){
			return 0;
		}
		if(node.left==null && node.right==null){
			return 0;
		}
		if(node.vc!=0){
			return node.vc;
		}
		int val1=1 + this.vertexCover(node.left)+this.vertexCover(node.right);
		int val2=0;
		if(node.left!=null){
			val2+=(1 + this.vertexCover(node.left.left) + this.vertexCover(node.left.right));
		}
		if(node.right!=null){
			val2+=(1 + this.vertexCover(node.right.left) + this.vertexCover(node.right.right));
		}
		return node.vc=Math.min(val1, val2);
	}
	
}