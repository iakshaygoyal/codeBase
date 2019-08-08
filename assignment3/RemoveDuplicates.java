package Assignment3;

import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string :");
		String s=sc.nextLine();
		REMOVE_DUPLICATES(s);

	}
	public static void REMOVE_DUPLICATES(String s)
	{
		int prev,curr;
		for(prev=0,curr=1;curr<s.length();prev++,curr++)
		{
			if(s.charAt(prev)!=s.charAt(curr))
			System.out.print(s.charAt(prev));
		}
		System.out.print(s.charAt(prev));
	}

}
