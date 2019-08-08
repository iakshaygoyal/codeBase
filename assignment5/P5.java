package assignment5;

import java.util.Scanner;

import lec05.power;

public class P5 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter string :");
		String x=s.nextLine();
		int i=string2Integer(x);
		System.out.println(i);

	}
//	public static int INTEGER(String s,int i)
//	{
//		if(i==s.length())
//			return 0;
//		int n=s.charAt(i)-'0';
//		n=n*power.POWER(10,s.length()-i-1)+INTEGER(s,i+1);
//		return n;
//	}
	
	public static int string2Integer(String s){
		if(s.length()==0){
			return 0;
		}
		int c=s.charAt(0)-'0';
		return c*power.POWER(10, s.length()-1)+string2Integer(s.substring(1));
	}

}
