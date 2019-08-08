package HashTable;

import java.util.ArrayList;

import assignment7.LinkedList;

public class HashTable<K,V> implements Map<K, V> {
	
	private class HTNode implements Comparable<HTNode>{
		K key;
		V value;
		
		HTNode(K key, V value){
			this.key = key;
			this.value = value;
		}

		// No need over here
		public int compareTo(HashTable<K, V>.HTNode arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public boolean equals(Object other){
			HTNode otherNode = (HTNode) other; //typecasting
			return this.key.equals(otherNode.key);
		}
		
		public String toString(){
			return "{ "+this.key+", "+this.value+" }";
		}
	}
	
	private ArrayList<LinkedList<HTNode>> bucketArray;
	private int size;
	public final static int DEFAULT_INITIAL_VALUE = 10;
	
	HashTable(){
		this(DEFAULT_INITIAL_VALUE);
	}
	
	HashTable(int initialSize){
		this.bucketArray = new ArrayList<>();
		
		for(int i=0; i<initialSize; i++){
			this.bucketArray.add(null);
		}
		
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void put(K key, V value) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<HTNode> list = this.bucketArray.get(bucketIndex);
		HTNode node = new HTNode(key, value);
		
		if(list == null){
			this.size++;
			LinkedList<HTNode> newList = new LinkedList<>();
			newList.addFirst(node);
			this.bucketArray.set(bucketIndex, newList);
		}
		else{
			int idx = list.findElement(node);
			if(idx == -1){
				this.size++;
				list.addLast(node);
			}
			else{
				list.getElementAt(idx).value = value;
			}
		}
		double loadFactor = ((1.0)*this.size) / this.bucketArray.size();
		if(loadFactor > 0.75){
			this.rehash();
		}
		
	}

	@Override
	public V get(K key) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<HTNode> list = this.bucketArray.get(bucketIndex);
		HTNode node = new HTNode(key, null);
		
		if(list == null){
			return null;
		}
		else{
			int idx = list.findElement(node);
			if(idx == -1){
				return null;
			}
			else{
				return list.getElementAt(idx).value;
			}
		}
	}

	@Override
	public V remove(K key) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<HTNode> list = this.bucketArray.get(bucketIndex);
		HTNode node = new HTNode(key, null);
		
		if(list == null){
			return null;
		}
		else{
			int idx = list.findElement(node);
			if(idx == -1){
				return null;
			}
			else{
				this.size--;
				V retval = list.getElementAt(idx).value;
				list.removeAt(idx);
				return retval;
			}
		}
	}

	@Override
	public void display() {
		System.out.println(this);
		
	}
	
	public String toString(){
		return this.bucketArray.toString();
	}
	
	private int hashFunction(K key){
		return Math.abs(key.hashCode() % this.bucketArray.size());
	}
	
	private void rehash(){
		ArrayList<LinkedList<HTNode>> temp = this.bucketArray;
		
		// re-initializing state of hash table.
		this.bucketArray = new ArrayList<>();
		for(int i=0; i<2*temp.size(); i++){
			this.bucketArray.add(null);
		}
		this.size = 0;
		
		// putting data back in
		for(int i=0; i<temp.size(); i++){
			LinkedList<HTNode> list = temp.get(i);
			
			while(list != null && !list.isEmpty()){
				HTNode node = list.removeFirst();
				this.put(node.key, node.value);
			}
		}
	}

}
