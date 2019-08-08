import java.util.Scanner;

public class mergesort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println("END");
		arr = mergeSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println("END");
	}

	public static int[] mergeSort(int[] arr, int si, int ei){
		if(si == ei){
			int[] retval = new int[1];
			retval[0] = arr[si];
			return retval;
		}
		int mi = (si + ei)/2;
		int[] left = mergeSort(arr, si, mi);
		int[] right = mergeSort(arr, mi+1, ei);
		int[] retval = merge(left, right);
		return retval;
	}
	
	public static int[] merge(int[] arr1, int[] arr2){
		int[] arr3 = new int[arr1.length + arr2.length];
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i] < arr2[j]){
				arr3[k++]=arr1[i++];
			}
			else{
				arr3[k++]=arr2[j++];
			}
		}
		while(i<arr1.length){
			arr3[k++]=arr1[i++];
		}
		while(j<arr2.length){
			arr3[k++]=arr2[j++];
		}
		return arr3;
		
	}
}
