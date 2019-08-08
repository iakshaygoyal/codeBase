package Questions.Amazon;

public class Add2Lists {

	static class LL{
		class Node{
			int data;
			Node next;
			
			Node(int data){
				this.data=data;
				this.next=null;
			}
		}
		
		Node head,tail;
		int size;
		
		LL(){
			head=tail=null;
			size=0;
		}
		
		void addFirst(int value){
			Node node=new Node(value);
			if(size==0){
				head=tail=node;
			}
			else{
				node.next=head;
				head=node;
			}
			size++;
		}
		
		void display(){
			Node node=head;
			while(node!=null){
				System.out.print(node.data+" ");
				node=node.next;
			}
			System.out.println();
		}
		
		void addTwoLists(LL ll){
			head=addTwoLists(head, ll.head);
		}
		
		Node addTwoLists(Node first, Node second){
			   Node node=null;
			   Node head=null;
			   int carry=0;
			   while(first!=null && second!=null){
			   	int value=first.data+second.data+carry;
			   	int sum=value%10;
			   	carry=value/10;
			   	Node temp=new Node(sum);
			   	if(node==null){
			   		head=temp;
			   		node=temp;
			   	}
			   	else{
			   		node.next=temp;
			   		node=temp;
			   	}
			   	first=first.next;
			   	second=second.next;
			   }
			   while(first!=null){
			   	int value=first.data+carry;
			   	int sum=value%10;
			   	carry=value/10;
			   	Node temp=new Node(sum);
			   	node.next=temp;
			   	node=temp;	
			   	first=first.next;
			   }
			   while(second!=null){
			   	int value=second.data+carry;
			   	int sum=value%10;
			   	carry=value/10;
				Node temp=new Node(sum);
			   	node.next=temp;
				node=temp;
				second=second.next;
			   }
			   return head;
			}
	}
	
	
	public static void main(String[] args) {
		LL ll=new LL();
		ll.addFirst(6);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(1);
		ll.display();
		
		LL ll1=new LL();
		ll1.addFirst(1);
		ll1.addFirst(3);
		ll1.addFirst(7);
		ll1.addFirst(2);
		ll1.display();
		
		ll.addTwoLists(ll1);
		ll.display();
	}

}
