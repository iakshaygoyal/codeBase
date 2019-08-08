package assignment3revisited;

import java.util.Scanner;

public class PowerModified {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter x :");
		int x=s.nextInt();
		System.out.println("Enter n :");
		int n=s.nextInt();
		int power=POWER(x,n);
		System.out.println(power);
		

	}
	public static int POWER(int x,int n)
	{
		if(n==0)
			return 1;
		if(n%2==0)
		{
			int y=POWER(x,n/2);
			return y*y;
		}
		else
		{
			int y=POWER(x,n/2);
			return y*y*x;
		}
	}

}
