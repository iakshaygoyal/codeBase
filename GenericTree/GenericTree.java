package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import Stack.DifferentStacks.*;
import Stack.Interfaces.*;
import Queue.DifferentQueues.*;
import Queue.Interfaces.*;

public class GenericTree<T extends Comparable<T>> {

	private class Node implements Comparable<Node> {
		T data;
		ArrayList<Node> children;

		public Node(T data, ArrayList<Node> children) {
			this.data = data;
			this.children = children;
		}

		public String toString() {
			String retval = "";
			retval += this.data + "=>";
			for (Node child : this.children) {
				retval += child.data + ",";
			}
			retval += "END\n";			
			for(Node child : this.children){
				retval+=child.toString();
			}
			return retval;
		}
		
		public Integer sumOfNodesAndChildren(){
			System.out.println("hi");
			Integer retval = (Integer)this.data;
			
			for(Node child : this.children){
				retval += (Integer)child.data;
			}
			return retval;
		}

		@Override
		public int compareTo(GenericTree<T>.Node object) {
			return this.data.compareTo(object.data);
		}

	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, -1);
	}

	private Node takeInput(Scanner scn, Node parentNode, int ithchild) {
		if (parentNode == null) {
			System.out.println("Enter root node : ");
		} else {
			System.out.println("Enter " + ithchild + "th child node of " + parentNode.data);
		}
		Integer childData = scn.nextInt();
		System.out.println("Enter number of childs of " + childData);
		Integer numChild = scn.nextInt();
		Node child = new Node((T) childData, new ArrayList<Node>());
		this.size++;

		for (int i = 0; i < numChild; i++) {
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
	
	public int size2(){
		return this.size2(this.root);
	}
	
	private int size2(Node node){
		int retval=0;
		for(Node child : node.children){
			retval+=this.size2(child);
		}
		retval+=1;
		return retval;			
	}
	
	public T max(){
		return this.max(this.root);
	}
	
	private T max(Node node){
		T maxm=node.data;
		
		for(Node child : node.children){
			T current=this.max(child);
			if(current.compareTo(maxm) > 0){
				maxm=current;
			}
		}
		
		return maxm;
	}

	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node){
		int maxHeight = -1;
		
		for(Node child : node.children){
			int currentHeight = this.height(child);
			if(currentHeight > maxHeight){
				maxHeight = currentHeight;
			}
		}
		
		maxHeight+=1;
		return maxHeight;
	}
	
	public void printAtDepth(int depth){
		this.printAtDepth(this.root, depth);
		System.out.println();
	}
	
	private void printAtDepth(Node node ,int depth){
		if(depth == 0){
			System.out.print(node.data+", ");
			return;
		}
		
		for(Node child : node.children){
			this.printAtDepth(child, depth-1);
		}
	}
	
	//Number of nodes greater than x
	public int greaterThanX(T x){
		return this.greaterThanX(this.root, x);
	}
	
	private int greaterThanX(Node node , T x){
		int retval=0;
		for(Node child : node.children){
			retval+=this.greaterThanX(child,x);
		}
		if(node.data.compareTo(x) > 0){
			retval+=1;
		}
		return retval;
	}
	
	
	public Integer maxSumOfNodes(){
//		return (Integer)this.maxSumOfNodes(this.root).data;
		return (Integer)this.maxSumOfNodes2(this.root).node.data;
	}
	
	private Node maxSumOfNodes(Node node){
		Node retval = node;
		
		for(Node child : node.children){
			Node current = this.maxSumOfNodes(child);
			if(current.sumOfNodesAndChildren() > retval.sumOfNodesAndChildren()){
				retval = current;
			}
		}
		
		return retval;
	}
	
	//Dynamic Programming(Storing of results)
	private class Pair{
		Node node;
		Integer sumOfNodesOfChildren;
		Pair(Node node){
			this.node=node;
			this.sumOfNodesOfChildren=node.sumOfNodesAndChildren();
		}
	}
	
	private Pair maxSumOfNodes2(Node node){
		Pair retval = new Pair(node);
		
		for(Node child : node.children){
			Pair current = this.maxSumOfNodes2(child);
			if(current.sumOfNodesOfChildren > retval.sumOfNodesOfChildren){
				retval = current;
			}
		}
		
		return retval;
	}
	
	public void preOrder(){
		this.preOrder(this.root);
		System.out.print("END");
	}
	
	private void preOrder(Node node){
		System.out.println(node.data);
		for(Node child : node.children){
			this.preOrder(child);
		}
		
	}
	
	public void postOrder(){
		this.postOrder(this.root);
		System.out.println("END");
	}
	
	private void postOrder(Node node){
		for(Node child : node.children){
			this.postOrder(child);
		}
		System.out.println(node.data);
	}
	
	public void levelOrder(){
		iQueue<Node> queue=new queueUsingLinkedList<>();
		
		try{
		queue.enqueue(this.root);
		while(!queue.isEmpty()){
			Node node = queue.dequeue();
			System.out.print(node.data+", ");
			for(Node child : node.children){
				queue.enqueue(child);
			}
		}
		}catch(Exception ex){
			
		}
		System.out.println("END");
	}
	
	public void preOrder2(){
		iStack<Node> stk=new stackUsingLinkedList<>();
		
		try{
		stk.push(this.root);
		while(!stk.isEmpty()){
			Node node = stk.pop();
			System.out.println(node.data+", ");
			for(int i=node.children.size()-1; i>=0; i--){
				stk.push(node.children.get(i));
			}
		}
		}catch(Exception ex){
			
		}
		System.out.println("END");
		
	}
	
	public int sumOfNodes(){
		return this.sumOfNodes(this.root);
	}
	
	private int sumOfNodes(Node node){
		int retval = (int)node.data;
		for(Node child : node.children){
			retval+=sumOfNodes(child);
		}
		return retval;
	}
	
	public boolean isStructureSame(GenericTree tree){
		return this.isStructureSame(this.root, tree.root);
	}
	
	private boolean isStructureSame(Node node1, Node node2){
		if((node1.data != node2.data) || (node1.children.size() != node2.children.size())){
			return false;
		}
		for(int i=0; i<node1.children.size(); i++){
			if(!isStructureSame(node1.children.get(i), node2.children.get(i))){
				return false;
			}
		}
		return true;
	}
	
	int val=Integer.MAX_VALUE;
	//best method
	public void justGreaterThan(int data){
		Node node = this.justGreaterThan(this.root, data);
		if(node == null){
			System.out.println("No value greater then " + data);
		}
		else{
			System.out.println(node.data);
		}
	}
	
	private Node justGreaterThan(Node node, int data){
		Node retval = null;
		if((int)node.data > data){
			retval = node;
		}
		for(Node child : node.children){
			Node current = this.justGreaterThan(child, data);
			if((retval == null && current != null) || (current != null && retval.compareTo(current) > 0)){
				retval = current;
			}
		}
		return retval;
	}
	
	//best method
	public int secondLargest(){
		return (int)this.secondLargest(this.root, (int)this.max()).data;
	}
	
	private Node secondLargest(Node node, int maxm){
		Node retval = null;
		if((int)node.data < maxm){
			retval = node;
		}
		for(Node child : node.children){
			Node current = this.secondLargest(child, maxm);
			if((retval == null && current != null) || (current != null && current.compareTo(retval) > 0)){
				retval = current;
			}
		}
		return retval;
	}
	
	public int totalLeafNodes(){
		return this.totalLeafNodes(this.root);
	}
	
	private int totalLeafNodes(Node node){
		if(node.children.size() == 0){
			return 1;
		}
		int retval = 0;
		for(Node child : node.children){
			retval+=this.totalLeafNodes(child);
		}
		return retval;
	}
	
	public void replaceEachNodeByDepthValue(){
		this.replaceEachNodeByDepthValue(this.root, 0);
	}
	
	private void replaceEachNodeByDepthValue(Node node, Integer depth){
		node.data = (T)depth;
		for(Node child : node.children){
			this.replaceEachNodeByDepthValue(child, depth+1);
		}
	}

}
 