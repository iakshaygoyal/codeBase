package Assignment3;

import java.util.Scanner;

public class SumOf2Arrays {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int[] a=new int[1];
	int[] b=new int[1];
	a=TAKEINPUT();
	PRINTARRAY(a);
	b=TAKEINPUT();
	PRINTARRAY(b);
	int sum1,sum2;
	sum1=SUM(a);
	sum2=SUM(b);
	System.out.println("SUM : "+(sum1 + sum2));
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
	public static int SUM(int[] a)
	{
		int i,sum=0;
		int size=a.length;
		for(i=0;i<size;i++)
		{
			sum=sum*10+a[i];
		}
		return sum;
	}
}
