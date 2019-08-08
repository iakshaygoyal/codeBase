package lec04;

import lec03.ArrayBasic;

public class Merging {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		int[] b=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(b);
		int[] c=MERGING(a,b);
		ArrayBasic.PRINT_ARRAY(c);
	}
	public static int[] MERGING(int[] a,int[] b)
	{
		int[] c=new int[a.length+b.length];
		int i=0,j=0,k=0;
		ArrayBasic.BUBBLE_SORT(a);
		ArrayBasic.BUBBLE_SORT(b);
		while(i<a.length && j<b.length)
		{
			if(a[i]<=b[j])
			{
				c[k]=a[i];
				i++;
				k++;
			}
			else
			{
				c[k]=b[j];
				j++;
				k++;
			}
		}
		while(i<a.length)
		{
			c[k]=a[i];
			i++;
			k++;
		}
		while(j<b.length)
		{
			c[k]=b[j];
			j++;
			k++;
		}
		return c;
	}

}
