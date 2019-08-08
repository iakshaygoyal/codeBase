package lec03;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=s.nextInt();
		boolean b;
		b=PRIME(n);
		if(b==true)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
	}
	public static boolean PRIME(int n)
	{
		int i=2;
		while(i<n)
		{
			if(n%i==0)
			{
				return false;
			}
			i++;
		}
		return true;
	}

}
