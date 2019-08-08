package lec04;

import java.util.Scanner;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		int[][] arr = new int[4][5];

		// Incorrect - indexes
		// arr[4][5] = 20;

		// Incorrect - types
		// arr[3] = 15;

		// Correct
		// arr[3] = new int[10];
		
		int[][] xyz = takeInput();
		print2dNormal(xyz);
		
	//	int[][] def = {{1, 2, 3, 4}, {5, 6, 7}, {}, {9, 10, 11, 12, 13, 14}};
	//	print2dNormal(arr);

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

				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + "\t");}

				System.out.println();
		}
	}

}