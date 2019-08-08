package assignment5;

import java.util.Scanner;

public class Imp1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String s1="hello world";
		String s2="bye";
		String s3=s1+s2.charAt(1)+")";
		String s4=s1+s1.charAt(0);
		System.out.println(s4);
		System.out.println(s3);
		System.out.println(s2);
		System.out.println(s1);	
		s3=s1.concat(s2);
		System.out.println(s3);
	}

}
