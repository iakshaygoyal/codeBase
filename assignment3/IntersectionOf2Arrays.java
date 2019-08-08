package Assignment3;

import java.util.Scanner;

public class IntersectionOf2Arrays {

	public static void main(String[] args) {
		int[] a;
		int[] b;
		a=TAKEINPUT();
		PRINTARRAY(a);
		b=TAKEINPUT();
		PRINTARRAY(b);
		INTERSECTION(a,b);
	}
	public static int[] TAKEINPUT()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		int[] x=new int[n];
		for(int i=0;i<x.length;i++)
		{
			System.out.println("Enter "+(i+1)+"th element :");
			x[i]=s.nextInt();
		}
		return x;
	}
	public static void PRINTARRAY(int[] x)
	{
		for(int i=0;i<x.length;i++)
		{
			System.out.print(x[i]+"\t");
		}
		System.out.println("\n");
	}
	public static void INTERSECTION(int[] a,int[] b)
	{
		int check;
		boolean c=false;
		System.out.println("Intersection : ");
		for(int i=0;i<a.length;i++)
		{
			check=a[i];
			for(int j=0;j<b.length;j++)
			{
				if(a[i]==b[j])
				{
					System.out.print(a[i]+"\t");
					c=true;
					break;
				}
			}
		}
		if(c==false)
			System.out.println("No Intersection");
	}
}
