package again;

import java.util.ArrayList;
import java.util.Scanner;

public class binaryTree {
	
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		Node(){}

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
	}
	
	private class Pair{
		int height;
		int diameter;
		
		Pair(int height, int diameter){
			this.height=height;
			this.diameter=diameter;
		}
		
		Pair(){}
	}
	
	private class triplet{
		boolean isBST;
		int min;
		int max;
		
		triplet(boolean isBST, int min, int max){
			this.isBST=isBST;
			this.min=min;
			this.max=max;
		}
		
		triplet(){}
	}

	private Node root;
	private int size;

	public binaryTree(){}
	
	
	
	public binaryTree(int type, int[] one, int[] two){
		if(type == 1){
			this.root=this.constructTreeFromPreorderAndInorder(one, 0, one.length-1, two, 0, two.length-1);
		}
	}
	
	private Node constructTreeFromPreorderAndInorder(int[] pre, int psi, int pei, int[] in, int isi, int iei){
		if(psi>pei || isi>iei){
			return null;
		}
		
		Node node=new Node(pre[psi], null, null);
		
		int idx=isi;
		
		while(in[idx] != pre[psi]){
			idx++;
		}
		
		int nre=idx-isi;
		
		node.left=this.constructTreeFromPreorderAndInorder(pre, psi+1, psi+nre, in, isi, idx-1);
		node.right=this.constructTreeFromPreorderAndInorder(pre, psi+nre+1, pei, in, idx+1, iei);
		
		return node;
	}

	public binaryTree(boolean takeInput) {
		if (takeInput) {
			Scanner scn = new Scanner(System.in);
			this.root = this.takeInput(scn, null, false);
		}
	}
	
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
	
	public int diameter(){
//		return this.diameter(this.root);
		return this.diameter2(this.root).diameter;
	}
	
	private int diameter(Node node){
		if(node == null){
			return 0;
		}
		
		int factor1=this.height(node.left)+this.height(node.right)+2;
		int factor2=this.diameter(node.left);
		int factor3=this.diameter(node.right);
		
		return Math.max(factor1, Math.max(factor2, factor3));
	}
	
	private Pair diameter2(Node node){
		if(node == null){
			return new Pair(-1, 0);
		}
		
		Pair lpair = this.diameter2(node.left);
		Pair rpair = this.diameter2(node.right);
		
		int factor1=lpair.diameter;
		int factor2=rpair.diameter;
		int factor3=lpair.height+rpair.height+2;
		
		int currentdiameter=Math.max(factor1, Math.max(factor2, factor3));
		int currentheight=Math.max(lpair.height, rpair.height)+1;
		Pair currentpair = new Pair(currentheight, currentdiameter);
		
		return currentpair;
		
	}
	
	public boolean findElement(int data){
		return this.findElement(this.root, data);
	}
	
	private boolean findElement(Node node, int data){
		if(node == null){
			return false;
		}
		else if(node.data == data){
			return true;
		}
		else if(this.findElement(node.left, data)){
			return true;
		}
		else if(this.findElement(node.right, data)){
			return true;
		}
		else{
			return false;
		}
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
	
	public int max(){
		return this.max(this.root);
	}
	
	private int max(Node node){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		
		int currentValue=node.data;
		int lmax=this.max(node.left);
		int rmax=this.max(node.right);
		
		return Math.max(currentValue, Math.max(lmax, rmax));
	}
	
	public int min(){
		return this.min(this.root);
	}
	
	private int min(Node node){
		if(node == null){
			return Integer.MAX_VALUE;
		}
		
		int currentValue=node.data;
		int lmin=this.min(node.left);
		int rmin=this.min(node.right);
		
		return Math.min(currentValue, Math.min(lmin, rmin));
	}
	
	public boolean isBST(){
//		return this.isBST(this.root);
//		return this.isBST2(this.root).isBST;
		return this.isBST3(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(Node node){
		if(node == null){
			return true;
		}
		
		int lmax=this.max(node.left);
		int rmin=this.min(node.right);
		
		if(node.data<lmax || node.data>rmin){
			return false;
		}
		else if(!this.isBST(node.left)){
			return false;
		}
		else if(!this.isBST(node.right)){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	private triplet isBST2(Node node){
		if(node == null){
			return null;
		}
		
		triplet ltriplet=this.isBST2(node.left);
		triplet rtriplet=this.isBST2(node.right);
		triplet retval = new triplet(true, node.data, node.data);
		
		if(ltriplet != null){
			if(!ltriplet.isBST || node.data<ltriplet.max){
				retval.isBST=false;
			}
		}
		
		if(rtriplet != null){
			if(!rtriplet.isBST || node.data>rtriplet.min){
				retval.isBST=false;
			}
		}
		
		if(ltriplet != null){
			retval.min=ltriplet.min;
		}
		
		if(rtriplet != null){
			retval.max=rtriplet.max;
		}
		
		return retval;
	}
	
	private boolean isBST3(Node node, int minlimit, int maxlimit){
		if(node == null){
			return true;
		}
	    else if(node.data<minlimit || node.data>maxlimit){
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
	
	public int justGreaterThan(int data){
		int retval = this.justGreaterThan(this.root, data);
		
		if(retval == Integer.MAX_VALUE){
			return -1;
		}
		else{
			return retval;
		}
	}
	
	private int justGreaterThan(Node node, int data){
		if(node == null){
			return Integer.MAX_VALUE;
		}
		
		int retval=Integer.MAX_VALUE;
		
		if(node.data > data){
			retval=node.data;
		}
		
		int lretval=this.justGreaterThan(node.left, data);
		int rretval=this.justGreaterThan(node.right, data);
		
		return Math.min(retval, Math.min(lretval, rretval));
		
	}
	
	public int justLessThan(int data){
		int retval = this.justLessThan(this.root, data);
		
		if(retval == Integer.MIN_VALUE){
			return -1;
		}
		else{
			return retval;
		}
	}
	
	private int justLessThan(Node node, int data){
		if(node == null){
			return Integer.MIN_VALUE;
		}
		
		int retval=Integer.MIN_VALUE;
		
		if(node.data < data){
			retval=node.data;
		}
		
		int lretval=this.justLessThan(node.left, data);
		int rretval=this.justLessThan(node.right, data);
		
		return Math.max(retval, Math.max(lretval, rretval));
		
	}
	
	private class Pair2{
		Node successor;
		boolean found;
	}
	
	public int inorderSuccessor(int data){
		Pair2 obj = new Pair2();
		this.inorderSuccessor(this.root, data, obj);
		return obj.successor != null ? obj.successor.data : -1;
	}
	
	private void inorderSuccessor(Node node, int data, Pair2 obj){
		if(node == null){
			return;
		}
		
		this.inorderSuccessor(node.left, data, obj);
		
		if(node.data == data){
			obj.found = true;
		}
		else if(obj.found == true && obj.successor == null){
			obj.successor = node;
		}
		
		this.inorderSuccessor(node.right, data, obj);
	}
	
	private class Pair3{
		Node predecessor;
		boolean found;
	}
	
	public int inorderPredecessor(int data){
		Pair3 obj = new Pair3();
		this.inorderPredecessor(this.root, data, obj);
		return obj.predecessor != null ? obj.predecessor.data : -1;
	}
	
	private void inorderPredecessor(Node node, int data, Pair3 obj){
		if(node == null){
			return;
		}
		
		this.inorderPredecessor(node.right, data, obj);
		
		if(node.data == data){
			obj.found = true;
		}
		else if(obj.found == true && obj.predecessor == null){
			obj.predecessor = node;
		}
		
		this.inorderPredecessor(node.left, data, obj);
	}
	
	private class tri{
		int minm;
		int maxm;
		boolean isbst;
		
		tri(int minm, int maxm, boolean isbst){
			this.minm = minm;
			this.maxm = maxm;
			this.isbst = isbst;
		}
	}
	
	public boolean isBST4(){
		return this.isBST4(this.root).isbst;
	}
	
	private tri isBST4(Node node){
		if(node == null){
			return null;
		}
		
		tri left = this.isBST4(node.left);
		tri right = this.isBST4(node.right);
		
		int cmin = node.data;
		int cmax = node.data;
		boolean cisbst = true;
		
		if(left != null && right != null){
			if(left.isbst && right.isbst && node.data > left.maxm && node.data < right.minm){
				cmin = left.minm;
				cmax = right.maxm;
			}
			else{
				cisbst = false;
			}
		}
		else if(left != null){
			if(left.isbst && node.data > left.maxm){
				cmin = left.minm;
			}
			else{
				cisbst = false;
			}
		}
		else if(right != null){
			if(right.isbst && node.data < right.minm){
				cmax = right.maxm;
			}
			else{
				cisbst = false;
			}
		}
		
		return new tri(cmin, cmax, cisbst);
	}
	
	public boolean sumOfTwoNodesEqualValue(int sum){
		return this.sumOfTwoNodesEqualValue(this.root, sum);
	}
	
	private boolean sumOfTwoNodesEqualValue(Node node, int sum){
		if(node == null){
			return false;
		}
		else if(this.findElement(node, sum - node.data) && 2 * node.data != sum){
			return true;
		}
		else if(this.sumOfTwoNodesEqualValue(node.left, sum)){
			return true;
		}
		else if(this.sumOfTwoNodesEqualValue(node.right, sum)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public ArrayList<Node> listOfAncestors(Node node, int data){
		if(node == null){
			return null;
		}
		
		if(node.data == data){
			ArrayList<Node> retval = new ArrayList<>();
			retval.add(node);
			return retval;
		}
		
		ArrayList<Node> left = this.listOfAncestors(node.left, data);
		if(left != null){
			left.add(node);
			return left;
		}
		
		ArrayList<Node> right = this.listOfAncestors(node.right, data);
		if(right != null){
			right.add(node);
			return right;
		}
		return null;
	}
	
	public int LCA(int data1, int data2){
		ArrayList<Node> list1 = this.listOfAncestors(this.root, data1);
		ArrayList<Node> list2 = this.listOfAncestors(this.root, data2);
		
		int retval = -1;
		
		if(list1 == null || list2 == null){
			return retval;
		}
				
		for(int i = list1.size() - 1, j = list2.size() - 1; i>=0 && j>=0; i--, j--){
			if(list1.get(i) == list2.get(j)){
				retval = list1.get(i).data;
			}
			else{
				break;
			}
		}
		
		return retval;
	}
	
	public void decode(String s){
		this.decode(s, this.root);
	}
	
	private void decode(String S ,Node root){
	    Node node = new Node();
	    node = root;
	    
	    while(S.length() != 0){
	        if(S.charAt(0) == '0'){
	            if(node.left != null){
	                node = node.left;
	                S = S.substring(1);
	            }
	            else{
	                System.out.print(node.data);
	                node = root;
	            }
	        }
	        else{
	            if(node.right != null){
	                node = node.right;
	                S = S.substring(1);
	            }
	            else{
	                System.out.print(node.data);
	                node = root;
	            }
	        }
	    }
	}
	
}