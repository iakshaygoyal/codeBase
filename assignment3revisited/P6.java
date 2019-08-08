package assignment3revisited;

import java.util.Scanner;

import lec03.ArrayBasic;
import lec06.Sorts;

public class P6 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter sum :");
		int sum=s.nextInt();
		PAIRS(a,sum);

	}
	public static void PAIRS(int[] a,int sum)
	{
		a=Sorts.MERGE_SORT(a, 0, a.length-1);
		ArrayBasic.PRINT_ARRAY(a);
		int i=0,j=a.length-1;
		while(i<j)
		{
			if(a[i]+a[j]<sum)
				i++;
			else if(a[i]+a[j]>sum)
				j--;
			else
			{
				System.out.println(a[i] + ", " + a[j]);
				i++;
				j--;
			}
		}
	}

}
