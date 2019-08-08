package oops;

import java.util.Scanner;

class LowSalaryException extends Exception{
	public LowSalaryException() {
		super("Low Salary : Shit!!");
	}
}

public class CustomException {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int x=scn.nextInt();
		try{
			isLow(x);
		}
		catch(LowSalaryException lowSalaryException){
			System.out.println(lowSalaryException);
		}
		scn.close();
	}
	
	static void isLow(int salary) throws LowSalaryException{
		if(salary<1000){
			throw new LowSalaryException();
		}
	}

}
