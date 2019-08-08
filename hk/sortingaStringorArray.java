package hk;

import java.util.Arrays;
import java.util.Scanner;

public class sortingaStringorArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String x = s.nextLine();
		System.out.println(x);
		char[] arr = x.toCharArray();
		Arrays.sort(arr);
		x = new String(arr);
		System.out.println(x);
//		 cannot sort a string in this fashion
//		for(int i=0; i<x.length()-1; i++){
//			for(int j=0; j<x.length()-1-i; j++){
//				if(x.charAt(j) > x.charAt(j+1)){
//					char c = x.charAt(j);
//					x.charAt(j) = x.charAt(j+1);
//				}
//			}
//		}

	}

}
