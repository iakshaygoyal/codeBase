package lec03;

import java.util.Scanner;

public class sqrt {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=s.nextInt();
		/*int sqrt=0;
		while(sqrt*sqrt<=n)
		{
			sqrt++;
		}
		sqrt--;
		System.out.println("Square Root : "+sqrt);
		*/
		System.out.println("Enter precision : ");
		int precision=s.nextInt();
		
		double sqrt=0;
		double increment=1;
		int counter=1;
		/*while(counter<=precision)
		{
			increment=increment*0.1;
			counter++;
		}
		while(sqrt*sqrt<=n)
		{
			sqrt=sqrt+increment;
		}
		sqrt=sqrt-increment;
		System.out.println("sqrt : "+sqrt);
		*/
		while(counter<=precision)
		{
			while(sqrt*sqrt<=n)
			{
				sqrt=sqrt+increment;
				System.out.println("sqrt : "+sqrt);
			}
			sqrt=sqrt-increment;
			System.out.println("sqrt : "+sqrt);
			increment=increment*0.1;
			counter++;
		}
		System.out.println("sqrt : "+sqrt);

	}

}
