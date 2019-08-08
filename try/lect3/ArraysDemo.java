package lect3;

import java.util.Scanner;

public class ArraysDemo {

	public static int[] TakeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the number of elements: ");

		int n = s.nextInt();
		int[] ar = new int[n];

		int i = 0;
		int size = ar.length;
		while (i < size) {
			System.out.println("Enter " + (i + 1) + "th element: ");
			ar[i] = s.nextInt();
			i++;
		}

		return ar;
	}

	public static void printArray(int[] xyz) {
		int i = 0;
		int size = xyz.length;
		while (i < size) {
			System.out.print(xyz[i] + ", ");
			i++;
		}

		System.out.println("END");
	}

	public static int largestElement(int[] arr) {
		int retVal = arr[0];

		int counter = 1;
		while (counter < arr.length) {
			if (retVal < arr[counter]) {
				retVal = arr[counter];
			}

			counter = counter + 1;
		}

		return retVal;
	}

	public static int linearSearch(int[] arr, int element) {
		int index = -1;

		for (int i = 0; i < arr.length; i = i + 1) {
			if (arr[i] == element) {
				index = i;
				break;
			}
		}

		return index;
	}

	public static void reverseArray(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			
			// one bubbling trip;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1] < arr[j]) {
					swapArrayItems(arr, j + 1, j);
				}
			}
		}
	}

	public static void main(String[] args) {
//		int[] arr = new int[10];
//		arr[9] = 45;
//		System.out.println(arr[9]);
//
//		arr = TakeInput();
//		printArray(arr);
//		
//		bubbleSort(arr);
//		
//		System.out.println("Sorted: ");
//		printArray(arr);

		// Doesn't work well
//		System.out.println(arr);
//
//		int x = 10, y = 20;
//
//		System.out.println(x + ", " + y);
//		swap(x, y);
//		System.out.println(x + ", " + y);
//
//		arr[0] = 10;
//		arr[arr.length - 1] = 20;
//
//		System.out.println(arr[0] + ", " + arr[arr.length - 1]);
//		swapArrayItems(arr, 0, arr.length - 1);
//		System.out.println(arr[0] + ", " + arr[arr.length - 1]);
		
		
		int[] arr = TakeInput();
		
		Scanner scn = new Scanner(System.in);
				
		System.out.println("Please enter m: ");
		int m = scn.nextInt();
		
		System.out.println("Please enter i: ");
		int i = scn.nextInt();
		
		System.out.println("Please enter j: ");
		int j = scn.nextInt();
		
		System.out.println(sumIncrementalArray(arr, m, i, j));
	}

	public static void swap(int xx, int yy) {
		System.out.println(xx + ", " + yy);

		int temp = xx;
		xx = yy;
		yy = temp;

		System.out.println(xx + ", " + yy);
	}

	public static void swapArrayItems(int[] arr, int fi, int si) {
//		System.out.println(arr[fi] + ", " + arr[si]);

		int temp = arr[fi];
		arr[fi] = arr[si];
		arr[si] = temp;

//		System.out.println(arr[fi] + ", " + arr[si]);
	}

	public static int sumIncrementalArray(int[] arr, int m, int i, int j){
		int retVal = 0;
		
		for(int k = i; k <= j; k++){
			retVal += termAt(arr, m, k);
		}
		
		return retVal;
	}
	
	public static int termAt(int[] arr, int m, int i){
		if(m == 0){
			return arr[i];
		}
		
		if(i % 2 == 0){
			return termAt(arr, m - 1, i / 2);
		}
		else {
			return termAt(arr, m - 1, (i - 1) / 2) + termAt(arr, m - 1, (i + 1)/ 2);
		}
	}
}
