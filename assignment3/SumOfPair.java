package assignment3;

import java.util.Scanner;

public class SumOfPair {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int[] a=new int[1];
		a=TAKEINPUT();
		PRINTARRAY(a);
		System.out.println("Enter n :");
		int n=s.nextInt();
		SUM_PAIR(a,n);

	}
	public static int[] TAKEINPUT()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		int[] x=new int[n];
		int i;
		int size=x.length;
		for(i=0;i<size;i++)
		{
			System.out.println("Enter "+(i+1)+"th element :");
			x[i]=s.nextInt();
		}
		return x;
	}
	public static void PRINTARRAY(int[] x)
	{
		int i;
		int size=x.length;
		for(i=0;i<size;i++)
		{
			System.out.print(x[i]+"\t");
		}
		System.out.println("\n");
	}
	public static void SUM_PAIR(int[] a,int n)
	{
		int size=a.length;
		int check;
		System.out.println("Pairs :");
		boolean b=true;
		for(int i=0;i<size-1;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(a[i]+a[j]==n)
				{
					System.out.println(a[i]+"\t"+a[j]);
					b=false;
					break;
				}
			}
		}
		if(b==true)
			System.out.println("No Pair");
	}
}
