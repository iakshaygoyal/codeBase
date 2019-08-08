package lect19;

public interface PriorityQueue<K extends Comparable<K>, V> {
	void add(K key, V value);
	V remove() throws Exception;
	V get()  throws Exception;
	int size();
	boolean isEmpty();
	void display();
}
