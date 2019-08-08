package lect19;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

	private class HeapNode {
		K key;
		V value;

		HeapNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public String toString(){
			return "{ " + this.key + ", " + this.value + " }";
		}
	}

	private class NormalComparator implements Comparator<HeapNode> {
		public int compare(Heap<K, V>.HeapNode o1, Heap<K, V>.HeapNode o2) {
			return o1.key.compareTo(o2.key);
		}
	}

	private class ReverseComparator implements Comparator<HeapNode> {
		public int compare(Heap<K, V>.HeapNode o1, Heap<K, V>.HeapNode o2) {
			return o2.key.compareTo(o1.key);
		}
	}

	private ArrayList<HeapNode> data;
	private Comparator<HeapNode> comparator;

	public Heap() {
		this(true);
	}

	public Heap(boolean isMinHeap) {
		if (isMinHeap) {
			comparator = new ReverseComparator();
		} else {
			comparator = new NormalComparator();
		}
		this.data = new ArrayList<>();
	}

	public Heap(boolean isMinHeap, K[] keys, V[] values){
		this(isMinHeap);
		
		for(int i = 0; i < keys.length; i++){
			HeapNode node = new HeapNode(keys[i], values[i]);
			this.data.add(node);
		}
		
		for(int i = (this.size() / 2 - 1); i >= 0; i--){
			this.downHeapify(i);
		}
		
/***********************Cannot work in O(n) unless heaps share same data array.**************************************/
		
//		ArrayList<Heap> heaps = new ArrayList<>();
//		for(int i = keys.length / 2; i < keys.length; i++){
//			Heap<K, V> curr = new Heap<>(isMinHeap);
//			curr.add(keys[i], values[i]);
//			
//			heaps.add(curr);
//		}
//		
//		int idxInArray = (keys.length / 2) - 1;
//		while(heaps.size() != 1){
//			Heap<K, V> last = heaps.remove(heaps.size() - 1);
//			Heap<K, V> secondLast = heaps.remove(heaps.size() - 1);
//			
//			Heap<K, V> mergedHeap = this.mergeHeaps(
//									new HeapNode(keys[idxInArray], values[idxInArray]), 
//									secondLast, 
//									last);
//			heaps.add(0, mergedHeap);
//			idxInArray--;
//		}
//		
//		this.data = heaps.get(0).data;
	}
	
//	private Heap<K, V> mergeHeaps(HeapNode root, Heap<K, V> left, Heap<K, V> right){
//		return null;
//	}
	
	public int size() {
		return this.data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(K key, V value) {
		HeapNode newNode = new HeapNode(key, value);
		this.data.add(newNode);
		
		this.upHeapify(this.size() - 1);
	}
	
	private void upHeapify(int ci){
		if(ci == 0){
			return;
		}
		
		int pi = (ci - 1) / 2;
		if(comparator.compare(this.data.get(pi), this.data.get(ci)) < 0){
			this.swapNodes(pi, ci);
			this.upHeapify(pi);
		}
	}

	public V remove() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Heap is empty");
		}

		V retVal = this.data.get(0).value;

		this.swapNodes(0, this.size() - 1);
		this.data.remove(this.size() - 1);

		this.downHeapify(0);

		return retVal;
	}

	private void downHeapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxIndex = pi;

		if (lci < this.size() && 
				this.comparator.compare(this.data.get(maxIndex), this.data.get(lci)) < 0) {
			maxIndex = lci;
		}

		if (rci < this.size() && 
				this.comparator.compare(this.data.get(maxIndex), this.data.get(rci)) < 0) {
			maxIndex = rci;
		}
		
		if(maxIndex != pi){
			this.swapNodes(pi, maxIndex);
			this.downHeapify(maxIndex);
		}
	}

	public V get() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Heap is empty");
		}

		return this.data.get(0).value;
	}

	private void swapNodes(int i, int j) {
		HeapNode temp = this.data.get(i);
		this.data.set(i, this.data.get(j));
		this.data.set(j, temp);
	}

	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		return this.data.toString();
	}
}
