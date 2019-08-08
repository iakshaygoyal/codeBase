package Questions.Amazon;
import java.util.*;

//3 true 2 true 5 false true 0 false false true 4 true 1 false false false true 7 false false

public class BT2Dll {
	
	static class BT{
		class Node{
			int data;
			Node left,right;
			
			Node(int data,Node left,Node right){
				this.data=data;
				this.left=left;
				this.right=right;
			}
			
			public String toString(){
				String retval="";
				
				if(left!=null){
					retval+=left.data+" => ";
				}
				
				retval+=data;
				
				if(right!=null){
					retval+=" <= "+right.data;
				}
				retval+="END\n";
				
				if(left!=null){
					retval+=left.toString();
				}
				
				if(right!=null){
					retval+=right.toString();
				}
				
				return retval;
			}
		}
		
		Node root;
		int size;
		
		BT(){
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
		
		public void display(){
			System.out.println(this);
		}
		
		public String toString(){
			return root.toString();
		}
		
		void printDLL(Node node){
			while(node.right!=null){
				System.out.print(node.data+" ");
				node=node.right;
			}
			System.out.println(node.data+" ");
			while(node.left!=null){
				System.out.print(node.data+" ");
				node=node.left;
			}
			System.out.println(node.data+" ");
		}
		
//		Convert a given Binary Tree to Doubly Linked List | Set 3
		
		static Node prev;
		static Node head;
		void convertToDll(){
			prev=null;
			inOrder(root);
			printDLL(head);
		}
		
		void inOrder(Node node){
			if(node==null){
				return;
			}
			inOrder(node.left);
			if(prev==null){
				head=node;
			}
			else{
				node.left=prev;
				prev.right=node;
			}
			prev=node;
			inOrder(node.right);
		}
		
//		Convert a given Binary Tree to Doubly Linked List | Set 4
		
		void convertToDll1(){
			head=null;
			reverseInOrder(root);
			printDLL(head);
		}
		
		void reverseInOrder(Node node){
			if(node==null){
				return;
			}
			reverseInOrder(node.right);
			if(head!=null){
				node.right=head;
				head.left=node;
			}
			head=node;
			reverseInOrder(node.left);
		}
	}

	public static void main(String[] args) {
		BT bt=new BT();
		bt.display();
		bt.convertToDll1();
	}

}
