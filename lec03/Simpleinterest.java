package lec03;

import java.util.Scanner;

public class Simpleinterest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter p : ");
		int p=s.nextInt();
		System.out.println("Enter r : ");
		int r=s.nextInt();
		System.out.println("Enter t : ");
		int t=s.nextInt();
		int si;
		si=SI(p,r,t);
		System.out.println("Simple Interest : "+si);
	}
	public static int SI(int p,int r,int t)
	{
		int si=p*r*t/100;
		return si;
	}

}
