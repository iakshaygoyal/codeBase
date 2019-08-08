package lec06;

import java.util.ArrayList;
import java.util.Scanner;

public class Keypad {

	public static void main(String[] args) {
		System.out.println(KEYPAD("12"));	
	}
	public static ArrayList<String> KEYPAD(String s){
		if(s.length()==1){
			String currentcode=GET_CODE(s.charAt(0));
			ArrayList<String> current=new ArrayList<>();
			for(int i=0;i<currentcode.length();i++){
				current.add(currentcode.charAt(i)+"");
			}
			return current;
		}
		ArrayList<String> smaller=KEYPAD(s.substring(1));
		String currentcode=GET_CODE(s.charAt(0));
		ArrayList<String> current=new ArrayList<>();
		for(int i=0;i<currentcode.length();i++){
			for(int j=0;j<smaller.size();j++){
				current.add(currentcode.charAt(i)+smaller.get(j));			}
		}
		return current;
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
