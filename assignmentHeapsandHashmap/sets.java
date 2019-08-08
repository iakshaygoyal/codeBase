package assignmentHeapsandHashmap;

import java.util.HashSet;
import java.util.Set;

public class sets {

	public static void main(String[] args){
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(4);
		System.out.println(set.toString());
		set.remove(2);
		System.out.println(set.toString());
	}
}
