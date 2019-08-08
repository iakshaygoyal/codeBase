package assignment5;

import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter String :");
		String x=s.nextLine();
		boolean b=PALINDROME(x,0);
		if(b==true)
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");

	}
	public static boolean PALINDROME(String s,int i)
	{
		if(i>=(s.length()/2))
			return true;
		if(s.charAt(i)!=s.charAt(s.length()-1-i))
			return false;
		return PALINDROME(s,i+1);
	}

}
