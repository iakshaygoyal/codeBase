package Heap;

import java.util.Arrays;

public class is {

	public static void main(String[] args) {
		int[] a={5,4,3,2,1,10,5,3};
		System.out.println(Arrays.toString(a));
//		for(int i=1;i<a.length;i++){
//			for(int j=i-1;j>=0;j--){
//				if(a[j+1]<a[j]){
//					int temp=a[j];
//					a[j]=a[j+1];
//					a[j+1]=temp;
//				}
//				else{
//					break;
//				}
//			}
//		}
		int size=a.length;
		 int i, key, j;
		   for (i = 1; i < size; i++)
		   {
		       key = a[i];
		       j = i-1;
		 
		       /* Move elements of A[0..i-1], that are greater than key, to one 
		          position ahead of their current position.
		          This loop will run at most k times */
		       while (j >= 0 && a[j] > key)
		       {
		           a[j+1] = a[j];
		           j = j-1;
		       }
		       a[j+1] = key;
		   }
		System.out.println(Arrays.toString(a));
	}

}
