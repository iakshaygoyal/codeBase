package assignment4revisited;

import lec03.ArrayBasic;

public class P3 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		ZEROES_ONES(a);
		ArrayBasic.PRINT_ARRAY(a);

	}
	public static void ZEROES_ONES(int[] a)
	{
		int i=0,j=a.length-1;
		while(i<j)
		{
			if(a[i]==1 && a[j]==0)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
			else if(a[i]==0)
				i++;
			else
				j--;
		}
	}

}
