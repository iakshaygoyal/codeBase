package Assignment3;

import java.util.Scanner;

public class imp1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string : ");
		String s=sc.nextLine();
		s.charAt(0)='a';
		System.out.println(s);
	}

}
