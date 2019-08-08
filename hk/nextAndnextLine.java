package hk;

import java.util.Scanner;

public class nextAndnextLine {

	// either use next or use nextline
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String s1 = s.next();
		String s2 = s.next();
		String s3 = s.nextLine();
		
		System.out.println(n);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}

}
