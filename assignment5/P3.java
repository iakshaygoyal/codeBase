package assignment5;

import java.util.Scanner;

import lec05.power;

public class P3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter k :");
		int k=s.nextInt();
		double sum=GP(k);
		System.out.println(sum);
		
	}
	public static double GP(int k)
	{
		if(k==0)
			return 1.0;
		double s=GP(k-1);
		s=s+(1.0/power.POWER(2,k));
		return s;
	}

}
