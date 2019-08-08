package lec03;

import java.util.Scanner;

public class Sequenc {

	public static void main(String[] args) {
		int prev,current,n;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no. of nos. : ");
		n=s.nextInt();
		System.out.println("enter first no. : ");
		prev=s.nextInt();
		boolean goingdown=true;
		int counter=2;
		while(counter<=n)
		{
			System.out.println("Enter no. : ");
			current=s.nextInt();
			if(goingdown)
			{
				if(current>=prev)
				{
					goingdown=false;
				}
			}
			else
			{
				if(current<=prev)
				{System.out.println("Invalid");
				return;}
			}
			prev=current;
			counter++;
			
		}
		System.out.println("Valid");
	}

}
