package assignment5;

import java.util.Scanner;

public class P10 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter String :");
		String x=s.nextLine();
		String y=PUT_STAR(x);
		System.out.println(y);

	}
	
	public static String PUT_STAR(String s){
		if(s.length() == 1){
			return s;
		}
		if(s.charAt(0) == s.charAt(1)){
			return s.charAt(0) + "*" + PUT_STAR( s.substring(1));
		}
		else{
			return s.charAt(0) + PUT_STAR( s.substring(1));
		}
	}
	

}
