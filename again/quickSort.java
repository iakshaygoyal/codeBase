package again;

import java.util.Arrays;

public class quickSort {

	public static void main(String[] args) {
		int[] a = new int[]{3,6,5,8,9,1,2,0,4,5,9,-2,-4,10,3};
//		int[] a={3,8,1,9,2,4};
//		quickSort(a, 0, a.length-1);
//		for(int val : a){
//			System.out.print(val + " ");
//		}
		quickSortRec(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	//here after one complete loop we r not placing the pivot at the correct place but actually we r dividing the array in two parts
	//(ONE HAVING SMALLER ELEMENTS AS COMPARED TO PIVOT AND OTHER WITH ELEMENTS LARGER THEN PIVOT)
	public static void quickSort(int[] a, int lo, int hi){
		if(lo >= hi){
			return;
		}
		
		int pivot = a[lo];
		int lefti = lo;
		int righti = hi;
		
		while(lefti <= righti){
			while(a[lefti] < pivot){
				lefti++;
			}
			while(a[righti] > pivot){
				righti--;
			}
			
			if(lefti <= righti){
				int temp = a[lefti];
				a[lefti] = a[righti];
				a[righti] = temp;
				lefti++;
				righti--;
			}
		}
		quickSort(a, lo, righti);
		quickSort(a, lefti, hi);
	}
	
	
	//RECURSIVE APPROACH(USE THIS)
	
	
	public static void quickSortRec(int[] a,int lo,int hi){
		if(lo<hi){
			int pi=partition(a, lo, hi);
			quickSortRec(a, lo, pi-1);
			quickSortRec(a, pi+1, hi);
		}
	}
	
	
	//PLACES THE PIVOT AT ITS CORRECT POSITION AND THE ELEMENTS SMALLER THEN THE PIVOT IN THE LEFT AND LARGER THEN THE PIVOT IN THE RIGHT
	public static int partition(int[] a,int lo,int hi){
		int pivot=a[hi];
		int j=lo;
		for(int i=lo;i<hi;i++){
			if(a[i]<=pivot){
				swap(a,i,j);
				j++;
			}
		}
		swap(a,j,hi);
		return j;
	}
	
	public static void swap(int[] a,int fi,int si){
		int temp=a[fi];
		a[fi]=a[si];
		a[si]=temp;
	}

}
