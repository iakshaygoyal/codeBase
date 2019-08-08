package lec04;

import java.util.Scanner;

public class StringBasics {

	public static void main(String[] args) {
		String s = "Hello World";
		
		System.out.println(s.charAt(4));
		System.out.println(s.length());
		
		System.out.println(s.substring(5));
		System.out.println(s.substring(2, 7));
		System.out.println(s.substring(2, 3));
		System.out.println(s.substring(2, 2));
		System.out.println(s.substring(2, 1));
		
		String s1 = "Hello Universe";
		String s2 = s + s1;
		System.out.println(s2);
		
		s2 = s.concat(s1);
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s.startsWith("Hello"));
		System.out.println(s.startsWith("ello"));
		
		System.out.println(s.indexOf("o "));
		System.out.println(s.indexOf(" o"));
		System.out.println(s.indexOf("l"));
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter a string for me: ");
		String use = scn.nextLine();
		
		
		System.out.println("You printed: " + use);
		
		printChars("hello");
		
		System.out.println(isPalindrome("blabla"));
		System.out.println(isPalindrome("blaalb"));
		System.out.println(isPalindrome("blazalb"));
		printSubstrings("abcd");
		
		analyzeString();
	}
	
	public static void printChars(String str){
		for(int i = 0; i < str.length(); i++){
			System.out.println(str.charAt(i));
		}
	}
	
	public static boolean isPalindrome(String str){
		boolean retVal = true;
		
		int si = 0, li = str.length() - 1;
		while(si < li){
			if(str.charAt(si) != str.charAt(li)){
				retVal = false;
				break;
			}
			
			si++;
			li--;
		}
		
		/*
		while(si < li && str.charAt(si) == str.charAt(li)){
			si++;
			li--;
		}
		
		if(si < li){
			retVal = false;
		}
		else{
			retVal = true;
		}*/
		
		return retVal;
	}
	
	public static void printSubstrings(String str){
		System.out.println("");
		
		for(int i = 0; i < str.length(); i++){
			for(int j = i + 1; j <= str.length(); j++){
				System.out.println(str.substring(i, j));
			}
		}
	}
	
	public static void analyzeString(){
		Scanner s = new Scanner(System.in);
		
		int lines = 0, words = 0, chars = 0;
		boolean done = false;
		while(!done){
			String line = s.nextLine().trim();
			
			lines++;
			words++;
			
			for(int i = 0; i < line.length(); i++){
				if(line.charAt(i) == ' '){
					words++;
				}
				else if(line.charAt(i) == '$'){
					done = true;
					break;
				}
				
				chars++;
			}
		}
		
		System.out.println("Lines: " + lines);
		System.out.println("Words: " + words);
		System.out.println("Chars: " + chars);
	}

}
