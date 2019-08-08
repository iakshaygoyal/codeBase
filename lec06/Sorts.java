package lec06;

import lec03.ArrayBasic;
import lec04.Merging;

public class Sorts {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		a=MERGE_SORT(a,0,a.length-1);
		ArrayBasic.PRINT_ARRAY(a);

	}
	public static int[] MERGE_SORT(int[] a,int lo,int hi)
	{
		if(lo==hi){
			return new int[] {a[lo]};
		}
		int mid=(lo+hi)/2;
		int[] a1=MERGE_SORT(a,lo,mid);
		int[] a2=MERGE_SORT(a,mid+1,hi);
		int[] atotal=Merging.MERGING(a1, a2);
		return atotal;
	}

}
