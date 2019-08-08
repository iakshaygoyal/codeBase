package dp;

import java.util.Scanner;

public class longestPalindromicSubsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
//		System.out.println(lps(str, ""));
//		System.out.println(lps(str, "", new int[str.length() + 1][str.length() + 1]));
		System.out.println(lps2(str, 0, str.length()-1));
		System.out.println(lps2(str, 0, str.length()-1, new int[str.length() + 1][str.length() + 1]));

	}
	
//	public static int lps(String s, String output){
//		if(s.length() == 0){
//			for(int i=0; i<output.length()/2; i++){
//				if(output.charAt(i) != output.charAt(output.length() - 1 - i)){
//					return 0;
//				}
//			}
//			return output.length();
//		}
//		
//		return Math.max(lps(s.substring(1), output), lps(s.substring(1), output + s.charAt(0)));
//	}
//	
	// Not the correct way as 2 different situations may arise with a single position of storage
//	public static int lps(String s, String output, int[][] storage){
//		if(storage[s.length()][output.length()] != 0){
//			return storage[s.length()][output.length()];
//		}
//		
//		int retval = 0;
//		
//		int i=0;
//		if(s.length() == 0){
//			for(i=0; i<output.length()/2; i++){
//				if(output.charAt(i) != output.charAt(output.length() - 1 - i)){
//					retval = 0;
//				}
//			}
//			if(i == output.length()/2){
//				retval = output.length();
//			}
//		}
//		else{
//			retval = Math.max(lps(s.substring(1), output, storage), lps(s.substring(1), output + s.charAt(0), storage));
//		}
//		
//		storage[s.length()][output.length()] = retval;
//		return retval;
//	}	
//	
	public static int lps2(String s, int i, int j){
		if(i == j){
			return 1;
		}
		if(s.charAt(i) == s.charAt(j) && i + 1 == j){
			return 2;
		}
		
		if(s.charAt(i) == s.charAt(j)){
			return 2 + lps2(s, i+1, j-1);
		}
		else{
			return Math.max(lps2(s, i+1, j), lps2(s, i, j-1));
		}
	}
	
	public static int lps2(String s, int i, int j, int[][] storage){
		if(storage[i][j] != 0){
			return storage[i][j];
		}
		
		int retval;
		
		if(i == j){
			retval = 1;
		}
		else if(s.charAt(i) == s.charAt(j) && i + 1 == j){
			retval = 2;
		}
		
		else if(s.charAt(i) == s.charAt(j)){
			retval = 2 + lps2(s, i+1, j-1, storage);
		}
		else{
			retval = Math.max(lps2(s, i+1, j, storage), lps2(s, i, j-1, storage));
		}
		
		storage[i][j] = retval;
		return retval;
	}

}
