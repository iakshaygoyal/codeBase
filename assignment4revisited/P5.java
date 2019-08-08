package assignment4revisited;

import lec03.ArrayBasic;

public class P5 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		int d=DUPLICATE(a);
		System.out.println(d);

	}
	public static int DUPLICATE(int[] a)
	{
		int n=a.length;
		int s1=(n)*(n-1)/2;
		int s2=0;
		for(int i=0;i<n;i++)
			s2=s2+a[i];
		int duplicate=(n-1)-(s1-s2);
		return duplicate;
	}

}
