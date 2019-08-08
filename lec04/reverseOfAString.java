package lec04;

public class reverseOfAString {

	public static void main(String[] args) {
		String s = "akshay";
		System.out.println(s);
		StringBuffer s1 = new StringBuffer(s);
		s1.reverse();
		s = new String(s1);
		System.out.println(s);

	}

}
