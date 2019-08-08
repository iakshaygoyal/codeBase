package LL;

public class LinkedList<T> {

	// this class should be private
	private class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private int size;
	private Node head;
	private Node tail;

	public LinkedList() {
		this(null, null, 0);
	}

	private LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T getFirst() throws Exception {
		if (this.isEmpty()) {
//			throw new RuntimeException("The list is empty");
			throw new Exception("The list is empty");
		}

		return this.head.data;
	}

	public T getLast() {
		if (this.isEmpty()) {
			throw new RuntimeException("The list is empty");
		}

		return this.tail.data;
	}

	public T getElementAt(int idx) {
		return this.getNodeAt(idx).data;
	}

	private Node getNodeAt(int idx) {
		if (this.isEmpty()) {
			throw new RuntimeException("The list is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new RuntimeException("Argument is invalid");
		}

		if (idx == 0) {
			return this.head;
		} else if (idx == this.size() - 1) {
			return this.tail;
		} else {
			int counter = 0;
			Node temp = this.head;

			while (counter < idx) {
				counter++;
				temp = temp.next;
			}

			return temp;
		}
	}

	public void addFirst(T data) {
		Node newNode = new Node(data, this.head);
		this.head = newNode;

		if (this.isEmpty()) {
			this.tail = this.head;
		}

		this.size++;
	}

	public void addLast(T data) {
		Node newNode = new Node(data, null);

		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}

		this.size++;
	}

	public void addAt(T data, int idx) {
		if (idx < 0 || idx > this.size()) {
			throw new RuntimeException("Invalid argument");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nM1 = this.getNodeAt(idx - 1);

			Node newNode = new Node(data, nM1.next);
			nM1.next = newNode;

			this.size++;
		}
	}

	public T removeFirst() throws Exception{
		if (this.isEmpty()) {
//			throw new RuntimeException("The list is empty");
			throw new Exception("The list is empty");
		}

		T retVal = this.head.data;

		if (this.size() == 1) {
			this.head = this.tail = null;
		} else {
			this.head = this.head.next;
		}
		
		this.size--;

		return retVal;
	}
	
	public T removeAt(int idx) throws Exception{
		if(this.isEmpty()){
//			throw new RuntimeException("The list is empty");
			throw new Exception("The list is empty");

		}
		
		if(idx < 0 || idx >= this.size()){
//			throw new RuntimeException("Invalid argument.");
			throw new Exception("Invalid argument.");

		}
		
		if(idx == 0){
			return this.removeFirst();
		}
		else{
			Node nM1 = this.getNodeAt(idx - 1);
			
			T retVal = nM1.next.data;
			nM1.next = nM1.next.next;
			
			// removing last element
			if(idx == this.size() - 1){
				this.tail = nM1;
			}
			
			this.size--;
			
			return retVal;
		}
	}

	public String toString() {
		String retVal = "";

		Node temp = this.head;
		while (temp != null) {
			retVal += temp.data + ", ";
			temp = temp.next;
		}

		retVal += "END";

		return retVal;
	}

	public void display() {
		System.out.println(this);
	}
}
