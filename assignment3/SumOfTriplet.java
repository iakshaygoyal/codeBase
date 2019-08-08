package Assignment3;

import java.util.Scanner;

public class SumOfTriplet {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int[] a=new int[1];
		a=TAKEINPUT();
		PRINTARRAY(a);
		System.out.println("Enter n :");
		int n=s.nextInt();
		SUM_TRIPLET(a,n);
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
	public static void SUM_TRIPLET(int[] a,int n)
	{
		boolean b=true;
		System.out.println("Triplets : ");
		for(int i=0;i<a.length-2;i++)
		{
			for(int j=i+1;j<a.length-1;j++)
			{
				for(int k=i+2;k<a.length;k++)
				{
					if(a[i]+a[j]+a[k]==n)
					{
						System.out.println(a[i]+"\t"+a[j]+"\t"+a[k]);
						b=false;
						break;
					}
				}
			}
		}
		if(b==true)
			System.out.println("No Triplets");
	}
}
