import java.util.*;
import java.lang.*;
public class LinkedList {
	
	class Node implements Comparable<Node>{
		int data;
		Node next;
		
		Node(int data,Node next){
			this.data=data;
			this.next=next;
		}
		
		public int compareTo(Node node){
			return this.data-node.data;
		}
	}
	
	Node head;
	Node tail;
	int size;
	
	LinkedList(){
		this(null,null,0);
	}
	
	LinkedList(Node head,Node tail,int size){
		this.head=head;
		this.tail=tail;
		this.size=size;
	}
	
	void addFirst(int data){
		Node newNode=new Node(data,this.head);
		this.head=newNode;
		if(this.size==0){
			this.tail=newNode;
		}
		this.size++;
	}
	
	void addLast(int data){
		Node newNode=new Node(data,null);
		if(this.size==0){
			this.head=newNode;
			this.tail=newNode;
		}
		else{
			this.tail.next=newNode;
			this.tail=newNode;
		}
		this.size++;
	}
	
	int get(int idx){
		if(idx>=this.size){
			return -1;
		}
		Node node=this.head;
		while(idx>0){
			node=node.next;
			idx--;
		}
		return node.data;
	}
	
	void display(){
		Node temp=this.head;
		while(temp!=null){
			System.out.print(temp.data+", ");
			temp=temp.next;
		}
		System.out.println("END");
	}
	
	int midPoint(){
		if(this.size==0){
			return -1;
		}
		Node slow=this.head,fast=this.head;
		while(fast.next!=null){
			fast=fast.next.next;
			if(fast==null){
				break;
			}
			slow=slow.next;
		}
		return slow.data;
	}
	
	int kEnd(int k){
		if(k<0 || k>=this.size){
			return -1;
		}
		Node node1=this.head;
		while(k>=0){
			node1=node1.next;
			k--;
		}
		Node node2=this.head;
		while(node1!=null){
			node1=node1.next;
			node2=node2.next;
		}
		return node2.data;
	}
	
	void bs(){
		for(int i=0;i<(this.size-1);i++){
			Node temp=this.head;
			for(int j=0;j<(this.size-1-i);j++){
				if(temp.compareTo(temp.next) > 0){
					this.swap(temp,temp.next);
				}
				temp=temp.next;
			}
		}
	}
	
	void ss(){
		Node node1=this.head;
		for(int i=0;i<(this.size-1);i++){
			Node node2=node1.next;
			for(int j=i+1;j<this.size;j++){
				if(node1.compareTo(node2)>0){
					this.swap(node1, node2);
				}
				node2=node2.next;
			}
			node1=node1.next;
		}
	}
	
	void ss1(){
		for(Node node1=this.head;node1.next!=null;node1=node1.next){
			for(Node node2=node1.next;node2!=null;node2=node2.next){
				if(node1.compareTo(node2)>0){
					this.swap(node1, node2);
				}
			}
		}
	}
	
	void is(){
		this.is(this.head);
	}
	private void is(Node node){
		if(node==null){
			return;
		}
		this.is(node.next);
		while(node.next!=null){
			if(node.compareTo(node.next) > 0){
				this.swap(node, node.next);
				node=node.next;
			}
			else{
				break;
			}
		}
	}
	
	void rbs(){
		Node node=this.tail;
		this.rbs(this.head,null);
		this.tail=node;
	}
	private void rbs(Node node,Node prevnode){
		if(this.tail==this.head){
			return;
		}
		if(node==this.tail){
			this.tail=prevnode;
			this.rbs(this.head, null);
		}
		else{
			if(node.compareTo(node.next)>0){
				this.swap(node, node.next);
			}
			this.rbs(node.next, node);
		}
	}
	
	void swap(Node node1,Node node2){
		int temp=node1.data;
		node1.data=node2.data;
		node2.data=temp;
	}
	
