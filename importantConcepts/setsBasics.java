package importantConcepts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class setsBasics {

	public static void main(String[] args) {
		Set<Integer> s=new HashSet<>();//random ordering
//		Set<Integer> s=new TreeSet<>();//sorted ordering
//		Set<Integer> s=new LinkedHashSet<>();//ordering based on insertion
//		if(s.isEmpty()){
//			System.out.println("EMPTY");
//		}
//		else{
//			System.out.println("NOT EMPTY");
//		}
		System.out.println("size : "+s.size());
		s.add(2);
		s.add(7);
		s.add(1);
		s.add(3);
		s.add(5);
		s.add(2);
		s.add(9);
		s.add(10);
		s.add(21);
		s.add(61);
		s.add(71);
		s.add(24);
		s.add(19);
		System.out.println(s);
//		s.remove(91);
//		s.remove(7);
//		System.out.println(s);
//		if(s.isEmpty()){
//			System.out.println("EMPTY");
//		}
//		else{
//			System.out.println("NOT EMPTY");
//		}
//		System.out.println("size : "+s.size());
		
		
		
		
		//MODIFING A COLLECTION WHILE ITERATING
		
		
		
	
		Iterator<Integer> it=s.iterator();
		while(it.hasNext()){
			if(it.next()%2==0){
				it.remove();
			}
		}
		System.out.println(s);
		
		
		
		
		
		
		
		Set<String> s1= new HashSet<>();
		s1.add("ab");
		s1.add("zs");
		s1.add("ds");
		s1.add("rp");
		s1.add("cg");
		s1.add("am");
		s1.add("lo");
		s1.add("am");
		System.out.println(s1);
	}

}
