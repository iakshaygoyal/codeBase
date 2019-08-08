package lec04;

public class StringBufferClass {

	public static void main(String[] args) {
		
		//Mutable & append
		StringBuffer s1 = new StringBuffer("hello");
		StringBuffer s2 = s1;
		s1.append("Java");
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println();
		
		//Insert
		StringBuffer s3 = new StringBuffer("great");	
		s3.insert(2, "Java");
		System.out.println(s3);
		
		System.out.println();
		
		//Reverse
		s3.reverse();
		System.out.println(s3);
		
		System.out.println();
		
		//setCharAt
		s3.setCharAt(3, 'c');
		System.out.println(s3);
		
		//deleteCharAt
		s3.deleteCharAt(3);
		System.out.println(s3);
	}

}
