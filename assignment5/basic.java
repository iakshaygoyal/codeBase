package assignment5;

import java.util.Scanner;

public class basic {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String x = s.nextLine();
		System.out.println(x);
		x = fun(x);
		System.out.println(x);

	}
	
	public static String fun(String s ){
		if(s.length() == 1){
			return s;
		}
		return s.charAt(0) + "_" + fun(s.substring(1));
	}

}
