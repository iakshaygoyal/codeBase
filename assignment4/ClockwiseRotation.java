package assignment4;

import lec03.ArrayBasic;

public class ClockwiseRotation {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		int n;
		n=C_R(a);
		System.out.println("Index of Rotation : "+n);
	}
	public static int C_R(int[] a)
	{
		
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i+1]<a[i])
				return i+1;
		}
		return a.length;
	}

}