	LinkedList mergeSort(int start,int end){
		if(start==end){
			LinkedList retval=new LinkedList();
			retval.addFirst(this.get(start));
			return retval;
		}
		int mid=(start+end)/2;
		LinkedList list1=mergeSort(start, mid);
		LinkedList list2=mergeSort(mid+1,end);
		LinkedList retval=list1.merge(list2);
		return retval;
	}
	
	LinkedList merge(LinkedList list){
		Node node1=this.head;
		Node node2=list.head;
		LinkedList retval=new LinkedList();
		while(node1!=null && node2!=null){
			if(node1.compareTo(node2) > 0){
				retval.addLast(node2.data);
				node2=node2.next;
			}
			else{
				retval.addLast(node1.data);
				node1=node1.next;
			}
		}
		while(node1!=null){
			retval.addLast(node1.data);
			node1=node1.next;
		}
		while(node2!=null){
			retval.addLast(node2.data);
			node2=node2.next;
		}
		return retval;
	}
	
	void reversePointersRecursive(){
		this.reversePointersRecursive(this.head, null);
		Node node=this.head;
		this.head=this.tail;
		this.tail=node;
	}
	private void reversePointersRecursive(Node node,Node prev){
		if(node==null){
			return;
		}
		this.reversePointersRecursive(node.next, node);
		node.next=prev;
	}
	
	void reverseDataRecursive(){
		Node node=this.head;
		this.reverseDataRecursive(this.head, 1);
		this.head=node;
	}
	private void reverseDataRecursive(Node node,int idx){
		if(node==null){
			return;
		}
		this.reverseDataRecursive(node.next, idx+1);
		if(idx>this.size/2){
			this.swap(this.head, node);
			this.head=this.head.next;
		}
	}
	
	void reversePointersIterative(){
		Node p=null;
		Node c=this.head;
		Node n=this.head.next;
		while(c!=null){
			c.next=p;
			p=c;
			c=n;
			if(c!=null){
				n=n.next;
			}
		}
		Node node=this.head;
		this.head=this.tail;
		this.tail=node;
	}
	
	void removeDuplicates(){
		Node node1=this.head;
		Node node2=this.head.next;
		while(node2!=null){
			if(node1.compareTo(node2)==0){
				node2=node2.next;
				node1.next=node2;
			}
			else{
				node1=node1.next;
				node2=node2.next;
			}
		}
	}
	
	void oddThenEven(){
		Node odd=this.head;
		Node even=this.head;
		while(odd!=null){
			if(odd.data%2==0){
				odd=odd.next;
			}
			else{
				this.swap(odd, even);
				odd=odd.next;
				even=even.next;
			}
		}
	}
	
	void kReverse(int k){
		Node temp=this.head;
		Node node=this.head;
		int turns=this.size/k;
		for(int i=0;i<this.size-k && turns>0;i++){
			if(i%k==0){
				this.head=node;
				this.kReverse(node, 0, k);
				turns--;
			}
			node=node.next;
		}
		this.head=temp;
	}
	private void kReverse(Node node,int idx,int k){
		if(idx>=k){
			return;
		}
		this.kReverse(node.next, idx+1, k);
		if(idx>=(k/2)){
			this.swap(node, this.head);
			this.head=this.head.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addFirst(3);
		list.addFirst(8);
		list.addFirst(9);
		list.addFirst(2);
		list.addFirst(15);
		list.addFirst(8);
		list.addFirst(6);
		list.addFirst(1);
		list.addFirst(17);
		list.addFirst(7);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(12);
		list.addFirst(8);
		list.display();
//		System.out.println(list.midPoint());
//		System.out.println(list.kEnd(2));
//		list.bs();
//		list.display(); 
//		list.mergeSort(0, list.size-1).display();
//		list.reversePointersRecursive();
//		list.display();
//		list.reverseDataRecursive();
//		list.display();
//		list.reversePointersIterative();
//		list.display();
//		list.removeDuplicates();
//		list.display();
		list.oddThenEven();
		list.display();
		list.kReverse(3);
		list.display();
//		list.is();
//		list.display();
		list.rbs();
		list.display();
	}

}