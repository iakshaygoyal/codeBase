package assignment3;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a=new int[1];
		a=TAKEINPUT();
		PRINTARRAY(a);
		BUBBLE_SORT(a);
		PRINTARRAY(a);
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
	public static void BUBBLE_SORT(int[] a)
	{
		int temp;
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				if(a[j+1]<a[j])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
}
