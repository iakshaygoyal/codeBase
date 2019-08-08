package Questions.Directi;
import java.util.*;

//3 true 2 true 5 false true 8 false false true 4 true 1 false false false true -7 false false

public class Max_Path_Sum_BT {

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
		
		Node root;
		int size;
		
		public BT(){
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
			return this.root.toString();
		}
		
		int max;
		int maxPathSum(){
			max=Integer.MIN_VALUE;
			maxPathSum(root);
			return max;
		}
		
		int maxPathSum(Node node){
			if(node==null){
				return 0;
			}
			int l=maxPathSum(node.left);
			int r=maxPathSum(node.right);
			int max_single=Math.max(Math.max(l, r)+node.data, node.data);
			max=Math.max(max, Math.max(max_single, l+r+node.data));
			return max_single;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BT tree=new BT();
		tree.display();
		System.out.println(tree.maxPathSum());

	}

}
