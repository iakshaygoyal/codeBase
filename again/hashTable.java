package again;

import java.util.ArrayList;

import HashTable.Map;
import assignment7.LinkedList;

public class hashTable<K,V> implements Map<K, V> {
	
	private class HTNode implements Comparable<HTNode>{
		K key; 
		V value;
		
		public HTNode(K key, V value){
			this.key=key;
			this.value=value;
		}

		@Override
		public int compareTo(hashTable<K, V>.HTNode arg0) {
			return 0;
		}
		
		public boolean equals(Object obj){
			HTNode curentNode = (HTNode) obj;
			return this.key.equals(curentNode.key);
		}
		
		public String toString(){
			return "{ "+this.key+", "+this.value+" }";
		}
	}
	private ArrayList<LinkedList<HTNode>> bucketArray;
	private int size;
	public static int DEFAULT_INITIAL_VALUE=10;
	
	public hashTable(){
		this(hashTable.DEFAULT_INITIAL_VALUE);
	}
	
	public hashTable(int capacity){
		this.bucketArray = new ArrayList<>();
		for(int i=0; i<capacity; i++){
			bucketArray.add(null);
		}
		this.size=0;
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
		HTNode newNode = new HTNode(key, value);
		
		if(list == null){
			this.size++;
			LinkedList<HTNode> newList = new LinkedList<>();
			newList.addFirst(newNode);
			this.bucketArray.set(bucketIndex, newList);
		}
		else{
			int idx = list.findElement(newNode);
			if(idx == -1){
				this.size++;
				list.addLast(newNode);
			}
			else{
				list.getElementAt(idx).value = newNode.value;
			}
		}
		
		double loadFactor = ((1.0)*this.size)/this.bucketArray.size();
		if(loadFactor > 0.75){
			this.rehash();
		}
		
	}
	
	private void rehash(){
		ArrayList<LinkedList<HTNode>> temp = this.bucketArray;
		
		this.bucketArray = new ArrayList<>();
		for(int i=0; i<2*temp.size(); i++){
			this.bucketArray.add(null);
		}
		this.size=0;
		
		for(int i=0; i<temp.size(); i++){
			LinkedList<HTNode> list = temp.get(i);
			
			if(list != null){
				while(!list.isEmpty()){
					HTNode node = list.removeFirst();
					this.put(node.key, node.value);
				}
			}
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
	
	public int hashFunction(K key){
		return Math.abs(key.hashCode() % this.bucketArray.size());
	}



}
