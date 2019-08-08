package assignment5;

import java.util.Scanner;

public class ChangePi {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter String :");
		String s=scn.nextLine();
		s=changePi(s);
		System.out.println(s);

	}
	
	public static String changePi(String s){
		if(s.length()<2){
			return s;
		}
		if(s.charAt(0)=='p' && s.charAt(1)=='i'){
			return "3.14"+changePi(s.substring(2));
		}
		else if(s.charAt(1)=='p'){
			return s.charAt(0)+changePi(s.substring(1));
		}
		else{
			return s.substring(0,2)+changePi(s.substring(2));
		}
	}

}
