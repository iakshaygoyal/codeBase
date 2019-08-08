package Heap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
public class Heap<K extends Comparable<K>,V> implements PriorityQueue<K, V> {
	
	private class heapNode{
		K key;
		V value;	
		heapNode(K key, V value){
			this.key=key;
			this.value=value;
		}
		
		public String toString(){
			String retval = "{ "+this.key+", "+this.value+" }";
			return retval;
		}
	}
	
	private class reverseComparator implements Comparator<heapNode>{
		@Override
		public int compare(Heap<K, V>.heapNode o1, Heap<K, V>.heapNode o2) {
			return o2.key.compareTo(o1.key);
		}
	}

	
	private class normalComparator implements Comparator<heapNode>{
		@Override
		public int compare(Heap<K, V>.heapNode o1, Heap<K, V>.heapNode o2) {
			return o1.key.compareTo(o2.key);
		}
	}
	
	
	private ArrayList<heapNode> data;
	private Comparator<heapNode> comparator;

	public Heap(){
		this(true);
	}
	
	public Heap(boolean isMinHeap){
		if(isMinHeap){
			this.comparator = new reverseComparator();
		}
		else{
			this.comparator = new normalComparator();
		}
		this.data=new ArrayList<>();
		
	}
	
	public Heap(boolean isMinHeap, K[] keys, V[] values){
		this(isMinHeap);
		
		for(int i=0 ;i < keys.length ; i++){
			heapNode node = new heapNode(keys[i], values[i]);
			this.data.add(node);
		}
		
		for(int i=this.size()/2 - 1 ; i>=0 ; i--){
			this.downHeapify(i);
		}
		
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void add(K key, V value) {
		heapNode newNode = new heapNode(key,value);
		this.data.add(newNode);
		this.upHeapify(this.size()-1);
	}
	
	private void upHeapify(int ci){
		if(ci == 0){
			return;
		}
		int pi=(ci-1)/2;
		
		if(comparator.compare(this.data.get(ci), this.data.get(pi)) > 0){
			this.swapNodes(ci, pi);
			this.upHeapify(pi);
		}
		
	}

	@Override
	public V remove() throws Exception {
		if(isEmpty()){
			throw new Exception();
		}
		V retval = this.data.get(0).value;
		this.swapNodes(0, this.size()-1);
		this.data.remove(this.size()-1);
		
		this.downHeapify(0);
		
		return retval;
	}
	
	private void downHeapify(int pi){
		int minIndex = pi;
		int lci = 2*pi+1;
		int rci = 2*pi+2;
		
		if(lci<this.size() && comparator.compare(this.data.get(lci), this.data.get(minIndex)) > 0){
			minIndex = lci;
		}
		
		if(rci<this.size() && comparator.compare(this.data.get(rci), this.data.get(minIndex)) > 0){
			minIndex = rci;
		}
		
		if(minIndex != pi){
			this.swapNodes(pi, minIndex);
			this.downHeapify(minIndex);
		}
		
	}

	@Override
	public V get() throws Exception {
		if(isEmpty()){
			throw new Exception();
		}
		return this.data.get(0).value;
	}

	@Override
	public void display() {
		System.out.println(this);
	}
	
	public String toString(){
		return this.data.toString();
	}
	
	
	public void swapNodes(int fi,int si){
		heapNode temp = this.data.get(fi);
		this.data.set(fi, this.data.get(si));
		this.data.set(si, temp);
	}
}