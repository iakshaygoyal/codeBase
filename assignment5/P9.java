package assignment5;

import java.util.Scanner;

public class P9 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter String 1 :");
		String s1=s.nextLine();
		System.out.println("Enter string 2 :");
		String s2=s.nextLine();
		boolean b=false;
		if(s1.length()==s2.length())
			b=CHECK(s1,s2,0);
		if(b==true)
			System.out.println("Reverse");
		else
			System.out.println("Not Reverse");
	}
	public static boolean CHECK(String s1,String s2,int i)
	{
		if(i==s1.length()/2)
			return true;
		if(s1.charAt(i)!=s2.charAt(s2.length()-1-i))
			return false;
		return CHECK(s1,s2,i+1);
	}

}
