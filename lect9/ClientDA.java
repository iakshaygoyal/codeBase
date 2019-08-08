package lect9;

public class ClientDA {
	public static void main(String[] args){
		DynamicArray da = new DynamicArray();
		for(int i=0;i<8;i++)
		{
			da.add(i);
		}
//		da.insertAt(100, 5);
		da.removeAt(3);
		da.display();
	}
}
