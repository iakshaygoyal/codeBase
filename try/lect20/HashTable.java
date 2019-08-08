package lect20;

import java.util.ArrayList;

import lect11.linkedlists.LinkedList;

public class HashTable<K, V> implements Map<K, V> {
	private class HTNode implements Comparable<HTNode> {
		K key;
		V value;

		HTNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object other) {
			HTNode otherNode = (HTNode) other;
			return this.key.equals(otherNode.key);
		}

		// unrequired for hash table (required by linked list)
		public int compareTo(HashTable<K, V>.HTNode o) {
			return 0; // does not matter
		}
	
		public String toString(){
			return "{ " + this.key + ", " + this.value + " }";
		}
	}

	private ArrayList<LinkedList<HTNode>> bucketArray;
	private int size;
	public static final int DEFAULT_INITIAL_BUCKET_SIZE = 10;

	public HashTable() {
		this(DEFAULT_INITIAL_BUCKET_SIZE);
	}

	public HashTable(int initBucketArrayCapacity) {
		this.bucketArray = new ArrayList<>();

		for (int i = 0; i < initBucketArrayCapacity; i++) {
			this.bucketArray.add(null);
		}

		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void put(K key, V value) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<HTNode> linkedList = this.bucketArray.get(bucketIndex);

		HTNode newNode = new HTNode(key, value);

		if (linkedList == null) {
			this.size++;

			LinkedList<HTNode> newList = new LinkedList<>();
			newList.addLast(newNode);
			this.bucketArray.set(bucketIndex, newList);
		} else {
			int findIndex = linkedList.findElement(newNode);
			if (findIndex == -1) {
				this.size++;
				linkedList.addLast(newNode);
			} else {
				linkedList.getElementAt(findIndex).value = newNode.value;
			}
		}

		double loadFactor = (1.0 * this.size()) / this.bucketArray.size();
		if (loadFactor > 0.75) {
			this.rehash();
		}
	}

	public V get(K key) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<HTNode> linkedList = this.bucketArray.get(bucketIndex);

		HTNode newNode = new HTNode(key, null);

		if (linkedList == null) {
			return null;
		} else {
			int findIndex = linkedList.findElement(newNode);
			if (findIndex == -1) {
				return null;
			} else {
				return linkedList.getElementAt(findIndex).value;
			}
		}
	}

	public V remove(K key) {
		int bucketIndex = this.hashFunction(key);
		LinkedList<HTNode> linkedList = this.bucketArray.get(bucketIndex);

		HTNode newNode = new HTNode(key, null);

		if (linkedList == null) {
			return null;
		} else {
			int findIndex = linkedList.findElement(newNode);
			if (findIndex == -1) {
				return null;
			} else {
				V retVal = linkedList.getElementAt(findIndex).value;

				try {
					linkedList.removeAt(findIndex);
					this.size--;
				} catch (Exception ex) {
					// swallow the exception
				}

				return retVal;
			}
		}
	}

	public void display(){
		System.out.println(this);
	}
	
	public String toString(){
		return this.bucketArray.toString();
	}
	
	private int hashFunction(K key) {
		return Math.abs(key.hashCode() % this.bucketArray.size());
	}

	private void rehash() {
		ArrayList<LinkedList<HTNode>> tempArray = this.bucketArray;

		// re-initializing state of hash table.
		this.bucketArray = new ArrayList<>();
		for (int i = 0; i < 2 * tempArray.size(); i++) {
			this.bucketArray.add(null);
		}
		this.size = 0;

		// putting data back in
		for (int i = 0; i < tempArray.size(); i++) {
			LinkedList<HTNode> linkedList = tempArray.get(i);

			while (linkedList != null && !linkedList.isEmpty()) {
				try {
					HTNode node = linkedList.removeFirst();
					this.put(node.key, node.value);
				} catch (Exception ex) {
					// nothing to do here
				}
			}
		}
	}
}
