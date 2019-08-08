package Questions;
import java.util.*;

//50 true 25 true 32 false false true 12 true 6 false false false true 75 true 57 true 25 true 32 false false true 12 true 6 false false false false false
public class Duplicates_BT {
	static class Tree{
		private class Node{
			int data;
			Node left;
			Node right;
			
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
		
		private Node root;
		private int size;	
		
		Tree(){
			this.root=null;
		}
		
		public Tree(boolean b){
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
			System.out.println(root.toString());
		}
		
		HashMap<String,Integer> map;
		void printDuplicates(){
			map=new HashMap<>();
			printDuplicates(root);
		}
		private String printDuplicates(Node node){
			if(node==null){
				return "";
			}
			String s="";
			s+=('(');
			s+=(node.data);
			s+=(printDuplicates(node.left));
			s+=(printDuplicates(node.right));
			
			if(map.containsKey(s) && map.get(s)==1){
				System.out.println(node.data);
			}
			
			if(map.containsKey(s)){
				map.put(s, map.get(s)+1);
			}
			else{
				map.put(s, 1);
			}
			
			return s;
		}

	}
	public static void main(String[] args) {
		Tree tree=new Tree(true);
		tree.display();
		tree.printDuplicates();
	}


}
