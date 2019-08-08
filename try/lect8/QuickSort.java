package lect8;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1, 5, 4, 3, 2, 1, 6, 8, 9};
		quickSort(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if(lo >= hi){
			return;
		}
		
		int pi = (lo + hi) / 2;
		int pivot = arr[pi];

		int leftI = lo, rightI = hi;
		while (leftI <= rightI) {
			while (arr[leftI] < pivot) {
				leftI++;
			}

			while (arr[rightI] > pivot) {
				rightI--;
			}

			if (leftI <= rightI) {
				int temp = arr[leftI];
				arr[leftI] = arr[rightI];
				arr[rightI] = temp;

				leftI++;
				rightI--;
			}
		}
		
		quickSort(arr, lo, rightI);
		quickSort(arr, leftI, hi);
	}

}
