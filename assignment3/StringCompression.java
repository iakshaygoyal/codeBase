package Assignment3;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter string :");
		String x=s.nextLine();
		COMPRESSION(x);

	}
	public static void COMPRESSION(String s)
	{
		int prev,curr;
		int n=1;
		for(prev=0,curr=1;curr<s.length();prev++,curr++)
		{
			if(s.charAt(prev)!=s.charAt(curr))
			{
				System.out.print(s.charAt(prev));
				if(n!=1)
				{
					System.out.print(n);
					n=1;
				}
			}
			else
			n++;
		}
		System.out.print(s.charAt(prev));
		if(n!=1)
			System.out.print(n);
	}
}
