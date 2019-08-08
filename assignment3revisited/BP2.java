package assignment3revisited;

import java.util.Scanner;

public class BP2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		COMPRESSION(str,1);

	}
	public static void COMPRESSION(String s,int n)
	{
		if(s.length()==1)
		{
			System.out.print(s.charAt(0));
			if(n!=1)
			System.out.print(n);
			return;
		}
		if(s.charAt(0)==s.charAt(1))
		{
			COMPRESSION(s.substring(1),n+1);
		}
		else
		{
			System.out.print(s.charAt(0));
			if(n!=1)
			System.out.print(n);
			COMPRESSION(s.substring(1),1);
		}
	}

}
