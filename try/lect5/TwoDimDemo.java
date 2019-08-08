package lect5;

import java.util.Scanner;
import lect3.*;

public class TwoDimDemo {
	
	public static int firstIndex(int[] arr, int el){
		if(arr.length == 0){
			return -1;
		}
		
		if(arr[0] == el){
			return 0;
		}
		else{
			int[] smallerArray = new int[arr.length - 1];

			for (int i = 0; i < smallerArray.length; i++) {
				smallerArray[i] = arr[i + 1];
			}
			
			int firstIndexInSmallerArray = firstIndex(smallerArray, el);
			if(firstIndexInSmallerArray == -1){
				return -1;
			}
			else{
				return firstIndexInSmallerArray + 1;
			}
		}
	}
	
	public static int firstIndexSmarter(int[] arr, int el, int si){
		if(si == arr.length){
			return -1;
		}
		
		if(arr[si] == el){
			return si;
		}
		else{
			// there is no smaller array, only a virtual index
			int firstIndexInSmallerArray = firstIndexSmarter(arr, el, si + 1);
			return firstIndexInSmallerArray;
		}
	}

	public static int lastIndex(int[] arr, int el, int si){
		if(si == arr.length){
			return -1;
		}
		
		int lastIndexInSA = lastIndex(arr, el, si + 1);
		if(lastIndexInSA != -1){
			return lastIndexInSA;
		}
		else{
			if(arr[si] == el){
				return si;
			}
			else{
				return -1;
			}
		}
	}

	public static int[] allIndices(int[] arr, int el, int si){
		if(si == arr.length){
			return new int[0];
		}
		
		int[] allIndicesOfSmallerArray = allIndices(arr, el, si + 1);
		if(arr[si] == el){
			int[] temp = new int[allIndicesOfSmallerArray.length + 1];
			
			for(int i = 0; i < allIndicesOfSmallerArray.length; i++){
				temp[i] = allIndicesOfSmallerArray[i];
			}
			
			temp[temp.length - 1] = si;
			allIndicesOfSmallerArray = temp;
		}
		return allIndicesOfSmallerArray;
	}
	
	public static void main(String[] args) {
		// int[][] arr = takeInput();
		// print2dWave(arr);
		// print2dSpiral(arr);
		// printDecreasing(5);
		// printIncreasing(5);
//		printDI(5);
//		System.out.println(firstIndexSmarter(new int[] {1, 5, 6, 5, 9}, 5, 0));
		int[] allIndicesResult = allIndices(new int[] {1, 2, 2, 3, 2, 3, 2}, 2, 0);
		ArraysDemo.printArray(allIndicesResult);
	}

	public static void print2dSpiral(int[][] arr) {
		int nElemenets = arr.length * arr[0].length;
		int counter = 0;

		int rMin = 0, rMax = arr.length - 1, cMin = 0, cMax = arr[0].length - 1;
		while (counter < nElemenets) {
			// loop for min col
			for (int row = rMin; row <= rMax && (counter < nElemenets); row++) {
				System.out.println(arr[row][cMin]);
				counter++;
			}
			cMin++;

			// loop for max row
			for (int col = cMin; col <= cMax && (counter < nElemenets); col++) {
				System.out.println(arr[rMax][col]);
				counter++;
			}
			rMax--;

			// rLoop for max col
			for (int row = rMax; row >= rMin && (counter < nElemenets); row--) {
				System.out.println(arr[row][cMax]);
				counter++;
			}
			cMax--;

			// rLoop for min row
			for (int col = cMax; col >= cMin && (counter < nElemenets); col--) {
				System.out.println(arr[rMin][col]);
				counter++;
			}
			rMin++;
		}
	}

	public static int[][] takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter number of rows: ");

		int rows = s.nextInt();

		int[][] arr = new int[rows][];
		for (int i = 0; i < rows; i++) {
			System.out.println("Please enter number of columns for " + (i + 1) + "th row");
			int cols = s.nextInt();

			arr[i] = new int[cols];

			for (int j = 0; j < cols; j++) {
				System.out.println("Enter value for cell (" + i + ", " + j + ")");
				arr[i][j] = s.nextInt();
			}
		}

		return arr;
	}

	public static void print2dNormal(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {

				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + "\t");
				}

				System.out.println();
			}
		}
	}

	public static void print2dWave(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.println(arr[row][col]);
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.println(arr[row][col]);
				}
			}
		}
	}

	public static int factorial(int num) {
		if (num == 0) {
			return 1;
		}

		int nMin1Factorial = factorial(num - 1);
		int cFactorial = num * nMin1Factorial;
		return cFactorial;
	}

	public static void printDecreasing(int num) {
		if (num == 0) {
			System.out.println(num);
			return;
		}

		System.out.println(num);
		printDecreasing(num - 1);
	}

	public static void printIncreasing(int num) {
		if (num == 0) {
			System.out.println(num);
			return;
		}

		printIncreasing(num - 1);
		System.out.println(num);
	}

	public static void printDI(int num) {
		if (num == 0) {
			System.out.println(num);
			return;
		}

		System.out.println(num);
		printDI(num - 1);
		System.out.println(num);
	}

	public static int fib(int num) {
		if (num == 1 || num == 2) {
			return num - 1;
		}

		int nM1Fib = fib(num - 1);
		int nM2Fib = fib(num - 2);

		int cFib = nM1Fib + nM2Fib;
		return cFib;
	}

	public static boolean isSorted(int[] arr) {
		if (arr.length == 1 || arr.length == 0) {
			return true;
		}

		if (arr[0] < arr[1]) {
			int[] smallerArray = new int[arr.length - 1];

			for (int i = 0; i < smallerArray.length; i++) {
				smallerArray[i] = arr[i + 1];
			}

			return isSorted(smallerArray);
		} else {
			return false;
		}
	}

	public static boolean contains(int[] arr, int el) {
		if(arr.length == 0){
			return false;
		}
		
		if (arr[0] == el) {
			return true;
		} else {
			int[] smallerArray = new int[arr.length - 1];

			for (int i = 0; i < smallerArray.length; i++) {
				smallerArray[i] = arr[i + 1];
			}
			
			boolean isElementContainedInSmallerArray = contains(smallerArray, el);
			return isElementContainedInSmallerArray;
		}
	}
	
	
}
