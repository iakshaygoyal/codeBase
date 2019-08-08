package lect6;

import java.util.ArrayList;

import lect3.*;
import lect4.*;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = {5, 4, 3, 2, 1};
		//
		// bubbleSortRecursive(arr, 0, arr.length - 1);
		// arr = mergeSort(arr, 0, arr.length - 1);
		// ArraysDemo.printArray(arr);

		// String[] ssEs = subsequence("abcd");
		// for (String val : ssEs) {
		// System.out.println(val);
		// }

		// System.out.println(keypad("29"));
		//
		// System.out.println(changePi("api"));
		// System.out.println(insertAsterik("hello"));
		//
		// System.out.println(permutations("abca"));

		// printSS("abcd", "");
//		printPermutaions("abca", "");
		printKeypad("23", "");
	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					ArraysDemo.swapArrayItems(arr, i, i + 1);
				}
			}

			counter = counter + 1;
		}
	}

	public static void bubbleSortRecursive(int[] arr, int si, int li) {
		if (li == 0) {
			return;
		}

		if (si == li) {
			bubbleSortRecursive(arr, 0, li - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			ArraysDemo.swapArrayItems(arr, si, si + 1);
		}
		bubbleSortRecursive(arr, si + 1, li);
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			return new int[] { arr[lo] };
		}

		int mid = (lo + hi) / 2;
		int[] firstSortedHalf = mergeSort(arr, lo, mid);
		int[] secondSortedHalf = mergeSort(arr, mid + 1, hi);

		int[] totalSortedArray = lect4.Sorts.mergeTwoSortedArrays(firstSortedHalf, secondSortedHalf);
		return totalSortedArray;
	}

	public static String[] subsequence(String str) {
		if (str.length() == 0) {
			return new String[] { "" };
		}

		String[] smaller = subsequence(str.substring(1));
		String[] current = new String[2 * smaller.length];

		// copy smaller into it
		for (int i = 0; i < smaller.length; i++) {
			current[i] = smaller[i];
		}

		// add extra elements
		for (int i = 0; i < smaller.length; i++) {
			current[i + smaller.length] = str.charAt(0) + smaller[i];
		}

		return current;
	}

	public static ArrayList<String> keypad(String str) {
		if (str.length() == 1) {
			String currentCharCode = kpCode(str.charAt(0));

			ArrayList<String> current = new ArrayList<>();

			for (int i = 0; i < currentCharCode.length(); i++) {
				current.add(currentCharCode.substring(i, i + 1));
			}

			return current;
		}

		ArrayList<String> smaller = keypad(str.substring(1));
		String currentCharCode = kpCode(str.charAt(0));

		ArrayList<String> current = new ArrayList<>();
		for (int i = 0; i < currentCharCode.length(); i++) {
			for (int j = 0; j < smaller.size(); j++) {
				current.add(currentCharCode.charAt(i) + smaller.get(j));
			}
		}

		return current;
	}

	public static String kpCode(char c) {
		String retVal = "";

		switch (c) {
		case '1':
			retVal = "abc";
			break;
		case '2':
			retVal = "def";
			break;
		case '3':
			retVal = "ghi";
			break;
		case '4':
			retVal = "jkl";
			break;
		case '5':
			retVal = "mno";
			break;
		case '6':
			retVal = "pqr";
			break;
		case '7':
			retVal = "stu";
			break;
		case '8':
			retVal = "vwx";
			break;
		case '9':
			retVal = "yz";
			break;
		default:
			break;
		}

		return retVal;
	}

	public static String changePi(String str) {
		if (str.length() < 2) {
			return str;
		}

		if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
			return "3.14" + changePi(str.substring(2));
		} else if (str.charAt(1) == 'p') {
			return str.charAt(0) + changePi(str.substring(1));
		} else {
			return str.substring(0, 2) + changePi(str.substring(2));
		}
	}

	public static String insertAsterik(String str) {
		if (str.length() == 1) {
			return str;
		}

		if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "*" + insertAsterik(str.substring(1));
		} else {
			return str.charAt(0) + insertAsterik(str.substring(1));
		}
	}

	public static ArrayList<String> permutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> current = new ArrayList<>();

			current.add("");

			return current;
		}

		boolean[] dupCheck = new boolean[256];
		ArrayList<String> current = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (!dupCheck[currentChar]) {
				ArrayList<String> smaller = permutations(str.substring(0, i) + str.substring(i + 1));

				for (int j = 0; j < smaller.size(); j++) {
					current.add(currentChar + smaller.get(j));
				}

				dupCheck[currentChar] = true;
			}
		}

		return current;
	}

	public static void printSS(String str, String outputSoFar) {
		if (str.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}

		printSS(str.substring(1), outputSoFar);
		printSS(str.substring(1), outputSoFar + str.charAt(0));
	}

	public static void printPermutaions(String str, String outputSoFar) {
		if (str.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}

		boolean[] dupCheck = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			if (!dupCheck[str.charAt(i)]) {
				printPermutaions(str.substring(0, i) + str.substring(i + 1), outputSoFar + str.charAt(i));
				dupCheck[str.charAt(i)] = true;
			}
		}
	}
	
	public static void printKeypad(String str, String outputSoFar){
		if(str.length() == 0){
			System.out.println(outputSoFar);
			return;
		}
		
		String charCode = kpCode(str.charAt(0));
		for(int i = 0; i < charCode.length(); i++){
			printKeypad(str.substring(1), outputSoFar + charCode.charAt(i));
		}
	}
}
