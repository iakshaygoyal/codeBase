package again;

import java.util.ArrayList;

public class subsequencePermutationKeypad {

	public static void main(String[] args) {
//		System.out.println(subsequence("abcd"));
//		System.out.println(permutation("abcd"));
		printPermutation("abcd", " ");
//		printSubsequence("abcd", " ");

	}
	
	public static ArrayList<String> subsequence(String s){
		if(s.length() == 0){
			ArrayList<String> current = new ArrayList<>();
			current.add(" ");
			return current;
		}
		
		ArrayList<String> smaller = subsequence(s.substring(1));
		ArrayList<String> current = new ArrayList<>();
		
		for(String str : smaller){
			current.add(str);
		}
		for(String str : smaller){
			current.add(s.charAt(0) + str);
		}
		
		return current;
	}

	public static ArrayList<String> permutation(String s){
		if(s.length() == 1){
			ArrayList<String> current = new ArrayList<>();
			current.add(s);
			return current;
		}
		
		ArrayList<String> current = new ArrayList<>();
		for(int i=0; i<s.length(); i++){
			char currentChar = s.charAt(i);
			String rest = s.substring(0,i) + s.substring(i+1,s.length());
			ArrayList<String> smaller = permutation(rest);
			
			for(String str : smaller){
				current.add(currentChar + str);
			}
		}
		return current;
	}
	
	public static void printPermutation(String s, String output){
		if(s.length() == 0){
			System.out.println(output);
			return;
		}
		
		for(int i=0; i<s.length(); i++){
			char currentChar = s.charAt(i);
			String rest = s.substring(0,i) + s.substring(i+1,s.length());
			printPermutation(rest, output + currentChar);
		}
	}
	
	public static void printSubsequence(String s, String output){
		if(s.length() == 0){
			System.out.println(output);
			return;
		}
		
		printSubsequence(s.substring(1), output);
		printSubsequence(s.substring(1), output+s.charAt(0));
	}
}
