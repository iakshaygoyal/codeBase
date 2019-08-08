package Heap;

public interface PriorityQueue<K extends Comparable<K>,V> {
	int size();
	boolean isEmpty();
	void add(K key, V value);
	V remove() throws Exception;
	V get() throws Exception;
	void display();

}
