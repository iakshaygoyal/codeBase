package lect11;

public class DynamicArray<T> {
	private T[] data;
	private int size;
	
	public static final int DEFAULT_CAPACITY = 16;
	
	public DynamicArray(){
		this(DynamicArray.DEFAULT_CAPACITY);
	}
	
	public DynamicArray(int capacity){
		this.data = (T[])new Object[capacity];
		this.size = 0;
	}
	
	public void add(T item){
		if(this.size == this.data.length){
			T[] temp = (T[])new Object[2 * this.data.length];
			
			for(int i = 0; i < this.data.length; i++){
				temp[i] = this.data[i];
			}
			
			this.data = temp;
		}
		
		
		this.data[this.size] = item;
		this.size++;
	}
	
	// TO BE DONE.
	public T removeAt(int idx) throws Exception{
		if(idx < 0 || idx > this.size){
			throw new Exception("invalid argument");
		}
		
		return null;
	}
	
	// TO BE DONE
	public void display(){
		
	}
	
	// TO BE DONE
	public void insertAt(T item, int idx){
		
	}
	
	public int compareAverages(DynamicArray<?> other){
		return 0;
	}
}
