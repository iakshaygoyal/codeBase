package again;

import lec03.ArrayBasic;

public class recursiveBubbleSort {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		ArrayBasic.PRINT_ARRAY(a);
		recursiveBubbleSort(a, 0, a.length-1);
		ArrayBasic.PRINT_ARRAY(a);

	}
	
	public static void recursiveBubbleSort(int[] a, int fi, int li){
		if(li==0){
			return;
		}
		if(fi<li){
			if(a[fi]>a[fi+1]){
				int temp=a[fi];
				a[fi]=a[fi+1];
				a[fi+1]=temp;
			}
			recursiveBubbleSort(a, fi+1, li);
		}
		else{
			recursiveBubbleSort(a, 0, li-1);
		}
	}

}
