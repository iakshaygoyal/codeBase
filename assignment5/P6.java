package assignment5;

import java.util.Scanner;

public class P6 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter string :");
		String x=s.nextLine();
		x=noX(x);
		System.out.println(x);
	}
//	public static String REMOVE_X(String s,int i)
//	{
//		if(i==s.length())
//		{
//			String b="";
//			return b;
//		}
//		String a=REMOVE_X(s,i+1);
//		if(s.charAt(i)!='x')
//			{
//				String c=s.charAt(i)+a;
//				return c;
//			}
//		else
//			return a;
//		
//	}
	
	public static String noX(String s){
		if(s.length()==0){
			return "";
		}
		if(s.charAt(0)=='x'){
			return noX(s.substring(1));
		}
		else{
			return s.charAt(0)+noX(s.substring(1));
		}
	}

}
