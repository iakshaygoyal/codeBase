package BST;

import java.util.ArrayList;

public class imp {

	public static void main(String[] args) {
	
		f(new ArrayList<Integer>(), 5, "");

	}
	
	public static void f(ArrayList<Integer> list, int i, String s){
		if(i == 0){
			return;
		}
		
		list.add(i);
		s+=i+", ";

		
		f(list, i-1, s);
		System.out.println(list);
		
		System.out.println(s);
	}

}
