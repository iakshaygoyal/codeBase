package Assignment3;

import java.util.Scanner;

public class imp4 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no. of characters : ");
		int n=s.nextInt();
		char[] a=new char[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter character :");
			a[i]=s.next().charAt(0);
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+", ");
		}
	}

}
