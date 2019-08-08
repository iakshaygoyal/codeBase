package Questions.Amazon;

public class Detect_Remove_Loop_LL {

	static class LL{
		
		class Node{
			int data;
			Node next;
			
			Node(int data,Node next){
				this.data=data;
				this.next=next;
			}
		}
		
		Node head,tail;
		int size;
		
		LL(){
			this.head=null;
			this.tail=null;
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
		
		int detectLoop(Node head){
		     Node slow=head;
		     Node fast=head;
		     while(fast!=null && fast.next!=null){
		         slow=slow.next;
		         fast=fast.next.next;
		         if(slow==fast){
		             return 1;
		         }
		     }
		     return 0;
		 }
		
		 int removeTheLoop(Node node) {
		      Node slow=node;
		      Node fast=node;
		      Node p_fast=null;
		      while(fast!=null && fast.next!=null){
		          slow=slow.next;
		          p_fast=fast.next;
		          fast=fast.next.next;
		          if(slow==fast){
		              break;
		          }
		      }
		      if(fast==null || fast.next==null){
		          return 0;
		      }
		      slow=node;
		      
		      while(slow!=fast){
		          slow=slow.next;
		          p_fast=p_fast.next;
		          fast=fast.next;
		      }
		      p_fast.next=null;
		      return 1;
		  }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
