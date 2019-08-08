package HashTable;

public interface Map<K,V> {
	int size();
	boolean isEmpty();
	void put(K key, V value);
	V get(K key);
	V remove(K key);
	void display();

}
