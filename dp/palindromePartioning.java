package dp;

import java.util.Scanner;

public class palindromePartioning {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String x = s.nextLine();
		System.out.println(pp(x, 0, x.length()-1, new int[x.length()][x.length()]));

	}
	
	public static int pp(String s, int si, int ei, int[][] storage){
		if(storage[si][ei] != 0){
			return storage[si][ei];
		}
		else{
			if(si == ei){
				storage[si][ei] = 0;
			}
			else if(isPalindrome(s, si, ei)){
				storage[si][ei] = 0;
			}
			else{
				int minval = Integer.MAX_VALUE;
				for(int i=si+1; i<=ei; i++){
					int f1 = pp(s, si, i-1, storage);
					int f2 = pp(s, i, ei, storage);
					int cost = f1+f2;
					if(cost < minval){
						minval = cost;
					}
				}
				storage[si][ei] = 1+minval;
			}
			return storage[si][ei];
		}
	}
	
	public static boolean isPalindrome(String s, int si, int ei){
		for(int i=si, j=ei; i<=(si + ei)/2; i++, j--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
	//Cannot use dynamic approach over here
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		String x = s.nextLine();
//		System.out.println(pp(x));
//
//	}
//	
//	public static int pp(String s){
//		if(s.length() == 1){
//			return 0;
//		}
//		else if(isPalindrome(s)){
//			return 0;
//		}
//		int minval = Integer.MAX_VALUE;
//		for(int i=1; i<s.length(); i++){
//			int f1 = pp(s.substring(0, i));
//			int f2 = pp(s.substring(i));
//			int cost = f1+f2;
//			if(cost < minval){
//				minval = cost;
//			}
//		}
//		return 1+minval;
//	}
//	
//	public static boolean isPalindrome(String s){
//		for(int i=0; i<s.length()/2; i++){
//			if(s.charAt(i) != s.charAt(s.length()-1-i)){
//				return false;
//			}
//		}
//		return true;
//	}

	
}
