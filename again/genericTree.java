package again;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

	public class genericTree<T extends Comparable<T>> {
		private class Node{
			T data;
			ArrayList<Node> children;
			
			Node(T data, ArrayList<Node> children){
				this.data = data;
				this.children = children;
			}
			
			public String toString(){
				String retVal = "";
				
				retVal += this.data + " => ";
				for(Node child: this.children){
					retVal += child.data + ", ";
				}
				
				retVal += "END\n";
				
				for(int i = 0; i < this.children.size(); i++){
					retVal += this.children.get(i).toString();
				}
				
				return retVal;
			}
			
			private int sumOfNodeAndChildren(){
				System.out.println("hi");
				int retval=(int)this.data;
				
				for(Node child : this.children){
					retval+=(int)child.data;
				}
				
				return retval;
			}
		}
		
		
		private Node root;
		private int size;
		
		public genericTree(){
			Scanner scn = new Scanner(System.in);
			this.root = this.takeInput(scn, null, -1);
		}
		
		private Node takeInput(Scanner scn, Node parentNode, int ithChild){
			if(parentNode == null){
				System.out.println("Enter data for root node");
			}
			else{
				System.out.println("Enter data for " + ithChild + "th child of " + parentNode.data);
			}
			
			Integer cData = scn.nextInt();
			
			System.out.println("Enter number of children for " + cData);
			Integer numChildren = scn.nextInt();
			
			Node child = new Node((T)cData, new ArrayList<>());
			this.size++;
			
			for(int i = 0; i < numChildren; i++){
				Node grandChild = this.takeInput(scn, child, i + 1);
				child.children.add(grandChild);
			}
			
			return child;
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
		
		public int countNodes(){
			return this.countNodes(this.root);
		}
		
		private int countNodes(Node node){
			int retval=0;
			
			for(Node child : node.children){
				retval+=this.countNodes(child);
			}
			
			return 1+retval;
		}
		
		public T largestData(){
			return this.largestData(this.root);
		}
		
		private T largestData(Node node){
			T largestData=node.data;
			
			for(Node child : node.children){
				T currentData=this.largestData(child);
				if(currentData.compareTo(largestData) > 0){
					largestData=currentData;
				}
			}
			
			return largestData;
		}
		
		public int height(){
			return this.height(this.root);
		}
		
		private int height(Node node){
			int maxHeight=-1;
			
			for(Node child : node.children){
				int currentHeight=this.height(child);
				if(currentHeight>maxHeight){
					maxHeight=currentHeight;
				}
			}
			
			return 1+maxHeight;
		}
		
		public void printAtDepth(int depth){
			this.printAtDepth(this.root, depth);
			System.out.println("END");
		}
		
		private void printAtDepth(Node node, int depth){
			if(depth == 0){
				System.out.print(node.data+", ");
				return;
			}
			
			for(Node child : node.children){
				this.printAtDepth(child, depth-1);
			}
		}
		
		public int nodesGreaterThanX(T data){
			return this.nodesGreaterThanX(this.root, data);
		}
		
		private int nodesGreaterThanX(Node node, T data){
			int retval=0;
			
			for(Node child : node.children){
				retval+=this.nodesGreaterThanX(child, data);
			}
			
			if(node.data.compareTo(data) > 0){
				retval++;
			}
			
			return retval;
			
		}
		
		public T maxSumOfNodeAndChildren(){
//			return this.maxSumOfNodeAndChildren(this.root).data;
			return this.maxSumOfNodeAndChildren2(this.root).node.data;
			
		}
		
		private Node maxSumOfNodeAndChildren(Node node){
			Node retval=node;
			
			for(Node child : node.children){
				Node currentNode=this.maxSumOfNodeAndChildren(child);
				if(currentNode.sumOfNodeAndChildren() > retval.sumOfNodeAndChildren()){
					retval=currentNode;
				}
			}
			
			return retval;
		}
		

		private class Pair{
			Node node;
			int sumOfNodesAndChildren;
			
			Pair(Node node){
				this.node=node;
				this.sumOfNodesAndChildren=node.sumOfNodeAndChildren();
			}
		}
		
		private Pair maxSumOfNodeAndChildren2(Node node){
			Pair retval = new Pair(node);
			
			for(Node child : node.children){
				Pair currentPair=this.maxSumOfNodeAndChildren2(child);
				if(currentPair.sumOfNodesAndChildren > retval.sumOfNodesAndChildren){
					retval=currentPair;
				}
			}
			
			return retval;
		}
		
		public void preOrderIterative(){
			LinkedList<Node> list = new LinkedList<>();
			list.addFirst(this.root);
			
			while(!list.isEmpty()){
				Node currentNode=list.removeFirst();
				System.out.print(currentNode.data+", ");
				
				for(int i=currentNode.children.size()-1; i>=0; i--){
					list.addFirst(currentNode.children.get(i));
				}
			}
			
			System.out.println("END");
		}
		
}
