package lec07;

public class Quicksort {

	public static void main(String[] args) {
//		int[] a={-2,-1,5,4,3,2,1,8,9};
		int[] a={2,3,4,5,0,1,6};
//		int[] a={2,3,4,5,0};
		QUICK_SORT(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);

	}
	
	public static void QUICK_SORT(int[] a,int lo,int hi)
	{
		if(lo>=hi){
			return;
		}
//		int pi=(lo+hi)/2;
//		int pivot=a[pi];
		//Here you cannot use a[0] since we are working on the same array
		int pivot=a[lo];
		int lefti=lo,righti=hi;
		while(lefti<=righti)
		{
			while(a[lefti]<pivot)
				lefti++;
			while(a[righti]>pivot)
				righti--;
			if(lefti<=righti)
			{
				int temp=a[lefti];
				a[lefti]=a[righti];
				a[righti]=temp;
				lefti++;
				righti--;
			}
		}
		QUICK_SORT(a,lo,righti);
		QUICK_SORT(a,lefti,hi);
	}

}
