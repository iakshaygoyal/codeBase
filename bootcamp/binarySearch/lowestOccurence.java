package bootcamp.binarySearch;

import java.util.Scanner;

public class lowestOccurence {

	public static void main(String[] args) {
		int[] a=new int[]{1,2,3,3,3,3,4,5,6,7,8,8,9};
		System.out.println(lowestIndex(a, 3));
	}
	
	public static int lowestIndex(int[] a,int value){
		int lo=0;
		int hi=a.length-1;
		int retval=-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			if(a[mid]==value){
				retval=mid;
				hi=mid-1;
			}
			else if(a[mid]<value){
				lo=mid+1;
			}
			else{
				hi=mid-1;
			}
		}
		return retval;
	}

}
