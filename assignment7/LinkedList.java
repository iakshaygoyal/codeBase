package assignment7;  

public class LinkedList<T extends Comparable<T>> {
	
	private class Node implements Comparable<Node>{
		T data;
		Node next;
		
		public Node(T data,Node next){
			this.data=data;
			this.next=next;
		}
		
		public int compareTo(Node other){
		return this.data.compareTo(other.data);
		}
		
		public boolean equals(Object obj){
			Node node=(Node)obj;
			return this.data.equals(node.data);
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
		if(this.isEmpty()){
			throw new RuntimeException("Empty List");
		}
		if(idx<0 || idx>=this.size){
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
	
	public int findElement(T data){
		if(this.isEmpty()){
			throw new RuntimeException("Empty List");
		}
		Node temp = this.head;
		int idx=0;
		while(temp!=null){
			if(temp.data.equals(data)){
				return idx;
			}
			temp=temp.next;
			idx++;
		}
		return -1;
	}
	
//	public void swapData(Node n1,Node n2){
//		T data=n1.data;
//		n1.data=n2.data;
//		n2.data=data;
//	}
//	
//// Wrong process for swapping nodes	
////	public void swap(int idx1,int idx2){
////		if(this.isEmpty()){
////			throw new RuntimeException("Empty List");
////		}
////		if(idx1<0 || idx2<0 || idx1>=this.size-1 || idx2>=this.size-1){
////			throw new RuntimeException("Invalid Index");
////		}
////		Node n1=this.getNodeAt(idx1);
////		Node n2=this.getNodeAt(idx2);
////		Node temp=n1;
////		n1=n2;
////		n2=temp;
////		if(this.head==n1){
////			this.head=n2;
////		}
////		if(this.head==n2){
////			this.head=n1;
////		}
////		if(this.tail==n1){
////			this.tail=n2;
////		}
////		if(this.tail==n2){
////			this.tail=n1;
////		}
////	}
//	
//	public void swapNode(int idx1,int idx2){
//		if(this.isEmpty()){
//		throw new RuntimeException("Empty List");
//		}
//		if(idx1<0 || idx2<0 || idx1>=this.size || idx2>=this.size || idx1==idx2){
//		throw new RuntimeException("Invalid Index");
//		}
//		Node n1,n2;
//		if(idx1==0){
//			n1=this.head;
//		}
//		else{
//			n1=this.getNodeAt(idx1-1);
//		}
//		if(idx2==0){
//			n2=this.head;
//		}
//		else{
//			n2=this.getNodeAt(idx2-1);
//		}
//		if(n1!=this.head && n2!=this.head){
//			Node temp1=n1.next.next;
//			n1.next.next=n2.next.next;
//			n2.next.next=temp1;
//			
//			Node temp2=n1.next;
//			n1.next=n2.next;
//			n2.next=temp2;
//			
//		}
//		else if(n1!=this.head){
//			Node temp1=n1.next.next;
//			n1.next.next=this.head.next;
//			this.head.next=temp1;
//			
//			Node temp2=n1.next;
//			n1.next=this.head;
//			this.head=temp2;
//		}
//		else{
//			Node temp1=this.head.next;
//			this.head.next=n2.next.next;
//			n2.next.next=temp1;
//			
//			Node temp2=this.head;
//			this.head=n2.next;
//			n2.next=temp2;
//		}
//	}
//	
//	public void eliminateDuplicates(){
//		if(this.isEmpty()){
//			throw new RuntimeException("Empty List");
//		}
//		if(this.size==1)
//			return;
//		Node temp=this.head;
//		while(temp.next!=null){
//			if(temp.data==temp.next.data){
//				temp.next=temp.next.next;
//			}
//			else{
//				temp=temp.next;
//			}
//		}
//	}
//	
//	
////	public LinkedList<T> merge(LinkedList<T> list1,LinkedList<T> list2){
////		LinkedList<T> list3=new LinkedList<>();
////		while(list1.head!=null && list2.head!=null){
////			if(list2.head.compareTo(list1.head) > 0){
////				list3.addLast(list1.head.data);
////				list1.head=list1.head.next;
////			}
////			else if(list1.head.compareTo(list2.head) > 0){
////				list3.addLast(list2.head.data);
////				list2.head=list2.head.next;
////			}
////			else{
////				list3.addLast(list1.head.data);
////				list1.head=list1.head.next;
////			}
////		}
////		while(list1.head!=null){
////			list3.addLast(list1.head.data);
////			list1.head=list1.head.next;
////		}
////		while(list2.head!=null){
////			list3.addLast(list2.head.data);
////			list2.head=list2.head.next;
////		}
////		return list3;
////	}
//	
//	//Better Method
//	public LinkedList<T> merge(LinkedList<T> list){
//		LinkedList<T> retval=new LinkedList<>();
//		Node first=this.head;
//		Node second=list.head;
//		
//		while(first != null && second != null){
//			if(first.compareTo(second) > 0){
//				retval.addLast(second.data);
//				second=second.next;
//			}
//			else{
//				retval.addLast(first.data);
//				first=first.next;
//			}
//		}
//		
//		while(first != null){
//			retval.addLast(first.data);
//			first=first.next;
//		}
//		while(second != null){
//			retval.addLast(second.data);
//			second=second.next;
//		}
//		return retval;
//	}
//	
//	//Better Method
////	public void bubbleSort(){
////		for(int i=0;i<this.size-1;i++){
////			Node temp=this.head;
////			for(int j=0;j<this.size-1-i;j++){
////				if((temp.data).compareTo(temp.next.data) > 0){
////					this.swapData(temp, temp.next);
////				}
////				temp=temp.next;
////			}
////		}
////	}
//	
//	
////	public void bubbleSort(){
////		for(int i=0;i<this.size-1;i++){
////			for(int j=0;j<this.size-1-i;j++){
////				Node temp=this.getNodeAt(j);
////				if((temp.data).compareTo(temp.next.data) > 0){
////					this.swapData(temp,temp.next);
////				}
////			}
////		}
////	}
//	
//	//Better Method
//	public void selectionSort(){
//		Node temp1=this.head;
//		for(int i=0;i<this.size;i++){
//			Node temp2=temp1.next;
//			for(int j=i+1;j<this.size;j++){
//				if((temp1.data).compareTo(temp2.data) > 0){
//					this.swapData(temp1, temp2);
//				}
//				temp2=temp2.next;
//			}
//			temp1=temp1.next;
//		}
//	}
//	
//
////	public void selectionSort(){
////		for(int i=0;i<this.size;i++){
////			Node temp1=this.getNodeAt(i);
////			for(int j=i+1;j<this.size;j++){
////				Node temp2=this.getNodeAt(j);
////				if((temp1.data).compareTo(temp2.data) > 0){
////				this.swapData(temp1, temp2);
////				}
////			}
////		}
////	}
//	
////	public void insertionSort(){
////		Node temp1=this.head;
////		Node temp2=this.head.next;
////		for(int i=0;i<this.size-1;i++){
////			for(int j=i+1;j>0;j--){
////				if(temp1.data.compareTo(temp2.data) > 0){
////					
////				}
////				
////			}
////			temp1=temp1.next;
////			temp2=temp1.next;
////		}
////	}
//	
//	//Better Method
//	public void insertionSort(){
//		
//		for(int i=0;i<this.size-1;i++){
//			for(int j=i+1;j>0;j--){
//				Node temp1=this.getNodeAt(j-1);
//				Node temp2=this.getNodeAt(j);
//				if(temp1.data.compareTo(temp2.data) > 0){
//					this.swapData(temp1, temp2);
//				}	
//			}
//		}
//	}
//	
//	// Better Method
//	public void helperBS(){
//		recursiveBubbleSort(this.head,this.tail,null);
//	}
//	
//	public void recursiveBubbleSort(Node head,Node tail,Node phead){
//		if(tail==this.head){
//			return;
//		}
//		if(head==tail){
//			this.recursiveBubbleSort(this.head,phead,null);
//		}
//		else{
//			if(head.data.compareTo(head.next.data) > 0){
//				this.swapData(head, head.next);
//		}
//			this.recursiveBubbleSort(head.next, tail,head);
//		}
//	}
//	
////	public void helperBS(){
////	this.recursiveBubbleSort(0,this.size-1);
////	}
////	
////	public void recursiveBubbleSort(int fi,int li){
////		if(li==0){
////			return;
////		}
////		if(fi==li){
////			this.recursiveBubbleSort(0,li-1);
////		}
////		else{
////			Node temp1=this.getNodeAt(fi);
////			Node temp2=temp1.next;
////			if(temp1.data.compareTo(temp2.data) > 0){
////				this.swapData(temp1,temp2);
////			}
////			this.recursiveBubbleSort(fi+1,li);
////		}
////	}
//
//	//Better Method
//	public void helperSS(){
//		recursiveSelectionSort(this.head,this.head.next);
//	}
//	
//	public void recursiveSelectionSort(Node head,Node shead){
//		if(head==this.tail){
//			return;
//		}
//		if(shead==null){
//			recursiveSelectionSort(head.next,head.next.next);
//		}
//		else{
//			if(head.data.compareTo(shead.data) > 0){
//				this.swapData(head, shead);
//		}
//			recursiveSelectionSort(head,shead.next);
//		}
//	}
//	
//	
////	public void recursiveSelectionSort(int fi,int si){
////		if(fi==this.size-1){
////			return;
////		}
////		if(si==this.size){
////			this.recursiveSelectionSort(fi+1,fi+2);
////		}
////		else{
////			Node temp1=this.getNodeAt(fi);
////			Node temp2=this.getNodeAt(si);
////			if(temp1.data.compareTo(temp2.data) > 0){
////				this.swapData(temp1, temp2);
////		}
////			this.recursiveSelectionSort(fi,si+1);
////		}
////	}
//	
//	public void recursiveInsertonSort(int fi,int prevfi){
//		if(prevfi==this.size){
//			return;
//		}
//		if(fi==0){
//			this.recursiveInsertonSort(prevfi+1, prevfi+1);
//		}
//		else{
//			Node temp1=this.getNodeAt(fi-1);
//			Node temp2=this.getNodeAt(fi);
//			if(temp1.data.compareTo(temp2.data) > 0){
//				this.swapData(temp1, temp2);
//				this.recursiveInsertonSort(fi-1, prevfi);
//			}
//			else{
//				this.recursiveInsertonSort(prevfi+1, prevfi+1);
//			}
//		}
//	}
//	public LinkedList<T> helperMergeSort(){
//		return mergeSort(0,this.size-1);
//	}
//	
//	public LinkedList<T> mergeSort(int lo,int hi){
//		if(lo==hi){
//			LinkedList<T> list4=new LinkedList<>();
//			list4.addFirst(this.getElementAt(lo));
//			return list4;
//		}
//		int mid=(lo+hi)/2;
//		LinkedList<T> list1=mergeSort(lo,mid);
//		LinkedList<T> list2=mergeSort(mid+1,hi);
//		LinkedList<T> list3=list1.merge(list2);
//		return list3;
//	}
//	
//	public boolean isPalindrome(){
//		Node temp1=this.head;
//		for(int i=0,j=this.size-1;i<j;i++,j--){
//			Node temp2=this.getNodeAt(j);
//			if(temp1.data!=temp2.data)
//				return false;
//			temp1=temp1.next;
//		}
//		return true;
//	}
//	
//	public void reverse(){
//		if(this.isEmpty()){
//			throw new RuntimeException("Empty List");
//		}
//		if(this.size==1){
//			return;
//		}
//		Node prev=null;
//		Node curr=this.head;
//		Node Next=curr.next;
//		while(curr!=null){
//			curr.next=prev;
//			prev=curr;
//			curr=Next;
//			if(curr!=null){
//				Next=curr.next;
//			}
//		}
//		Node temp=this.head;
//		this.head=this.tail;
//		this.tail=temp;
//	}
//	
//	public void recursiveReverseHelper(){
//		this.recursiveReverse(null, this.head);
//		Node temp=this.head;
//		this.head=this.tail;
//		this.tail=temp;
//	}
//	
//	public void recursiveReverse(Node prev,Node curr){
//		if(curr==null){
//			return;
//		}
//		recursiveReverse(curr,curr.next);
//		curr.next=prev;
//	}
//	
//	public void oddThenEven(){
//		for(Node temp1=this.head;temp1!=this.tail;temp1=temp1.next){
//			if((int)temp1.data%2 == 0){
//				for(Node temp2=temp1.next;temp2!=null;temp2=temp2.next){
//					if((int)temp2.data%2!=0){
//						this.swapData(temp1, temp2);
//						break;
//					}
//				}
//			}
//		}
//	}
//	
//	public void append(int n){
//		if(n<0 || n>=this.size){
//			throw new RuntimeException("Invalid n");
//		}
//		Node temp=this.getNodeAt(this.size-(n+1));
//		this.tail.next=this.head;
//		this.head=temp.next;
//		temp.next=null;
//		this.tail=temp;
//	}
//	
//	public T elementAtMidPoint(){
//		return this.nodeAtMidPoint().data;
//	}
//	
//	private Node nodeAtMidPoint(){
//		Node slow=this.head;
//		Node fast=this.head;
//		while(fast.next!=null && fast.next.next!=null){
//			fast=fast.next.next;
//			slow=slow.next;
//		}
//		return slow;
//	}
//	
//	public T kthElementFromLast(int k){
//		if(k<1 || k>this.size){
//			throw new RuntimeException("Invalid k");
//		}
//		return this.kthNodeFromLast(k).data;
//	}
//	
//	private Node kthNodeFromLast(int k){
//		Node temp1=this.head;
//		Node temp2=this.head;
//		while(k!=0){
//			temp1=temp1.next;
//			k--;
//		}
//		while(temp1!=null){
//			temp1=temp1.next;
//			temp2=temp2.next;
//		}
//		return temp2;
//	}
//	
//	public void reverseData(){
//		Node temp1=this.head;
//		for(int i=0,j=this.size-1;i<j;i++,j--){
//			Node temp2=this.getNodeAt(j);
//			this.swapData(temp1, temp2);
//			temp1=temp1.next;
//		}
//	}
//	
//	public void helperRecursiveReverseData(){
//		Node temp=this.head;
//		this.recursiveReverseData(this.head, 0);
//		this.head=temp;
//	}
//	
//	private void recursiveReverseData(Node temp,int idx){
//		if(temp==null){
//			return;
//		}
//		this.recursiveReverseData(temp.next,idx+1);
//		if(idx>=(this.size/2)){
//		this.swapData(temp, this.head);
//		this.head=this.head.next;
//		}
//	}
//	
//	public void bubbleSort(){
//		for(int i=0;i<this.size-1;i++){
//			Node temp=this.head;
//			for(int j=0;j<this.size-1-i;j++){
//				if((temp).compareTo(temp.next) > 0){
//					this.swapData(temp, temp.next);
//				}
//				temp=temp.next;
//			}
//		}
//	}
//	
//	public void helperkReverse(int k){
//		if(k<1 || k>this.size-1){
//			throw new RuntimeException("Invalid k");
//		}
//		Node temp1=this.head;
//		for(int i=0;i<(this.size/k);i++){
//			int n=k*i;
//			Node temp=temp1;
//			while(n!=0){
//				n--;
//				temp=temp.next;
//			}
//			this.head=temp;
//			kReverse(temp,k,k);
//		}
//		this.head=temp1;
//	}
//	
//	private void kReverse(Node temp,int k,int size){
//		if(k==0 || temp==null){
//			return;
//		}
//		kReverse(temp.next,k-1,size);
//		if(k<=(size/2)){
//		this.swapData(temp, this.head);
//		this.head=this.head.next;
//		}
//	}
//	
	
	public T dataatMid() throws Exception{
		return this.nodeatMid().data;
	}
	
	private Node nodeatMid() throws Exception{
		if(this.isEmpty()){
			throw new Exception("Empty List");
		}
		Node slow=this.head;
		Node fast=this.head;
		while(fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	public T kDatafromEnd(int k){
		return this.kNodefromEnd(k).data;
	}
	
	private Node kNodefromEnd(int k){
		Node temp1=this.head;
		Node temp2=this.head;
		while(k!=0){
			temp1=temp1.next;
			k--;
		}
		while(temp1!=null){
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return temp2;
	}
	
	public boolean recursiveFind(T value){
		return this.recursiveFind(this.head, value);
	}
	
	private boolean recursiveFind(Node node,T value){
		if(node==null){
			return false;
		}
		if(node.data.equals(value)){
			return true;
		}
		return this.recursiveFind(node.next, value);
	}
	
	public void recursiveReversePointers(){
		this.recursiveReversePointers(this.head, null);
		Node temp=this.head;
		this.head=this.tail;
		this.tail=temp;
	}
	
	private void recursiveReversePointers(Node node,Node pnode){
		if(node==null){
			return;
		}
		this.recursiveReversePointers(node.next, node);
		node.next=pnode;
	}
	
	public void recursiveReverseData(){
		Node phead=this.head;
		this.recursiveReverseData(this.head, 1);
		this.head=phead;
	}
	
	private void recursiveReverseData(Node node,int idx){
		if(node==null){
			return;
		}
		this.recursiveReverseData(node.next, idx+1);
		if(idx>this.size/2){
			T temp=node.data;
			node.data=this.head.data;
			this.head.data=temp;
			this.head=this.head.next;
		}
	}
	
	public void iterativeReversePointers(){
		Node p=null;
		Node c=this.head;
		Node n=this.head.next;
		while(c!=null){
			c.next=p;
			p=c;
			c=n;
			if(n!=null){
				n=n.next;
			}
		}
		Node temp=this.head;
		this.head=this.tail;
		this.tail=temp;
	}
	
	
	public void bs(){
		for(int i=0;i<this.size-1;i++){
			Node temp=this.head;
			for(int j=0;j<this.size-1-i;j++){
				if(temp.compareTo(temp.next)>0){
					this.swap(temp, temp.next);
				}
				temp=temp.next;
			}
		}
	}
	
	public void swap(Node node1,Node node2){
		T temp=node1.data;
		node1.data=node2.data;
		node2.data=temp;
	}
	
	public LinkedList<T> merge(LinkedList<T> list){
		Node node1=this.head;
		Node node2=list.head;
		LinkedList<T> retval=new LinkedList<>();
		while(node1!=null && node2!=null){
			if(node1.compareTo(node2)<0){
				retval.addLast(node1.data);
				node1=node1.next;
			}
			else{
				retval.addLast(node2.data);
				node2=node2.next;
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
	
	public LinkedList<T> mergeSort(int lo,int hi){
		if(lo==hi){
			LinkedList<T> retval=new LinkedList<>();
			retval.addFirst(this.getElementAt(lo));
			return retval;
		}
		int mid=(lo+hi)/2;
		LinkedList<T> list1=this.mergeSort(lo,mid);
		LinkedList<T> list2=this.mergeSort(mid+1, hi);
		LinkedList<T> list3=list1.merge(list2);
		return list3;
	}
	
	public void removeDuplicates(){
		Node temp=this.head;
		Node temp1=this.head.next;
		while(temp1!=null){
			if(temp.data.equals(temp1.data)){
				temp1=temp1.next;
			}
			else{
				temp.next=temp1;
				temp=temp1;
				temp1=temp1.next;
			}
		}
		temp.next=null;
	}
	
	public void ss(){
		Node temp=this.head;
		for(int i=0;i<this.size-1;i++){
			Node temp1=temp;
			for(int j=i;j<this.size-1;j++){
				if(temp.compareTo(temp1.next)>0){
					this.swap(temp, temp1.next);
				}
				temp1=temp1.next;
			}
			temp=temp.next;
		}
	}
	
	public void is(){
		this.is(this.head);
	}
	
	private void is(Node node){
		if(node.next==null){
			return;
		}
		is(node.next);
		Node temp=node;
		while(temp.next!=null){
			if(temp.compareTo(temp.next)>0){
				this.swap(temp, temp.next);
				temp=temp.next;
			}
			else{
				break;
			}
		}
	}
	
	public void rbs(){
		Node temp=this.tail;
		this.rbs(this.head, null);
		this.tail=temp;
	}
	
	private void rbs(Node node1,Node node2){
		if(this.tail==this.head){
			return;
		}
		if(node1==this.tail){
			this.tail=node2;
			this.rbs(this.head, null);
		}
		else{
			if(node1.compareTo(node1.next)>0){
				this.swap(node1, node1.next);
			}
			this.rbs(node1.next, node1);
		}
	}
	
	public void rss(){
		this.rss(this.head, this.head);
	}
	
	private void rss(Node node1,Node node2){
		if(node2==this.tail){
			return;
		}
		if(node1==this.tail){
			this.rss(node2.next, node2.next);
		}
		else{
			if(node2.compareTo(node1.next)>0){
				this.swap(node2, node1.next);
			}
			this.rss(node1.next, node2);
		}
	}
	
	public boolean isPalindrome(){
		Node temp=this.head;
		boolean b=this.isPalindrome(this.head,1);
		this.head=temp;
		return b;
	}
	
	private boolean isPalindrome(Node node,int idx){
		if(node==null){
			return true;
		}
		if(!this.isPalindrome(node.next,idx+1)){
			return false;
		}
		if(idx>this.size()/2){
			if(this.head.equals(node)){
				this.head=this.head.next;
				return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public void oddThenEven(){
		Node node1=this.head;
		Node node2=this.head;
		while(node1!=null){
			if((int)node1.data%2!=0){
				this.swap(node1, node2);
				node1=node1.next;
				node2=node2.next;
			}
			else{
				node1=node1.next;
			}
		}
	}
	
	public void append(int n){
		Node node=this.getNodeAt(this.size-n-1);
		this.tail.next=this.head;
		this.tail=node;
		this.head=node.next;
		node.next=null;
	}
	
	public void kreverse(int k){
		Node temp=this.head;
		Node temp1=this.head;
		int size=this.size;
		for(int i=0;i<size;i++){
			if(i%k==0 && size-i>=k){
				this.head=temp1;
				this.kreverse(temp1, 0, k);
			}
			temp1=temp1.next;
		}
		this.head=temp;
	}
	
	private void kreverse(Node node,int idx,int k){
		if(node==null || idx==k){
			return;
		}
		this.kreverse(node.next, idx+1, k);
		if(idx>=(k/2)){
			this.swap(this.head, node);
			this.head=this.head.next;
		}
	}
	
}