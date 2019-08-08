package Questions.Amazon;

public class KReverseLinkedList {
	
	static class LL{
		class Node{
			int data;
			Node next;
			
			Node(int data,Node next){
				this.data=data;
				this.next=next;
			}
		}
		
		Node head;
		Node tail;
		int size;
		
		LL(){
			head=null;
			tail=null;
			size=0;
		}
		
		void addFirst(int data){
			Node node=new Node(data,null);
			if(size==0){
				head=tail=node;
			}
			else{
				node.next=head;
				head=node;
			}
			size++;
		}
		
		public String toString(){
			Node temp=head;
			String s="";
			for(int i=0;i<size;i++){
				s+=(temp.data+" ");
				temp=temp.next;
			}
			return s;
		}
		
		void kReverse(int k){
			Node prev_head=head;
			Node node=head;
			for(int i=0;i<size;i++){
				if(i%k==0){
					head=node;
					kReverse(node, 0, k);
				}
				node=node.next;
			}
			head=prev_head;
		}
		
		void kReverse(Node node,int i,int k){
			if(node==null || i==k){
				return;
			}
			kReverse(node.next, i+1, k);
			if(i>=(k/2)){
				int temp=head.data;
				head.data=node.data;
				node.data=temp;
				head=head.next;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LL ll=new LL();
		ll.addFirst(3);
		ll.addFirst(13);
		ll.addFirst(12);
		ll.addFirst(21);
		ll.addFirst(4);
		ll.addFirst(17);
		ll.addFirst(1);
		ll.addFirst(5);
		ll.addFirst(2);
		ll.addFirst(10);
		ll.addFirst(7);
		System.out.println(ll.toString());
		ll.kReverse(5);
		System.out.println(ll.toString());
	}

}
