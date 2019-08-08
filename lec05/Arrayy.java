package lec05;

import java.util.Scanner;

import lec03.ArrayBasic;

public class Arrayy {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
//		boolean b=CONTAINS(a,n);
//		if(b==true)
//			System.out.println("Present");
//		else
//			System.out.println("Not Present");
//		int index=FIRST_INDEX(a,0,n);
//		System.out.println("Index : "+index);
		
//		int index=LAST_INDEX(a,0,n);
//		System.out.println("Index : "+index);
		ALL_INDICES(a,0,n);
//		int[] b=ALL_INDEX(a,0,n);
//		ArrayBasic.PRINT_ARRAY(b);
	}
	public static boolean CONTAINS(int[] a,int n)
	{
		if(a.length==0)/*Base Case*/
			return false;
		if(a[0]==n)
			return true;
		int[] b=new int[a.length-1];
		for(int i=0;i<b.length;i++)
		{
			b[i]=a[i+1];
		}
		return CONTAINS(b,n);
	}
	public static int FIRST_INDEX(int[] a,int i,int n)
	{
		if(i==a.length)
			return -1;
		if(a[i]==n)
			return i;
		return FIRST_INDEX(a,i+1,n);
	}

	public static int LAST_INDEX(int[] a,int i,int n)
	{
		if(i==a.length)
			return -1;
		int j=LAST_INDEX(a,i+1,n);
		if(j==-1){
		if(a[i]==n)
			return i;
		}
		return j;
	}
	public static void ALL_INDICES(int[] a,int i,int n)
	{
		if(i==a.length)
			return ;
		if(a[i]==n)
			System.out.println(i);
		ALL_INDICES(a,i+1,n);
	}
	public static int[] ALL_INDEX(int[] a,int i,int n)
	{
		if(i==a.length)
		{
			return new int[0];
		}
		int[] b=ALL_INDEX(a,i+1,n);
		if(a[i]==n)
		{
			int[] temp=new int[b.length+1];
			temp[0]=i;
			for(int j=0;j<b.length;j++)
				temp[j+1]=b[j];
			b=temp;
		}
		return b;
	}
	
}
