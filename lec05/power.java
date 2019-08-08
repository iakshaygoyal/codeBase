package lec05;

import java.util.Scanner;

public class power {

		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter x :");
			int x=s.nextInt();
			System.out.println("Enter n :");
			int n=s.nextInt();
			int p=POWER(x,n);
			System.out.println(p);

		}
		public static int POWER(int x,int n)
		{
			if(n==0)
				return 1;
			int v=POWER(x,n-1);
			int cv=x*v;
			return cv;
		}


	}

