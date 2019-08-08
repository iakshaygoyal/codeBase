package lect10;

import java.util.Scanner;

public class imp1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter dividened");
		int divd=s.nextInt();
		System.out.println("Enter divisor");
		int divs=s.nextInt();
		try{
			int q=divd/divs;
			System.out.println(q);
		}
		catch(ArithmeticException aEx){
			System.out.println(aEx);
			System.out.println("You have entered wrong input");
		}
		finally{
			System.out.println("Finally here");
		}
		String x;
//		System.out.println(x.length());

	}

}
