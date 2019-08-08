package bootcamp.strings;
import java.util.*;
import java.lang.*;
public class stringBuilderClass {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		//(NO NEED TO SAVE THE STRING HERE AS THE ORIGINAL STRING GOT MODIFIED UNLIKE STRING CLASS(SINCE THIS CLASS IS MUTABLE))
		
		//(MUTABLE AND APPEND)
		StringBuilder sb1=new StringBuilder("Akshay");
		System.out.println(sb1);
		StringBuilder sb2=sb1;
		sb2.append("goyal");
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println();
		
		
		//INSERT
		sb1.insert(3, "great");
		System.out.println(sb1);
		
		//(REPLACE AND DELETE)
		sb1=new StringBuilder("elephant");
		sb1.replace(1, 3, "hi");

		System.out.println(sb1);
		sb1.delete(1,3);
		System.out.println(sb1);
		System.out.println();
		
		
		//REVERSE
		sb1.reverse();
		System.out.println(sb1);
		System.out.println();
		
		//CAPACITY AND LENGTH
		System.out.println(sb1.capacity());
		System.out.println(sb1.length());
		System.out.println();
		
		//CHARAT
		System.out.println(sb1.charAt(4));
		System.out.println();
		}

}
