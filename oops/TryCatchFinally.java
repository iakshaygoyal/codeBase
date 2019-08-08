package oops;
import java.util.Scanner;
public class TryCatchFinally {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		try{
			int x=10/n;
			System.out.println(x);
		}
		catch(ArithmeticException exception){
			System.out.println("In catch");
			System.out.println(exception);
		}
		finally{
			System.out.println("In finally");
		}
		scn.close();	
	}

}