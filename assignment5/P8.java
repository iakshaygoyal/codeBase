package assignment5;

import java.util.Scanner;

public class P8 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		int c=COUNT(n);
		System.out.println(c);

	}
	public static int COUNT(int n)
	{
		if(n==0)
			return 0;
		int v=COUNT(n/10);
		v=v+(n%10);
		return v;
	}

}
