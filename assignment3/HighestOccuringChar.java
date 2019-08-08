package Assignment3;

import java.util.Scanner;

public class HighestOccuringChar {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter string :");
		String x=s.nextLine();
		H_O_C(x);

	}
	public static void H_O_C(String s)
	{
		int n=0,num=0;
		char c,chr = 0;
		for(int i=0;i<s.length();i++)
		{
			n=1;
			c=s.charAt(i);
			for(int j=i+1;j<s.length();j++)
			{
				if(s.charAt(j)==c)
				n++;
			}
			if(n>num)
			{
				chr=c;
				num=n;
			}
		}
		System.out.println("Character : "+chr);
		System.out.println("Number of times : "+num);
	}

}
