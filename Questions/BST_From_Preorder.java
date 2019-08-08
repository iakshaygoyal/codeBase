package Questions;

public class BST_From_Preorder {
	
	static class Tree{
		class Node{
			int data;
			Node left,right;
			
			Node(int data){
				this.data=data;
			}
			
			public String toString(){
				String ans="";
				
				if(this.left!=null){
					ans+=(this.left.data+" => ");
				}
				ans+=(this.data);
				if(this.right!=null){
					ans+=(" <= "+this.right.data);
				}
				ans+=(" END\n");
				
				if(this.left!=null){
					ans+=(this.left.toString());
				}
				if(this.right!=null){
					ans+=(this.right.toString());
				}
				
				return ans;
			}
		}
		
		Node root;
		int size;
		
		Tree(){}
		
		void add(int value){
			root=add(root,value);
		}
		private Node add(Node node,int value){
			if(node==null){
				Node newNode=new Node(value);
				size++;
				return newNode;
			}
			
			if(value==node.data){
				System.out.println("Duplicates");
			}
			else if(value<node.data){
				node.left=add(node.left, value);
			}
			else{
				node.right=add(node.right, value);
			}
			return node;
		}
		
		void display(){
			System.out.println(root.toString());
		}
		
		//O(n^2)
		void preorderToTree(int[] pre){
			root=preorderToTree(pre, 0, pre.length-1);
		}
		private Node preorderToTree(int[] pre,int psi,int pei){
			if(psi>pei){
				return null;
			}
			
			Node node=new Node(pre[psi]);
			int i=psi;
			while(i<=pei){
				if(pre[i]>pre[psi]){
					break;
				}
				i++;
			}
			node.left=preorderToTree(pre, psi+1, i-1);
			node.right=preorderToTree(pre, i, pei);
			return node;
		}
		
		//O(n)
		int idx;
		void preorderToTree1(int[] pre){
			idx=0;
			root=preorderToTree1(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		private Node preorderToTree1(int[] pre,int min,int max){
			if(idx>=pre.length){
				return null;
			}
			Node root=null;
			if(pre[idx]>min && pre[idx]<max){
				root=new Node(pre[idx++]);
				if(idx<pre.length){
					root.left=preorderToTree1(pre, min, root.data);
					root.right=preorderToTree1(pre, root.data, max);
				}
			}
			return root;
		}
		
	}

	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.add(12);
		tree.add(25);
		tree.add(5);
		tree.add(1);
		tree.add(45);
		tree.add(52);
		tree.add(27);
		tree.add(11);
		tree.display();
		
		tree.preorderToTree(new int[]{25,15,10,5,11,12,20,50,45,30,75});
		tree.display();
		
		tree.preorderToTree1(new int[]{25,15,10,5,11,12,20,50,45,30,75});
		tree.display();
		
	}

}
