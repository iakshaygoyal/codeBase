package lec03;

import java.util.Scanner;

public class sqrt1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		System.out.println("Enter precision");
		int p=s.nextInt();
		double inc=1;
		double sqrt=0;
		/*while(p>0)
		{
			inc=inc*0.1;
			p--;
		}
		while(sqrt*sqrt<=n)
		{
			sqrt=sqrt+inc;
			System.out.println("Sqrt : "+sqrt);
		}
		sqrt=sqrt-inc;
		*/
		while(p>=0)
		{
			while(sqrt*sqrt<=n)
			{
				sqrt=sqrt+inc;
			}
			sqrt=sqrt-inc;
			inc=inc*0.1;
			p--;
		}
		System.out.println("Sqrt : "+sqrt);
		System.out.println("Sqrt : "+sqrt);
	}

}
