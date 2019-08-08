package assignment5;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a :");
		int a=s.nextInt();
		System.out.println("Enter b :");
		int b=s.nextInt();
		int m=MULTIPLE(a,b);
		System.out.println(m);

	}
	public static int MULTIPLE(int a,int b)
	{
		if(b==0)
			return 0;
		int c=MULTIPLE(a,b-1);
		int cv=c+a;
		return cv;
	}

}
