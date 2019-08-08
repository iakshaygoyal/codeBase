package assignment5;

import java.util.Scanner;

public class RP5 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter string :");
		String x=s.nextLine();
		double i=string2Integer(x);
		System.out.println(i);

	}
//	public static int INTEGER(String s,int i)
//	{
//		if(i==s.length())
//			return 0;
//		int n=INTEGER(s,i+1);
//		int cv=n*10+(s.charAt(i))-48;
//		return cv;
//	}
	
	public static double string2Integer(String s){
		if(s.length() == 0){
			return 0;
		}
		double smaller = string2Integer(s.substring(1));
		double current = Math.pow(10, s.length()-1) * (s.charAt(0) - '0');
		return current + smaller;
	}

}
