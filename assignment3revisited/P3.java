package assignment3revisited;

import java.util.Scanner;

public class P3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		NO_DUPLICATES(str);

	}
	public static void NO_DUPLICATES(String s)
	{
		if(s.length()==1)
		{
			System.out.print(s.charAt(0));
			return;
		}
		if(s.charAt(0)==s.charAt(1))
		{
			NO_DUPLICATES(s.substring(1));
		}
		else
		{
			System.out.print(s.charAt(0));
			NO_DUPLICATES(s.substring(1));
		}
	}

}
