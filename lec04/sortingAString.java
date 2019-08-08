package lec04;

import java.util.Arrays;

public class sortingAString {

	public static void main(String[] args) {
		String s = "akshay";
		System.out.println(s);
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		s = new String(arr);
		System.out.println(s);
		int[] arr1 = {3,6,1,4,8,2,9,0,7};
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i] + ", ");
		}
		System.out.println();
		Arrays.sort(arr1, arr1.length-3, arr1.length);
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i] + ", ");
		}
		System.out.println();
		Arrays.sort(arr1);
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i] + ", ");
		}
	}

}
