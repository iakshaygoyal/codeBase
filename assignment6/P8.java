package assignment6;

import java.util.ArrayList;

public class P8 {

	public static void main(String[] args) {
		System.out.println(keypad("12"));
	}
	
	public static ArrayList<String> keypad(String s){
		if(s.length() == 0){
			ArrayList<String> retval = new ArrayList<>();
			retval.add("");
			return retval;
		}
		
		ArrayList<String> smaller = keypad(s.substring(1));
		String str = GET_CODE(s.charAt(0));
		ArrayList<String> current = new ArrayList<>();
		
		for(int i=0; i<str.length(); i++){
			for(String x : smaller){
				current.add(str.charAt(i) +  x);
			}
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
