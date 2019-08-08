package Questions.GS;

public class Merge_Sort_LL {

	static class LL{
		class Node{
			int data;
			Node next;
			
			Node(int data){
				this.data=data;
				this.next=null;
			}
		}
		
		Node head;
		
		LL(){
			head=null;
		}
		
		void add(int val){
			Node node=new Node(val);
			node.next=head;
			head=node;
		}
		
		void display(){
			Node node=head;
			while(node!=null){
				System.out.print(node.data+" ");
				node=node.next;
			}
			System.out.println();
		}
		
		void ms(){
			head=ms(head);
		}
		
		Node getMiddle(Node node){
			Node slow=node;
			Node fast=node.next;
			while(fast!=null && fast.next!=null){
				slow=slow.next;
				fast=fast.next.next;
			}
			return slow;
		}
		
		Node ms(Node node){
			if(node==null || node.next==null) return node;
			
			Node mid=getMiddle(node);
			Node next_mid=mid.next;
			
			mid.next=null;
			
			Node left=ms(node);
			Node right=ms(next_mid);
			
			return merge(left,right);
		}
		
		Node merge(Node node1,Node node2){
			if(node1==null) return node2;
			
			if(node2==null) return node1;
			
			Node node=null;
			if(node1.data<node2.data){
				node=node1;
				node.next=merge(node1.next, node2);
			}
			else{
				node=node2;
				node.next=merge(node1, node2.next);
			}
			
			return node;
		}
		
	}
	
	public static void main(String[] args) {
		LL ll=new LL();
		ll.add(8);
		ll.add(2);
		ll.add(7);
		ll.add(5);
		ll.add(1);
		ll.add(3);
		ll.add(71);
		ll.add(15);
		ll.add(1);
		ll.add(3);
		ll.display();
		ll.ms();
		ll.display();
	}

}
