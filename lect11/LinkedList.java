package lect11;

public class LinkedList<T> {
	
	private class Node{
		T data;
		Node next;
		
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList(){
		this(null,null,0);
	}
	
	private LinkedList(Node head,Node tail,int size){
		this.head=head;
		this.tail=tail;
		this.size=size;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size==0;
	}
	
	public T getFirst(){
		if(this.isEmpty()){
			throw new RuntimeException("Empty List");
		}
		return this.head.data;
	}
	
	public T getLast(){
		if(this.isEmpty()){
			throw new RuntimeException("Empty List");
		}
		return this.tail.data;
	}
	
	public T getElementAt(int idx){
		return this.getNodeAt(idx).data;
	}
	
	private Node getNodeAt(int idx){
		if(isEmpty()){
			throw new RuntimeException("Empty List");
		}
		if(idx<0 || idx>this.size){
			throw new RuntimeException("Invalid Index");
		}
		if(idx==0){
			return this.head;
		}
		else if(idx==this.size-1){
			return this.tail;
		}
		else{
			int counter=0;
			Node temp=this.head;
			while(counter<idx){
				counter++;
				temp=temp.next;
			}
			return temp;
		}
	}
	
	public void addFirst(T data){
		Node newNode=new Node(data,this.head);
		this.head=newNode;
		if(this.isEmpty()){
			this.tail=newNode;
		}
		this.size++;
	}
	
	public void addLast(T data){
		Node newNode=new Node(data,null);
		if(this.isEmpty()){
			this.head=newNode;
			this.tail=newNode;
		}
		else
		{
			this.tail.next=newNode;
			this.tail=newNode;
		}
		this.size++;
	}
	
	public void addAt(T data,int idx){
		if(idx<0 || idx>this.size){
			throw new RuntimeException("Invalid Index");
		}
		if(idx==0){
			this.addFirst(data);
		}
		else if(idx==this.size-1){
			this.addLast(data);
		}
		else{
			Node temp=this.getNodeAt(idx-1);
			Node newNode=new Node(data,temp.next);
			temp.next=newNode;
			this.size++;
		}
	}
	
	public T removeFirst(){
		if(this.isEmpty()){
			throw new RuntimeException("Empty List");
		}
		T retval=this.head.data;
		this.head=this.head.next;
		if(this.size==1){
			this.tail=null;
		}
		this.size--;
		return retval;
	}
	
	public T removeAt(int idx){
		if(isEmpty()){
			throw new RuntimeException("Empty List");
		}
		if(idx<0 || idx>this.size){
			throw new RuntimeException("Invalid Index");
		}
		if(idx==0){
			return this.removeFirst();
		}
		else{
			Node temp=this.getNodeAt(idx-1);
			T retval=temp.next.data;
			temp.next=temp.next.next;
			if(idx==this.size-1){
				this.tail=temp;
			}
			this.size--;
			return retval;
		}
	}
	
	public String toString(){
		String retval="";
		Node temp=this.head;
		while(temp!=null){
			retval=retval+temp.data+" ,";
			temp=temp.next;
		}
		retval=retval+"END";
		
		return retval;
	}
	
	public void display(){
		System.out.println(this);
	}

}
