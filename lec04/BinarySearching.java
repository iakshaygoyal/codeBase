package lec04;

import java.util.Scanner;

import lec03.ArrayBasic;

public class BinarySearching {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		Scanner s=new Scanner(System.in);
		System.out.println("Enter item to be searched : ");
		int item=s.nextInt();
		int index;
		index=BINARY_SEARCH(a,item);
		System.out.println("Index : "+index);
	}
	public static int BINARY_SEARCH(int[] a,int item)
	{
		ArrayBasic.BUBBLE_SORT(a);
		ArrayBasic.PRINT_ARRAY(a);
		int start,end,middle;
		start=0;
		end=a.length-1;
		int retval=-1;
		while(start<=end)
		{
			middle=(start+end)/2;
			if(a[middle]==item)
			{
				retval=middle;
				break;
			}
			else if(a[middle]<item)
			{
				start=middle+1;
			}
			else
				end=middle-1;
		}
		return retval;
	}

}
