package lect9.da;

public class DynamicArray {
	private int[] data;
	private int size;
	
	public static final int DEFAULT_CAPACITY = 16;
	
	public DynamicArray(){
		this(DynamicArray.DEFAULT_CAPACITY);
	}
	
	public DynamicArray(int capacity){
		this.data = new int[capacity];
		this.size = 0;
	}
	
	public void add(int item){
		if(this.size == this.data.length){
			int[] temp = new int[2 * this.data.length];
			
			for(int i = 0; i < this.data.length; i++){
				temp[i] = this.data[i];
			}
			
			this.data = temp;
		}
		
		
		this.data[this.size] = item;
		this.size++;
	}
	
	// TO BE DONE.
	public int removeAt(int idx) throws Exception{
		if(idx < 0 || idx > this.size){
			throw new Exception("invalid argument");
		}
		
		return -1;
	}
	
	// TO BE DONE
	public void display(){
		
	}
	
	// TO BE DONE
	public void insertAt(int item, int idx){
		
	}
}
