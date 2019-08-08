package lect9;

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
	public int removeAt(int idx){
		if(idx<0 || idx>=this.size)
			return -1;
		int t=this.data[idx];
		for(int i=idx;i<this.size-1;i++)
		{
			this.data[i]=this.data[i+1];
		}
		this.size--;
		if(this.size==this.data.length/4)
		{
			int [] temp=new int[this.data.length/2];
			for(int i=0;i<this.size;i++){
				temp[i]=this.data[i];
			}
			this.data=temp;
		}
		return t;
	}
	
	// TO BE DONE
	public void display(){
		for(int i=0;i<this.size;i++)
			System.out.println(this.data[i]);
	}
	
	// TO BE DONE
	public void insertAt(int item, int idx){
		if(this.size==this.data.length){
			int [] temp=new int[2*this.data.length];
			for(int i=0;i<this.data.length;i++){
				temp[i]=this.data[i];
			}
			this.data=temp;
		}
		for(int i=this.size-1;i>=idx;i--){
			this.data[i+1]=this.data[i];
		}
		this.data[idx]=item;
		this.size++;
	}
}
