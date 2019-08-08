package collections;
import java.util.*;
public class lists {
	
	//REMOVE METHOD ONLY REMOVES THE FIRST OCCURENCE OF A GIVEN ELEMANT

	public static void main(String[] args) {
		ArrayList<Integer> list1=new ArrayList<>();
//		LinkedList<Integer> list1 =new LinkedList<>();
//		Vector<Integer> list1=new Vector<>();
		list1.add(1);
		list1.add(4);
		list1.add(2);
		list1.add(7);
		list1.add(6);
		list1.add(4);
		list1.add(17);
		list1.add(61);
		list1.add(4);
		System.out.println(list1);
		list1.remove((Object)4);
		System.out.println(list1);
	}

}
