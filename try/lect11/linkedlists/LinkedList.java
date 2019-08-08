package lect11.linkedlists;

public class LinkedList<T extends Comparable<T>> {

	// this class should be private
	private class Node implements Comparable<Node>{
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public int compareTo(Node other){
			return this.data.compareTo(other.data);
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

	public T getFirst() throws Exception{
		if (this.isEmpty()) {
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

	public T removeLast()  throws Exception{
		if(this.isEmpty()){
			throw new Exception("Invalid operation");
		}
		
		T retVal = this.tail.data;
		
		if(this.size() == 1){
			this.head = null;
			this.tail = null;
		}
		else{
			Node nm1 = this.getNodeAt(this.size() - 2);
			nm1.next = null;
			this.tail = nm1;
		}
		
		this.size--;
		
		return retVal;
	}

	public T removeAt(int idx) throws Exception{
		if (this.isEmpty()) {
			throw new Exception("The list is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid argument.");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if(idx == this.size() - 1){
			return this.removeLast();
		} else {
			Node nM1 = this.getNodeAt(idx - 1);

			T retVal = nM1.next.data;
			
			nM1.next = nM1.next.next;
			this.size--;

			return retVal;
		}
	}

	public String toString() {
		String retVal = "[ ";

		Node temp = this.head;
		while (temp != null) {
			retVal += temp.data + ", ";
			temp = temp.next;
		}

		retVal += " ]";

		return retVal;
	}

	public void display() {
		System.out.println(this);
	}

	public T midPointElement() {
		return this.midPointNode().data;
	}

	private Node midPointNode() {
		Node slow = this.head, fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public T kthElementFromEnd(int k) throws Exception {
		if (k <= 0 || k > this.size()) {
			throw new Exception("Invalid argument");
		}

		Node slow = this.head, fast = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public int findElement(T data) {
		return this.findElement(this.head, data, 0);
	}

	private int findElement(Node temp, T data, int idx) {
		if (temp == null) {
			return -1;
		}

		if (temp.data.equals(data)) {
			return idx;
		} else {
			return findElement(temp.next, data, idx + 1);
		}
	}

	public void reverse_D_I() {
		int i = 0, j = this.size() - 1;

		while (i < j) {
			Node ndI = this.getNodeAt(i), ndJ = this.getNodeAt(j);

			T tempData = ndI.data;
			ndI.data = ndJ.data;
			ndJ.data = tempData;

			i++;
			j--;
		}
	}

	public void reverse_D_R() {
		Node tHead = this.head;
		this.reverse_D_R(this.head, 0);
		this.head = tHead;
	}

	private void reverse_D_R(Node temp, int idx) {
		if (temp == null) {
			return;
		}

		reverse_D_R(temp.next, idx + 1);

		if (idx >= this.size() / 2) {
			T hData = this.head.data;
			this.head.data = temp.data;
			temp.data = hData;

			this.head = this.head.next;
		}
	}

	public void bubbleSort(){
		int counter = 1;
		
		while(counter <= this.size - 1){
			Node temp = this.head;
			
			for(int i = 0; i < this.size() - counter; i++){
				if(temp.compareTo(temp.next) > 0){
					T tData = temp.data;
					temp.data = temp.next.data;
					temp.next.data = tData;
				}
				
				temp = temp.next;
			}
			
			counter = counter + 1;
		}
	}
	
	public LinkedList<T> mergeTwoSortedLists(LinkedList<T> other){
		LinkedList<T> retVal = new LinkedList<T>();
		Node thisTemp = this.head, otherTemp = other.head;
		
		while(thisTemp != null && otherTemp != null){
			if(thisTemp.compareTo(otherTemp) <= 0){
				retVal.addLast(thisTemp.data);
				thisTemp = thisTemp.next;
			}
			else{
				retVal.addLast(otherTemp.data);
				otherTemp = otherTemp.next;
			}
		}
		
		while(thisTemp != null){
			retVal.addLast(thisTemp.data);
			thisTemp = thisTemp.next;
		}
		
		while(otherTemp != null){
			retVal.addLast(otherTemp.data);
			otherTemp = otherTemp.next;
		}
		
		return retVal;
	}

	public void mergeSort(){
		LinkedList<T> sorted = this.mergeSortHelper();
		
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}
	
	private LinkedList<T> mergeSortHelper(){
		if(this.size() == 1){
			return this;
		}
		
		Node mid = this.midPointNode();
		Node midNext = mid.next;
		
		mid.next = null;
		
		LinkedList<T> fHalf = new LinkedList<>(this.head, mid, (this.size() + 1)/ 2);
		LinkedList<T> sHalf = new LinkedList<>(midNext, this.tail, this.size() / 2);
		
		fHalf = fHalf.mergeSortHelper();
		sHalf = sHalf.mergeSortHelper();
		
		LinkedList<T> sorted = fHalf.mergeTwoSortedLists(sHalf);
		return sorted;
	}
}
