package assignment4revisited;

import lec03.ArrayBasic;

public class P1 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		PUSH_ZEROES(a);
		ArrayBasic.PRINT_ARRAY(a);

	}
	public static void PUSH_ZEROES(int[] a)
	{
		int z=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==0)
				z++;
			else
				a[i-z]=a[i];
		}
		for(int i=a.length-1;i>a.length-1-z;i--)
			a[i]=0;
	}

}
