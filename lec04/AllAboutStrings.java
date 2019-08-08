package lec04;

import java.util.Scanner;

public class AllAboutStrings {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter String :");
//		String s=sc.nextLine();
//		System.out.println("String : "+s);
//		PRINT_CHARS(s);
//		boolean b;
//		b=PALINDROME(s);
//		if(b==true)
//			System.out.println("Palindrome");
//		else
//			System.out.println("Not a Palindrome");
//		SUB_STRINGS(s);
		System.out.println(COUNT_PALINDROME("cbbcbc"));

	}
//	public static void PRINT_CHARS(String s)
//	{
//		for(int i=0;i<s.length();i++)
//			System.out.println(s.charAt(i));
//	}
//	public static boolean PALINDROME(String s)
//	{
//		boolean b=true;
//		for(int i=0;i<(s.length()/2);i++)
//		{
//			if(s.charAt(i)!=s.charAt((s.length()-1-i)))
//			{
//				b=false;
//				break;
//			}
//		}
//		return b;
//	}
//	public static void SUB_STRINGS(String s)
//	{
//		for(int i=0;i<s.length();i++)
//		{
//			for(int j=i+1;j<s.length()+1;j++)
//			{
//				System.out.println(s.substring(i,j));
//			}
//		}
//	}
	public static int COUNT_PALINDROME(String s)
	{
		int np=0;
		//for odd length palindrome
		for(int i=0;i<s.length();i++)
		{
			int j=0;
			while(i-j>=0 && i+j<s.length() && s.charAt(i-j)==s.charAt(i+j))
			{
				np++;
				j++;
			}
		}
		//for even length palindrome
		for(int i=1;i<s.length();i++)
		{
			int j=1;
			while(i-j>=0 && i+j-1<s.length() && s.charAt(i-j)==s.charAt(i+j-1))
			{
				np++;
				j++;
			}
		}
		return np;
	}

}
