package lec03;

import java.util.Scanner;

public class New2 {
	
	public static void main(String[] args) {
		int[] arr = new int[3];
		//System.out.println(arr[9]);

		arr = TakeInput();
		printArray(arr);
		
		bubbleSort(arr);
		
		System.out.println("Sorted: ");
		printArray(arr);

		//Doesn't work well
		System.out.println(arr);
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
	}
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
}
