package Questions;
import java.util.*;
public class Serialize_Deserialize_BT {
	
//	3 true 2 true 5 false true 0 false false true 4 true 1 false false false true 7 false false
//	 50 true 25 true 32 false false true 12 true 6 false false false true 75 true 87 false false true 62 false false
//	 50 true 25 true 5 false false true 40 true 30 false false false true 75 true 63 false false true 100 false false
//	50 true 25 true 32 false false true 12 true 6 false false false true 75 true 57 true 47 true 11 false true 12 false false true 52 true 49 false false false false true 92 true 78 false false true 102 false true 104 false false
//	50 true 25 true 32 false false true 12 true 6 false false false true 75 true 57 true 47 true 11 false true 12 false false true 52 true 49 false false false false false
	
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
		
		ArrayList<Integer> list;
		void serialize(){
			list=new ArrayList<>();
			serialize(root);
			System.out.println(list);
		}
		private void serialize(Node node){
			if(node==null){
				list.add(-1);
				return;
			}
			list.add(node.data);
			serialize(node.left);
			serialize(node.right);
		}
		
		int idx;
		void deserialize(){
			idx=0;
			Tree tree1=new Tree();
			tree1.root=derserialize();
			tree1.display();
		}
		private Node derserialize(){
			if(idx==list.size() || list.get(idx)==-1){
				idx++;
				return null;
			}
			Node node=new Node(list.get(idx++),null,null);
			node.left=derserialize();
			node.right=derserialize();
			return node;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree=new Tree(true);
		tree.display();
		tree.serialize();
		tree.deserialize();
	}

}
