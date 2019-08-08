package assignment3revisited;

import lec03.ArrayBasic;
import lec06.Sorts;

public class P2 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		int[] b=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(b);
		INTERSECTION(a,b);

	}
	public static void INTERSECTION(int[] a,int[] b)
	{
		a=Sorts.MERGE_SORT(a, 0, a.length-1);
		b=Sorts.MERGE_SORT(b, 0, b.length-1);
		ArrayBasic.PRINT_ARRAY(a);
		ArrayBasic.PRINT_ARRAY(b);
		int i=0,j=0;
		while(i<a.length && j<b.length)
		{
			if(a[i]==b[j])
			{
				System.out.println(a[i]);
				i++;
				j++;
			}
			else if(a[i]>b[j])
				j++;
			else
				i++;
		}
		
	}

}
