package lec07;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintorReturn {

	public static void main(String[] args) {
//		PRINT_PERMUTATION("aba","");
		HashMap<Character, Boolean> map = new HashMap<>();
		PRINT_SUBSEQUENCE("aba","");
//		PRINT_KEYPAD("23","");
	}
	
	public static void PRINT_PERMUTATION(String s,String outputsofar){
		if(s.length()==0){
			System.out.print(outputsofar + ", ");
			return;
		}
		
		HashMap<Character, Boolean> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), true);
				char c=s.charAt(i);
				String rest=s.substring(0,i)+s.substring(i+1);
				PRINT_PERMUTATION(rest,outputsofar+c);
			}
		}
	}
	
	public static void PRINT_SUBSEQUENCE(String s,String outputsofar){
		if(s.length()==0){
			System.out.print(outputsofar + ", ");
			return;
		}
		PRINT_SUBSEQUENCE(s.substring(1),outputsofar);
		PRINT_SUBSEQUENCE(s.substring(1),outputsofar+s.charAt(0));
	}
	public static void PRINT_KEYPAD(String s,String outputsofar){
		if(s.length()==0){
			System.out.println(outputsofar);
			return;
		}
		String smaller=GET_CODE(s.charAt(0));
		for(int i=0;i<smaller.length();i++){
			PRINT_KEYPAD(s.substring(1),outputsofar+smaller.charAt(i));
		}
	}
	public static String GET_CODE(char c) {
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


}
