package lect7;

import java.util.ArrayList;
import lect6.*;

public class RecursionCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList<String> aPoABC = permutations("cd");
		// System.out.println(aPoABC);

		// printPermutations("abcd", "");

		// printSS("abcd", "");

		int N = 1000000;
		int[] arr = new int[N];

		// Merge Sort
		for (int i = 0; i < arr.length; i++) {
			arr[i] = N - i;
		}

		long beginTime = System.currentTimeMillis();

		Sorts.mergeSort(arr, 0, arr.length - 1);

		long endTime = System.currentTimeMillis();
		System.out.println("MS for N = " + N + " took " + (endTime - beginTime) + " ms");

		// Bubble Sort
		for (int i = 0; i < arr.length; i++) {
			arr[i] = N - i;
		}

		beginTime = System.currentTimeMillis();

		Sorts.bubbleSort(arr);

		endTime = System.currentTimeMillis();
		System.out.println("BS for N = " + N + " took " + (endTime - beginTime) + " ms");

	}

	public static ArrayList<String> permutations(String str) {
		if (str.length() == 1) {
			ArrayList<String> current = new ArrayList<>();

			current.add(str);

			return current;
		}

		ArrayList<String> current = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			char cC = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);

			ArrayList<String> rosPermutations = permutations(ros);

			for (int j = 0; j < rosPermutations.size(); j++) {
				current.add(cC + rosPermutations.get(j));
			}
		}

		return current;
	}

	public static void printPermutations(String str, String outputSoFar) {
		if (str.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char cC = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);

			printPermutations(ros, outputSoFar + cC);
		}
	}

	public static void printSS(String str, String outputSoFar) {
		if (str.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}

		printSS(str.substring(1), outputSoFar + "");
		printSS(str.substring(1), outputSoFar + str.charAt(0));
	}
}
