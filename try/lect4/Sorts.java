package lect4;

import lect3.*;

public class Sorts {

	public static void main(String[] args) {
		// int[] arr = ArraysDemo.TakeInput();
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

		// selectionSort(arr);
		insertionSort(arr);

		System.out.println(binarySearch(arr, 1));

		ArraysDemo.printArray(arr);

		int[] a1 = { 1, 3, 5, 7 }, a2 = { 2, 3, 6, 8, 10, 12, 14 };
		int[] a3 = mergeTwoSortedArrays(a1, a2);

		ArraysDemo.printArray(a3);
	}

	public static void selectionSort(int[] xyz) {
		for (int i = 0; i < xyz.length - 1; i++) {
			for (int j = i + 1; j < xyz.length; j++) {
				if (xyz[i] > xyz[j]) {
					ArraysDemo.swapArrayItems(xyz, i, j);
				}
			}
		}
	}

	public static void insertionSort(int[] xyz) {
		for (int i = 1; i < xyz.length; i++) {
			// for(int j = i; j > 0; j--){
			// if(xyz[j - 1] > xyz[j]){
			// ArraysDemo.swapArrayItems(xyz, j - 1, j);
			// }
			// else{
			// break;
			// }
			// }

			for (int j = i; j > 0 && xyz[j - 1] > xyz[j]; j--) {
				ArraysDemo.swapArrayItems(xyz, j - 1, j);
			}
		}
	}

	public static int binarySearch(int[] arr, int num) {
		int retVal = -1;

		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (arr[mid] == num) {
				retVal = mid;
				break;
			} else if (arr[mid] > num) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		return retVal;
	}

	public static int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];

		int i = 0, j = 0, k = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] <= a2[j]) {
				a3[k] = a1[i];
				i++;
				k++;
			} else {
				a3[k] = a2[j];
				j++;
				k++;
			}
		}

		while (i < a1.length) {
			a3[k] = a1[i];
			i++;
			k++;
		}

		while (j < a2.length) {
			a3[k] = a2[j];
			j++;
			k++;
		}

		return a3;
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			// one bubbling trip;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					ArraysDemo.swapArrayItems(arr, j + 1, j);
				}
			}
		}
	}
	
	public static void bubbleSort(String[] arr){
		for (int i = 0; i < arr.length - 1; i++) {

			// one bubbling trip;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1].length() < arr[j].length()) {
					// swap
				}
			}
		}
	}
}
