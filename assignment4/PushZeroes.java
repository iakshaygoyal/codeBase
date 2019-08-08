package Assignment4;

import lec03.ArrayBasic;

public class PushZeroes {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		PUSH_ZEROES(a);
		ArrayBasic.PRINT_ARRAY(a);
	}
	public static void PUSH_ZEROES(int[] a)
	{
		int i,j,zero=0;
		for(i=0;i<a.length;i++)
		{
			if(a[i]==0)
				zero++;
		}
		for(i=0;i<a.length-zero;i++)
		{
			if(a[i]==0)
			{
				for(j=i;j<a.length-1;j++)
				a[j]=a[j+1];
				a[j]=0;
				i--;
			}
		}
	}

}
