package again;

import java.util.ArrayList;
import java.util.Comparator;

import Heap.PriorityQueue;

public class heap<K extends Comparable<K>,V> implements PriorityQueue<K, V> {
	
	private class heapNode{
		K key;
		V value;
		
		heapNode(K key, V value){
			this.key=key;
			this.value=value;
		}	
		
		public String toString(){
			
			return "{"+this.key+", "+this.value+"}";
		}
	}
	
	private class normalComparator implements Comparator<heapNode>{

		@Override
		public int compare(heapNode arg0, heapNode arg1) {
			return arg0.key.compareTo(arg1.key);
		}
	}
	
	private class reverseComparator implements Comparator<heapNode>{

		@Override
		public int compare(heap<K, V>.heapNode arg0, heap<K, V>.heapNode arg1) {
			return arg1.key.compareTo(arg0.key);
		}
	}
	
	private ArrayList<heapNode> data;
	private Comparator<heapNode> comparator;
	
	public heap(){
		this(false);
	}
	
	public heap(boolean b){
		if(b == true){
			this.comparator = new normalComparator();
		}
		else{
			this.comparator = new reverseComparator();
		}
		this.data = new ArrayList<>();
	}
	
	public heap(boolean b, K[] key, V[] value){
		this(b);
		
		for(int i=0; i<key.length; i++){
			heapNode newNode = new heapNode(key[i], value[i]);
			data.add(newNode);
		}
		
		for(int i = this.size()/2-1; i>=0; i--){
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
		heapNode newNode = new heapNode(key, value);
		this.data.add(newNode);
		this.upHeapify(this.size()-1);
	}
	
	private void upHeapify(int ci){
		if(ci == 0){
			return;
		}
		int pi = (ci-1)/2;
		
		if(ci>0 && this.comparator.compare(this.data.get(ci), this.data.get(pi)) > 0){
			this.swapNodes(pi, ci);
			this.upHeapify(pi);
		}
	}

	@Override
	public V remove() throws Exception {
		if(this.isEmpty()){
			throw new Exception("heap is empty");
		}
		
		V retval = this.data.get(0).value;
		
		this.swapNodes(0, this.size()-1);
		this.data.remove(this.size()-1);
		this.downHeapify(0);
		
		return retval;
	}
	
	private void downHeapify(int pi){
		int lci = 2*pi+1;
		int rci = 2*pi+2;
		int currenti = pi;
		
		if(lci < this.size() && this.comparator.compare(this.data.get(lci), this.data.get(currenti)) > 0){
			currenti=lci;
		}
		
		if(rci < this.size() && this.comparator.compare(this.data.get(rci), this.data.get(currenti)) > 0){
			currenti = rci;
		}
		
		if(currenti != pi){
			this.swapNodes(currenti, pi);
			this.downHeapify(currenti);
		}
	}


	@Override
	public V get() throws Exception {
		if(this.isEmpty()){
			throw new Exception("heap is empty");
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
	
	private void swapNodes(int idx1, int idx2){
		
		heapNode temp = this.data.get(idx1);
		this.data.set(idx1, this.data.get(idx2));
		this.data.set(idx2, temp);
	}

}
