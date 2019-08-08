package lect10.exceptions;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the divisor: ");
		int divs = scn.nextInt();

		System.out.println("Enter the dividend: ");
		int divd = scn.nextInt();

		int qnt = 0;
		try {
			qnt = divd / divs;
			System.out.println("Quotient: " + qnt);
			
			String str = "";
			System.out.println(str.length());
			
			System.out.println("All Well");
		} 
		catch (ArithmeticException aEx) {
			System.out.println(aEx);
			System.out.println("Some error occured. Perhaps you provided a faulty input.");
		}
		catch(NullPointerException nEx){
			System.out.println(nEx);
			System.out.println("String was null.");
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		finally{
			System.out.println("Exitting the safe zone.");
		}
		
		System.out.println("Thanks for using the program");
	}

}
