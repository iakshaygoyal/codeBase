package lec03;

import java.util.Scanner;

public class ArrayBasic {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int[]a;
//		int[] b=new int[] {1,2,3};
//		PRINT_ARRAY(b);
//		System.out.println(b.length);
		a=TAKE_INPUT();
		PRINT_ARRAY(a);
		/*int largest;
		largest=LARGEST(a);
		System.out.println("Largest Element : "+largest);
		System.out.println("Enter item to be searched : ");
		int item=s.nextInt();
		int index;
		index=SEARCH(a,item);
		System.out.println("Index : "+index);
		REVERSE(a);
		System.out.println("Reverse :");
		PRINT_ARRAY(a);
		*/
		System.out.println("Sorted :");
//		BUBBLE_SORT(a);
//		SELECTION_SORT(a);
//		INSERTION_SORT(a);
//		R_B_S(a,1);
		
		REC_B_S(a,0,a.length-1);
		PRINT_ARRAY(a);
	}
	public static int[] TAKE_INPUT()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no. of elements : ");
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter "+(i+1)+" th element : ");
			a[i]=s.nextInt();
		}
		return a;
	}
	public static void PRINT_ARRAY(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ,");
		}
		System.out.println("END");
	}
	public static int LARGEST(int[] a)
	{
		int largest=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(largest<a[i])
				largest=a[i];
		}
		return largest;
	}
	public static int SEARCH(int[] a,int item)
	{
		int index=-1;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==item)
			{
				index=i;
				break;
			}
		}
		return index;
	}
	public static void REVERSE(int[] a)
	{
		for(int i=0;i<(a.length/2);i++)
		{
			int temp=a[i];
			a[i]=a[a.length-1-i];
			a[a.length-1-i]=temp;
		}
	}
	public static void SWAP(int[] a,int fi,int si)
	{
		int temp=a[fi];
		a[fi]=a[si];
		a[si]=temp;
	}
	public static void BUBBLE_SORT(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-1-i;j++)
			{
				if(a[j]>a[j+1])
				SWAP(a,j,j+1);
			}
		}
	}
	public static void SELECTION_SORT(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				SWAP(a,i,j);
			}
		}
	}
	public static void INSERTION_SORT(int[] a)
	{
		for(int i=1;i<a.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(a[j-1]>a[j])
					SWAP(a,j-1,j);
				else
					break;
			}
		}
	}
	public static void R_B_S(int[] a,int counter)
	{
		if(counter==a.length)
			return;
		for(int i=0;i<a.length-counter;i++)
		{
			if(a[i]>a[i+1])
				SWAP(a,i,i+1);
		}
		R_B_S(a,counter+1);
	}
	public static void REC_B_S(int[] a,int si,int li)
	{
		if(li==0)
			return;
		else
			{
			if(si==li)
			{
				REC_B_S(a,0,li-1);
			}
			else
			{
				if(a[si]>a[si+1])
					SWAP(a,si,si+1);
				REC_B_S(a,si+1,li);
			}
		}
	}
}
