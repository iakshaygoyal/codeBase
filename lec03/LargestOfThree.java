package lec03;

import java.util.Scanner;

public class LargestOfThree {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter x : ");
		int x=s.nextInt();
		System.out.println("Enter y : ");
		int y=s.nextInt();
		System.out.println("Enter z : ");
		int z=s.nextInt();
		int largest;
		largest=Largest(x,y,z);
		System.out.println("Largest : "+largest);
	}
	public static int Largest(int x,int y,int z)
	{
		if(x>=y &&x>=z)
		{
			return x;
		}
		else if(y>=x && y>=z)
		{
			return y;
		}
		else
			return z;
	}

}
