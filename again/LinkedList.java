package again;

public class LinkedList<T extends Comparable<T>> {

	// this class should be private
	private class Node implements Comparable<Node>{
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public int compareTo(Node other) {
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

	public T getFirst() {
		if (this.isEmpty()) {
			throw new RuntimeException("The list is empty");
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

	public T removeFirst() {
		if (this.isEmpty()) {
			throw new RuntimeException("The list is empty");
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
	
	public T removeAt(int idx){
		if(this.isEmpty()){
			throw new RuntimeException("The list is empty");
		}
		
		if(idx < 0 || idx >= this.size()){
			throw new RuntimeException("Invalid argument.");
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
	
	public int findElement(T data){
		return this.findElement(this.head, data);
	}
	
	private int findElement(Node node, T data){
		if(node == null){
			return -(this.size+1);
		}
		
		int retval = 0;
		
		if(node.data.equals(data)){
			return retval;
		}
		
		return 1 + this.findElement(node.next, data);
	}
	
	public T midPoint(){
		Node slow=this.head;
		Node fast=this.head;
		
		while(fast != null){
			fast=fast.next;
			if(fast != null){
				fast=fast.next;
				if(fast != null){
					slow=slow.next;
				}
			}
		}
		
		return slow.data;
	}
	
	public void bubbleSort(){
		for(int i=0; i<this.size-1; i++){
			Node temp=this.head;
			for(int j=0; j<this.size-1-i; j++){
				if(temp.compareTo(temp.next) > 0){
					this.swapData(temp, temp.next);
				}
				temp=temp.next;
			}
		}
	}
	
	public void swapData(Node node1, Node node2){
		T temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}
	
	public LinkedList<T> merge(LinkedList<T> list){
		this.bubbleSort();
		list.bubbleSort();
		
		LinkedList<T> newList = new LinkedList<T>();
		Node temp1=this.head;
		Node temp2=list.head;
		
		while(temp1 != null && temp2 != null){
			if(temp1.compareTo(temp2) > 0){
				newList.addLast(temp2.data);
				temp2=temp2.next;
			}
			else{
				newList.addLast(temp1.data);
				temp1=temp1.next;
			}
		}
		
		while(temp1 != null){
			newList.addLast(temp1.data);
			temp1=temp1.next;
		}
		
		while(temp2 != null){
			newList.addLast(temp2.data);
			temp2=temp2.next;
		}
		
		return newList;
	}
	
	public LinkedList<T> mergeSort(){
		return this.mergeSort(0, this.size-1);
	}
	
	public LinkedList<T> mergeSort(int lo, int hi){
		if(lo == hi){
			LinkedList<T> retval = new LinkedList<T>();
			retval.addLast(this.getElementAt(lo));
			return retval;
		}
		
		int mid = (lo+hi)/2;
		LinkedList<T> list1 = this.mergeSort(lo, mid);
		LinkedList<T> list2 = this.mergeSort(mid+1, hi);
		LinkedList<T> retval = list1.merge(list2);
		return retval;
	}
	
	public void iterativeReverseLink(){
		if(this.size == 0 || this.size ==1){
			return;
		}
		Node prev=null;
		Node curr=this.head;
		Node next=curr.next;
		
		while(curr != null){
			curr.next=prev;
			prev=curr;
			curr=next;
			if(curr != null){
				next=curr.next;
			}
		}
		
		Node temp=this.head;
		this.head=this.tail;
		this.tail=temp;
	}
	
	public void recursiveReverseLink(){
		this.recursiveReverseLink(this.head, null);
		Node temp=this.head;
		this.head=this.tail;
		this.tail=temp;
	}
	
	private void recursiveReverseLink(Node curr, Node prev){
		if(curr == null){
			return;
		}
		
		this.recursiveReverseLink(curr.next, curr);
		curr.next=prev;
	}
	
	public void bs(){
		for(int i=0; i<this.size-1; i++){
			
			Node temp = this.head;
			for(int j=0; j<this.size-1-i; j++){
				if(temp.compareTo(temp.next) > 0){
					this.swapData(temp, temp.next);
				}
				temp = temp.next;
			}
		}
	}
	
	public void ss(){
		Node temp1 = this.head;
		for(int i=0; i<this.size-1; i++){
			
			Node temp2 = temp1.next;
			for(int j=i+1; j<this.size; j++){
				if(temp1.compareTo(temp2) > 0){
					this.swapData(temp1, temp2);
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
	}
	
	public void is(){
		is(this.head);
	}
	
	private void is(Node node){
		if(node == this.tail){
			return;
		}
		
		is(node.next);
		while(node.next != null){
			if(node.compareTo(node.next) > 0){
				this.swapData(node, node.next);
				node = node.next;
			}
			else{
				break;
			}
		}
	}
	
	public void rbs(){
		rbs(this.head, this.tail, null);
	}
	
	private void rbs(Node first, Node last, Node back){
		if(last == this.head){
			return;
		}
		
		if(first != last){
			if(first.compareTo(first.next) > 0){
				this.swapData(first, first.next);
			}
			rbs(first.next, last, first);
		}
		else{
			rbs(this.head, back, null);
		}
	}
	
	public void rss(){
		rss(this.head, this.head.next);
	}
	
	private void rss(Node first, Node second){
		if(first == this.tail){
			return;
		}
		
		if(second != null){
			if(first.compareTo(second) > 0){
				this.swapData(first, second);
			}
			rss(first, second.next);
		}
		else{
			rss(first.next, first.next.next);
		}
	}
	
	public boolean isPalindrome(){
		Node temp = this.head;
		boolean b = isPalindrome(this.head, 0);
		this.head = temp;
		return b;
	}
	
	private boolean isPalindrome(Node node, int idx){
		if(node == null){
			return true;
		}
		if(!isPalindrome(node.next, idx+1)){
			return false;
		}
		
		if(idx > (this.size()/2)){
			if(node.data != this.head.data){
				return false;
			}
			this.head = this.head.next;
		}
		
		return true;
	}
	
	public void oddAndEven(){
		Node temp1 = this.head;
		Node temp2 = this.head;
		
		for(int i=0; i<this.size; i++){
			if((int) temp1.data % 2 != 0 || (int) temp2.data % 2 == 0){
				if((int)temp1.data % 2 != 0){
					temp1 = temp1.next;
				}
				if((int)temp2.data % 2 == 0){
					temp2 = temp2.next;
				}
			}
			else{
				this.swapData(temp1, temp2);
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
	}
	
	public void kreverse(int k){
		Node temp = this.head;
		
		for(int i=0; i<(this.size / k); i++){
			this.head = temp;
			int n = k*i;
			while(n != 0){
				this.head = this.head.next;
				n--;
			}
			kreverse(this.head, k, 0);
		}
		
		this.head = temp;
	}
	
	private void kreverse(Node node, int k, int i){
		if(i == k){
			return;
		}
		kreverse(node.next, k, i+1);
		if(i >= (k/2)){
			this.swapData(node, this.head);
			this.head = this.head.next;
		}
	}
	
}

